package com.message;

import java.util.ArrayList;

import com.bufferpool.MessageBufferPool;

public class Field {
	private ArrayList<SendMessage> a = new ArrayList<SendMessage>();
	private ArrayList<ReceiveMessage> b =  new ArrayList<ReceiveMessage>();
	private MessageBufferPool m =  new MessageBufferPool();
	public MessageBufferPool getM() {
		
		return m;
	}
	public void setM(MessageBufferPool m) {
		this.m = m;
	}
	private SendMessage x = null;
	private ReceiveMessage y = null;
	public void addSendMessage(SendMessage v){
		a.add(v);
	}
	public void addReceiveMessage(ReceiveMessage v){
		b.add(v);
	}
	public Field(){
		m.applyforbuffer(10);
		//y = new ReceiveMessage(m);
		//x = new SendMessage(m);
		
		//a.add(x);
		//b.add(y);
	}
	public void allstart(){
		if(a.size()>=1&&b.size()>=1){
			for(int i=0;i<a.size();i++){
				a.get(i).start();
			}
			for(int j = 0;j<b.size();j++){
				b.get(j).start();
			}
		}else{
			if(a.size()==0){
				System.out.println("缺少发送线程");
			}
			if(b.size()==0){
				System.out.println("缺少接受线程");
			}
			System.out.println("至少有一个发送线程和接受线程");
		}
		
	}
	public ArrayList<SendMessage> getA() {
		return a;
	}
	public void setA(ArrayList<SendMessage> a) {
		this.a = a;
	}
	public ArrayList<ReceiveMessage> getB() {
		return b;
	}
	public void setB(ArrayList<ReceiveMessage> b) {
		this.b = b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
