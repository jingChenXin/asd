package com.byzx.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @Description 生成订单号，确保唯一
 * @author 景
 * @date 2019年4月28日 下午10:31:28
 * @version v1.0
 */
public class GrenOrderNum {

	public static String grenOrderNum() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = sdf.format(date);
		// 获取当前时间+四位随机数
		s = s + (int) Math.ceil(Math.random() * 10000);
		return s;
	}

}
