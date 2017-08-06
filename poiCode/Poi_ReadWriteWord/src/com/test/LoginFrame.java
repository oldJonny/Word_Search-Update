package com.test;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class LoginFrame extends JFrame implements ActionListener{
	private JButton btn1, btn2;
	
	public LoginFrame(){
//		super("��¼����");
//		initComponent();
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		btn1 = new JButton("�ܺĺ˲����ϵͳ");
		btn2 = new JButton("Word�ĵ��滻ϵͳ");
		add(btn1);
		add(btn2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}
	
	// ��ʼ������
	private void initComponent() {
		this.setSize(200, 100);
		Font font = new Font("����", Font.BOLD, 20);
		
		
		btn1.setBounds(10, 10, 10, 10);
		btn1.setFont(font);
		
		
		btn2 = new JButton("����2");
//		btn1.setBounds(200, 630, 120, 35);
		btn2.setFont(font);
		btn2.addActionListener(this);
		
//		this.getContentPane().add(btn2);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * ��ť�¼�
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.equals(btn1)) {
			new CarMan();
		}
		else if(button.equals(btn2)){
			System.out.println("aa");
			UIManager ui = new UIManager();
			ui.initUI();
		}
	}
	
	public static void main(String[] args) {
//		new LoginFrame();
		LoginFrame frame = new LoginFrame();
		frame.setTitle("������ҵ�ĵ�����ϵͳ");
		frame.setSize(340, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
