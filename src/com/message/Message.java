package com.message;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Message {
	private String m = null;//�̶�������Ϣ�Ĵ�Сn ��������̵߳�id
	private int Messagex = 0; //��Ϣ���ε���������
	private int Messagey = 20;  //��Ϣ���ε���������
	private int size = 50;        //��Ϣ���εĿ�
	ImageIcon icon = new ImageIcon("image\\messae0.png");
	private Image messageimage =null; 
	public Message(String name) {
		m = name;
	}
	public void setMessageName(String s){
		m=s;
		
	}
	public String getm(){
		return m;
	}
	private boolean alive = false;
	public void die() { alive = false; }
	public void reborn() { alive = true; }
	public boolean isAlive() { return alive; }
	public void draw(Graphics g) {  //����Ϣ�ľ���
		//g.drawRect(Messagex, Messagey, 100, size);
		g.drawString(m,Messagex+80 ,Messagey+20);
		try {
			messageimage =ImageIO.read(new File("image\\message0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		g.drawImage(messageimage,Messagex,Messagey, null);
	}
	public void draw(Graphics g,int x,int y,int width,int length) {  //��pool��message����̬
		g.drawRect(x, y, width, length);
		g.drawString(m,x ,y+20);
		
		//g.drawImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9)
		/*if ( alive ) {
			g.fillRect(x, y, size, size);
		}*/
	}
	public void drawRecive(int x,int y,int p,int q){
		
		
	}
	public int getMessagex() {
		return Messagex;
	}
	public void setMessagex(int messagex) {
		Messagex = messagex;
	}
	public int getMessagey() {
		return Messagey;
	}
	public void setMessagey(int messagey) {
		Messagey = messagey;
	}
}
