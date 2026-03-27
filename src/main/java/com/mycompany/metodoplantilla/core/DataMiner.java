package com.mycompany.metodoplantilla.core;


import java.io.*;

public abstract class DataMiner {

    public void mine(String path) {
        try {
            BufferedReader file = openFile(path);
            String rawData = extractData(file);
            String data = parseData(rawData);
            String analysis = analyzeData(data);
            sendReport(analysis);
            closeFile(file);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    protected abstract BufferedReader openFile(String path) throws Exception;
    protected abstract String extractData(BufferedReader file) throws Exception;
    protected abstract String parseData(String rawData);

    protected String analyzeData(String data) {
        return "Resultado del analisis → " + data.toUpperCase();
    }

    protected void sendReport(String analysis) {
        System.out.println(analysis);
    }

    protected void closeFile(BufferedReader file) throws Exception {
        file.close();
    }
}
