package com.abilists.dao.plugins;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.abilists.bean.model.survey.PluginsMSurveyModel;

@Repository
public interface SSurveyDao {

	public List<PluginsMSurveyModel> sltPluginsMSurveyList(Map<String, Object> map) throws SQLException;
	public PluginsMSurveyModel sltPluginsMSurvey(Map<String, Object> map) throws SQLException;

}