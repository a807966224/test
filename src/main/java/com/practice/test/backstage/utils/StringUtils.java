package com.practice.test.backstage.utils;

/**
 * 字符串操作工具类
 * @author Scott
 *
 */
public class StringUtils {
	
	/**
	 * 首字母大写
	 * @param str
	 * @return
	 */
	public static String initcap(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	public static String arrayToString(Object[] objs) {
		
		StringBuffer stringBuffer = new StringBuffer();
		
		for(int i=0;i<objs.length;i++) {
			if(i != objs.length - 1) {
				stringBuffer.append(objs[i] + ",");
			}else {
				stringBuffer.append(objs[i]);
			}
		}
		
		return stringBuffer.toString();
	}
	
	private StringUtils() {}
	
}
