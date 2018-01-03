package com.dany.favorites.common.utils;

import android.util.Log;

import com.dany.favorites.common.constants.LogLevel;
import com.dany.favorites.global.FavorApp;


public class ALog {
	private static LogLevel _loglevel = LogLevel.Null;
	
	private static LogLevel getLogLevel(){
		_loglevel = FavorApp.Companion.getInstance().getCurrentLogLevel();
		if (_loglevel == LogLevel.Null){
			_loglevel = LogLevel.Disable;
		}
		return _loglevel;
	}
	
	private static boolean isEnable(LogLevel level){
		boolean result = false;
		if (getLogLevel() == LogLevel.Disable || getLogLevel() == LogLevel.Null){
			result = false;
		} else if (getLogLevel().getId() <= level.getId() ) {
			result = true;
		}
		return result;
	}
	
	public static void d(String tag, String msg, Throwable tr){
		if (isEnable(LogLevel.Debug)){
			Log.d(tag, msg, tr);
		}
	}
	
	public static void d(String tag, String msg){
		if (isEnable(LogLevel.Debug)){
			Log.d(tag, msg);
		}
	}

	public static void e(String tag, String msg, Throwable tr){
		if (isEnable(LogLevel.Error)){
			Log.e(tag, msg, tr);
		}
	}
	
	public static void e(String tag, String msg){
		if (isEnable(LogLevel.Error)){
			Log.e(tag, msg);
		}
	}
	
	public static void v(String tag, String msg, Throwable tr){
		if (isEnable(LogLevel.Info)){
			Log.v(tag, msg, tr);
		}
	}
	
	public static void v(String tag, String msg){
		if (isEnable(LogLevel.Info)){
			Log.v(tag, msg);
		}
	}
}
