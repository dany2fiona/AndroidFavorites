package com.dany.favorites.common.utils;

import android.app.Activity;
import android.content.Context;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.TimerTask;

/**
 * add by dan.y 2017/2/17
 * Virtual Keyboard controller class
 */

public class KeyboardUtil {
	
	 private KeyboardUtil() { 
		    // Utility class. 
	 } 
	 
	 public static void showKeyboard(final EditText editText){
			editText.setFocusable(true);  
			editText.setFocusableInTouchMode(true);  
			editText.requestFocus(); 
			java.util.Timer timer = new java.util.Timer();  
		     timer.schedule(new TimerTask()
		     {  
		         public void run()  
		         {  
		             InputMethodManager inputManager =
		                 (InputMethodManager)editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		             inputManager.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
		             /**
		              * ali OS crash 在hidekeyboard设置一次即可
		              */
//		             editText.setInputType(InputType.TYPE_CLASS_TEXT);
//		 			 editText.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
		         }  
		           
		     },  
		         200);  
	 }
	 public static void hideKeyboard(final EditText editText){
				 InputMethodManager inputManager =
						 (InputMethodManager)editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
				 inputManager.hideSoftInputFromWindow(editText.getWindowToken(),0);
				 editText.setInputType(InputType.TYPE_CLASS_TEXT);
				 editText.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
	 }

	public static void hideKeyboard(final EditText editText, int inputType){
		InputMethodManager inputManager =
				(InputMethodManager)editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		inputManager.hideSoftInputFromWindow(editText.getWindowToken(),0);
		editText.setInputType(inputType);
		editText.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
	}
	
	public static void hideKeyboard(Context context){
		if (context instanceof Activity) {
			try{
				InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
				if(imm.isActive())
					imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
			}catch(Exception ex){}
		}
		
	}
	
	public static void alwaysHideKeyBoard(Context context){
		if (context instanceof Activity) {
			try{
				InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
				if(imm.isActive() && ((Activity)context).getCurrentFocus() != null)
					imm.hideSoftInputFromWindow(((Activity)context).getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
	}

}
