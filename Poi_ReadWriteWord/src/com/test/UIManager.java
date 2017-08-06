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
	//定义awt组件变量
	private JPanel combop , jp1, jp2, jp3 ,jp4, jp5;
	private JButton btn1, btn2, btn3, btn4, btn5;
	//定义其他变量
	static Map<String,List<String>> AA_result,BB_result,CC_result,DD_result,EE_result;
	static final String filepathString = "C:\\Users\\lyzdsb\\Desktop\\dhy\\能效对标输出文档（水泥为例）.docx";
	static final String destpathString = "C:\\Users\\lyzdsb\\Desktop\\能效对标输出文档（水泥为例）（修改后）.docx";
	static final String jtfAA_string ="企业名称,企业地址,法人姓名,法人职务,法人电话,负责人姓名,负责人职务,联系人1姓名,联系人1职务,企业属地,传真,负责人电话,负责人邮箱";
	static final String jtfBB_string ="机构名称,联系地址,机构电话,机构传真,机构领导姓名,组长姓名,组长执法证号,组长电话,组员1姓名,组员1执法证号,组员1电话,组员2姓名, 组员2执法证号,组员2电话,组长邮箱,组员1邮箱,组员2邮箱";
	static final String jtfCC_string ="现场执法日期（年月日）,首次会议启动时间（时分）, 现场监察启动时间（时分）, 末次会议启动时间（时分）, 末次会议结束时间（时分）,抽查资料月份（X月,X月等六个月）,企业资料提供年限（执法时间的上年度）,召开预备会的时间,监察通知书发出日期（年月日）,通知书到达时间,询问起止时间15时30分至17点00分（时分至时分） ";
	static final String jtfDD_string ="执法编号";
	static final String jtfEE_string ="企业提供资料,抽查资料";

	public UIManager() {
		super("Word文档替换系统");
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

		// 对象实例化
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		// 容器
		Container container = this.getLayeredPane();
		// 对象化面板
		combop = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		//对于第一页:jp1
		
		//实例化结果map
		AA_result = new HashMap<String, List<String>>();
		BB_result = new HashMap<String, List<String>>();
		CC_result = new HashMap<String, List<String>>();
		DD_result = new HashMap<String, List<String>>();
		EE_result = new HashMap<String, List<String>>();
		
		//创建所有的Jtf对象并且获取B框text
		UITools.getAllTextofJtf(jtfAA_string, AA_result, jp1,"AA");
		UITools.getAllTextofJtf(jtfBB_string, BB_result, jp2,"BB");
		UITools.getAllTextofJtf(jtfCC_string, CC_result, jp3,"CC");
		UITools.getAllTextofJtf(jtfDD_string, DD_result, jp4,"DD");
		UITools.getAllTextofJtf(jtfEE_string, EE_result, jp5,"EE");
		

		// 各个页面的btn
		btn1 = new JButton("确定");
		btn1.addActionListener(this);
		jp1.add(btn1);
		
		btn2 = new JButton("确定");
		btn2.addActionListener(this);
		jp2.add(btn2);
		
		btn3 = new JButton("确定");
		btn3.addActionListener(this);
		jp3.add(btn3);
		
		btn4 = new JButton("确定");
		btn4.addActionListener(this);
		jp4.add(btn4);
		
		btn5 = new JButton("确定");
		btn5.addActionListener(this);
		jp5.add(btn5);
		
		//各个页面的tab
		tab.add(jp1, "AA");
		tab.add(jp2, "BB");
		tab.add(jp3, "CC");
		tab.add(jp4, "DD");
		tab.add(jp5, "EE");
		combop.add(new JLabel("Word文档替换系统"));
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
