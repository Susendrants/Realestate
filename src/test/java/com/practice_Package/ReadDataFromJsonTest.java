package com.practice_Package;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {
public static void main(String[] args) throws IOException, ParseException {
	JSONParser jsonp = new JSONParser();
	FileReader filepath = new FileReader(".\\src\\test\\resources\\JSONdata.json");
	Object obj = jsonp.parse(filepath);
	JSONObject map = (JSONObject)obj;
	System.out.println(map.get("url"));
	
}
}
