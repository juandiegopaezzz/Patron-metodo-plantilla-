package com.mycompany.metodoplantilla.miners;


import com.mycompany.metodoplantilla.core.DataMiner;
import java.io.BufferedReader;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.FileInputStream;

public class DocDataMiner extends DataMiner {

    private XWPFDocument document;

    @Override
    protected BufferedReader openFile(String path) throws Exception {
        document = new XWPFDocument(new FileInputStream(path));
        return null; 
    }

    @Override
    protected String extractData(BufferedReader file) throws Exception {
        return document.getParagraphs()
                .stream()
                .map(p -> p.getText())
                .reduce("", (a, b) -> a + "\n" + b);
    }

    @Override
    protected String parseData(String rawData) {
        return "DOCX PARSED:\n" + rawData;
    }

    @Override
    protected void closeFile(BufferedReader file) throws Exception {
        if (document != null) document.close();
    }
}