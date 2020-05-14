package spring.boot.sbwebappconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * https://www.baeldung.com/spring-boot-application-configuration
 * https://www.baeldung.com/spring-boot-change-port
 * https://www.baeldung.com/spring-boot-context-path
 * The priority order in descending order, which Spring Boot uses to select the effective configuration:
 *
 * Java Config
 * Command Line Arguments
 * Java System Properties
 * OS Environment Variables
 * application.properties in Current Directory
 * application.properties in the classpath (src/main/resources or the packaged jar file)
 */

@SpringBootApplication
public class SbwebappconfigApplication
{
	@Autowired
	private ApplicationContext applicationContext;

	/*
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>	webServerFactoryCustomizer()
	{
		return factory -> factory.setContextPath( "/baeldung");
	}
  */

	/*
	   Ha Tomcat helyett Jetty kell, de Undertow is megy
	   pom.xml-be is hozza kell adni a fuggoseget
	   Nem probaltam ki

	@Bean
	public JettyEmbeddedServletContainerFactory  jettyEmbeddedServletContainerFactory()
	{
		JettyEmbeddedServletContainerFactory jettyContainer =	new JettyEmbeddedServletContainerFactory();

		jettyContainer.setPort(9000);
		jettyContainer.setContextPath("/springbootapp");
		return jettyContainer;
	}
  */

	@Autowired // ami marhasag, mert ezt program akarna hivni, nem a framework ...
	public void shutDown( ExecutorServiceExitCodeGenerator executorServiceExitCodeGenerator) // ExecutorServiceExitCodeGenerator
	{
		SpringApplication.exit( applicationContext, executorServiceExitCodeGenerator);
	}

	public static void main(String[] args)
	{
		SpringApplication.run( SbwebappconfigApplication.class, args);

		/* Meg egy modja a hallgatozo port beallitasanak :
        SpringApplication app = new SpringApplication(CustomApplication.class);
        app.setDefaultProperties(Collections.singletonMap( "server.port", "8083"));
        app.run(args);
		 */
	}
}
