package com.thread;

import com.bufferpool.Buffer;
import com.message.Field;
import com.ui.Reciveui;
import com.ui.SendUI;

public class SendDraw implements Runnable{

	private int numbert = 0;
	public int getNumbert() {
		return numbert;
	}
	public void setNumbert(int numbert) {
		this.numbert = numbert;
	}
	SendUI u = new SendUI();
	public SendDraw(SendUI t){
		u=t;
	}
	@Override
	public void run() {
		Field f = Buffer.sfd;
		while(f.getA().get(numbert).drawSend()){
			u.repaint();
			try {
				Thread.currentThread().sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		u.repaint();
		Buffer.sendStop = false;
		
	}

}