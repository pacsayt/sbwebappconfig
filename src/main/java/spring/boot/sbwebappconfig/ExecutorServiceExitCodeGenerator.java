package spring.boot.sbwebappconfig;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * https://github.com/nklkarthi/java-tutorials/blob/master/spring-boot/src/main/java/org/baeldung/common/resources/ExecutorServiceExitCodeGenerator.java
 */
@Component
public class ExecutorServiceExitCodeGenerator implements ExitCodeGenerator
{
/* Ezt honnan szedem ?
  private ExecutorService executorService;

  public ExecutorServiceExitCodeGenerator(ExecutorService executorService)
  {
  }
*/
  @Override
  public int getExitCode()
  {
    int returnCode = 0;
/*
    try
    {
      if (!Objects.isNull(executorService))
      {
        executorService.shutdownNow();
        returnCode = 1;
      }
    }
    catch (SecurityException ex)
    {
      returnCode = 0;
    }
*/
    return returnCode;
  }
}