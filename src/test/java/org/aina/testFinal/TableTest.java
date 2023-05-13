package org.aina.testFinal;

import org.aina.PDFGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TableTest {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Red", "JOP"));
        books.add(new Book("Tete", "Hipster"));
        HashMap<String, Object> datas = new HashMap<>();
        datas.put("books", books);
        try(OutputStream os = new FileOutputStream("table.pdf")){
            new PDFGenerator(datas, "table.html").generate(os);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
