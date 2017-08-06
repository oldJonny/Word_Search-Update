package com.test;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JTextFieldDemo1 implements ActionListener {

	// 鍒涘缓鐩稿叧鍙橀噺
	private JFrame jf;
	private JPanel jp;
	private JPanel combop;
	private JTextField jtf1, jtf2, jtf3, jtf4;
	private JButton btn;
	private JTabbedPane jtab;
	private JLabel jl;
	private String search_text;
	private String update_text;

	static final String filepathString = "C:\\Users\\lyzdsb\\Desktop\\dhy\\能效对标输出文档（水泥为例）.docx";
	static final String destpathString = "C:\\Users\\lyzdsb\\Desktop\\能效对标输出文档（水泥为例）.docx";

	public String getSearch_text() {
		return search_text;
	}

	public void setSearch_text(String search_text) {
		this.search_text = search_text;
	}

	public String getUpdate_text() {
		return update_text;
	}

	public void setUpdate_text(String update_text) {
		this.update_text = update_text;
	}

	// 鏋勯�鍑芥暟
	public JTextFieldDemo1() {

		jf = new JFrame("Word_search_update");

		Container contentPane = jf.getContentPane();
		contentPane.setLayout(new BorderLayout());

		jp = new JPanel();

		// 4涓狫TF瀵硅薄
		jtf1 = new JTextField();
		jtf2 = new JTextField("鍐呭1", 10);
		jtf3 = new JTextField("       -->        ");
		jtf4 = new JTextField("鍐呭2", 10);

		// 鐐瑰嚮鏂囨湰妗嗭紝榛樿鏂囧瓧娑堝け
		jtf2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtf2.setText("");
			}

		});

		// 鐐瑰嚮鏂囨湰妗嗭紝榛樿鏂囧瓧娑堝け
		jtf4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtf4.setText("");
			}

		});

		// 鐩戝惉绗竴涓枃鏈
		jtf2.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
			}

			public void insertUpdate(DocumentEvent e) {
				search_text = jtf2.getText();
				System.out.println("search_text Inserted:" + jtf2.getText());
			}

			public void removeUpdate(DocumentEvent e) {
			}
		});

		// 鐩戝惉绗簩涓枃鏈
		jtf4.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
			}

			public void insertUpdate(DocumentEvent e) {
				update_text = jtf4.getText();
				System.out.println("update_text Inserted:" + jtf4.getText());
			}

			public void removeUpdate(DocumentEvent e) {
			}
		});
		jtf3.setEnabled(false);

		jtf2.setFont(new Font("璋愪綋", Font.BOLD | Font.ITALIC, 16));
		jtf4.setFont(new Font("璋愪綋", Font.BOLD | Font.ITALIC, 16));
		// 璁剧疆鏂囨湰鐨勬按骞冲榻愭柟寮�
		jtf2.setHorizontalAlignment(JTextField.CENTER);
		jtf4.setHorizontalAlignment(JTextField.CENTER);

		// 涓�釜Jbutton瀵硅薄
		btn = new JButton("纭畾");
		btn.addActionListener(this);

		jtab = new JTabbedPane(JTabbedPane.TOP); 		
		jtab.add(jp,"娴嬭瘯");
		
		jp.add(jtf1);
		jp.add(jtf2);
		jp.add(jtf3);
		jp.add(jtf4);
		jp.add(btn);
		
		jl = new JLabel("Word鏂囨。鏇挎崲绯荤粺");
		combop = new JPanel();
		combop.add(jl);
//		contentPane.setLayout(new BorderLayout());
		contentPane.add(combop,BorderLayout.NORTH);
		contentPane.add(jtab,BorderLayout.CENTER);
		contentPane.add(jp);
		
		//jframe鐨勫簳灞傝缃�
		jf.pack();
		jf.setLocation(400, 200);
		jf.setVisible(true);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// 缁勮result锛屽緱鍒颁咯涓枃鏈鐨則ext
	public static Map<String, String> getResult(String search_text,
			String update_text) {
		Map<String, String> result = new HashMap<String, String>();
		result.put(search_text, update_text);
		return result;
	}

	public static void main(String[] args) {
		JTextFieldDemo1 x = new JTextFieldDemo1();
	}

	// button鐩戝惉鏂规硶
	public void actionPerformed(ActionEvent e) {
		Map<String, String> result = new HashMap<String, String>();
		result = JTextFieldDemo1.getResult(search_text, update_text);
		Word_search_update.replaceAndGenerateWord(filepathString,
				destpathString, result);
	}

}