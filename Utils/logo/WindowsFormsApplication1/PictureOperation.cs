using System;
using System.Linq;
using System.Collections.Generic;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Drawing.Imaging;

namespace WindowsFormsApplication1
{

    public static class PictureOperation
    {
        public static void Save(Image img, string path)
        {
            Save(img, path, ImgCodes.JPEG, 90);
        }

        public static void Save(Image img, string path, ImgCodes code, int quality)
        {
            var qualityParam = new EncoderParameter(Encoder.Quality, quality);
            var codecInfo = GetCodeInfo(code);
            var encoderParams = new EncoderParameters(1);
            encoderParams.Param[0] = qualityParam;
            img.Save(path, codecInfo, encoderParams);
        }

        public static Image Resize(Image source, ResizeTypes resizeType, int width, int height)
        {
            ResizeModel model = new ResizeModel();
            model.Source = source;
            model.ResizeType = resizeType;
            model.Width = width;
            model.Height = height;
            return Resize(model);
        }

        public static Image Resize(ResizeModel model)
        {
            int srcWidth, srcHeight, destWidth, destHeight, cutWidth, cutHeight, x, y;

            #region 初始化变量
            x = model.StartX;
            y = model.StartY;
            cutWidth = srcWidth = model.Source.Width;
            cutHeight = srcHeight = model.Source.Height;
            destWidth = model.Width;
            destHeight = model.Height;
            #endregion

            #region 确定画布大小及裁剪尺寸
            switch (model.ResizeType)
            {
                case ResizeTypes.Auto:
                    GetFinalSize(model.Width, model.Height, srcWidth, srcHeight, out destWidth, out destHeight);
                    break;
                case ResizeTypes.Cut:
                    #region 裁剪算法
                    double srcProportion = (double)srcWidth / srcHeight;
                    double destProportion = (double)model.Width / model.Height;

                    bool autoCut = x == -1 && y == -1;

                    if (srcProportion >= destProportion)
                    {
                        //高瘦，固定高度，求宽度
                        cutWidth = (int)Math.Floor(srcHeight * destProportion);
                        if (autoCut) x += (srcWidth - cutWidth) / 2;
                    }
                    else
                    {
                        //矮胖，固定宽度，球高度
                        cutHeight = (int)Math.Floor(srcWidth / destProportion);
                        if (autoCut) y += (srcHeight - cutHeight) / 2;
                    }

                    if (x + cutWidth > srcWidth)
                    {
                        cutWidth = srcWidth - x;
                    }

                    if (y + cutHeight > srcHeight)
                    {
                        cutHeight = srcHeight - y;
                    }
                    #endregion
                    break;
                case ResizeTypes.FixedHeight:
                    GetFinalSize(model.Width, model.Height, srcHeight - 1, srcHeight, out destWidth, out destHeight);
                    break;
                case ResizeTypes.FixedWidth:
                    GetFinalSize(model.Width, model.Height, srcWidth, srcWidth - 1, out destWidth, out destHeight);
                    break;
                default:
                    break;
            }
            #endregion

            Image imgResult = new Bitmap(destWidth, destHeight);//结果对象

            using (var g = Graphics.FromImage(imgResult))
            {
                g.Clear(Color.White);
                g.InterpolationMode = InterpolationMode.HighQualityBicubic;
                g.SmoothingMode = SmoothingMode.HighQuality;
                //g.PixelOffsetMode = PixelOffsetMode.HighQuality;
                g.CompositingQuality = CompositingQuality.HighQuality;

                Rectangle destRect = new Rectangle(0, 0, destWidth, destHeight);
                Rectangle srcRect = new Rectangle(x, y, cutWidth, cutHeight);

                g.DrawImage(model.Source, destRect, srcRect, GraphicsUnit.Pixel);

                if (model.IsWartermarked)//是否加水印
                {
                    Image warterMark = model.ImageWartermark;
                    bool doImageWartermark = (null != warterMark
                        && warterMark.Width < destWidth / 1
                        && warterMark.Height < destHeight / 1);//能否图片水印

                    if (doImageWartermark)
                    {
                        #region 图片水印
                        GetWatermarkPlacement(model.Position, g.DpiX, g.DpiY, destWidth, destHeight, warterMark, out x, out y);

                        /*
                        ImageAttributes ia = new ImageAttributes();
                        ColorMatrix cm = new ColorMatrix();
                        cm.Matrix33 = 0.75f;
                        ia.SetColorMatrix(cm);
                        */

                        ImageAttributes ia = new ImageAttributes();

                        //The first step in manipulating the watermark image is to replace 
                        //the background color with one that is trasparent (Alpha=0, R=0, G=0, B=0)
                        //to do this we will use a Colormap and use this to define a RemapTable
                        ColorMap colorMap = new ColorMap();

                        //My watermark was defined with a background of 100% Green this will
                        //be the color we search for and replace with transparency
                        colorMap.OldColor = Color.FromArgb(255, 0, 255, 0);
                        colorMap.NewColor = Color.FromArgb(0, 0, 0, 0);

                        ColorMap[] remapTable = { colorMap };

                        ia.SetRemapTable(remapTable, ColorAdjustType.Bitmap);

                        //The second color manipulation is used to change the opacity of the 
                        //watermark.  This is done by applying a 5x5 matrix that contains the 
                        //coordinates for the RGBA space.  By setting the 3rd row and 3rd column 
                        //to 0.3f we achive a level of opacity
                        float[][] colorMatrixElements = { 
                                                 new float[] {1.0f,  0.0f,  0.0f,  0.0f, 0.0f},       
                                                 new float[] {0.0f,  1.0f,  0.0f,  0.0f, 0.0f},        
                                                 new float[] {0.0f,  0.0f,  1.0f,  0.0f, 0.0f},        
                                                 new float[] {0.0f,  0.0f,  0.0f,  0.3f, 0.0f},        
                                                 new float[] {0.0f,  0.0f,  0.0f,  0.0f, 1.0f}};
                        ColorMatrix wmColorMatrix = new ColorMatrix(colorMatrixElements);

                        ia.SetColorMatrix(wmColorMatrix, ColorMatrixFlag.Default,
                            ColorAdjustType.Bitmap);


                        g.DrawImage(warterMark, new Rectangle(x, y, warterMark.Width, warterMark.Height), 0, 0, warterMark.Width, warterMark.Height, GraphicsUnit.Pixel, ia);

                        warterMark.Dispose();
                        #endregion
                    }
                    else
                    {
                        #region 文字水印

                        int[] sizes = new int[] { 18, 16, 14, 12, 10, 8, 6, 4 };

                        Font font = null;
                        SizeF size = new SizeF();

                        for (int i = 0; i < 8; i++)//自动适应大小
                        {
                            font = new Font("arial", sizes[i], FontStyle.Bold);
                            size = g.MeasureString(model.TextWatermark, font);

                            if ((ushort)size.Width < (ushort)destWidth * .90)
                                break;
                        }

                        float fx = destWidth * .95f - size.Width;
                        float fy = destHeight * .99f - size.Height;

                        StringFormat StrFormat = new StringFormat();
                        StrFormat.Alignment = StringAlignment.Near;

                        //黑色阴影 (Alpha 153)
                        SolidBrush brush1 = new SolidBrush(Color.FromArgb(153, 0, 0, 0));
                        g.DrawString(model.TextWatermark,
                            font,
                            brush1,
                            new PointF(fx + 1, fy + 1),
                            StrFormat);

                        //白色前景 (Alpha 153)
                        SolidBrush brush2 = new SolidBrush(Color.FromArgb(153, 255, 255, 255));
                        g.DrawString(model.TextWatermark,
                            font,
                            brush2,
                            new PointF(fx, fy),
                            StrFormat);
                        #endregion
                    }
                }

                g.Flush();
            }

            model.Source.Dispose();

            return imgResult;
        }

