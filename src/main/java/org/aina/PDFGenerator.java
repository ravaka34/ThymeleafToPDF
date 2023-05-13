package org.aina;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.jsoup.helper.W3CDom;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public class PDFGenerator {
    private HashMap<String, Object> datas;
    private String htmlTemplate;

    public PDFGenerator(HashMap<String, Object> datas, String htmlTemplate) {
        this.datas = datas;
        this.htmlTemplate = htmlTemplate;
    }

    private String generateHtml(){
        TemplateEngine templateEngine = new TemplateEngine();
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        for (String key : datas.keySet()
             ) {
            context.setVariable(key, datas.get(key));
        }
        return templateEngine.process(htmlTemplate, context);
    }

    private org.w3c.dom.Document generateHTMLDom(){
        org.jsoup.nodes.Document doc = org.jsoup.Jsoup.parse(generateHtml());
        return new W3CDom().fromJsoup(doc);
    }

    public void generate(OutputStream os) throws IOException {
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.useFastMode();
        builder.withW3cDocument(generateHTMLDom(), "/");
        builder.toStream(os);
        builder.run();
    }

    public HashMap<String, Object> getDatas() {
        return datas;
    }

    public void setDatas(HashMap<String, Object> datas) {
        this.datas = datas;
    }

    public String getHtmlTemplate() {
        return htmlTemplate;
    }

    public void setHtmlTemplate(String htmlTemplate) {
        this.htmlTemplate = htmlTemplate;
    }
}
