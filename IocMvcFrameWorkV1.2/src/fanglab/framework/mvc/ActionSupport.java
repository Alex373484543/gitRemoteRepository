package fanglab.framework.mvc;

public interface ActionSupport {

    /**
     * Return a ModelAndView object for render, or null if no need to render.
     * 
     * @return A ModelAndView object, or null.
     * @throws Exception If any exception is thrown.
     */
    ModelAndView execute() throws Exception;

}
