package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.MediaDao;
import com.befun.domain.estate.Media;

@Repository("MediaDao")
public class MediaDaoImpl extends BaseHibernateDao<Media, Long> implements MediaDao {

}
