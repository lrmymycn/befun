package com.befun.util.input.impl.access.parser;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.befun.domain.estate.ContentType;
import com.befun.domain.estate.Media;
import com.befun.domain.estate.MediaType;
import com.befun.domain.estate.ModelModification;
import com.befun.util.input.impl.access.AccessUtil;

public class MediaColumnParser implements ColumnParser<Media> {

    @Override
    public Media parse(Map<String, Object> col) {
        Media rs = new Media();
        rs.setAlt(AccessUtil.getString(col, "alt"));
        rs.setBid(AccessUtil.getString(col, "id"));
        rs.setProjectBid(AccessUtil.getString(col, "project_id"));

        Byte contentTypeV = AccessUtil.getByte(col, "content_type");
        ContentType contentType = ContentType.ENVIRONMENT;
        if (contentTypeV != null) {
            contentType = ContentType.getValue(contentTypeV);
        }
        rs.setContentType(contentType);

        Byte mediaTypeV = AccessUtil.getByte(col, "media_type");
        MediaType mediaType = MediaType.PICTURE;
        if (mediaTypeV != null) {
            mediaType = MediaType.getValue(mediaTypeV);
        }
        rs.setMediaType(mediaType);

        rs.setLargeUrl(AccessUtil.getString(col, "large_url"));
        rs.setMediumUrl(AccessUtil.getString(col, "medium_url"));
        rs.setSmallUrl(AccessUtil.getString(col, "small_url"));
        if(!StringUtils.isEmpty(rs.getLargeUrl())){
            if(StringUtils.isEmpty(rs.getMediumUrl())){
                String mediumUrl = this.getDestUrl(rs.getLargeUrl(), "medium");
                rs.setMediumUrl(mediumUrl);
            }
            if(StringUtils.isEmpty(rs.getSmallUrl())){
                String smallUrl = this.getDestUrl(rs.getLargeUrl(), "small");
                rs.setSmallUrl(smallUrl);
            }
            String largeUrl = this.getDestUrl(rs.getLargeUrl(), "large");
            rs.setLargeUrl(largeUrl);
        }
        rs.setName(AccessUtil.getString(col, "name1"));

        ModelModification modelModification = ModelModification.createDefault();
        rs.setModelModification(modelModification);
        return rs;
    }

    private String getDestUrl(String oriUrl, String size) {
        String regex = "^(/[^/]+/[^/]+/)(.+)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(oriUrl);
        StringBuilder sb = new StringBuilder("/img");
        if (m.find()) {
            String head = m.group(1);
            String fileName = m.group(2);
            sb.append(head).append(size).append("/").append(fileName);
            return sb.toString();
        }
        sb.append(oriUrl);
        return sb.toString();
    }
    
//    @Test
//    public void test1(){
//    	String durl = getDestUrl("/pro_b7ddd784-c878-49c7-a08d-112a12a3d453/fp/botanic.jpg", "large");
//    	System.out.println(durl);
//    }
//    
//    @Test
//    public void test2(){
//    	String durl = getDestUrl("/img/pro_b7ddd784-c878-49c7-a08d-112a12a3d453/fp/botanic.jpg", "large");
//    	System.out.println(durl);
//    }
}
