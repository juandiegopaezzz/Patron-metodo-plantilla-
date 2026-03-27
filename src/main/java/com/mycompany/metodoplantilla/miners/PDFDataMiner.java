package com.mycompany.metodoplantilla.miners;


import com.mycompany.metodoplantilla.core.DataMiner;
import java.io.BufferedReader;
import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFDataMiner extends DataMiner {

    private PDDocument document;

    @Override
    protected BufferedReader openFile(String path) throws Exception {
        document = PDDocument.load(new File(path));
        return null; // no usamos BufferedReader aquí
    }

    @Override
    protected String extractData(BufferedReader file) throws Exception {
        PDFTextStripper stripper = new PDFTextStripper();
        return stripper.getText(document);
    }

    @Override
    protected String parseData(String rawData) {
        return "PDF PARSED:\n" + rawData;
    }

    @Override
    protected void closeFile(BufferedReader file) throws Exception {
        if (document != null) document.close();
    }
}