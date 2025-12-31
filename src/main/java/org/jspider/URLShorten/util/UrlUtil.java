package org.jspider.URLShorten.util;

import java.util.Random;

public class UrlUtil {
	static String ref = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";

	public static String generateCode() {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			sb.append(ref.charAt(random.nextInt(ref.length())));
		}
		return sb.toString();
	}
}