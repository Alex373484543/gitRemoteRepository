package alex.framework.mvc;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ViewResolver {
	
	  /**
     * Init this ViewResolver.
     * 
     * @param context ServletContext object that holds information of current 
     *                web application.
     * @throws ServletException If init failed.
     */
    void init(ServletContext context) throws ServletException;

    /**
     * To resolve view's name and render view if necessary.
     * 
     * @param view View's logic name.
     * @param model Model represent as a generic Map.
     * @param request HttpServletRequest object.
     * @param response HttpServletResponse object.
     * @throws ServletException If any ServletException occur.
     * @throws IOException If any IOException occur.
     */
    void resolveView(String view, Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
