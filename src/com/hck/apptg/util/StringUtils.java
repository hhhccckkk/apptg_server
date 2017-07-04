package com.hck.apptg.util;

import java.util.Random;


public class StringUtils {
	private static char[] sourceChar={'2','3','4','5','6','7','8','9','A','C','B','D','F','G','H','J','K','Z','X','V','B','N','M','Q','W','E','R','T','Y','U','I','P'};
	public static boolean IsNull(String string) {
		if ("".equals(string) || null == string || string.trim().equals("")) {
			System.out.print("null");
			return true;
		}
		return false;
	}
	public static String getRandom(int length) {
        if (sourceChar	 == null || sourceChar.length == 0 || length < 0) {
            return null;
        }
        StringBuilder str = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            str.append(sourceChar[random.nextInt(sourceChar.length)]);
        }
        return str.toString();
    }

}
