package com.qa.Employee.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.employee.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Employees extends TestBase {

	@BeforeClass
	void getAllEmployees() throws InterruptedException {

		logger.info("******************* Started TC001_Get_All_Employees ********************");

		RestAssured.baseURI = "http://localhost:3000";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/users");

		Thread.sleep(5000);

	}

	@Test
	void checkResposeBody() {

		logger.info("***********  Checking Respose Body **********");
		String responseBody = response.getBody().asString();
		logger.info("Response body is---> " + responseBody);
		Assert.assertTrue(responseBody != null);
		System.out.println("Response Body is :" + responseBody);

	}

	@Test
	void checkStatusCode() {

		logger.info("***********  Checking Respose Status **********");
		int statusCode = response.statusCode();
		logger.info("Status code is --> " + statusCode);
		Assert.assertEquals(statusCode, 200);
		System.out.println("Response Body is :" + statusCode);
	}

	@Test
	void checkResponseTime() {

		logger.info("***********  Checking Respose Time **********");
		long responseTime = response.time();
		logger.info("Response Time is --> " + responseTime);
		if (responseTime > 2000) {
			logger.warn("Response Time is greater than 2000");
			Assert.assertTrue(responseTime > 1000);
			System.out.println("Response Body is :" + responseTime);
		}

	}

	@Test
	void checkstatusLine() {
		logger.info("***********  Checking Status Line **********");

		String statusLine = response.getStatusLine(); // Getting status Line
		logger.info("Status Line is ==>" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		System.out.println("Response Body is :" + statusLine);

	}

	@Test
	void checkContentType() {

		logger.info("***********  Checking Content Type **********");

		String contentType = response.header("Content-Type");
		logger.info("Content type is ==>" + contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		System.out.println("Response Body is :" + contentType);
	}

	void checkserverType() {

		logger.info("***********  Checking Server Type **********");

		String ServerType = response.header("Server");
		logger.info("Content type is ==>" + ServerType);
		Assert.assertEquals(ServerType, "cloudflare");
		System.out.println("Response Body is :" + ServerType);

	}

	@Test
	void checkcontentEncoding() {
		logger.info("***********  Checking Content Encoding**********");

		String contentEncoding = response.header("Content-Encoding");
		logger.info("Content Encoding is==>" + contentEncoding);
		Assert.assertEquals(contentEncoding, null);
		System.out.println("Response Body is :" + contentEncoding);

	}

	void checkContentLenght() {

		logger.info("***********  Checking Content Length**********");

		String contentLength = response.header("Content-Length");
		logger.info("Content Length is==>" + contentLength);

		if (Integer.parseInt(contentLength) > 700) { // convert int to string
			logger.warn("Content Length is less than 100");

			Assert.assertTrue(Integer.parseInt(contentLength) > 100);

		}
	}

	void checkCookies() {
		logger.info("***********  Checking Cookies **********");
		String getCookies = response.getCookie("__cfduild");
		logger.info("Content Length is==>" + getCookies);
		Assert.assertEquals(getCookies, "d7dc99f48753cfdba748aed5b711dc8a81620474715");
		System.out.println("Response Body is :" + getCookies);

	}

	@AfterClass
	void tearDown() {
		logger.info("*********  Finished TC001_Get_All_Employees **********");
	}

}
