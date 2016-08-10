package fanglab.framework.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Interface of exception resolver to handle exception.
 * 
 */
public interface ExceptionResolver {

    /**
     * Do init work when servlet starts.
     * 
     * @param context ServletContext object.
     * @throws ServletException If init failed.
     */
    void init(ServletContext context) throws ServletException;

    /**
     * When exception thrown during action's execution.
     * 
     * @param action Action object.
     * @param e Exception instance.
     * @return ModelAndView object after handle this exception, or null if 
     *         no exception page to display to user.
     */
    ModelAndView handleException(ActionSupport action, Exception e) throws Exception;

}
