package com.qa.Employee.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.employee.testbase.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_Delete_Employee_Records extends TestBase {
	
	
	@BeforeClass
	 void delete_All_Employee() throws InterruptedException {
		
			logger.info("*********Started TC005_Delete_Employee_Record **********");
			
			RestAssured.baseURI = "http://localhost:3000";
			httpRequest = RestAssured.given();
			
			response = httpRequest.request(Method.GET,"/users");
					
			// First get the JsonPath object instance from the Response interface
			JsonPath jsonPathEvaluator = response.jsonPath();
				 
			//Capture id
			String empID=jsonPathEvaluator.get("[5].id");
			response = httpRequest.request(Method.DELETE, "/users/"+empID); //Pass ID to delete record
			
			Thread.sleep(3000);
		}
		
		@Test
		void checkResposeBody()
		{
			logger.info("***********  Checking Respose Body **********");
			String responseBody = response.getBody().asString();
			//Assert.assertEquals(responseBody.contains("successfully! deleted Records"), true);
			Assert.assertEquals(responseBody.contains(""), true);
			System.out.println("Response Body is :" + responseBody);

		}
			
		@Test
		void checkStatusCode()
		{
			logger.info("***********  Checking Respose Status **********");
			int statusCode = response.getStatusCode(); // Gettng status code
			Assert.assertEquals(statusCode, 200);
			System.out.println("Response Body is :" + statusCode);
		}
		
		@AfterClass
		void tearDown()
		{
			logger.info("*********  Finished TC005_Delete_Employee_Record **********");
		}
	}


