package com.mycompany.metodoplantilla.miners;


import com.mycompany.metodoplantilla.core.DataMiner;
import java.io.*;

public class CSVDataMiner extends DataMiner {

    @Override
    protected BufferedReader openFile(String path) throws Exception {
        return new BufferedReader(new FileReader(path));
    }

    @Override
    protected String extractData(BufferedReader file) throws Exception {
        StringBuilder data = new StringBuilder();
        String line;

        while ((line = file.readLine()) != null) {
            data.append(line).append("\n");
        }
        return data.toString();
    }

    @Override
    protected String parseData(String rawData) {
        return rawData.replace(",", " | ");
    }
}