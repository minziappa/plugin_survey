package com.abilists.service.plugins.impl;

public class InitiativeServiceImplTest {
	public static void main(String[] args) {
		
		InitiativeServiceImpl initiativeService = new InitiativeServiceImpl();
		try {
			initiativeService.createTables("test");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("aaa==>");
	}
}
