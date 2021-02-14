package com.aseef.meme.aseefcriomemebackend;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class TomcatContainerCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

	
	private int swaggerPort=8080;
	
	@Override
	public void customize(TomcatServletWebServerFactory factory) {
		// TODO Auto-generated method stub
		Connector swaggerConnector = new Connector();
        swaggerConnector.setPort(swaggerPort);
        factory.addAdditionalTomcatConnectors(swaggerConnector);
		
	}

}
