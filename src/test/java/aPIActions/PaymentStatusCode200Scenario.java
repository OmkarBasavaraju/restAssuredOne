package aPIActions;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import Base.Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PaymentStatusCode200Scenario extends Base {
	
	public static String AccessToken;
	public static String id;
	
	@Test(priority =1)
	public void getAcesstoken() {
		Response resp = given().params("grant_type","client_credentials").auth().preemptive().basic(prop.getProperty("UserName"), prop.getProperty("Password")).post("/v1/oauth2/token");
		System.out.println(resp.getStatusCode());
		AccessToken = resp.jsonPath().get("access_token").toString();
		id = resp.jsonPath().get("app_id").toString();
		System.out.println(AccessToken);
		System.out.println(id);
	}
	
	@Test(priority =2)
public void authorizePayment() {
	Response resp = given().accept(ContentType.JSON).auth().preemptive().basic(prop.getProperty("UserName"), prop.getProperty("Password")).get("/v2/payments/authorizations/0VF52814937998046");
	System.out.println(resp.asPrettyString());
}
}
// /v2/payments/authorizations