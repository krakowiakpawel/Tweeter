package pl.tweeter.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class Service {

	public static void setMessageCookie(HttpServletResponse response, String value, int time)
		 {
		Cookie cookie;
		try {
			cookie = new Cookie("message", URLEncoder.encode(value, "UTF-8"));
			cookie.setMaxAge(time);
			response.addCookie(cookie);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
