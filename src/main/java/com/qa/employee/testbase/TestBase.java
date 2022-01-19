package com.qa.employee.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httpRequest;
	public static Response response;
	public String empId="409"; //111111 Hard coded - Input for Get details of Single Employee & update employee
	

	public Logger logger;

	@BeforeClass
	public void setUp() {

		logger = Logger.getLogger("EmployeesRestAPI"); // added Logger
		PropertyConfigurator.configure("Log4j.properties");//added logger
		logger.setLevel(org.apache.log4j.Level.DEBUG);

	}

	
}
