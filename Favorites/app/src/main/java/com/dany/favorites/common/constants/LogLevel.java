package com.dany.favorites.common.constants;


public enum LogLevel {
	Null(0), Info(1), Debug(2), Error(3),Disable(999);
	private int id;

	LogLevel(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public static LogLevel convertToEnum(int code) {
		for (LogLevel type : LogLevel.values()) {
			if (type.getId() == code) {
				return type;
			}
		}
		return Null;
	}
}
