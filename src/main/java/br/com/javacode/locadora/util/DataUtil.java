package br.com.javacode.locadora.util;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/*
 * Padrões de formatação data Brasil -pt-BR
 * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
 * 
 *  Primeiro o formato normal que todo mundo usa com o mínimo de dois dígitos para cada número, e quatro dígitos para o ano
	dd: dia do mês com mínimo de dois dígitos (01 à 31)
	MM: mês do ano com mínimo de dois dígitos (01 à 12)
	yyyy: ano com quatro dígitos (exemplo: 2018)
	HH: horas com mínimo de dois dígitos (00 à 24)
	mm: minutos com mínimo de dois dígitos (00 à 59)
	ss: minutos com mínimo de dois dígitos (00 à 59)
	hh: horas (até 12) com mínimo de dois dígitos (00 à 12)
	Além dos formatos mais comuns citados acima, também pode-se obter variações deles. Veja:
	
	d: dia do mês com mínimo de um dígito (1 à 31)
	M: mês do ano com mínimo de um dígito (1 à 12)
	yy: ano com dois dígitos (exemplo: 18)
	H: horas com mínimo de um dígito (0 à 24)
	m: minutos com mínimo de um dígito (0 à 59)
	s: minutos com mínimo de um dígito (0 à 59)
	h: horas (até 12) com mínimo de um dígito (0 à 12)
 */
public final class DataUtil {

	Locale brasil = new Locale("pt", "BR"); // Retorna do país e a língua

	/**
	 * Get current local date.
	 * 
	 * @return
	 */
	public static LocalDate getLocalDateFromClock() {
		return LocalDate.now();
	}

	/**
	 * Get next day.
	 * 
	 * @param localDate
	 * @return
	 */
	public static LocalDate getNextDay(LocalDate localDate) {
		return localDate.plusDays(1);
	}

	/**
	 * Get Previous Day.
	 * 
	 * @param localDate
	 * @return
	 */
	public static LocalDate getPreviousDay(LocalDate localDate) {
		return localDate.minus(1, ChronoUnit.DAYS);
	}

	/**
	 * Get day of the week.
	 * 
	 * @param localDate
	 * @return
	 */
	public static DayOfWeek getDayOfWeek(LocalDate localDate) {
		DayOfWeek day = localDate.getDayOfWeek();
		return day;
	}

	/**
	 * Get first day of the Month.
	 * 
	 * @return LocalDate
	 */
	public static LocalDate getFirstDayOfMonth() {
		LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
		return firstDayOfMonth;
	}

	/**
	 * Get start of the Day.
	 * 
	 * @param localDate
	 * @return
	 */
	public static LocalDateTime getStartOfDay(LocalDate localDate) {
		LocalDateTime startofDay = localDate.atStartOfDay();
		return startofDay;
	}

