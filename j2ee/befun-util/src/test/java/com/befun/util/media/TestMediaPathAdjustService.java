package com.befun.util.media;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.befun.domain.estate.Media;
import com.befun.service.estate.MediaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context-datasource.xml" })
public class TestMediaPathAdjustService {

	@Resource
	@Qualifier("MediaPathAdjustService")
	private MediaPathAdjustService target;

	@Resource
	@Qualifier("MediaService")
	private MediaService mediaService;

	@Test
	public void testAdjustMedia() {
		Media m = mediaService.get(460l);
		target.adjustMedia(m);
	}

	@Test
	public void testAdjustAllMedias() {
		target.adjustAllMedias();
	}
}
