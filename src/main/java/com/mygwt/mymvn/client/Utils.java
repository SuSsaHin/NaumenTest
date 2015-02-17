package com.mygwt.mymvn.client;

import com.google.gwt.user.client.Window;

public class Utils
{
	public static native void closeWindow()
	/*-{
		$wnd.close();
	}-*/;
	
	public static void openFixWindow(String placePrefix, String placeToken, String title)
	{
		Window.open("../MyGwt.html#" + placePrefix + ":" + placeToken, 
				title, "height = 200, width = 400, modal=yes, chrome=yes, dependent=yes, centerscreen=yes");
	}
}
