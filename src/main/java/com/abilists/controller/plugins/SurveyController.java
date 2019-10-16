package com.abilists.controller.plugins;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abilists.bean.para.survey.SltSurveyPara;
import com.abilists.core.common.bean.ConfigBean;
import com.abilists.core.utility.PathUtility;
import com.abilists.plugins.controller.AbstractController;
import com.abilists.service.plugins.SurveyService;
import com.abilists.service.plugins.impl.InitiativeServiceImpl;

@SessionAttributes(value = {"configBean"})
@Controller
@RequestMapping("/plugins/survey")
public class SurveyController extends AbstractController {
	final Logger logger = LoggerFactory.getLogger(InitiativeServiceImpl.class);
	
	@Autowired
	private ConfigBean configBean;

	@Autowired
	private SurveyService surveyService;

	@RequestMapping(value = {"/", "", "index"})
	public String index(HttpServletRequest request, ModelMap model) throws Exception {
		// Set base URL
		configBean.setBaseURL(PathUtility.getURLBase(request));
		configBean.setContextPath(request.getContextPath());
		model.addAttribute("configBean", configBean);

		return "apps/plugins/survey/index";
	}

    @RequestMapping(value = {"serveyList"}, method=RequestMethod.GET)
	public String serveyList(@Validated SltSurveyPara sltSurveyPara, 
			BindingResult bindingResult, ModelMap model, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception {

    	// surveyService.sltServeyList(sltSurveyPara);

		model.addAttribute("configBean", model);

	   	return "apps/plugins/survey/serveyList";
	}

}