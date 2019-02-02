package com.restapi.junit.automation;
import java.util.HashMap;
//import com.jayway.restassured.RestAssured;
//import com.jayway.restassured.builder.ResponseSpecBuilder;
//import com.jayway.restassured.specification.ResponseSpecification;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import com.restapi.cucumber.serenity.APISerenitySteps;
import com.restapi.testbase.TestBase;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class APITestAutomation extends TestBase {
	
	static ResponseSpecBuilder responseBuilder;
	static ResponseSpecification responseSpec;
	static String promotionElementName="Gallery";
	static String categoryName="Carbon credits";
	static String endPointURL = "/Categories/6327/Details.json?catalogue=false";
	static String canRelistKey = "CanRelist";
	static String descriptionKey ="Description";
	static String descriptionSubstring="2x larger image";
	
	@Steps
	APISerenitySteps steps;
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "https://api.tmsandbox.co.nz";
		RestAssured.basePath="/v1";
		responseBuilder= new ResponseSpecBuilder();
		responseBuilder.expectHeader("Content-Type","application/json");
		responseBuilder.expectStatusCode(200);
		responseBuilder.expectBody("Name",equalTo(categoryName));
		responseSpec=responseBuilder.build();
	}
	
	@Step("Validation - CanRelist as true")
	@Title("This test will validate CanRelist as true")
	@Test
	public void APIAssignmentAcceptanceCriteria2(){
		
		/**
		  * given()
		  * set cookies,add auth,adding parameters,setting header info
		  * .when()
		  *  GET,POST,PUT,DELETE..etc
		  * .then()
		  *  Validate status code,extract response, extract headers,cookies,extract the response body
		  * .statuscode(200) 
		  *  returning status code 200 - Status - Success
		  *  .extract.path()
		  *  Extracting the JsonPath Matched String
		  *  
		  */
		
		 boolean canRelistVal = steps.getResponse(endPointURL)
    	 .statusCode(200)
    	 .log()
    	 .all()
    	 .extract().path(canRelistKey);
		
		 // Validation - JsonPath Matched String 'CanRelist' as true
         assertTrue(canRelistVal);
	}
	
	@Title("This test will validate Description of Promotion Element contains text '2x larger image")
	@Test
	public void APIAssignmentAcceptanceCriteria3(){
		
		//Returning Promotion Element Hash Object
		HashMap<String,String> responseHashObj = steps.getDescriptionoByNameOfPromotionElement(promotionElementName,endPointURL);
		
		//Validation - Promotion Element description with Name = 'Gallery' is validated of contains text '2x larger image'
		assertThat(responseHashObj.get(descriptionKey),containsString(descriptionSubstring));
	}
	
	@Step("Validation - Name as Carbon Credits")
	@Title("This test will validate Name as Carbon Credits")
	@Test
	public void APIAssignmentAcceptanceCriteria1(){
		
		/**
		  * given()
		  * set cookies,add auth,adding parameters,setting header info
		  * .when()
		  *  GET,POST,PUT,DELETE..etc
		  * .then()
		  *  Validate status code,extract response, extract headers,cookies,extract the response body
		  * .spec()
		  *  passing ResponseSpecification object as an arguement
		  *  
		  */
		
			steps.getResponse(endPointURL)
			.statusCode(200)
			.log()
			.all()
			.spec(responseSpec);

}
}