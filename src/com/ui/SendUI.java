package com.ui;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.*;

import com.bufferpool.Buffer;
import com.bufferpool.MessageBufferPool;
import com.message.Field;
import com.message.ReceiveMessage;
import com.message.SendMessage;
import com.thread.ReceiveDrawGO;
import com.thread.SendDraw;

public class SendUI extends JPanel{
	private MJF mjf =null;
	public MJF getMjf() {
		return mjf;
	}
	public void setMjf(MJF mjf) {
		this.mjf = mjf;
	}
	private Field field  = null;
	public SendUI(){
		field = Buffer.sfd;
	}
	public Field getField() {
		return field;
	}
	public void setField(Field f){
		field = f;
	}
	public void paint(Graphics g){            
		super.paint(g);
		for(int i = 0;i<field.getA().size();i++){
			//field.getA().get(i).draw(g, 0, 0, 50);
			field.getA().get(i).getM().draw(g);
		}
		//field.getA().get(0).draw(g, 0, 0, 50);
		//field.getA().get(0).getM().draw(g);
	}
	public void MouseAction(){
		SendMessage v = new SendMessage();
		v.setRmn(Buffer.numbers);
		Buffer.numbers = Buffer.numbers+1;
		v.setTemppanel(this);
		field.addSendMessage(v);
		if(mjf!=null){
			v.setPoolu(mjf.getPanel());
		}
		System.out.println("加入发送线程成功");
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					  JFrame f = new JFrame();
				      f.setSize(400, 400);
				      SendUI t = new SendUI();
				      f.add(t);
				      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				      f.setVisible(true);
				      
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
