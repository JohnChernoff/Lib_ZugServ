package org.chernovia.lib.net.zugserv;

import java.util.ArrayList;

public interface ZugServ {
	public static enum ServType { TYPE_SOCK, TYPE_WEBSOCK, TYPE_IRC, TYPE_TWITCH, TYPE_UNKNOWN };
	public static String 
	MSG_TXT = "txt",
	MSG_LOGIN = "login",
	MSG_PASS = "pwd",
	MSG_LOG_SUCCESS = "log_OK",
	MSG_SERV = "serv_msg", 
	MSG_ERR = "err_msg",
	MSG_PRIV = "priv_msg", 
	MSG_CAST = "broadcast";
	void connect(Connection conn);
	void newMsg(Connection conn, String msg);
	void loggedIn(Connection conn);
	void disconnected(Connection conn);
	ArrayList<Connection> getAllConnections(boolean active);
	void broadcast(String type,String msg);
	void tch(int ch, String type, String msg);
	void startSrv();
	ServType getType();
	int getMaxConnections();
	void setMaxConnections(int c);
}
