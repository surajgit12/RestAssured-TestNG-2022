package com.qa.employee.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

// for this we need to add 	<!-- 	RandomStringUtils maven dependency -->

public class RestUtils {

	public static String User_first_name() {

		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Kori" + generatedString);

	}

	public static String User_last_name() {

		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Santener" + generatedString);

	}

	public static String User_id() {
		String generatedString = RandomStringUtils.randomNumeric(3);
		return (generatedString);
	}

	public static String User_SubjectID() {
		String generatedString = RandomStringUtils.randomNumeric(3);
		return (generatedString);
	}

}
