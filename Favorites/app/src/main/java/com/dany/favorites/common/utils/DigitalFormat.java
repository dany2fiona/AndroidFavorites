package com.dany.favorites.common.utils;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;


import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * created by dan.y 2016/12/20 from lastpro
 */

public class DigitalFormat {

	/**
	 * Ticketformat “Y"->"是"，”N“-->”否“
	 */
	public static String convertYN(String string){
		String s = "";
		if(string.equalsIgnoreCase("Y")){
			s="是";
		}else{
			s="否";
		}
		return s;
	}

	/**
	 * 将double格式成一位小数格式
	 */
	public static String formatDoubleOnePoint(Double data){
		DecimalFormat format = new DecimalFormat("###,##0.0");
		String string = format.format(data);
		return string;
	}
	/**
	 * 将double格式成两位小数格式
	 */
	public static String formatDoubleTwoPoint(Double data){
		DecimalFormat format = new DecimalFormat("###,###.##");
		String string = format.format(data);
		return string;
	}
	/**
	 * 将double格式成三位小数格式
	 */
	public static String formatDoubleThreePoint(Double data){
		DecimalFormat format = new DecimalFormat("###,###.###");
		String string = format.format(data);
		return string;
	}

	/**
	 * 格式化Money
	 * Format Money("XXX,XXX.XX") 
	 */
	public static String formatMoney(double data){
		DecimalFormat format = new DecimalFormat("###,###,##0.00");
		String string = format.format(/*round(*/data/*,2)*/);
		return string;
	}

	/**
	 * 格式化Money
	 * Format Money("XXX,XXX.XX")
	 */
	public static String formatMoneyWithout0(double data){
		DecimalFormat format = new DecimalFormat("###,###,###");
		String string = format.format(/*round(*/data/*,2)*/);
		return string;
	}

	/**
	 * 格式化Money,欠款-100.00
	 * @param data
	 * @return
	 */
	public static String formatMoney(double data, boolean hasMinusSign){
		DecimalFormat format = new DecimalFormat("###,###,##0.00");
		String string = format.format(round(data,2));
		if(hasMinusSign){
			string = string.format("-%s", string);
		}
		return string;
	}
	
	public static double round(double v, int scale){
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}


	/**
	 * bigSize = 34px(17sp)，金额小数点和整数部字体大小不同的设置
	 * @param mContext
	 * @param amount
	 * @return 中文$ 23.33
	 */
	public static SpannableString getDisplayAmount(Context mContext, double amount){
		return getDisplayAmount(mContext, amount, UnitUtils.formatValue4Sp(mContext, 17));

	}

	//小数点不带入小字号
	public static SpannableString getDisplayAmountWithout0(Context mContext, double amount){
		return getDisplayAmountWithout0(mContext, amount, UnitUtils.formatValue4Sp(mContext, 15));

	}

	/**
	 * @param mContext
	 * @param amount
	 * @return 中文$ 23.33
	 */
	public static SpannableString getDisplayAmount(Context mContext, double amount, int bigSize) {
		String priceUnitIcon = "¥".concat(" ");
		String amountString = priceUnitIcon.concat(DigitalFormat
				.formatMoney(amount));
		SpannableString amountSpan = new SpannableString(amountString);
		int startPosition = 1;
		int endPosition = -1;
		if (amountString.contains(".")) {
			endPosition = amountString.indexOf(".");
		} else {
			endPosition = amountString.length();
		}

		amountSpan.setSpan(new AbsoluteSizeSpan(bigSize),
				startPosition, endPosition, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // 设置字体大小
		return amountSpan;
	}

	/**
	 * @param mContext
	 * @param amount
	 * @return 中文$ 23.33
	 */
	public static SpannableString getDisplayAmountInt(Context mContext, double amount, int bigSize) {
		String priceUnitIcon = "¥".concat(" ");
		String amountString = priceUnitIcon.concat(DigitalFormat
				.formatMoneyWithout0(amount));
		SpannableString amountSpan = new SpannableString(amountString);
		int startPosition = 1;
		int endPosition = -1;
		if (amountString.contains(".")) {
			endPosition = amountString.indexOf(".");
		} else {
			endPosition = amountString.length();
		}

		amountSpan.setSpan(new AbsoluteSizeSpan(bigSize),
				startPosition, endPosition, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // 设置字体大小
		return amountSpan;
	}


	public static SpannableString getDisplayAmountInt(Context mContext, double amount){
		return getDisplayAmountInt(mContext, amount, UnitUtils.formatValue4Sp(mContext, 17));

	}



	public static SpannableString getDisplayAmountWithout0(Context mContext, double amount, int bigSize) {
		String priceUnitIcon = "¥".concat(" ");
		String amountString = priceUnitIcon.concat(DigitalFormat
				.formatMoney(amount));
		SpannableString amountSpan = new SpannableString(amountString);
		int startPosition = 1;
		int endPosition = -1;
//		if (amountString.contains(".")) {
//			endPosition = amountString.indexOf(".");
//		} else {
			endPosition = amountString.length();
//		}

		amountSpan.setSpan(new AbsoluteSizeSpan(bigSize),
				startPosition, endPosition, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // 设置字体大小
		return amountSpan;
	}


	/**
	 * 格式化百分比为保留一位小数
	 * @param data 0.3498
	 * @return 35.0%
	 */
	public static String formatPercent(double data){
		DecimalFormat format = new DecimalFormat("###,###,##0.#");
		double pecent = data * 100;
		String string = format.format(round(pecent,1));
		string = string.concat("%");
		return string;
	}
	
}
