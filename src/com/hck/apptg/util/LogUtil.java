package com.hck.apptg.util;

public class LogUtil {
	private static boolean isPrintLog = false;

	public static void log(String log) {
		if (isPrintLog) {
			System.out.println(log);
		}
	}
}
