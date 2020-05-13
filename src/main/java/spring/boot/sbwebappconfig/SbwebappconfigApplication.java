package spring.boot.sbwebappconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * https://www.baeldung.com/spring-boot-application-configuration
 */


@SpringBootApplication
public class SbwebappconfigApplication
{
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

	public static void main(String[] args)
	{
		SpringApplication.run(SbwebappconfigApplication.class, args);
	}
}
