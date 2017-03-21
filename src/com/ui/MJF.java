package com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.bufferpool.Buffer;
import com.message.ReceiveMessage;
import com.thread.ReceiveDrawGO;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.GridLayout;

public class MJF extends JFrame {

	private JPanel contentPane;
	private Reciveui panel_s = new Reciveui();
	private SendUI panel_n = new SendUI();
	private PoolUI panel = new PoolUI();
	private Border emptyBorder = BorderFactory.createEmptyBorder(0,0,0,0);
	public PoolUI getPanel() {
		return panel;
	}
	public void setPanel(PoolUI panel) {
		this.panel = panel;
	}
	public SendUI getPanel_n() {
		return panel_n;
	}
	public void setPanel_n(SendUI panel_n) {
		this.panel_n = panel_n;
	}
	public Reciveui getPanel_s() {
		return panel_s;
	}
	public void setPanel_s(Reciveui panel_s) {
		this.panel_s = panel_s;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MJF frame = new MJF();
					frame.setVisible(true);
					//frame.runhere();
					ReceiveDrawGO go = new ReceiveDrawGO(frame.getPanel_s());
				    Thread as=new Thread(go);
				    as.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void runhere(){
		
		
	}
	/**
	 * Create the frame.
	 */
	public MJF() {
		setResizable(false);
		setTitle("\u6F14\u793A\u7A0B\u5E8F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 760);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setAlignmentY(0.0f);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{395, 107, 0};
		gbl_contentPane.rowHeights = new int[] {97, 530, 139, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		FlowLayout flowLayout = (FlowLayout) panel_n.getLayout();
		//panel_n = new SendUI();
		panel_n.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel_n = new GridBagConstraints();
		gbc_panel_n.gridwidth = 2;
		gbc_panel_n.fill = GridBagConstraints.BOTH;
		gbc_panel_n.insets = new Insets(0, 0, 5, 0);
		gbc_panel_n.gridx = 0;
		gbc_panel_n.gridy = 0;
		contentPane.add(panel_n, gbc_panel_n);
		Dimension d = new Dimension();
		d.setSize(1000, 300);
		JPanel panel_w = new JPanel();
		panel_w.setLayout(null);
		GridBagConstraints gbc_panel_w = new GridBagConstraints();
		gbc_panel_w.fill = GridBagConstraints.BOTH;
		gbc_panel_w.insets = new Insets(0, 0, 5, 5);
		gbc_panel_w.gridx = 0;
		gbc_panel_w.gridy = 1;
		contentPane.add(panel_w, gbc_panel_w);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(0, 194, 76, 59);
		ImageIcon iconbtnNewButton_2 = new ImageIcon("image/starticon.png");
		btnNewButton_2.setIcon(iconbtnNewButton_2);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBorder(emptyBorder);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_s.getField().allstart();
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setBounds(0, 76, 76, 59);
		ImageIcon iconbtnNewButton_1 = new ImageIcon("image/sendicon.png");
		btnNewButton_1.setIcon(iconbtnNewButton_1);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(emptyBorder);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_n.MouseAction();
			}
		});
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(0, 135, 76, 59);
		ImageIcon icon = new ImageIcon("image/basketicon01.png");
		btnNewButton.setIcon(icon);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(emptyBorder);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getX());
				System.out.println(e.getY());
				Buffer.putwood = true;
			}
		});
		panel_w.add(btnNewButton);
		panel_w.add(btnNewButton_1);
		panel_w.add(btnNewButton_2);
		
		
		panel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagConstraints gbc_panel_s = new GridBagConstraints();
		gbc_panel_s.gridwidth = 2;
		gbc_panel_s.anchor = GridBagConstraints.NORTH;
		gbc_panel_s.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_s.gridx = 0;
		gbc_panel_s.gridy = 2;
		contentPane.add(panel_s, gbc_panel_s);
		panel_s.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("ÎÒµã»÷ÁË");
				if(Buffer.putwood==true){
					System.out.println("°¡");
					panel_s.MouseAction(e.getX(), e.getY());
				}
				panel_s.repaint();
			}
		});
		panel_s.setBackground(Color.LIGHT_GRAY);
		panel_s.setMinimumSize(d);//.setPreferredSize(d);
		panel_s.setMaximumSize(d);
		//JPanel panel_c = new JPanel();
		panel_n.setMjf(this);
		panel_s.setMjf(this);
	}

}
