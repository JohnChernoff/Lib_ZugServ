package org.chernovia.lib.net.zugserv;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class WebSockServ extends ServAdapter {
	
	public boolean PASSWORD = false;
	private Server server;

	public WebSockServ(int port, ConnListener l) {
		super(l);
		server = new Server(port); 
		//Log.setLog(null);
		WebSocketHandler wsHandler = new WebSocketHandler() {
			@Override
			public void configure(WebSocketServletFactory factory) {
				factory.register(WebSockConn.class);
	        }
	    };
	    WebSockConn.SERVER = this; //wsHandler.setServer(this);
	    server.setHandler(wsHandler);
	}

	public void startSrv() { 
		try { 
			server.start(); //server.join(); 
		} catch (Exception e) { e.printStackTrace(); } 
	}
	public ServType getType() { return ServType.TYPE_WEBSOCK; }

}
