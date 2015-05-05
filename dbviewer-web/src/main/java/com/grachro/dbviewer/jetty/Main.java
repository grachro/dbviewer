package com.grachro.dbviewer.jetty;

import java.io.File;
import java.io.FilenameFilter;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.JettyWebXmlConfiguration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class Main {

	public static void main(String[] args) throws Exception {

		WebAppContext war = new WebAppContext();
		war.setContextPath("/dbviewer");

		// ProtectionDomain domain = Main.class.getProtectionDomain();
		// URL warLocation = domain.getCodeSource().getLocation();
		// war.setWar(warLocation.toExternalForm());

		// 外部jar及び、javaマクロ追加
		String dbviewrHome = System.getProperty("user.home") + "/dbviewer";
		String jars = loadAllJarPath(dbviewrHome + "/lib");
		war.setExtraClasspath(jars + ";" + dbviewrHome + "/java");

		String projectPath = new File(".").getAbsolutePath();
		String base = projectPath + "/src/main/webapp";
		war.setResourceBase(base);
		war.setDescriptor(base + "/WEB-INF/web.xml");

		Configuration[] configurations = { //
		new AnnotationConfiguration(),//
				new WebInfConfiguration(), //
				new WebXmlConfiguration(),//
				new MetaInfConfiguration(), //
				new FragmentConfiguration(),//
				new EnvConfiguration(),//
				new PlusConfiguration(),//
				new JettyWebXmlConfiguration() //
		};

		war.setConfigurations(configurations);

		Server server = new Server();

		Connector connector = new SelectChannelConnector();
		connector.setPort(48080);
		server.addConnector(connector);
		server.setHandler(war);

		server.start();
		server.join();
	}

	private static String loadAllJarPath(String dir) {

		File[] jars = new File(dir).listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".jar");
			}
		});

		StringBuilder sb = new StringBuilder();
		for (File f : jars) {
			if (sb.length() > 0) {
				sb.append(";");
			}
			sb.append(f.getAbsolutePath());
		}
		return sb.toString();
	}
}