        private static void GetWatermarkPlacement(WatermarkPositions watermarkPosition, float xDpi, float yDpi, int destWidth, int destHeight, Image watermarkImg, out int x, out int y)
        {
            float xProportion = xDpi / watermarkImg.HorizontalResolution;
            float yProportion = yDpi / watermarkImg.VerticalResolution;

            int watermarkImgWidth = Convert.ToInt32((float)watermarkImg.Width * xProportion);
            int watermarkImgHeight = Convert.ToInt32((float)watermarkImg.Height * yProportion);

            x = 5;
            y = 5;

            switch (watermarkPosition)
            {
                case WatermarkPositions.TopRight:
                    x = destWidth - watermarkImgWidth - 5;
                    y = 5;
                    break;
                case WatermarkPositions.BottomRight:
                    x = destWidth - watermarkImgWidth - 5;
                    y = destHeight - watermarkImgHeight - 5;
                    break;
                case WatermarkPositions.Center:
                    x = (destWidth - watermarkImgWidth)/2;
                    y = (destHeight - watermarkImgHeight)/2;
                    break;
                case WatermarkPositions.BottomLeft:
                    x = 5;
                    y = destHeight - watermarkImgHeight - 5;
                    break;
            }
        }

        private static void GetFinalSize(int width, int height, int srcWidth, int srcHeight, out int destWidth, out int destHeight)
        {
            destWidth = 800;
            destHeight = 800;

            if (srcWidth > srcHeight)
            {
                double proportion = srcWidth / (double)width;

                destWidth = width;
                destHeight = Convert.ToInt32(srcHeight / proportion);
            }
            else
            {
                double proportion = srcHeight / (double)height;

                destHeight = height;
                destWidth = Convert.ToInt32(srcWidth / proportion);
            }
        }

