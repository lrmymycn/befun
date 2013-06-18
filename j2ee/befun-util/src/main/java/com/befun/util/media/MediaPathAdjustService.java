package com.befun.util.media;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.Assert;

import com.befun.config.MediaConfig;
import com.befun.domain.PaginationBean;
import com.befun.domain.estate.Media;
import com.befun.service.estate.MediaService;
import com.befun.service.query.estate.MediaQueryCondition;

@Service("MediaPathAdjustService")
public class MediaPathAdjustService {

	private Log log = LogFactory.getLog(this.getClass());

	@Resource
	@Qualifier("txManager")
	private HibernateTransactionManager tm;

	@Resource
	@Qualifier("MediaService")
	private MediaService mediaService;

	@Resource
	@Qualifier("MediaConfig")
	private MediaConfig mediaConfig;

	public void adjustAllMedias() {
		long pageNumber = 1;
		int pageSize = 200;
		MediaQueryCondition qc = new MediaQueryCondition();
		qc.getOrderBy().add(Order.asc("id"));
		PaginationBean<Media> pgb = this.mediaService.query(qc, pageNumber,
				pageSize);
		long pageCount = pgb.getTotalPageCount();
		for (int i = 0; i < pageCount; i++) {
			TransactionDefinition definition = new DefaultTransactionDefinition(
					TransactionDefinition.PROPAGATION_REQUIRED);
			TransactionStatus status = null;
			boolean success = false;
			try {
				status = tm.getTransaction(definition);
				pgb = this.mediaService.query(qc, pageNumber + i, pageSize);
				for (Media m : pgb.getModels()) {
					this.adjustMedia(m);
				}
				success = true;
			} catch (Exception ex) {
				log.error(ex);
				throw new RuntimeException("Adjust media error!",ex);
			} finally {
				if (success) {
					tm.commit(status);
				} else {
					tm.rollback(status);
				}
			}
		}
	}

	public void adjustMedia(Media media) {
		TransactionDefinition definition = new DefaultTransactionDefinition(
				TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = null;
		boolean success = false;
		try {
			status = tm.getTransaction(definition);
			String projectBid = media.getProjectBid();
			if (StringUtils.isBlank(projectBid)) {
				return;
			}
			String largeUrl = media.getLargeUrl();
			String mediumUrl = media.getMediumUrl();
			String smallUrl = media.getSmallUrl();
			if (isOldUrl(largeUrl, projectBid)) {
				String destUrl = getDestUrl(largeUrl, projectBid);
				if (this.moveImageFile(largeUrl, destUrl)) {
					media.setLargeUrl(getDestUrl(largeUrl, projectBid));
				}
			}
			if (isOldUrl(mediumUrl, projectBid)) {
				String destUrl = getDestUrl(mediumUrl, projectBid);
				if (this.moveImageFile(mediumUrl, destUrl)) {
					media.setMediumUrl(getDestUrl(mediumUrl, projectBid));
				}
			}
			if (isOldUrl(smallUrl, projectBid)) {
				String destUrl = getDestUrl(smallUrl, projectBid);
				if (this.moveImageFile(smallUrl, destUrl)) {
					media.setSmallUrl(getDestUrl(smallUrl, projectBid));
				}
			}
			mediaService.saveOrUpdate(media);
			success = true;
		} catch (Exception ex) {
			log.error(ex);
			throw new RuntimeException("Adjust media error!",ex);
		} finally {
			if (success) {
				tm.commit(status);
			} else {
				tm.rollback(status);
			}
		}

	}

	private String getDestUrl(String oriUrl, String projectBid) {
		Assert.notNull(oriUrl, "Original URL should be not null!");
		Assert.notNull(projectBid, "Project Bid should be not null!");
		String regex = "^(/img/)(.+)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(oriUrl);
		StringBuilder sb = new StringBuilder("/img/").append(projectBid);
		if (m.find()) {
			String fileName = m.group(2);
			sb.append("/").append(fileName);
			return sb.toString();
		}
		return oriUrl;
	}

	private boolean isOldUrl(String oriUrl, String projectBid) {
		Assert.notNull(oriUrl, "Original URL should be not null!");
		Assert.notNull(projectBid, "Project Bid should be not null!");
		return !oriUrl.contains(projectBid);
	}

	private boolean moveImageFile(String oriUrl, String destUrl) {
		String oriFilePath = mediaConfig.getImgRootPath() + oriUrl.substring(4);
		String destFilePath = mediaConfig.getImgRootPath()
				+ destUrl.substring(4);
		File originalFile = new File(oriFilePath);
		File destFile = new File(destFilePath);
		String destDir = destFile.getParent();
		String destFileName = destFile.getName();
		destFile = this.generateDestFile(originalFile, destDir, destFileName);

		destFile.getParentFile().mkdirs();
		if (originalFile.exists()) {
			boolean success = originalFile.renameTo(destFile);
			this.log.info("Move image " + oriFilePath + " " + success);
			return success;
		}
		this.log.warn("Image " + oriFilePath + " not found! ");
		return false;
	}

	private File generateDestFile(File originalFile, String destDir,
			String destFileName) {
		File destFile = new File(destDir, destFileName);
		String destFileNameWithoutExt = destFileName.substring(0,
				destFileName.lastIndexOf("."));
		String extName = destFileName
				.substring(destFileName.lastIndexOf(".") + 1);
		if (destFile.exists()) {
			for (int i = 0; i < 1000; i++) {
				destFile = new File(destDir, destFileNameWithoutExt + "(" + i
						+ ")." + extName);
				if (!destFile.exists()) {
					break;
				}
			}
		}
		return destFile;
	}

	// @Test
	// public void test1() {
	// String oriUrl = "/img/others/small/alcove.jpg";
	// String projectBid = "pro_b6ddd784-c878-49c7-a08d-112a12a3d453";
	// if (isOldUrl(oriUrl, projectBid)) {
	// String durl = getDestUrl(oriUrl, projectBid);
	// System.out.println(durl);
	// }
	// }
	//
	// @Test
	// public void test2() {
	// String oriUrl =
	// "/img/pro_b7ddd784-c878-49c7-a08d-112a12a3d453/others/small/alcove.jpg";
	// String projectBid = "pro_b7ddd784-c878-49c7-a08d-112a12a3d453";
	// if (isOldUrl(oriUrl, projectBid)) {
	// String durl = getDestUrl(oriUrl, projectBid);
	// System.out.println(durl);
	// }
	// }
	//
	// @Test
	// public void test3() {
	// String oriUrl = "/img/others/small/alcove.jpg";
	// String destUrl =
	// "/img/pro_b7ddd784-c878-49c7-a08d-112a12a3d453/others/small/alcove.jpg";
	// this.moveImageFile(oriUrl, destUrl);
	//
	// }
	//
	// @Test
	// public void test4() {
	//
	// String destFileName = "alcove.jpg";
	// System.out.println(destFileName.substring(0,
	// destFileName.lastIndexOf(".")));
	// System.out
	// .println(destFileName.substring(destFileName.lastIndexOf(".") + 1));
	// }
}
