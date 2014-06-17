package air.template;

import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class TemplateFactory {
    private static org.thymeleaf.TemplateEngine engine;

    public synchronized static Template getTemplate(String templateName) {
        if (engine == null) {
            ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
            resolver.setTemplateMode("HTML5");
            resolver.setSuffix(".html");
            engine = new org.thymeleaf.TemplateEngine();
            engine.setTemplateResolver(resolver);
        }
        engine.clearTemplateCache();
        return new ThymeleafTemplate(engine, templateName, new Context());
    }
}
