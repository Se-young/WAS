package com.homwork.was;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {
	
	private static final Logger log = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args ) {

    	// get the Document root
        File docroot = new File("");
        // set the port to listen on
        int port = 0;
        
        try {
            HttpServer webserver = new HttpServer(docroot, port);
            webserver.start();
        } catch (IOException ex) {
        	log.error("Server could not start", ex);
        }
    }
}
