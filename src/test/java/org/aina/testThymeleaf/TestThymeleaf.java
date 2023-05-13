package org.aina.testThymeleaf;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import org.thymeleaf.context.Context;

public class TestThymeleaf {

    public static String generateTemplate(){
        TemplateEngine templateEngine = new TemplateEngine();
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateEngine.setTemplateResolver(templateResolver);

        String name = "Aina";
        int age = 25;

        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("age", age);
        return templateEngine.process("template.html", context);
    }

    public static void main(String[] args) {
        System.out.println(generateTemplate());
    }
}
