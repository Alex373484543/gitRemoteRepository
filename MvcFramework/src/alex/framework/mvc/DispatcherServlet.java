package alex.framework.mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import alex.framework.ioc.IContainer;
import alex.framework.ioc.data.IDataContext;
import alex.framework.ioc.entity.BeanEntity;
import alex.framework.util.MvcContainer;
import alex.framework.util.MvcString;
import alex.framework.util.ReflectionUtil;

public class DispatcherServlet extends HttpServlet {
	
	private static final String DEFAULTCONTAINER="alex.framework.ioc.DefaultContainer";
	private static final String DEFAULTVIEWRESOLVER="alex.framework.mvc.JspViewResolver";
	private Map<String, BeanEntity> actionMap;
	private ViewResolver viewResolver = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init();
		MvcContainer.clear();
		
		String scanPackage=config.getInitParameter("scanPackage");
		
		if(!MvcString.isNull(scanPackage))
		{
			MvcContainer.add("resource",scanPackage);
		}
		ServletContext context = config.getServletContext();
		actionMap = getUrlMapping(config);
		String viewResolverConfig = config.getInitParameter("viewResolver");
		if (!MvcString.isNull(viewResolverConfig)) {
			viewResolver = (ViewResolver) ReflectionUtil
					.getInstance(viewResolverConfig);
		} else {
			viewResolver = (ViewResolver) ReflectionUtil
					.getInstance(DEFAULTVIEWRESOLVER);
		}
		if (viewResolver != null)
			viewResolver.init(context);
		
	}
	
	
	@SuppressWarnings("unchecked")
	private Map<String, BeanEntity> getUrlMapping(ServletConfig config) {

		IContainer ic=null;
		String containerConfig = config.getInitParameter("container");
		if (!MvcString.isNull(containerConfig)) {
			ic=(IContainer)ReflectionUtil.getInstance(containerConfig);
		}else
		{
			ic = (IContainer)ReflectionUtil.getInstance(DEFAULTCONTAINER);//初始化容器，注册资源
		}

		Map<String, BeanEntity> map = new HashMap<String, BeanEntity>();

		IDataContext beanDefinitionContext = ic.getBeanDefinitionContext();// 服务描述信息的存储区
		Map<String, Object> beanDataMap = beanDefinitionContext.getAll();

		if (beanDataMap != null && !beanDataMap.isEmpty()) {
			Set<String> set = beanDataMap.keySet();
			if (set != null && !set.isEmpty()) {
				for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
					String url = iter.next();
					Object obj = beanDataMap.get(url);
					map.put(url, (BeanEntity) obj);
				}
			}
		}
		return map;
	}
	
	// render view:
	private void render(ModelAndView mv, HttpServletRequest reqest,
			HttpServletResponse response) throws ServletException, IOException {
		String view = mv.getView();

		if (MvcString.isNull(view))
			return;

		if (view.startsWith("redirect:")) {
			String redirect = view.substring("redirect:".length());
			response.sendRedirect(redirect);
			return;
		}
		Map<String, Object> model = mv.getModel();
		if (viewResolver != null)
			viewResolver.resolveView(view, model, reqest, response);
	}


}
