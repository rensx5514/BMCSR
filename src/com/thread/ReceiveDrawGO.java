package com.thread;

import com.bufferpool.Buffer;
import com.message.Field;
import com.ui.Reciveui;

public class ReceiveDrawGO implements Runnable{
	private int numbert = 0;
	public int getNumbert() {
		return numbert;
	}
	public void setNumbert(int numbert) {
		this.numbert = numbert;
	}
	Reciveui u = null;
	public ReceiveDrawGO(Reciveui t){
		u=t;
		System.out.println("传输R页面成功");
	}
	@Override
	public void run() {
		Field f = u.getField();
		while(f.getB().get(numbert).drawReceive()){
			f.getB().get(numbert).getM().reborn();
			u.repaint();
			try {
				Thread.currentThread().sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		f.getB().get(numbert).getM().die();
		u.repaint();
		Buffer.receiveStop=false;
		
		
	}

}
