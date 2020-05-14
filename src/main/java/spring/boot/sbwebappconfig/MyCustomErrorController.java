package spring.boot.sbwebappconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Spring Boot automatically registers a BasicErrorController bean if you don't specify any custom implementation in the configuration.
 * However, this default controller can, of course, be configured:
 */
@Controller
public class MyCustomErrorController implements ErrorController
{
  private static final String ERROR_PATH = "/error";

  @Autowired
  private ApplicationContext applicationContext;

  /* ^ vagy :
  @Autowired
  public void context(ApplicationContext context)
  {
    context = context;
  }

  ^ vagy :
  @Component
  public class ApplicationContextProvider implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
    ...}
  */

  @GetMapping( value = ERROR_PATH)
  public String error()
  {
    return "Error haven";
  }

  @GetMapping( "/errorHaven")
  String errorHeaven()
  {
    return "You have reached the haven of errors!!!";
  }

  @Override
  public String getErrorPath()
  {
    return ERROR_PATH;
  }

  @Autowired
  public void shutDown( ExitCodeGenerator exitCodeGenerator)
  {
    SpringApplication.exit( applicationContext, exitCodeGenerator);
  }
}