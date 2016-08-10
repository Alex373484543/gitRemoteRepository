package fanglab.framework.mvc;

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
import javax.servlet.http.HttpSession;

import fanglab.framework.SlContainer;
import fanglab.framework.SlException;
import fanglab.framework.SlString;
import fanglab.framework.ioc.container.IContainer;
import fanglab.framework.ioc.data.IDataContext;
import fanglab.framework.ioc.entity.BeanEntity;
import fanglab.framework.ioc.util.ReflectionUtil;

public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Map<String, BeanEntity> actionMap;
	private ExceptionResolver exceptionResolver = null;
	private ViewResolver viewResolver = null;
	
	private static final String DEFAULTVIEWRESOLVER="fanglab.framework.mvc.JspViewResolver";
	private static final String DEFAULTCONTAINER="fanglab.framework.ioc.container.DefaultContainer";

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SlContainer.clear();
		String scanPackageConfig = config.getInitParameter("scanPackage");
		System.out.println(scanPackageConfig);
		if (!SlString.isNullOrEmpty(scanPackageConfig)) {
			SlContainer.add("resource", scanPackageConfig);
		}
		ServletContext context = config.getServletContext();
		actionMap = getUrlMapping(config);

		String viewResolverConfig = config.getInitParameter("viewResolver");

		if (!SlString.isNullOrEmpty(viewResolverConfig)) {
			viewResolver = (ViewResolver) ReflectionUtil
					.getInstance(viewResolverConfig);
		} else {
			viewResolver = (ViewResolver) ReflectionUtil
					.getInstance(DEFAULTVIEWRESOLVER);
		}
		if (viewResolver != null)
			viewResolver.init(context);
	}

	
	@Override
	public void destroy() {
		super.destroy();
	}

	@SuppressWarnings("unchecked")
	private Map<String, BeanEntity> getUrlMapping(ServletConfig config) {

		IContainer ic=null;
		String containerConfig = config.getInitParameter("container");
		if (!SlString.isNullOrEmpty(containerConfig)) {
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

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String contextPath = request.getContextPath();

		if (!SlString.isNullOrEmpty(contextPath)) {
			String url = request.getRequestURI()
					.substring(contextPath.length());
			BeanEntity am = actionMap.get(url);
			if (am == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			ModelAndView mv = null;
			try {
				// init ActionContext:
				HttpSession session = request.getSession();
				ServletContext context = session.getServletContext();
				ActionContext.setActionContext(request, response, session,
						context);
				// try instance action:
				ActionSupport action = (ActionSupport) am.getValue();
				try {
					mv = action.execute();
				} catch (Exception e) {
					e.printStackTrace();
					if (exceptionResolver != null) {
						try {
							mv = exceptionResolver.handleException(action, e);
						} catch (Exception ex) {
							throw new ServletException(SlException.toString(e),
									e);
						}
					} else
						throw new ServletException(SlException.toString(e), e);
				} catch (Throwable t) {
					throw new ServletException(t);
				}
			} finally {
				ActionContext.remove();
			}
			if (mv != null)
				render(mv, request, response);
		}
	}

	// render view:
	private void render(ModelAndView mv, HttpServletRequest reqest,
			HttpServletResponse response) throws ServletException, IOException {
		String view = mv.getView();

		if (SlString.isNullOrEmpty(view))
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

	/**
	 * Call to doGet(request, response).
	 */
	@Override
	protected void doPost(HttpServletRequest reqest,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(reqest, response);
	}

	/**
	 * Send an HttpServletResponse.SC_BAD_REQUEST error.
	 */
	@Override
	protected void doDelete(HttpServletRequest reqest,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}

	/**
	 * Send an HttpServletResponse.SC_BAD_REQUEST error.
	 */
	@Override
	protected void doHead(HttpServletRequest reqest,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}

	/**
	 * Send an HttpServletResponse.SC_BAD_REQUEST error.
	 */
	@Override
	protected void doOptions(HttpServletRequest reqest,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}

	/**
	 * Send an HttpServletResponse.SC_BAD_REQUEST error.
	 */
	@Override
	protected void doPut(HttpServletRequest reqest, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}

	/**
	 * Send an HttpServletResponse.SC_BAD_REQUEST error.
	 */
	@Override
	protected void doTrace(HttpServletRequest reqest,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}
	
	public static void main(String[] args) {
		
	}

}
