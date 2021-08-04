package com.web.automation.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class DateManager {

	private static DateTimeFormatter pattern1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void setDateTimeFormatter(String pattern) {
		pattern1 = DateTimeFormatter.ofPattern(pattern);
	}

	public static String convertToPatternDate(String value) throws Exception {
		LocalDateTime currentDate = LocalDateTime.now();
		if (value.contains("+")) {
			String[] values = value.split(Pattern.quote("+"));
			String daysToAdd = values[1].replace("d", "");
			value = currentDate.plusDays(Integer.parseInt(daysToAdd)).format(pattern1).toString();
		} else if (value.contains("-")) {
			String[] values = value.split(Pattern.quote("-"));
			String daysToSubtract = values[1].replace("d", "");
			value = currentDate.minusDays(Integer.parseInt(daysToSubtract)).format(pattern1).toString();
		} else if (value.equalsIgnoreCase("hoje") || (value.equalsIgnoreCase("agora"))) {
			value = currentDate.format(pattern1).toString();
		} else if (value.equalsIgnoreCase("ontem")) {
			value = currentDate.minusDays(1).format(pattern1).toString();
		} else {
			throw new Exception("Invalid date!");
		}

		return value;
	}
	
	public static String convertToPatternDate(String value, String pattern) throws Exception {
		LocalDateTime currentDate = LocalDateTime.now();
		DateTimeFormatter patternDate = DateTimeFormatter.ofPattern(pattern);
		if (value.contains("+")) {
			String[] values = value.split(Pattern.quote("+"));
			String daysToAdd = values[1].replace("d", "");
			value = currentDate.plusDays(Integer.parseInt(daysToAdd)).format(patternDate).toString();
		} else if (value.contains("-")) {
			String[] values = value.split(Pattern.quote("-"));
			String daysToSubtract = values[1].replace("d", "");
			value = currentDate.minusDays(Integer.parseInt(daysToSubtract)).format(patternDate).toString();
		} else if (value.equalsIgnoreCase("hoje") || (value.equalsIgnoreCase("agora")) || (value.equalsIgnoreCase("atual"))) {
			value = currentDate.format(patternDate).toString();
			String valorTemp = "";
			if(value.contains("0")) {
				String[] valorData = value.split("");
				valorData[0] = "";
				valorData[3] = "";
				for(String valor: valorData) {
					valorTemp += valor;			
				}
				value = valorTemp;
			}
		} else if (value.equalsIgnoreCase("ontem")) {
			value = currentDate.minusDays(1).format(patternDate).toString();
			
		} else {
			throw new Exception("Invalid date!");
		}

		return value;
	}

	public static String getDateTime(int incrementHour, int incrementMinutes, int incrementSeconds, String pattern) {
		LocalDateTime dateTime = LocalDateTime.now();
		dateTime = incrementHour > 0 ? LocalDateTime.parse(dateTime.plusHours(incrementHour).toString())
				: incrementHour < 0 ? LocalDateTime.parse(dateTime.minusHours(incrementHour * (-1)).toString())
						: dateTime;
		dateTime = incrementMinutes > 0 ? LocalDateTime.parse(dateTime.plusMinutes(incrementMinutes).toString())
				: incrementMinutes < 0 ? LocalDateTime.parse(dateTime.minusMinutes(incrementMinutes * (-1)).toString())
						: dateTime;
		dateTime = incrementSeconds > 0 ? LocalDateTime.parse(dateTime.plusMinutes(incrementSeconds).toString())
				: dateTime;
		return dateTime.format(DateTimeFormatter.ofPattern(pattern));
	}

	public static String getDateTime(String date, int incrementHour, int incrementMinutes, int incrementSeconds,
			String pattern) {
		LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
		dateTime = incrementHour > 0 ? LocalDateTime.parse(dateTime.plusHours(incrementHour).toString())
				: incrementHour < 0 ? LocalDateTime.parse(dateTime.minusHours(incrementHour).toString()) : dateTime;
		dateTime = incrementMinutes > 0 ? LocalDateTime.parse(dateTime.plusMinutes(incrementMinutes).toString())
				: incrementMinutes < 0 ? LocalDateTime.parse(dateTime.minusMinutes(incrementMinutes * (-1)).toString())
						: dateTime;
		dateTime = incrementSeconds > 0 ? LocalDateTime.parse(dateTime.plusSeconds(incrementSeconds).toString())
				: dateTime;
		return dateTime.format(DateTimeFormatter.ofPattern(pattern));
	}

	public static String getPlusCurrentDateTime(int incrementDay, int incrementMonth, int incrementyear,
			String pattern) {

		LocalDateTime dateTime = LocalDateTime.now();

		dateTime = incrementDay > 0 ? LocalDateTime.parse(dateTime.plusDays(incrementDay).toString())
				: incrementDay < 0 ? LocalDateTime.parse(dateTime.minusDays(incrementDay * (-1)).toString()) : dateTime;
		dateTime = incrementMonth > 0 ? LocalDateTime.parse(dateTime.plusMonths(incrementMonth).toString())
				: incrementMonth < 0 ? LocalDateTime.parse(dateTime.minusMonths(incrementMonth * (-1)).toString())
						: dateTime;
		dateTime = incrementyear > 0 ? LocalDateTime.parse(dateTime.plusYears(incrementyear).toString())
				: incrementyear < 0 ? LocalDateTime.parse(dateTime.minusYears(incrementyear * (-1)).toString())
						: dateTime;
		return dateTime.format(DateTimeFormatter.ofPattern(pattern));
	}

	public static String getDateTime(String pattern) throws Exception {
		return convertToPatternDate("agora", pattern);
	}

	public static String getYesterday() throws Exception {
		return convertToPatternDate("ontem", "dd/MM/yyyy");
	}

	public static String getToday() throws Exception {
		return convertToPatternDate("hoje", "dd/MM/yyyy");
	}

	public static String getTomorrow() throws Exception {
		return convertToPatternDate("hoje+1", "dd/MM/yyyy");
	}

	public static String getTime() throws Exception {
		return convertToPatternDate("agora", "HH:mm:ss");
	}

	public static String getShortTime() throws Exception {
		return convertToPatternDate("agora", "HH:mm");
	}

	public static String getLongTime() throws Exception {
		return convertToPatternDate("agora", "HH:mm:ss.SSS");
	}

	public static String getDateTime(String value, String pattern) throws Exception {
		return convertToPatternDate(value, pattern);
	}

}
