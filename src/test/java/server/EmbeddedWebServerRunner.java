package server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;

public class EmbeddedWebServerRunner {

	public static void main(final String[] args) {
		try {
			new EmbeddedWebServerRunner("localhost", 8080).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private final String hostName;
	private final int portNumber;

	private final Server server;

	public EmbeddedWebServerRunner(final String hostName, final int port) {
		this.server = new Server(port);
		this.portNumber = port;
		this.hostName = hostName;
	}

	private String getHostAndPort() {
		return hostName + ":" + portNumber;
	}

	public void start() throws Exception {

        String resourceBase = "web/";
        String pathname = resourceBase+"WEB-INF/web.xml";
        File file = new File(pathname);
		if (!file.exists()) {
			throw new Exception("Cannot find web.xml, please check settings");
		}

		ContextHandlerCollection contexts = new ContextHandlerCollection();
		WebAppContext handler = new WebAppContext();
		handler.setResourceBase(resourceBase);
		handler.setDescriptor(pathname);
		handler.setContextPath("/");
		handler.setClassLoader(Thread.currentThread().getContextClassLoader());

		contexts.addHandler(handler);

		server.setHandler(contexts);
		server.start();
        System.out.println(String.format("Web server started... see 'http://%s/hello'", getHostAndPort()));
	}

	public void stop() throws Exception {
		server.stop();
	}

}
