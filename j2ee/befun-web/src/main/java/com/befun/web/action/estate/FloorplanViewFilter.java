package com.befun.web.action.estate;

import com.befun.web.view.FloorplanView;

public class FloorplanViewFilter {

	public static void filter(boolean isAnonymous, FloorplanView view) {
		if (isAnonymous) {
//			view.setProjectName(null);
			view.setStageName(null);
			view.setBuildingNum(null);
			view.setBuildingId(null);
			view.setPublicPictureId(null);
			view.setSalePictureId(null);
			view.setSalePicture(null);
			view.setDescription(null);
			view.setSplit(false);
			view.setStudio(false);
			view.setOpenBaclonyCount(null);
			view.setEnclosedBaclonyCount(null);
			view.setCourtyardCount(null);
			view.setAvgPricePerSQM(null);
		}
	}
}