	/**
	 * Print current time in day,month and year format.
	 */
	public static void printCurrentDayMonthAndYear() {
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);
	}

	/**
	 * Check two dates are equals.
	 * 
	 * @param date
	 * @param today
	 * @return
	 */
	public static boolean checkDateEquals(LocalDate date, LocalDate today) {
		if (date.equals(today)) {
			System.out.printf("Today %s and date1 %s are same date %n", today, date);
			return true;
		}
		return false;
	}

	/**
	 * Get current time.
	 * 
	 * @return
	 */
	public static LocalTime getCurrentTime() {
		LocalTime time = LocalTime.now();
		System.out.println("local time now : " + time);
		return time;
	}

	/**
	 * Add hours to time.
	 * 
	 * @param hours
	 * @return
	 */
	public static LocalTime addHoursToTime(int hours) {
		LocalTime time = LocalTime.now();
		LocalTime newTime = time.plusHours(hours); // adding two hours
		System.out.println("Time after 2 hours : " + newTime);
		return newTime;
	}

	/**
	 * Get date and time by zone.
	 * 
	 * @param timeZone
	 * @return
	 */
	public static ZonedDateTime timeZone(String timeZone) {
		ZoneId saoPaulo = ZoneId.of(timeZone);
		LocalDateTime localtDateAndTime = LocalDateTime.now();
		ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, saoPaulo);
		System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
		return dateAndTimeInNewYork;
	}

	/**
	 * Check for leap year.
	 */
	public static void checkLeapYear() {
		LocalDate today = LocalDate.now();
		if (today.isLeapYear()) {
			System.out.println("This year is Leap year");
		} else {
			System.out.println("2014 is not a Leap year");
		}
	}

	/**
	 * get time stamp.
	 * 
	 * @return
	 */
	public static Instant getTimeStamp() {
		Instant timestamp = Instant.now();
		System.out.println("What is value of this instant " + timestamp);
		return timestamp;
	}

	/**
	 * Get Date by hour,minute and seconds.
	 * 
	 * @param hour
	 * @param min
	 * @param seconds
	 * @return
	 */
	public static LocalTime getLocalTimeUsingFactoryOfMethod(int hour, int min, int seconds) {
		return LocalTime.of(hour, min, seconds);
	}

	/**
	 * Get zone date time.
	 * 
	 * @param localDateTime
	 * @param zoneId
	 * @return
	 */
	public static ZonedDateTime getZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId) {
		return ZonedDateTime.of(localDateTime, zoneId);
	}

	/**
	 * Returns a copy of this time with the specified amount added.
	 * 
	 * @param localTime
	 * @param duration
	 * @return
	 */
	public static LocalTime modifyDates(LocalTime localTime, Duration duration) {
		return localTime.plus(duration);
	}

	/**
	 * Obtains a Duration representing the duration between two temporal objects.
	 * 
	 * @param localTime1
	 * @param localTime2
	 * @return
	 */
	public static Duration getDifferenceBetweenDates(LocalTime localTime1, LocalTime localTime2) {
		return Duration.between(localTime1, localTime2);
	}

	/**
	 * Get date and time by passing format
	 * 
	 * @param representation
	 * @return
	 */
	public static LocalDateTime getLocalDateTimeUsingParseMethod(String representation) {
		return LocalDateTime.parse(representation);
	}

	/**
	 * Convert Date to Java 8 LocalDate
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDateTime convertDateToLocalDate(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

	/**
	 * Convert Calender to LocalDate
	 * 
	 * @param calendar
	 * @return
	 */
	public static LocalDateTime convertDateToLocalDate(Calendar calendar) {
		return LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
	}

	public static LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
		LocalDate result = date;
		int addedDays = 0;
		while (addedDays < days) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++addedDays;
			}
		}
		return result;
	}

	public static LocalDate subtractDaysSkippingWeekends(LocalDate date, int days) {
		LocalDate result = date;
		int subtractedDays = 0;
		while (subtractedDays < days) {
			result = result.minusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++subtractedDays;
			}
		}
		return result;
	}

	// Usando novos recursos do Java 8++

	/**
	 * Converting java.util.Date to java.time.LocalDate
	 * 
	 * @param dateToConvert
	 * @return LocalDate
	 */
	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
		return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
		return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}

	/**
	 * Converting java.util.Date to java.time.LocalDateTime
	 * 
	 * @param dateToConvert
	 * @return LocalDateTime
	 */
	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static LocalDateTime convertToLocalDateTimeViaMilisecond(Date dateToConvert) {
		return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static LocalDateTime convertToLocalDateTimeViaSqlTimestamp(Date dateToConvert) {
		return new java.sql.Timestamp(dateToConvert.getTime()).toLocalDateTime();
	}

	// Convert java.time.LocalDate to java.util.Date

	public static Date convertToDateViaSqlDate(LocalDate dateToConvert) {
		return java.sql.Date.valueOf(dateToConvert);
	}

	public static Date convertToDateViaInstant(LocalDate dateToConvert) {
		return java.util.Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	// Convert java.time.LocalDateTime to java.util.Date
	public static Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
		return java.sql.Timestamp.valueOf(dateToConvert);
	}

	public static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
		return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
	}

	// Java 9 Additions

	public static LocalDate convertToLocalDate(Date dateToConvert) {
		return LocalDate.ofInstant(dateToConvert.toInstant(), ZoneId.systemDefault());
	}

	public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
		return LocalDateTime.ofInstant(dateToConvert.toInstant(), ZoneId.systemDefault());
	}
}
