package air.template;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.StringWriter;

public class ThymeleafTemplate implements Template {
    private Context ctx = null;
    private TemplateEngine engine = null;
    private String templateName;

    public ThymeleafTemplate(TemplateEngine engine, String templateName, Context ctx) {
        this.ctx = ctx;
        this.engine = engine;
        this.templateName = "templates/"+templateName;
    }

    public void setVariable(String name, Object obj) {
        ctx.setVariable(name, obj);
    }

    public String toHTML() {
        StringWriter writer = new StringWriter();
        engine.process(templateName, ctx, writer);
        return writer.toString();
    }
}
