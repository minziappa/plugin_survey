package com.abilists.plugin.survey.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abilists.plugins.service.LtapService;

public class SurveyService implements LtapService {

	final Logger logger = LoggerFactory.getLogger(SurveyService.class);

	@Override
	public String loginLtap() throws Exception {
		
		System.out.println("TEST OK");

		return null;
	}

}
