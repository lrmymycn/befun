package com.befun.web.action.admin.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.hibernate.criterion.Order;

import com.befun.config.MediaConfig;
import com.befun.domain.estate.ContentType;
import com.befun.domain.estate.Media;
import com.befun.domain.estate.MediaType;
import com.befun.domain.estate.Project;
import com.befun.service.estate.MediaService;
import com.befun.service.query.estate.MediaQueryCondition;
import com.befun.service.query.estate.ProjectQueryCondition;
import com.befun.web.action.admin.AdminAction;
import com.befun.web.view.MediaView;
import com.befun.web.view.ProjectView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

public class MediaAction<T extends Media, V extends MediaView> extends AdminAction<Media, MediaView> {

    private static final long        serialVersionUID = 1423434908904040130L;

    private MediaQueryCondition      qc               = new MediaQueryCondition();

    private File                     largeFile;

    private File                     mediumFile;

    private File                     smallFile;

    private static List<MediaType>   mediaTypes       = new ArrayList<MediaType>();

    private static List<ContentType> contentTypes     = new ArrayList<ContentType>();

    private List<ProjectView>        qcProjects       = new ArrayList<ProjectView>();

    private MediaConfig              mediaConfig;

    static {
        if (mediaTypes.size() < 1) {
            mediaTypes.add(MediaType.PICTURE);
            mediaTypes.add(MediaType.FILE);
            mediaTypes.add(MediaType.VIDEO);
        }
        if (contentTypes.size() < 1) {
            contentTypes.add(ContentType.FLOORPLAN);
            contentTypes.add(ContentType.FLOORPLATE);
            contentTypes.add(ContentType.ENVIRONMENT);
            contentTypes.add(ContentType.PHOTOGRAPH);
            contentTypes.add(ContentType.RENDER_EXTERNAL);
            contentTypes.add(ContentType.RENDER_INTERNAL);
            contentTypes.add(ContentType.OTHER);
            contentTypes.add(ContentType.PROJECT_OVERVIEW);
            contentTypes.add(ContentType.PROJECT_DESCRIPTION);
            contentTypes.add(ContentType.PROJECT_FEATURES);
            contentTypes.add(ContentType.PROJECT_SCHEME);
        }
    }

    public MediaAction() {
        this.view = new MediaView();
    }

    public String createPage() {
        this.prepareEditorList();
        return super.createPage();
    }

    @Override
    public String create() {
        this.processImgFile();
        return super.create();
    }

    @Override
    public String update() {
        this.processImgFile();
        return super.update();
    }

    private void processImgFile() {
        Project proj = this.projectService.get(this.view.getProjectId());
        this.view.setProjectBid(proj.getBid());
        String url = null;
        File destFile = null;
        String originalFileName = null;
        if (this.smallFile != null) {
            originalFileName = getOriginalFileName("smallFile");
            destFile = mvToDestDir(this.smallFile, originalFileName, this.view, "small");
            url = this.getUrl(destFile, this.view, "small");
            this.view.setSmallUrl(url);
        }
        if (this.mediumFile != null) {
            originalFileName = getOriginalFileName("mediumFile");
            destFile = mvToDestDir(this.mediumFile, originalFileName, this.view, "medium");
            url = this.getUrl(destFile, this.view, "medium");
            this.view.setMediumUrl(url);
        }
        if (this.largeFile != null) {
            originalFileName = getOriginalFileName("largeFile");
            destFile = mvToDestDir(this.largeFile, originalFileName, this.view, "large");
            url = this.getUrl(destFile, this.view, "large");
            this.view.setLargeUrl(url);
        }
    }

    private String getOriginalFileName(String fileFieldName) {
        MultiPartRequestWrapper mpRequest = (MultiPartRequestWrapper) ServletActionContext.getRequest();
        String[] fileNames = mpRequest.getFileNames(fileFieldName);
        if (fileNames != null && fileNames.length > 0) {
            return fileNames[0];
        }
        return null;
    }

    private String getUrl(File file, MediaView v, String size) {
        String typePath = this.getTypePath(v);
        StringBuilder sb = new StringBuilder("/img/");
        if (!StringUtils.isBlank(v.getProjectBid())) {
            sb.append(v.getProjectBid()).append("/");
        }
        sb.append(typePath).append("/").append(size).append("/").append(file.getName());
        return sb.toString();
    }

