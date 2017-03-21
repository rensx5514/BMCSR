package com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mjr extends JFrame {
	JPanel allPanel,topPanel,onePanel,twoPanel,threePanel,sixPanle;
	JButton button1,button2;
	//MyButton2 button1,button2;
	JLabel label1,label2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mjr mjr = new Mjr();
		mjr.setVisible(true);
	}
	class MyButton2 extends JButton {  
	    private static final long serialVersionUID = 1965063150601339314L;  
	    public MyButton2(String text) {  
	        super(text);  
	        setOpaque(false);  
	        setContentAreaFilled(false); // 这一句非常重要, 否则父类还会绘制按钮的区域.  
	    }  
	    @Override  
	    protected void paintComponent(Graphics g) {  
	        int width = this.getWidth();  
	        int height = this.getHeight();  
	        Graphics2D g2d = (Graphics2D) g;  
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  
	                RenderingHints.VALUE_ANTIALIAS_ON);  
	        g2d.setColor(Color.GRAY);  
	        g2d.fillRoundRect(0,  
	                0,  
	                width,  
	                height,  
	                20,  
	                20);  
	        super.paintComponent(g); // 最后调用这个方法, 让父类绘制在按钮上绘制文字.  
	    }  
	} 
	public Mjr()
	{
		allPanel = new JPanel();
		topPanel = new JPanel();
		topPanel.setBackground(Color.blue);
		onePanel = new JPanel();
		onePanel.setBackground(Color.GREEN);
		threePanel = new JPanel();
		threePanel.setBackground(Color.black);
		twoPanel = new JPanel();
		twoPanel.setBackground(Color.RED);
		sixPanle = new JPanel();
		sixPanle.setBackground(Color.pink);
		button1 = new JButton();
		button2 = new JButton();
		label1 = new JLabel("创建一个消息发送进程:");
		label2 = new JLabel("创建一个消息接受进程:");
		label1.setFont(new Font("宋体",Font.BOLD,16));
		label2.setFont(new Font("宋体",Font.BOLD,16));
		allPanel.setLayout(new GridLayout(2, 1));
		allPanel.add(topPanel,0);
		topPanel.setLayout(new GridLayout(2, 1));
		topPanel.add(threePanel, 0);
		topPanel.add(onePanel, 1);
		onePanel.setLayout(new GridLayout(1, 2));
		onePanel.add(twoPanel,0);
		onePanel.add(sixPanle,1);
		twoPanel.setLayout(new GridLayout(2, 2));
		twoPanel.add(label1,0);
		twoPanel.add(button1,1);
		twoPanel.add(label2,2);
		twoPanel.add(button2,3);
		this.add(allPanel);
		this.setSize(800, 600);
		this.setResizable(false);
		setVisible(true);
	}
}
