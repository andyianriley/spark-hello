package air;

import air.template.Template;
import air.template.TemplateFactory;
import spark.servlet.SparkApplication;

import static spark.Spark.get;

public class MySparkApplication implements SparkApplication {
    @Override
    public void init() {
        get("/hello",(request, response) -> {
            return "Hello World!";
        });
        get("/hello-world", (request, response) -> {
                Template template = TemplateFactory.getTemplate("index");
                template.setVariable("title", "HelloWorld");
                template.setVariable("message", "Hello World");
                String html = template.toHTML();
                return (html);
        });
    }
}
