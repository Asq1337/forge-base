package me.ag3ntcow.base;

import java.awt.Color;

public class Util {

	public static final String CLIENT_PROXY = "me.ag3ntcow.base.proxy.ClientProxy";
	public static final String COMMON_PROXY = "me.ag3ntcow.base.proxy.CommonProxy";
	
    public static int rainbow(int delay) {
    	double rState = Math.ceil((System.currentTimeMillis() + delay)/8.0);
    	rState %= 360;
    	return Color.getHSBColor((float) (rState / 360.0f), 1f, 1f).getRGB(); 
    }
}
