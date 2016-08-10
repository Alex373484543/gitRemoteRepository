package fanglab.framework.ioc.handler;

import java.util.Map;

public abstract class HandlerDecorator implements IHandler {

	protected IHandler handler;

	public void setHandler(IHandler handler) {
		this.handler = handler;
	}

	public Map<String, Object> convert(String string) {

		if (handler != null) {
			return handler.convert(string);
		}

		return null;
	}
}
