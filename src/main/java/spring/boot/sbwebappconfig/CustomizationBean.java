package spring.boot.sbwebappconfig;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

// Vagy : java -jar spring-5.jar --server.port=8083
//        java -jar app.jar      --server.servlet.context-path=/springbootapp

@Component
public class CustomizationBean implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
{
  @Override
  public void customize(ConfigurableServletWebServerFactory configurableServletWebServerFactory)
  {
    configurableServletWebServerFactory.setPort(8083);

    // By default, the context path is “/”.
    configurableServletWebServerFactory.setContextPath( "/springbootapp");

    // Here, we specifically handled Bad Request to match the /400 path and all others to match the common path.
    // Lasd : MyCustomErrorController::@GetMapping("/errorHaven")String errorHeaven()
    configurableServletWebServerFactory.addErrorPages( new ErrorPage( HttpStatus.NOT_FOUND, "/404")); // NOT_FOUND 404, BAD_REQUEST 400
    configurableServletWebServerFactory.addErrorPages( new ErrorPage("/errorHaven"));
  }
}