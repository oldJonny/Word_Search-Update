package com.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class UIManager extends JFrame implements ActionListener{
	//����awt�������
	private JPanel combop , jp1, jp2, jp3 ,jp4, jp5;
	private JButton btn1, btn2, btn3, btn4, btn5;
	//������������
	static Map<String,List<String>> AA_result,BB_result,CC_result,DD_result,EE_result;
	static final String filepathString = "C:\\Users\\lyzdsb\\Desktop\\dhy\\��Ч�Ա�����ĵ���ˮ��Ϊ����.docx";
	static final String destpathString = "C:\\Users\\lyzdsb\\Desktop\\��Ч�Ա�����ĵ���ˮ��Ϊ�������޸ĺ�.docx";
	static final String jtfAA_string ="��ҵ����,��ҵ��ַ,��������,����ְ��,���˵绰,����������,������ְ��,��ϵ��1����,��ϵ��1ְ��,��ҵ����,����,�����˵绰,����������";
	static final String jtfBB_string ="��������,��ϵ��ַ,�����绰,��������,�����쵼����,�鳤����,�鳤ִ��֤��,�鳤�绰,��Ա1����,��Ա1ִ��֤��,��Ա1�绰,��Ա2����, ��Ա2ִ��֤��,��Ա2�绰,�鳤����,��Ա1����,��Ա2����";
	static final String jtfCC_string ="�ֳ�ִ�����ڣ������գ�,�״λ�������ʱ�䣨ʱ�֣�, �ֳ��������ʱ�䣨ʱ�֣�, ĩ�λ�������ʱ�䣨ʱ�֣�, ĩ�λ������ʱ�䣨ʱ�֣�,��������·ݣ�X��,X�µ������£�,��ҵ�����ṩ���ޣ�ִ��ʱ�������ȣ�,�ٿ�Ԥ�����ʱ��,���֪ͨ�鷢�����ڣ������գ�,֪ͨ�鵽��ʱ��,ѯ����ֹʱ��15ʱ30����17��00�֣�ʱ����ʱ�֣� ";
	static final String jtfDD_string ="ִ�����";
	static final String jtfEE_string ="��ҵ�ṩ����,�������";

	public UIManager() {
		super("Word�ĵ��滻ϵͳ");
	}

	public void initUI() {
		this.setBounds(600, 400, 400, 575);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
		layoutUI();
		this.setVisible(true);
	}
		
	private void layoutUI() {

		// ����ʵ����
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		// ����
		Container container = this.getLayeredPane();
		// �������
		combop = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		//���ڵ�һҳ:jp1
		
		//ʵ�������map
		AA_result = new HashMap<String, List<String>>();
		BB_result = new HashMap<String, List<String>>();
		CC_result = new HashMap<String, List<String>>();
		DD_result = new HashMap<String, List<String>>();
		EE_result = new HashMap<String, List<String>>();
		
		//�������е�Jtf�����һ�ȡB��text
		UITools.getAllTextofJtf(jtfAA_string, AA_result, jp1,"AA");
		UITools.getAllTextofJtf(jtfBB_string, BB_result, jp2,"BB");
		UITools.getAllTextofJtf(jtfCC_string, CC_result, jp3,"CC");
		UITools.getAllTextofJtf(jtfDD_string, DD_result, jp4,"DD");
		UITools.getAllTextofJtf(jtfEE_string, EE_result, jp5,"EE");
		

		// ����ҳ���btn
		btn1 = new JButton("ȷ��");
		btn1.addActionListener(this);
		jp1.add(btn1);
		
		btn2 = new JButton("ȷ��");
		btn2.addActionListener(this);
		jp2.add(btn2);
		
		btn3 = new JButton("ȷ��");
		btn3.addActionListener(this);
		jp3.add(btn3);
		
		btn4 = new JButton("ȷ��");
		btn4.addActionListener(this);
		jp4.add(btn4);
		
		btn5 = new JButton("ȷ��");
		btn5.addActionListener(this);
		jp5.add(btn5);
		
		//����ҳ���tab
		tab.add(jp1, "AA");
		tab.add(jp2, "BB");
		tab.add(jp3, "CC");
		tab.add(jp4, "DD");
		tab.add(jp5, "EE");
		combop.add(new JLabel("Word�ĵ��滻ϵͳ"));
		setResizable(false);
		container.setLayout(new BorderLayout());
		container.add(combop, BorderLayout.NORTH);
		container.add(tab, BorderLayout.CENTER);
	}


	public static void main(String[] args) {
		UIManager ui = new UIManager();
		ui.initUI();

		}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Map<String, String> result = new HashMap<String, String>();
		
		for(Entry<String, List<String>> entry : AA_result.entrySet())
		{
			
			if(entry.getValue().size()>0)
			{
				result.put(entry.getKey(), entry.getValue().get(entry.getValue().size()-1));
			}
		}
		for(Entry<String, List<String>> entry : BB_result.entrySet())
		{
			
			if(entry.getValue().size()>0)
			{
				result.put(entry.getKey(), entry.getValue().get(entry.getValue().size()-1));
			}
		}
		for(Entry<String, List<String>> entry : CC_result.entrySet())
		{
			
			if(entry.getValue().size()>0)
			{
				result.put(entry.getKey(), entry.getValue().get(entry.getValue().size()-1));
			}
		}
		for(Entry<String, List<String>> entry : DD_result.entrySet())
		{
			
			if(entry.getValue().size()>0)
			{
				result.put(entry.getKey(), entry.getValue().get(entry.getValue().size()-1));
			}
		}
		for(Entry<String, List<String>> entry : EE_result.entrySet())
		{
			
			if(entry.getValue().size()>0)
			{
				result.put(entry.getKey(), entry.getValue().get(entry.getValue().size()-1));
			}
		}
		Word_search_update.replaceAndGenerateWord(filepathString,
				destpathString, result);
	}
}
