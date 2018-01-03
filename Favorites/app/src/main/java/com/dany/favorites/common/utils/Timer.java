package com.dany.favorites.common.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SuppressLint("SimpleDateFormat")
public class Timer {

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}


	/**
	 * 获取当前时间错的毫秒数
	 */
	public static long getTimeMillis(String time){//time是12:30
		Long t = 0l;
		StringBuffer sb = new StringBuffer();
		String date  = getCurrentDate();
		sb.append(date);
		sb.append(" ");
		sb.append(time);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			t = sdf.parse(sb.toString()).getTime();//这就是距离1970年1月1日0点0分0秒的毫秒数
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * 获取当前时间错的毫秒数
	 */
	public static long getDateMillis(String date){//date:2017-02-17
		Long t = 0l;
		StringBuffer sb = new StringBuffer();
		sb.append(date);
		sb.append(" ");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			t = sdf.parse(sb.toString()).getTime();//这就是距离1970年1月1日0点0分0秒的毫秒数
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return t;
	}


	/**
	 * 距离1970年1月1日的长整型数据转换成字符串2014-10-01 12:34:48
	 */
	public static String longTimeToStringDateTime(long time) {
		Date date = new Date(time);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = df.format(date);
		return dateString;
	}


	/**
	 * 调用此方法输入所要转换的时间戳输入例如（1402733340）输出（"2014年06月14日16时09分00秒"）
	 *
	 * @param time
	 * @return
	 */
	public static String times(String time) {
		SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		@SuppressWarnings("unused")
		long lcc = Long.valueOf(time);
		int i = Integer.parseInt(time);
		String times = sdr.format(new Date(i * 1000L));
		return times;

	}



	/**
	 * 将long行的毫秒数转化为12：30这样的时间
	 * @param sd
	 * @return
     */
	public static String getTime(Long sd){
		Date dat=new Date(sd);
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(dat);
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		String sb=format.format(gc.getTime());
		return sb.toString();
	}

	/**
	 * 字符串的日期格式的计算
	 */
	public static int daysBetween(String smdate, String bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 格式化时间 ：如 2016/12/28 15:01:09 to 2016/12/28
	 */
	public static String getFormatDate(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 格式化日期 ：如 2016-12-05T19:10:15.407 to 12/05
	 */
	public static String getFormatDate2(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("MM/dd");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 格式化日期 ：如 2016-12-05T19:10:15 to 12/05
	 */
	public static String getFormatDate4(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("MM/dd");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 格式化日期 ：如 2016-12-05T19:10:15 to 2016/12/05
	 */
	public static String getFormatDate3(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 格式化时间 ：如 2016/12/28 15:01:09 to 15:01:09
	 */
	public static String getFormatTime1(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 格式化时间 ：如 2016-12-05T19:10:15 to 2016/12/05 19:10:15
	 */
	public static String getFormatDateAndTime(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 格式化时间 ：如 2016-12-05T19:10:15 to 2016/12/05 19:10:15
	 */
	public static String getFormatDateAndTimeNoS(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String dateString = df.format(date);
		return dateString;
	}


	/**
	 * 今天，明天，后天（开奖，彩票专用）
	 * @param dateStr
	 * @return
	 * @throws ParseException
     */
	public static String getGapDateName(String dateStr) throws ParseException {
		String name = "";
		Date todayDate = new Date();
		Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateStr);
		int count = daysBetween(todayDate,date);
		if(count == 0){
			name = "今天";
		}else if(count == 1){
			name = "明天";
		}else if(count == 2){
			name = "后天";
		}

		return name;
	}

	/**
	 * 格式化时间 ：如 2016-12-05T19:10:15 to 19:10
	 */
	public static String getFormatTimeNoMili(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("HH:mm");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 获取当前日期是星期几<br>
	 *
	 * @param dt
	 * @return 当前日期是星期几
	 */
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}


	/**
	 * 格式化时间 ：如 2016-12-05T19:10:15.407 to 19:10
	 */
	public static String getFormatTime(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("HH:mm");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 格式化时间 ：如 2015/11/02 15:01:09 to 2015/11/02 15:01
	 */
	public static String getFormatTime2(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd  HH:mm");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 格式化时间 ：如 2015/11/02 15:01:09 to 11/02 15:01
	 */
	public static String getFormatTime3(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("MM/dd  HH:mm");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 格式化时间 ：如 2016-12-05T19:10:15 to 19:10:15
	 */
	public static String getFormatTime4(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return 当前时间：如：2014-10-01 13：14：00
	 */
	public static String getCurrentTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = df.format(date);
		return dateString;
	}

	public static String getCurrentTime2() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateString = df.format(date);
		return dateString;
	}

	//获取当前日期一周后的日期
	public static String getDateAfter1Week(){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, +7);
		date = calendar.getTime();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 获取当前日期
	 * 
	 * @return 当前日期：如：2014-10-01
	 */
	public static String getCurrentDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 获取当前日期
	 * 
	 * @return 当前日期：如：201410
	 */
	public static String getCurrentYearMonth() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMM");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 转换日期格式(2015-09-23 to 23/09)
	 * 
	 * @throws ParseException
	 */
	public static String formatDateAsDdMM(String date) throws ParseException {

		return new SimpleDateFormat("dd/MM").format(convertStringToDate(date));
	}
	
	/**
	 * 转换日期格式(2015-09-23 to 2015/09/23)
	 * 
	 * @throws ParseException
	 */
	public static String formatDateAsYYYYMMDd(String date) throws ParseException {
		
		return new SimpleDateFormat("yyyy/MM/dd").format(convertStringToDate(date));
	}
	
	/**
	 * 转换日期格式(2015-09 to 2015/09/01)
	 * 
	 * @throws ParseException
	 */
	public static String formatDateAsYYYYMMd(String date) throws ParseException {
		String temp = date.concat("-01");
		return new SimpleDateFormat("yyyy/MM/dd").format(convertStringToDate(temp));
	}
	
	/**
	 * 转换日期格式(2015-09-23 to 23/09)
	 * 
	 * @throws ParseException
	 */
	public static String formatDateAsMMDd(String date) throws ParseException {
		
		return new SimpleDateFormat("MM/dd").format(convertStringToDate(date));
	}

	/**
	 * 日期字符串转换成日期格式（2015-09-23 to date）
	 * 
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String date) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	}

	/**
	 * 日期字符串转换成日期格式（2015-09-23 12:01:12 to date）
	 * 
	 * @throws ParseException
	 */
	public static Date convertStringToDateTime(String date)
			throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
	}

	/**
	 * 日期字符串转换成日期格式（201509 to date）
	 * 
	 * @throws ParseException
	 */
	public static Date convertStringFromYearMonth(String date)
			throws ParseException {
		return new SimpleDateFormat("yyyyMM").parse(date);
	}
	
	/**
	 * 日期字符串转换成日期格式（2015-09 to date）
	 * 
	 * @throws ParseException
	 */
	public static Date convertStringFromYearMonth2(String date)
			throws ParseException {
		return new SimpleDateFormat("yyyy-MM").parse(date);
	}

	/**
	 * 获取当前和之前一共N天的日期 如：31/7,1/8,2/8,3/8,4/8
	 */
	public static ArrayList<String> getLastSomeDates(Date date, int dateCount) {
		ArrayList<String> dateStringList = new ArrayList<String>();
		ArrayList<Date> dateList = new ArrayList<Date>();
		for (int i = 0; i < dateCount; i++) {
			dateList.add(date);
			date = getPreviousDay(date);
		}
		DateFormat df = new SimpleDateFormat("dd/MM");
		for (int i = 0; i < dateCount; i++) {
			String dateString = df.format(dateList.get(i));
			dateStringList.add(dateString);
		}
		return dateStringList;
	}

	/**
	 * 获得前一天的日期
	 */
	public static Date getPreviousDay(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 获得前N天的日期
	 */
	public static Date getPreviousDay(Date date, int dateCount) {
		for (int i = 0; i < dateCount; i++) {
			date = getPreviousDay(date);
		}
		return date;
	}

	/**
	 * 获取当前时间点
	 * 
	 * @return 当前时间：如：13：14
	 */
	public static String getCurrentHourAndMinutes() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("HH:mm");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 距离1970年1月1日的长整型数据转换成字符串2014-10-01
	 */
	public static String longTimeToStringDate(long time) {
		Date date = new Date(time);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = df.format(date);
		return dateString;
	}

	/**
	 * 将long型的毫秒数转换成HH:mm:ss的时间格式
	 */
	public static String msToStringTime(long time) {
		long temp = time / 1000;
		long hour = temp / 3600;
		long minutes = (temp - 3600 * hour) / 60;
		long second = temp - 3600 * hour - minutes * 60;
		return timeElemnetFormat(hour) + ":" + timeElemnetFormat(minutes) + ":"
				+ timeElemnetFormat(second);
	}

	/**
	 * 将时分秒按格式成00
	 */
	public static String timeElemnetFormat(long element) {
		return element < 10 ? "0" + element : element + "";
	}

	/**
	 * 使用参数Format格式化Date成字符串 2015-11-12
	 */
	public static String format(Date date) {
		return date == null ? " " : new SimpleDateFormat("yyyy-MM-dd")
				.format(date);
	}
	
	public static String format(String dateStr) throws ParseException {
		Date date = convertStringToDate(dateStr);
		return date == null ? " " : new SimpleDateFormat("yyyy-MM-dd")
				.format(date);
	}

	public static String formatMD(String date) throws ParseException {
		Date dt = convertStringToDate(date);
		return date == null ? " " : new SimpleDateFormat("MM-dd").format(dt);
	}

	/**
	 * 使用参数Format格式化Date成字符串
	 */
	public static String format(Date date, String pattern) {
		return date == null ? " " : new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 返回年月份 201509
	 * 
	 * @param date
	 * @return 201509
	 * @throws ParseException
	 */
	public static String getYearMonth(String date) throws ParseException {
		// int month = 0;
		String dateString = "";
		Date dt = convertStringToDateTime(date);
		// Calendar dd = Calendar.getInstance();// 定义日期实例
		// dd.setTime(dt);// 设置日期起始时间
		// month = dd.get(Calendar.MONTH);
		DateFormat df = new SimpleDateFormat("yyyyMM");
		dateString = df.format(dt);
		return dateString;
	}

	/**
	 * 返回月份
	 * 
	 * @param date
	 *            string
	 * @return 11
	 */
	public static String getMonth(String date) {
		String dateString = "";
		Date dt;
		try {
			dt = convertStringFromYearMonth(date);
		} catch (ParseException e) {
			e.printStackTrace();
			dt = new Date();
		}
		DateFormat df = new SimpleDateFormat("MM");
		dateString = df.format(dt);
		return dateString;
	}

	/**
	 * 获取最近3个月的年月
	 * 
	 * @return 如：201512，201511，201510
	 */
	public static ArrayList<String> getLastestThreeMonth() {
		ArrayList<String> lists = new ArrayList<String>();
//		Date date = new Date();
//		DateFormat df = new SimpleDateFormat("yyyyMM");
//		String currentMonth = df.format(date);
		lists.add(getYearMonthByParam(0));
		lists.add(getYearMonthByParam(-1));
		lists.add(getYearMonthByParam(-2));
		return lists;
	}

	/**
	 * 获取当前月份后，传入参数month，来得到固定的年月
	 * @param month int
	 * @return 如 当前月份201512， 参数－1，得到月份201511 
	 */
	public static String getYearMonthByParam(int month) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, month);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String time = format.format(c.getTime());
		return time;
	}
	
	/**
	 * 获取时间
	 * @param time
	 * @return 2016-03－15 上午10:41
	 */
	public static String getChatTime(Date time){
		//yyyy-MM-dd aah:mm
		String dateString = android.text.format.DateFormat.format("yyyy-MM-dd HH:mm:ss", time).toString();
		return dateString;
	}
	/**
	 * 得到当前的年(2016-01)
	 * @param time (2016-01)
	 * @return int 2016
	 */
	public static int getYearByYearMonth(String time){
		String dateString = "";
		int year = 0;
		Date dt;
		try {
			dt = convertStringFromYearMonth2(time);
		} catch (ParseException e) {
			e.printStackTrace();
			dt = new Date();
		}
		DateFormat df = new SimpleDateFormat("yyyy");
		dateString = df.format(dt);
		year = Integer.parseInt(dateString);
		return year;
	}
	
	/**
	 * 得到当前的月(2016-01)
	 * @param time (2016-01)
	 * @return int 1
	 */
	public static int getMonthByYearMonth(String time){
		String dateString = "";
		int month = 0;
		Date dt;
		try {
			dt = convertStringFromYearMonth2(time);
		} catch (ParseException e) {
			e.printStackTrace();
			dt = new Date();
		}
		DateFormat df = new SimpleDateFormat("MM");
		dateString = df.format(dt);
		month = Integer.parseInt(dateString);
		return month;
	}
	
	/**
	 * 得到当前的年(2016-01)
	 * @param time (2016-01)
	 * @return int 2016
	 */
	public static int getYearByDate(String time){
		String dateString = "";
		int year = 0;
		Date dt;
		try {
			dt = convertStringToDate(time);
		} catch (ParseException e) {
			e.printStackTrace();
			dt = new Date();
		}
		DateFormat df = new SimpleDateFormat("yyyy");
		dateString = df.format(dt);
		year = Integer.parseInt(dateString);
		return year;
	}
	
	/**
	 * 得到当前的月(2016-01-05)
	 * @param time (2016-01-05)
	 * @return int 1
	 */
	public static int getMonthByDate(String time){
		String dateString = "";
		int month = 0;
		Date dt;
		try {
			dt = convertStringToDate(time);
		} catch (ParseException e) {
			e.printStackTrace();
			dt = new Date();
		}
		DateFormat df = new SimpleDateFormat("MM");
		dateString = df.format(dt);
		month = Integer.parseInt(dateString);
		return month;
	}
	
	/**
	 * 得到当前的月(2016-01-05)
	 * @param time (2016-01-05)
	 * @return int 5
	 */
	public static int getDayByDate(String time){
		String dateString = "";
		int day = 0;
		Date dt;
		try {
			dt = convertStringToDate(time);
		} catch (ParseException e) {
			e.printStackTrace();
			dt = new Date();
		}
		DateFormat df = new SimpleDateFormat("dd");
		dateString = df.format(dt);
		day = Integer.parseInt(dateString);
		return day;
	}
	
	/**
	 * 得到当前的月(2016-01-05或2016-05)
	 * @param time (2016-01-05或2016-05)
	 * @return string 2016年01月05日或2016年05月
	 */
	public static String getShowDate(String time){
		String dateString = "";
		if(time.length()>7){
			String[] arrays = time.split("-");
			dateString = String.format("%s年%s月%s日", arrays[0],arrays[1],arrays[2]);
		}else{
			String[] arrays = time.split("-");
			dateString = String.format("%s年%s月", arrays[0],arrays[1]);
		}
		return dateString;
	}
	
	/**
	 * 月份格式化 08月---8月   ，  12月---12月
	 */
	public static String getFormatMonthIndex(String month){
		return (Integer.parseInt(month) < 10 ? month.substring(1) : month).concat("月");
	}

	//比较两个日期大小
	public static int compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
//				System.out.println("dt1 在dt2前");
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
//				System.out.println("dt1在dt2后");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

}
