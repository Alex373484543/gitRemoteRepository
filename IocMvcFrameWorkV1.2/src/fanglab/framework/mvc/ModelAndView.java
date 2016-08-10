package fanglab.framework.mvc;

import java.util.Collections;
import java.util.Map;

/**
 * A ModelAndView object contains a model and a view. Model is represent as a 
 * Map, and View is represent as a String.

 */
public final class ModelAndView {

    private String view;
    private Map<String, Object> model;

    /**
     * Construct a View with empty model.
     * 
     * @param view View's logic name.
     */
    public ModelAndView(String view) {
        this.view = view;
        this.model = Collections.emptyMap();
    }

    /**
     * Construct a View with model.
     * 
     * @param view View's logic name.
     * @param model Model as a Map.
     */
    public ModelAndView(String view, Map<String, Object> model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Return View.
     * 
     * @return View's logic name.
     */
    public String getView() {
        return view;
    }

    /**
     * Return model.
     * 
     * @return Model as a Map.
     */
    public Map<String, Object> getModel() {
        return model;
    }

}
