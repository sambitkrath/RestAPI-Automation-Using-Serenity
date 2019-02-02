package com.restapi.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {

	@BeforeClass
	public static void init(){
		//RestAssured.baseURI = "http://localhost:8085/student";
		RestAssured.baseURI = "https://api.tmsandbox.co.nz";
		RestAssured.basePath="/v1";
		
	}
}