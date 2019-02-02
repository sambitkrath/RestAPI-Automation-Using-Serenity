package com.restapi.cucumber.serenity;
import java.util.HashMap;
import com.restapi.utils.ReuseableSpecifications;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class APISerenitySteps {

	@Step("Getting a validatableResponse")
	public ValidatableResponse getResponse(String endPointURL){
		
	return	SerenityRest.rest().given()
		.spec(ReuseableSpecifications.getGenericRequestSpec())
		.when()
		.get(endPointURL)
		.then();
	}
	
	@Step("Getting Description information of the Promotion element with name: {0}")
	public HashMap<String,String> getDescriptionoByNameOfPromotionElement(String promotionElementName,String endPointURL){
		String jsonPathMatchString1 = "Promotions.findAll{it.Name=='";
		String jsonPathMatchString2 = "'}.get(0)";
		
	return	SerenityRest.rest().given()
		.when()
		.get(endPointURL)
		.then()
		.log()
		.all()
		.extract()
		.path(jsonPathMatchString1+promotionElementName+jsonPathMatchString2);
	}
	
	}

