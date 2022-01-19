package com.qa.Employee.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.employee.Utilities.RestUtils;
import com.qa.employee.testbase.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC004_Put_Employee_Records extends TestBase{


	String Empfirstname = RestUtils.User_first_name();
	String Emplastname = RestUtils.User_last_name();
	String Empid = RestUtils.User_id();
	String EmpsubjectId = RestUtils.User_SubjectID();

	@BeforeClass
	void Update_Existing_Users() throws InterruptedException {

		logger.info("*********Started TC003_Post_Employee_Record **********");

		RestAssured.baseURI = "http://localhost:3000";
		httpRequest = RestAssured.given();

		// JSONObject is a class that represents a simple JSON. We can add Key-Value
		// pairs using the put method
		// {"first_name":"Rakesh","last_name":"Kumar","id" :6,"subjectID":1}

		JSONObject requestParms = new JSONObject();
		
	
		requestParms.put("first_name", Empfirstname);
		requestParms.put("last_name", Emplastname);
		requestParms.put("id", empId);
		requestParms.put("subjectId", EmpsubjectId);

		// Add a header stating the Request body is a JSON

		httpRequest.headers("content-type", "application/json");

		// Add the Json to the body of the request
		httpRequest.body(requestParms.toJSONString());

		response = httpRequest.request(Method.PUT, "/users/"+empId);

		Thread.sleep(5000);

	}

	@Test
	void checkResposeBody()
	{
		logger.info("***********  Checking Respose Body **********");
		
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("first_name"), true);
		Assert.assertEquals(responseBody.contains("last_name"), true);
		Assert.assertEquals(responseBody.contains("id"), true);
		Assert.assertEquals(responseBody.contains("subjectId"), true);
		
		System.out.println("Response Body is :" + responseBody);
	}
	
	@Test
	void checkStatusCode() {

		logger.info("***********  Checking Respose Status **********");
		int statusCode = response.statusCode();
		logger.info("Status code is --> " + statusCode);
		Assert.assertEquals(statusCode, 200);
		System.out.println("Response Status Code is :" + statusCode);
	}
	

	@AfterClass
	void tearDown() {
		logger.info("*********  Finished TC004_Get_All_Employees **********");
	}
}

	
