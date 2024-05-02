package com.training.restapi;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class ApiAutomationUsers {
String sHostUrl="https://jsonplaceholder.typicode.com/";
String sendpoint="users";
String sURI;


 @Test
 
public void validusers() {
	 
	 sURI=sHostUrl+sendpoint;
     RestAssured.baseURI=sURI;  //copy paste your uri
     Response response = RestAssured.given().get();
     System.out.println(response.getStatusCode());
     //response.prettyPrint();
     
     String Expectedemail="Sincere@april.biz";
     //String Actualemail= response.jsonPath().get("email[0]");
     //assertEquals(Actualemail, Expectedemail);

     //equalTo - HamcrestMatcher 
     response.then().body("email[0]",equalTo(Expectedemail));
     response.then().body("email[0]", startsWith("S"));
     response.then().body("address.city", hasItem("Howemouth"));
     
	 
	 
 }
}
