package org.aina.testPdf;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.aina.testThymeleaf.TestThymeleaf;
import org.jsoup.helper.W3CDom;

public class TestPdf {

    public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream("out.pdf");
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.useFastMode();
        builder.withW3cDocument(new W3CDom().fromJsoup(org.jsoup.Jsoup.parse(TestThymeleaf.generateTemplate())), "/");
        builder.toStream(os);
        builder.run();
    }
}
