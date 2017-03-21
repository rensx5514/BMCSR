package com.message;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.bufferpool.Buffer;
import com.bufferpool.MessageBufferPool;
import com.thread.ReceiveDrawGO;
import com.thread.UpdatePool;
import com.ui.PoolUI;
import com.ui.Reciveui;
public class ReceiveMessage extends Thread{
	MessageBufferPool bp = null;
	private int woodx = 50;  //ľͰ���Ͻ�����
	private int woody = 200;  //ľͰ���Ͻ�����
	private int woodcorex = 0;
	private int woodcorey = 0;
	private int size = 50;   //����ľͰ����
	private int temp = 0;
	private int tempx = 0;
	private int tempy = 0;
	private int rmn = 0;
	private Image receiveimage =null; 
	public int getRmn() {
		return rmn;
	}
	public void setRmn(int rmn) {
		this.rmn = rmn;
	}
	private Message m = null;
	private Reciveui temppanel = null;
	private PoolUI poolu = null;
	public PoolUI getPoolu() {
		return poolu;
	}
	public void setPoolu(PoolUI poolu) {
		this.poolu = poolu;
	}
	public ReceiveMessage(){
		bp =Buffer.sfd.getM();
	}
	public Reciveui getTemppanel() {
		return temppanel;
	}
	public void setTemppanel(Reciveui temppanel) {
		this.temppanel = temppanel;
		System.out.println("���͵�RM�ɹ�");
		int i=temppanel.getField().getA().size();
		int ii=temppanel.getField().getB().size();
		System.out.println("a�߳���"+i);
		System.out.println("b�߳���"+ii);
	}
	//private Message test = new Message("1000");
	public Message getM(){
		return this.m;
	}
	public void setSize(int s){
		size =s;
	}
	public void setXY(int x,int y){
		woodx = x;
		woody = y;
	}
	public ReceiveMessage(MessageBufferPool bm){
		bp = bm;
	}
	 public void p_receive(){  //����Ϣ�������ȡ����ǰ�����Ϣ
		synchronized(Buffer.lock){
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(bp.MessageLen()==0){
				try {
					Buffer.lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(bp.MessageLen());
			Buffer.receiveStop=true;
					m=bp.del();
					m.setMessagex(400);
					m.setMessagey(0);
//					bp.down();
					System.out.println("Receivego++++++++++=");
					ReceiveDrawGO go = new ReceiveDrawGO(temppanel);
					go.setNumbert(rmn);
				   Thread as=new Thread(go);
				    as.start();
				    while(Buffer.receiveStop){
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
					
					System.out.println("shoudao"+bp.MessageLen()+"Num"+bp.getNum());  //��ӡ������
					m.die();
					if(bp.MessageLen() == bp.getNum()-1){
						Buffer.lock.notifyAll();
					}
		}
	}
	
	public void run(){
		super.run();
		while(true){
			p_receive();
			
		}
		
	}
	public void draw(Graphics g, int x, int y, int s) {  //��һ�����ܶ�����ľͰ
		//g.drawRect(woodx, woody, 100, size);
		g.drawString(this.getName(), woodx, woody-20);
		try {
			receiveimage =ImageIO.read(new File("image\\Recycle.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		g.drawImage(receiveimage,woodx,woody, null);
		//g.fillRect(woodx, woody, size, size);
		//System.out.println("++++++++++++++++++++====");
	}
	public boolean drawReceive(){
		System.out.println("woodx="+woodx);
		System.out.println("x="+m.getMessagex());
		System.out.println("y="+m.getMessagey());
		System.out.println("woody="+woody);
		System.out.println("��ʼ�����ƶ�");
		if(m.getMessagex()==woodx){
			if(m.getMessagey()==woody){
				m.die();
				m.setMessagex(500);
				m.setMessagey(0);
				System.out.println("�ɹ����յ���һ��");
				return false;
			}
			tempy = m.getMessagey()+1;
			m.setMessagey(tempy);
			return true;
		}else{
			tempx = m.getMessagex()-1;
			m.setMessagex(tempx);
			return true;
		}
	}
}
