package com.abilists.controller.plugins;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abilists.bean.para.survey.SltSurveyPara;
import com.abilists.plugins.service.PluginService;
import com.abilists.service.plugins.SurveyService;

@Controller
@RequestMapping("/plugins/survey")
public class SurveyController {

	@Autowired
	private SurveyService surveyService;
	@Autowired
	private PluginService pluginService;

    @RequestMapping(value = {"/", "", "index"})
	public String index(@Validated SltSurveyPara sltSurveyPara, 
			BindingResult bindingResult, ModelMap model, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception {

    	pluginService.createTables("servey");

	   	return "apps/plugins/survey/index";
	}

    @RequestMapping(value = {"serveyList"}, method=RequestMethod.GET)
	public String serveyList(@Validated SltSurveyPara sltSurveyPara, 
			BindingResult bindingResult, ModelMap model, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception {

    	surveyService.sltServeyList(sltSurveyPara);

		model.addAttribute("configBean", model);

	   	return "apps/plugins/survey/serveyList";
	}


}