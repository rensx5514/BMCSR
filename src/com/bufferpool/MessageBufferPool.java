package com.bufferpool;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

import com.message.Message;



public class MessageBufferPool {
	private Queue<Message> buffer=null; //���������ʽ�ṹ����Ϣ�ռ� 
	//private int N=0;//�����Ϣ�ռ䳤��
	private int Num  = 0;
	private int Poolx = 0;
	private int Pooly = 0;
	private int Poolwidth = 0;
	private int Poolheight = 0;
	public  MessageBufferPool(int i){
		this.applyforbuffer(i);
		Message a = new Message("0000");
		Message b = new Message("0001");
		Message c = new Message("0002");
		Message d = new Message("0003");
		Message e = new Message("0004");
		Message f = new Message("0005");
		Message g = new Message("0006");
		System.out.println("Ok");
		
		try {
			this.add(a);
			this.add(b);
			this.add(c);
			this.add(d);
			this.add(e);
			this.add(f);
		} catch (InterruptedException ei) {
			// TODO Auto-generated catch block
			ei.printStackTrace();
		}
		System.out.println(buffer.size());
	}
	public int MessageLen(){
		return buffer.size();
	}
	public  MessageBufferPool(){
		
	}
//	public void setN(int n) {
//		N = n;
//	}
	public void setNum(int n) {
		Num = n;
	}
	public int getNum() {
		return Num;
	}
	public void applyforbuffer(int n) {       //��̬����n����Ϣ�ռ�0
		Num=n;
		buffer=new LinkedBlockingQueue<Message>(n);
		return ;
	}
	public boolean add(Message m) throws InterruptedException{//��������򲻼ӣ�����FALSE
		if(buffer.size()<Num){
			((LinkedBlockingQueue<Message>) buffer).put(m);
			return true;
		}

		else
			return false;
	}
	public Message del(){//ɾ������ͷԪ�أ�������ԭ��Ϊ�գ�����NULL
		return buffer.poll();
	}
	public void display(){
		System.out.println("��ǰ��Ϣ��Ŀ��"+buffer.size());
//		for(int i;i<buffer.size();i++)
//			System.out.println(buffer[i]);
		
		
	}
	public void draw(Graphics g, int x, int y, int s) {  //��һ�����ܶ�����ľͰ
		g.drawRect(3,3,80,300);
		if(buffer!=null){
			Iterator<Message> it = buffer.iterator();
			int i=1;
			int h=0;
			h=300/Num;
			while(it.hasNext()){
				Message ait = it.next();
				ait.draw(g,3,3+((Num-i)*h),80,h);
				i++;
			}
		}
		
		//System.out.println("++++++++++++++++++++====");
	}
}
