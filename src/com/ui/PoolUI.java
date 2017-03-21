package com.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.bufferpool.Buffer;
import com.bufferpool.MessageBufferPool;
import com.message.Field;
import com.message.ReceiveMessage;
import com.message.SendMessage;

public class PoolUI extends JPanel {

	private Field field  = Buffer.sfd;
	private MessageBufferPool mp =new MessageBufferPool(100);
	public Field getField() {
		return field;
	}
	public void setField(Field f){
		field = f;
	}
	public void paint(Graphics g){            
		super.paint(g);
		//field.getM().draw(g, 10, 10, 10);
		Buffer.sfd.getM().draw(g, 10, 10, 10);
		//field.getA().get(0).draw(g, 0, 0, 50);
		//field.getA().get(0).getM().draw(g);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame f = new JFrame();
				      f.setSize(110, 600);
				      PoolUI t = new PoolUI();
				      t.setBackground(Color.BLUE);
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