    private File mvToDestDir(File originalFile, String originalFileName, MediaView v, String size) {
        String destDir = this.generateDestDir(v, size);
        File destFile = this.generateDestFile(originalFile, destDir, originalFileName);
        destFile.getParentFile().mkdirs();
        boolean success = originalFile.renameTo(destFile);
        if (success) {
            return destFile;
        }
        throw new IllegalStateException("Can not move image file to dest:" + destFile.getAbsolutePath());
    }

    private String generateDestDir(MediaView v, String size) {
        String typePath = getTypePath(v);
        StringBuilder sb = new StringBuilder(this.mediaConfig.getImgRootPath()).append("/");
        if (!StringUtils.isBlank(v.getProjectBid())) {
            sb.append(v.getProjectBid()).append("/");
        }
        sb.append(typePath).append("/").append(size);
        return sb.toString();
    }

    private String getTypePath(MediaView v) {
        String typePath = "default";
        switch (v.getContentType()) {
        case ENVIRONMENT:
            typePath = "default";
            break;
        case FLOORPLAN:
            typePath = "fp";
            break;
        case FLOORPLATE:
            typePath = "floorplate";
            break;
        case OTHER:
            typePath = "others";
            break;
        case PHOTOGRAPH:
            typePath = "photograph";
            break;
        case RENDER_EXTERNAL:
            typePath = "render";
            break;
        case RENDER_INTERNAL:
            typePath = "render";
            break;
        case PROJECT_OVERVIEW:
        case PROJECT_DESCRIPTION:
        case PROJECT_FEATURES:
        case PROJECT_SCHEME:
            typePath = "project";
            break;
        default:
            break;
        }
        return typePath;
    }

    private File generateDestFile(File originalFile, String destDir, String destFileName) {
        File destFile = new File(destDir, destFileName);
        String destFileNameWithoutExt = destFileName.substring(0, destFileName.lastIndexOf("."));
        String extName = destFileName.substring(destFileName.lastIndexOf(".") + 1);
        if (destFile.exists()) {
            for (int i = 0; i < 1000; i++) {
                destFile = new File(destDir, destFileNameWithoutExt + "(" + i + ")." + extName);
                if (!destFile.exists()) {
                    break;
                }
            }
        }
        return destFile;
    }

    @Override
    public String demand() {
        this.qc.getOrderBy().add(Order.desc("modelModification.creationDate"));
        return super.demand();
    }

    @Override
    public String demandById() {
        String rs = super.demandById();
        this.prepareEditorList();
        return rs;
    }

    private void prepareEditorList() {
        ProjectQueryCondition pQC = new ProjectQueryCondition();
        pQC.setEnabled(null);
        pQC.getSuburbQC().setEnabled(null);
        List<Project> projects = this.projectService.query(pQC);
        ProjectView psv = null;
        for (Project s : projects) {
            psv = projectConverter.convertToView(s);
            qcProjects.add(psv);
        }
    }

    protected void prepareQueryList() {
        ProjectQueryCondition pQC = new ProjectQueryCondition();
        pQC.setEnabled(null);
        pQC.getSuburbQC().setEnabled(null);
        List<Project> projects = this.projectService.query(pQC);
        ProjectView psv = null;
        for (Project s : projects) {
            psv = projectConverter.convertToView(s);
            qcProjects.add(psv);
        }
    }

    public void setQc(MediaQueryCondition qc) {
        this.qc = qc;
    }

    public File getLargeFile() {
        return largeFile;
    }

    public void setLargeFile(File largeFile) {
        this.largeFile = largeFile;
    }

    public File getMediumFile() {
        return mediumFile;
    }

    public void setMediumFile(File mediumFile) {
        this.mediumFile = mediumFile;
    }

    public File getSmallFile() {
        return smallFile;
    }

    public void setSmallFile(File smallFile) {
        this.smallFile = smallFile;
    }

    public List<MediaType> getMediaTypes() {
        return mediaTypes;
    }

    public List<ContentType> getContentTypes() {
        return contentTypes;
    }

    public List<ProjectView> getQcProjects() {
        return qcProjects;
    }

    @Override
    public MediaQueryCondition getQc() {
        return qc;
    }

    public MediaView getView() {
        return this.view;
    }

    public void setView(MediaView view) {
        this.view = view;
    }

    @Override
    public ViewConverter<Media, MediaView> getConverter() {
        return ConverterFactory.getConverter(Media.class);
    }

    @Override
    public MediaService getService() {
        return this.mediaService;
    }

    public MediaConfig getMediaConfig() {
        return mediaConfig;
    }

    public void setMediaConfig(MediaConfig mediaConfig) {
        this.mediaConfig = mediaConfig;
    }

}
