package org.aina.testFinal;

import org.aina.PDFGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Object> datas = new HashMap<>();
        datas.put("name", "Aina");
        datas.put("age", "25");
        try(OutputStream os = new FileOutputStream("final.pdf")){
            new PDFGenerator(datas, "template.html").generate(os);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
