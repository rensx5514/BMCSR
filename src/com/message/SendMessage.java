package com.message;
import java.awt.Graphics;

import com.bufferpool.Buffer;
import com.bufferpool.MessageBufferPool;
import com.thread.SendDraw;
import com.thread.UpdatePool;
import com.ui.PoolUI;
import com.ui.Reciveui;
import com.ui.SendUI;
public class SendMessage extends Thread{
	private int woodx = 50;  //ľͰ���Ͻ�����
	private int woody = 300;  //ľͰ���Ͻ�����
	private int woodcorex = 0;
	private int woodcorey = 0;
	private int size = 50;   //����ľͰ����
	private int temp = 0;
	private int tempx = 0;
	private int tempy = 0;
	private int rmn = 0;
	public int getRmn() {
		return rmn;
	}
	public void setRmn(int rmn) {
		this.rmn = rmn;
	}
	private SendUI temppanel = null;
	private PoolUI poolu = null;
	public PoolUI getPoolu() {
		return poolu;
	}
	public void setPoolu(PoolUI poolu) {
		this.poolu = poolu;
	}
	public SendUI getTemppanel() {
		return temppanel;
	}
	public void setTemppanel(SendUI temppanel) {
		this.temppanel = temppanel;
	}
	//private Message m = new Message("1000");
	Message sendm = new Message("null");
	MessageBufferPool bp = null;
	public SendMessage(){
		
		bp = Buffer.sfd.getM();
	}
	public SendMessage(MessageBufferPool bm){
		bp = bm;
	}
	public void setSize(int s){
		size =s;
	}
	public void setXY(int x,int y){
		woodx = x;
		woody = y;
	}
	public Message getM(){
		return this.sendm;
	}
	public void p_send(){  
		synchronized(Buffer.lock){
			Buffer.sendStop = true;
			System.out.println("11"+bp.MessageLen());
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					while(bp.MessageLen()==bp.getNum()){
								try {
									Buffer.lock.wait();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					}
					try {
						System.out.println("�ҷ�����"+this.currentThread().getName()); 
						sendm.setMessageName(this.currentThread().getName());
						bp.add(sendm);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sendm.setMessagex(0);
					sendm.setMessagey(20);
//					bp.up();
					SendDraw go = new SendDraw(temppanel);
					go.setNumbert(rmn);
				   Thread as=new Thread(go);
				    as.start();
					while(Buffer.sendStop){
						try {
							this.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					UpdatePool gop = new UpdatePool(poolu);
					Thread gopt=new Thread(gop);
					gopt.start();
					while(Buffer.poolStop){
						try {
							this.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("send"+this.currentThread().getName());  
					System.out.println(bp.MessageLen()+"Num"+bp.getNum());
					if(bp.MessageLen() == 1){
						Buffer.lock.notifyAll();
					}
		}
				//if()
		
	}
	public void run(){
		super.run();
		while(true){
			p_send();
			
		}
		
	}
	public void draw(Graphics g, int x, int y, int s) {  
		g.drawRect(woodx, woody, size, size);
	}
	public boolean drawSend(){
		
		tempx = sendm.getMessagex()+1;
		tempy = sendm.getMessagey();
		sendm.setMessagex(tempx);
		//System.out.println("TEMP="+tempx);
		//System.out.println(m.getMessagex()+"gg");
		if(sendm.getMessagex()==800){
			//m.setMessagex(51);
			sendm.setMessagex(0);
			sendm.setMessagey(20);
			return false;
		}else{
			return true;
		}
	}
}
