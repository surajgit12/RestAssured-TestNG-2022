package com.qa.Employee.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.employee.testbase.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Single_Employee_Record extends TestBase {
	
	@BeforeClass
	void getEmployeeData() throws InterruptedException
	{
		logger.info("*********11 Started TC002_Get_Single_Employee_Record **********");
		
		RestAssured.baseURI = "http://localhost:3000"; // Fake API Created for Video path "https://www.youtube.com/watch?v=7vx0RIwHVzg"
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/users/"+empId);
		
		Thread.sleep(7000);
	}
	
	@Test
	void checkResposeBody()
	{
		logger.info("***********  Checking Respose Body **********");
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empId),true);
		System.out.println("Response Body is :" + responseBody);
	}
		
	@Test
	void checkStatusCode()
	{
		logger.info("***********  Checking Status Code **********");
		int statusCode = response.getStatusCode(); // Gettng status code
		Assert.assertEquals(statusCode, 200);
		System.out.println("Response Status Code is :" + statusCode);
	}
	

	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC002_Get_Single_User_Record **********");
	}
	
}



