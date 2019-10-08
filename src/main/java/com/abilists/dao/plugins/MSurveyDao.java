package com.abilists.dao.plugins;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface MSurveyDao {

	public int istPluginsMSurvey(Map<String, Object> map) throws SQLException;
	public int udtPluginsMSurvey(Map<String, Object> map) throws SQLException;
	public int dltPluginsMSurvey(Map<String, Object> map) throws SQLException;

}