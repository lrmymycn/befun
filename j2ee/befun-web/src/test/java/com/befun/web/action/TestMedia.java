package com.befun.web.action;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.befun.domain.estate.ContentType;
import com.befun.web.view.MediaView;

public class TestMedia {

    private static final String ROOT_PATH = "/befun/img";

    @Test
    public void testGetUrl() {
        File file = new File("/befun/img/fp/1.jpg");
        MediaView v = new MediaView();
        v.setContentType(ContentType.FLOORPLAN);
        String url = this.getUrl(file, v);
        assertEquals("/img/fp/1.jpg", url);
    }

    private String getUrl(File file, MediaView v) {
        String typePath = this.getTypePath(v);
        return "/img/" + typePath + "/" + file.getName();
    }

    private String getTypePath(MediaView v) {
        String typePath = "others";
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
        default:
            break;
        }
        return typePath;
    }

}
