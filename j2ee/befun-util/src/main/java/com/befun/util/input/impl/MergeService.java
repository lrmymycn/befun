package com.befun.util.input.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Building;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.Media;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.ProjectMedia;
import com.befun.domain.estate.Stage;
import com.befun.service.ICommonService;
import com.befun.service.query.estate.ProjectMediaQueryCondition;

@Component("ImportMergeService")
public class MergeService {

	private static final String[] IGNORE_PROPERTIES_MEDIA = new String[] {
			"id", "bid", "modelModification" };

	private static final String[] IGNORE_PROPERTIES_PROJECT = new String[] {
			"id", "bid", "suburb", "sold", "soldOut", "stages",
			"modelModification" };

	private static final String[] IGNORE_PROPERTIES_STAGE = new String[] {
			"id", "bid", "sold", "soldOut", "buildings", "modelModification" };

	private static final String[] IGNORE_PROPERTIES_BUILDING = new String[] {
			"id", "bid", "sold", "soldOut", "floorplans", "modelModification" };

	private static final String[] IGNORE_PROPERTIES_FLOORPLAN = new String[] {
			"id", "bid", "minPrice", "maxPrice", "sold", "soldOut",
			"modelModification" };

	private static final String[] IGNORE_PROPERTIES_APARTMENT = new String[] {
			"id", "bid", "modelModification" };

	private Log log = LogFactory.getLog(getClass());

	@Resource
	@Qualifier("CommonService")
	private ICommonService commonService;

	public Media mergeMedia(Media model) {
		Media rs = model;
		Media exist = commonService.getByBid(Media.class, model.getBid());
		if (exist != null) {
			// BeanUtils.copyProperties(rs, exist, IGNORE_PROPERTIES_MEDIA);
			// rs = exist;
			return null;
		}
		return rs;
	}

	public Media getMediaByBid(String bid) {
		Media exist = commonService.getByBid(Media.class, bid);
		return exist;
	}

	public Project mergeProject(Project model) {
		Project rs = model;
		if (rs.getLogo() != null) {
			Media logo = commonService.getByBid(Media.class, rs.getLogo()
					.getBid());
			if (logo == null) {
				String errMsg = "Can not find logo :" + rs.getLogo().getBid()
						+ " for Project:" + rs.getBid();
				this.log.error(errMsg);
				throw new IllegalArgumentException(errMsg);
			}
			rs.setLogo(logo);
		}

		if (rs.getPicture() != null) {
			Media picture = commonService.getByBid(Media.class, rs.getPicture()
					.getBid());
			if (picture == null) {
				String errMsg = "Can not find picture :"
						+ rs.getPicture().getBid() + " for Project:"
						+ rs.getBid();
				this.log.error(errMsg);
				throw new IllegalArgumentException(errMsg);
			}
			rs.setPicture(picture);
		}

		Project exist = commonService.getByBid(Project.class, model.getBid());
		if (exist != null) {
			// BeanUtils.copyProperties(rs, exist, IGNORE_PROPERTIES_PROJECT);
			// rs = exist;
			return null;
		}

		return rs;
	}

	public ProjectMedia mergeProjectMedia(ProjectMedia model) {
		ProjectMedia rs = model;
		Project project = commonService.getByBid(Project.class, rs.getProject()
				.getBid());
		if (project == null) {
			String errMsg = "Can not find project :" + rs.getProject().getBid()
					+ " for ProjectMedia:" + rs;
			this.log.error(errMsg);
			throw new IllegalArgumentException(errMsg);
		}
		rs.setProject(project);

		Media media = commonService.getByBid(Media.class, rs.getMedia()
				.getBid());
		if (media == null) {
			String errMsg = "Can not find media :" + rs.getMedia().getBid()
					+ " for ProjectMedia:" + rs;
			this.log.error(errMsg);
			throw new IllegalArgumentException(errMsg);
		}
		rs.setMedia(media);

		ProjectMediaQueryCondition queryCondition = new ProjectMediaQueryCondition();
		queryCondition.setProjectBid(model.getProject().getBid());
		queryCondition.setMediaBid(model.getMedia().getBid());
		List<ProjectMedia> list = commonService.query(ProjectMedia.class,
				queryCondition);
		if (list != null && !list.isEmpty()) {
			// ProjectMedia exist = list.get(0);
			// rs = exist;
			return null;
		}

		return rs;
	}

