package com.homwork.was;


import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpServer {
    private static final Logger log = LoggerFactory.getLogger(HttpServer.class);
    private static final int NUM_THREADS = 50;
    private static final String INDEX_FILE = "index.html";
    private final File rootDirectory;
    private final int port;

    public HttpServer(File rootDirectory, int port) {
        this.rootDirectory = rootDirectory;
        this.port = port;
    }

    public void start() throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        try (ServerSocket server = new ServerSocket(port)) {
            log.info("Accepting connections on port " + server.getLocalPort());
            log.info("Document Root: " + rootDirectory);
            Socket request = server.accept();
                        
            while (true) {
                try {
                    request = server.accept();
                    Runnable r = new RequestProcessor(rootDirectory, INDEX_FILE, request);
                    pool.submit(r);
                } catch (IOException ex) {
                	log.warn("Error accepting connection", ex);
                }
            }
        }
    }

}