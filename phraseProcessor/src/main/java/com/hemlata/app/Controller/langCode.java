package com.hemlata.app.Controller;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
public class langCode {
	
	//API Call to get leagues of the different games
	public String codes(String lang) 
	{
		
		String code = null;
		HashMap<String, String> langcode = new HashMap<String, String>();
		langcode.put("ar","Arabic");
		langcode.put("be","Belarusian");
		langcode.put("bg","Bulgarian");
		langcode.put("en","English");
		langcode.put("bn","Bangla");
		langcode.put("el","Greek");
		langcode.put("fa","Persian");
		langcode.put("gu","Gujarati");
		langcode.put("he","Hebrew");
		langcode.put("hi","Hindi");
		langcode.put("ja","Japanese");
		langcode.put("kk","Kazakh");
		langcode.put("kn","Kannada");
		langcode.put("ky","Kyrgyz");
		langcode.put("mk","Macedonian");
		langcode.put("ml","Malayalam");
		langcode.put("mn","Mongolian");
		langcode.put("mr","Marathi");
		langcode.put("or","Odia");
		langcode.put("pa","Punjabi");
		langcode.put("ru","Russian");
		langcode.put("sd","Sindhi");
		langcode.put("ta","Tamil");
		langcode.put("te","Telugu");
		langcode.put("tg","Tajik");
		langcode.put("th","Thai");
		langcode.put("uk","Ukrainian");
		langcode.put("ur","Urdu");
		langcode.put("zh-Hans","Chinese Simplified");
		langcode.put("zh-Hant","Chinese Traditional");
		code=langcode.get(lang.toLowerCase());
		return code;
		
	}
}