package com.homwork.was.util;

import java.io.FileReader;

import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.homwork.was.HttpServer;

public class HostSetting {
	
	private static final Logger log = LoggerFactory.getLogger(HttpServer.class);
	private JSONParser parser = new JSONParser();
	
	public HostSetting() {
		try  {
			Object obj = parser.parse(new FileReader("/resources/host.json"));	
		} catch (Exception  e) {
			log.warn("");
		}
	}
}