        public static ImageCodecInfo GetCodeInfo(ImgCodes code)
        {
            return ImageCodecInfo.GetImageEncoders().FirstOrDefault(m => m.MimeType == codes[code]);
        }

        static PictureOperation()
        {
            codes.Add(ImgCodes.BMP, "image/bmp");
            codes.Add(ImgCodes.GIF, "image/gif");
            codes.Add(ImgCodes.JPEG, "image/jpeg");
            codes.Add(ImgCodes.PNG, "image/png");
            codes.Add(ImgCodes.TIFF, "image/tiff");
        }

        private static Dictionary<ImgCodes, string> codes = new Dictionary<ImgCodes, string>();
    }

    public enum WatermarkPositions { TopLeft, TopRight, BottomLeft, BottomRight, Center }

    public enum ImgCodes { BMP, GIF, JPEG, PNG, TIFF }

    public enum ResizeTypes { Auto, Absolute, FixedWidth, FixedHeight, Cut }

    public class ResizeModel
    {
        public ResizeModel()
        {
            ResizeType = ResizeTypes.Auto;
            IsWartermarked = true;
            TextWatermark = string.Concat("", DateTime.Now.Year);
            Position = WatermarkPositions.BottomLeft;
            StartX = StartY = 0;
        }

        /// <summary>
        /// 待处理图片
        /// </summary>
        public Image Source { get; set; }
        /// <summary>
        /// 缩放类型
        /// </summary>
        public ResizeTypes ResizeType { get; set; }
        /// <summary>
        /// 是否水印,若开启水印无图片则添加文字水印
        /// </summary>
        public bool IsWartermarked { get; set; }
        /// <summary>
        /// 水印图片
        /// </summary>
        public Image ImageWartermark { get; set; }
        /// <summary>
        /// 水印文字
        /// </summary>
        public string TextWatermark { get; set; }
        /// <summary>
        /// 水印图片位置
        /// </summary>
        public WatermarkPositions Position { get; set; }
        /// <summary>
        /// 后缀
        /// </summary>
        public string Suffix { get; set; }
        /// <summary>
        /// 输出宽度
        /// </summary>
        public int Width { get; set; }
        /// <summary>
        /// 输出高度
        /// </summary>
        public int Height { get; set; }
        /// <summary>
        /// 水印图片开始X坐标
        /// </summary>
        public int StartX { get; set; }
        /// <summary>
        /// 水印图片开始Y坐标
        /// </summary>
        public int StartY { get; set; }
    }
}