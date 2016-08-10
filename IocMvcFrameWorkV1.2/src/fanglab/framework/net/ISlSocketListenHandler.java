package fanglab.framework.net;

import java.net.*;

public interface ISlSocketListenHandler {
	String handle(String message, Socket socket);
}
