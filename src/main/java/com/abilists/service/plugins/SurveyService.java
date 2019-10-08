package com.abilists.service.plugins;

import java.util.List;

import com.abilists.bean.model.survey.PluginsMSurveyModel;
import com.abilists.bean.para.survey.IstSurveyPara;
import com.abilists.bean.para.survey.SltSurveyPara;
import com.abilists.bean.para.survey.UdtSurveyPara;

public interface SurveyService {

	public List<PluginsMSurveyModel> sltServeyList(SltSurveyPara sltSurveyPara) throws Exception;
	public PluginsMSurveyModel sltServey(SltSurveyPara sltSurveyPara) throws Exception;
	public boolean istServey(IstSurveyPara istSurveyPara) throws IndexOutOfBoundsException, Exception;
	public boolean udtServey(UdtSurveyPara udtSurveyPara) throws Exception;
	public boolean dltServey(UdtSurveyPara udtSurveyPara) throws Exception;

}
