package com.ui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.bufferpool.Buffer;
import com.bufferpool.MessageBufferPool;
import com.message.Field;
import com.message.ReceiveMessage;
import com.message.SendMessage;
import com.thread.ReceiveDrawGO;

public class Reciveui extends JPanel {
	private MJF mjf =null;
	private Field field  = null;
	public Reciveui(){
		field = Buffer.sfd;
	}
	public MJF getMjf() {
		return mjf;
	}
	public void setMjf(MJF mjf) {
		this.mjf = mjf;
	}
	public Field getField() {
		return field;
	}
	public void setField(Field f){
		field = f;
	}
	public void paint(Graphics g){            
		super.paint(g);   //覆盖原有画布
		for(int i=0;i<field.getB().size();i++){  //循环绘制field中的内容
			
				field.getB().get(i).draw(g, 0, 0, 50);
				if(field.getB().get(i).getM()!=null){
					field.getB().get(i).getM().draw(g);
					if(field.getB().get(i).getM().isAlive()){
						field.getB().get(i).getM().draw(g);
					}
				}
				
				
			
			
		}
	}
	public void Reciveui(){
		
	}
	public void MouseAction(int x,int y){
		ReceiveMessage v = new ReceiveMessage();
		v.setRmn(Buffer.numberr);
		Buffer.numberr = Buffer.numberr+1;
		v.setXY(x,y);
		v.setTemppanel(this);
		field.addReceiveMessage(v);
		System.out.println("成功");
		if(mjf!=null){
			v.setPoolu(mjf.getPanel());
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame f = new JFrame();
				      f.setSize(400, 400);
				      Reciveui t = new Reciveui();
				      f.add(t);
				      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				      f.setVisible(true);
					 // MessageBufferPool m =  new MessageBufferPool();
				      //m.applyforbuffer(10);
					  //SendMessage s = new SendMessage(m);
						//s.setTemppanel(temppanel);
					  //s.start();
					  //ReceiveMessage r = new ReceiveMessage(m);
				      //r.setTemppanel(t);
						//r.start();
						//SendMessage ss = new SendMessage(m);
						//ss.start();
				      
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
