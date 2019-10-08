package com.abilists.service.plugins.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abilists.bean.model.survey.PluginsMSurveyModel;
import com.abilists.bean.para.survey.IstSurveyPara;
import com.abilists.bean.para.survey.SltSurveyPara;
import com.abilists.bean.para.survey.UdtSurveyPara;
import com.abilists.core.service.AbilistsAbstractService;
import com.abilists.dao.plugins.MSurveyDao;
import com.abilists.dao.plugins.SSurveyDao;
import com.abilists.service.plugins.SurveyService;

@Service
public class SurveyServiceImpl extends AbilistsAbstractService implements SurveyService {

	final Logger logger = LoggerFactory.getLogger(SurveyServiceImpl.class);

	@Autowired
	private SqlSession sAbilistsDao;

	@Override
	public List<PluginsMSurveyModel> sltServeyList(SltSurveyPara sltSurveyPara) throws Exception {
		List<PluginsMSurveyModel> surveyList = null;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", sltSurveyPara.getUserId());

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			surveyList = sAbilistsDao.getMapper(SSurveyDao.class).sltPluginsMSurveyList(map);

		} catch (Exception e) {
			logger.error("sltOptions Exception error", e);
		}

		return surveyList;
	}

	@Override
	public PluginsMSurveyModel sltServey(SltSurveyPara sltSurveyPara) throws Exception {
		PluginsMSurveyModel survey = null;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", sltSurveyPara.getUserId());

		try {
			sqlSessionSlaveFactory.setDataSource(getDispersionDb());
			survey = sAbilistsDao.getMapper(SSurveyDao.class).sltPluginsMSurvey(map);
			if(survey == null) {
				logger.error("There is no user default options data. please insert your default data.");
			}
		} catch (Exception e) {
			logger.error("sltOptions Exception error", e);
		}

		return survey;
	}

	@Transactional(rollbackFor = {IndexOutOfBoundsException.class, Exception.class}, propagation = Propagation.REQUIRES_NEW)
	@Override
	public boolean istServey(IstSurveyPara istSurveyPara) throws Exception {
		try {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", istSurveyPara.getUserId());

		} catch (IndexOutOfBoundsException ie) {
			logger.error("IndexOutOfBoundsException error", ie);
			return false;
		} catch (Exception e) {
			logger.error("Exception error", e);
			return false;
		}

		return true;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public boolean udtServey(UdtSurveyPara udtSurveyPara) throws Exception {

		int intResult = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", udtSurveyPara.getUserId());

		try {
			intResult = mAbilistsDao.getMapper(MSurveyDao.class).udtPluginsMSurvey(map);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}
	
		if(intResult < 1) {
			logger.error("udtServey error, userId={}", udtSurveyPara.getUserId());
			return false;
		}
	
		return true;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public boolean dltServey(UdtSurveyPara udtSurveyPara) throws Exception {

		int intResult = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", udtSurveyPara.getUserId());

		try {
			intResult = mAbilistsDao.getMapper(MSurveyDao.class).udtPluginsMSurvey(map);
		} catch (Exception e) {
			logger.error("Exception error", e);
		}

		if(intResult < 1) {
			logger.error("dltServey error, userId={}", udtSurveyPara.getUserId());
			return false;
		}
	
		return true;
	}

}