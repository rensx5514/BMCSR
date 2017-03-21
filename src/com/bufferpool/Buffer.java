package com.bufferpool;

import com.message.Field;

public class Buffer {
	static int  b=0;
	public static String lock = new String();
	public static boolean putwood = false;  //鼠标单击放置按钮时设置为true  放下后变为false
	public static boolean stop = true;
	public static boolean receiveStop = true;
	public static boolean sendStop = true;
	public static boolean poolStop = true;
	public static Field sfd = new Field();
	public static int numberr = 0;
	public static int numbers = 0;
}