	public Stage mergeStage(Stage model) {
		Stage rs = model;

		Project project = commonService.getByBid(Project.class, rs.getProject()
				.getBid());
		if (project == null) {
			String errMsg = "Can not find project :" + rs.getProject().getBid()
					+ " for Stage:" + rs.getBid();
			this.log.error(errMsg);
			throw new IllegalArgumentException(errMsg);
		}
		rs.setProject(project);

		Stage exist = commonService.getByBid(Stage.class, model.getBid());
		if (exist != null) {
			// BeanUtils.copyProperties(rs, exist, IGNORE_PROPERTIES_STAGE);
			// rs = exist;
			return null;
		}
		return rs;
	}

	public Building mergeBuilding(Building model) {
		Building rs = model;

		Stage stage = commonService.getByBid(Stage.class, rs.getStage()
				.getBid());
		if (stage == null) {
			String errMsg = "Can not find stage :" + rs.getStage().getBid()
					+ " for Buidling:" + rs.getBid();
			this.log.error(errMsg);
			throw new IllegalArgumentException(errMsg);
		}
		rs.setStage(stage);

		Building exist = commonService.getByBid(Building.class, model.getBid());
		if (exist != null) {
			// BeanUtils.copyProperties(rs, exist, IGNORE_PROPERTIES_BUILDING);
			// rs = exist;
			return null;
		}
		return rs;
	}

	public Floorplan mergeFloorplan(Floorplan model) {
		Floorplan rs = model;

		Building building = commonService.getByBid(Building.class, rs
				.getBuilding().getBid());
		if (building == null) {
			String errMsg = "Can not find building :"
					+ rs.getBuilding().getBid() + " for Floorplan:"
					+ rs.getBid();
			this.log.error(errMsg);
			throw new IllegalArgumentException(errMsg);
		}
		rs.setBuilding(building);

		if (rs.getPublicPicture() != null
				&& rs.getPublicPicture().getBid() != null) {
			Media publicPicture = commonService.getByBid(Media.class, rs
					.getPublicPicture().getBid());
			if (publicPicture == null) {
				String errMsg = "Can not find publicPicture :"
						+ rs.getPublicPicture().getBid() + " for Floorplan:"
						+ rs.getBid();
				this.log.error(errMsg);
				throw new IllegalArgumentException(errMsg);
			}
			rs.setPublicPicture(publicPicture);
		}

		Media salePicture = commonService.getByBid(Media.class, rs
				.getSalePicture().getBid());
		if (salePicture == null) {
			String errMsg = "Can not find salePicture :"
					+ rs.getSalePicture().getBid() + " for Floorplan:"
					+ rs.getBid();
			this.log.error(errMsg);
			throw new IllegalArgumentException(errMsg);
		}
		rs.setSalePicture(salePicture);

		Floorplan exist = commonService.getByBid(Floorplan.class,
				model.getBid());
		if (exist != null) {
			// BeanUtils.copyProperties(rs, exist, IGNORE_PROPERTIES_FLOORPLAN);
			// rs = exist;
			return null;
		}

		return rs;
	}

	public Apartment mergeApartment(Apartment model) {
		Apartment rs = model;

		Floorplan floorplan = commonService.getByBid(Floorplan.class, rs
				.getFloorplan().getBid());
		if (floorplan == null) {
			String errMsg = "Can not find floorplan :"
					+ rs.getFloorplan().getBid() + " for Apartment:"
					+ rs.getBid();
			this.log.error(errMsg);
			throw new IllegalArgumentException(errMsg);
		}
		rs.setFloorplan(floorplan);

		Apartment exist = commonService.getByBid(Apartment.class,
				model.getBid());
		if (exist != null) {
			// BeanUtils.copyProperties(rs, exist, IGNORE_PROPERTIES_APARTMENT);
			// rs = exist;
			return null;
		}
		return rs;
	}
}
