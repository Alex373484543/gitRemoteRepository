package fanglab.framework.ioc.bean;

import fanglab.framework.ioc.annotation.Action;
import fanglab.framework.mvc.ActionSupport;
import fanglab.framework.mvc.ModelAndView;

@Action(value="/testAction.do")
public class TestAction implements ActionSupport {

	@Override
	public ModelAndView execute() throws Exception {	
		System.out.println("-----------------exe--------TestAction-------");
		return new ModelAndView("/test.jsp");
	}

}
