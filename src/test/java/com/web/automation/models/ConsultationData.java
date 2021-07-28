package com.web.automation.models;

import java.io.IOException;
import java.util.Properties;

import com.web.automation.constants.TestRunnerConstants;
import com.web.automation.util.PropertiesManager;

public class ConsultationData {

	private static PropertiesManager consultationProperties;

	private static String consultationIdField = "consultationId";
	private static String patientNameField = "patient";
	private static String patientCardNumberField = "patient_card";
	private static String ConsultationStartDateField = "consultation_start_date";
	private static String consultationStartHourField = "consultation_start_hour";
	private static String consultationEndDateField = "consultatio_end_date";
	private static String consultationEndHourField = "consultation_end_hour";
	private static String consultationCodeField = "consultation_code";
	private static String serviceNameField = "service_name";

	static {
		consultationProperties = new PropertiesManager(TestRunnerConstants.CONSULTATION_PROPERTIES_PATH);
	}

	public static String getConsultationId() throws IOException {
		return consultationProperties.getProperties().getProperty(consultationIdField);
	}

	public static void setConsultationId(String consultationId) throws IOException {
		consultationProperties.setProperty(consultationIdField, consultationId);
	}

	public static String getPatientName() throws IOException {
		return consultationProperties.getProperties().getProperty(patientNameField);
	}

	public static void setPatientName(String patientName) throws IOException {
		consultationProperties.setProperty(patientNameField, patientName);
	}

	public static String getPatientCardNumber() throws IOException {
		return consultationProperties.getProperties().getProperty(patientCardNumberField);
	}

	public static void setPatientCardNumber(String patientCardNumber) throws IOException {
		consultationProperties.setProperty(patientCardNumberField, patientCardNumber);
	}

	public static String getConsultationStartDate() throws IOException {
		return consultationProperties.getProperties().getProperty(ConsultationStartDateField);
	}

	public static void setConsultationStartDate(String consultationStartDate) throws IOException {
		consultationProperties.setProperty(ConsultationStartDateField, consultationStartDate);
	}

	public static String getConsultationStartHour() throws IOException {
		return consultationProperties.getProperties().getProperty(consultationStartHourField);
	}

	public static void setConsultationStartHour(String consultationStartHour) throws IOException {
		consultationProperties.setProperty(consultationStartHourField, consultationStartHour);
	}

	public static String getConsultationEndDate() throws IOException {
		return consultationProperties.getProperties().getProperty(consultationEndDateField);
	}

	public static void setConsultationEndDate(String consultationEndDate) throws IOException {
		consultationProperties.setProperty(consultationEndDateField, consultationEndDate);
	}

	public static String getConsultationEndHour() throws IOException {
		return consultationProperties.getProperties().getProperty(consultationEndHourField);
	}

	public static void setConsultationEndHour(String consultationEndHour) throws IOException {
		consultationProperties.setProperty(consultationEndHourField, consultationEndHour);
	}

	public static String getConsultationCode() throws IOException {
		return consultationProperties.getProperties().getProperty(consultationCodeField);
	}

	public static void setConsultationCode(String consultationCode) throws IOException {
		consultationProperties.setProperty(consultationCodeField, consultationCode);
	}

	public static String getServiceName() throws IOException {
		return consultationProperties.getProperties().getProperty(serviceNameField);
	}

	public static void setServiceName(String serviceName) throws IOException {
		consultationProperties.setProperty(serviceNameField, serviceName);
	}

}
