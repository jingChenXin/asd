package com.byzx.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @Description ���ɶ����ţ�ȷ��Ψһ
 * @author ��
 * @date 2019��4��28�� ����10:31:28
 * @version v1.0
 */
public class GrenOrderNum {

	public static String grenOrderNum() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = sdf.format(date);
		// ��ȡ��ǰʱ��+��λ�����
		s = s + (int) Math.ceil(Math.random() * 10000);
		return s;
	}

}
