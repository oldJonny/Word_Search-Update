package com.test;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UITools {
	
	//组合数组 outputList 和 inputList,组成map
	public static Map<JTextField, JTextField> crossCombination(List<JTextField> inputList, List<JTextField> outputList){
		Map<JTextField, JTextField> mapAfterCrossCombination = new LinkedHashMap<JTextField, JTextField>();		

		for(int i = 0; i < inputList.size();i++)
		{
			mapAfterCrossCombination.put(inputList.get(i), outputList.get(i));		
		}
		return mapAfterCrossCombination;		
	}
	
	// 把map中的jtf 加入面板中
	public static void addJtf2panel(JPanel jp, Map<JTextField, JTextField> jtf_map)
	{
		for(Entry<JTextField, JTextField> entry : jtf_map.entrySet())
		{
//			 System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			jp.add(entry.getKey());
			jp.add(entry.getValue());
		}
	}
	//获取outputJtf里的输入文字
	public static List<String> getTextFromJtf(final JTextField jtf)
	{
		final List<String> update_text = new ArrayList<String>();
		jtf.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
			}

			public void insertUpdate(DocumentEvent e) {
				update_text.add(jtf.getText());
//				System.out.println("update_text Inserted:" + jtf.getText());
			}

			public void removeUpdate(DocumentEvent e) {
			}
		});

		return update_text;
		
	}
	// 点击文本框，默认文字消失
	public static void jtfClick(final JTextField jtf){
		jtf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtf.setText("");
			}
		});
	}
	
	// 创建所有的 Jtf
	public static List<List<JTextField>> createAllJtf(String jtf_inputString)
	{
		List<List<JTextField>> result = new ArrayList<List<JTextField>>();
		
		List<String> jtf_inputString_List = Arrays.asList(jtf_inputString.split(","));
		List<JTextField> jtf_outputList = new ArrayList<JTextField>();
		List<JTextField> jtf_inputList = new ArrayList<JTextField>();
		
		//创建A框
		for(java.util.Iterator<String> it = jtf_inputString_List.iterator();it.hasNext();)
		{
			JTextField jtf = new JTextField(it.next(), 19);
			jtf.setEditable(false);
			jtf_inputList.add(jtf);
			
		}
		//创建B框
		for(int i = 0; i < jtf_inputString_List.size(); i++)
		{
			final JTextField jtf = new JTextField("", 10);
			jtf_outputList.add(jtf);
		}
				
		result.add(jtf_inputList);
		result.add(jtf_outputList);
		
		return result;
	}
	
	// 获取Jtf的输入map，以供Word_search_update.replaceAndGenerateWord调用
	// 变量的XX代表AA/BB/CC/DD/EE
	public static Map<String,List<String>> getAllTextofJtf(String jtfXX_string,Map<String,List<String>> XX_result,JPanel jp,String XX_str)
	{
		HashMap<JTextField, JTextField> mapXX = new HashMap<JTextField, JTextField>();
		List<List<JTextField>> jtfXX_List = UITools.createAllJtf(jtfXX_string);
		List<JTextField> jtfXX_inputList = jtfXX_List.get(0);

		List<JTextField> jtfXX_outputList = jtfXX_List.get(1);
		Map<JTextField, JTextField> jtfXX_map = UITools.crossCombination(jtfXX_inputList, jtfXX_outputList);
		UITools.addJtf2panel(jp, jtfXX_map);
		
		for(int i = 0; i < jtfXX_outputList.size(); i++)
		{
			int temp = i+1;
			String key = XX_str +temp;
			XX_result.put(key, UITools.getTextFromJtf(jtfXX_outputList.get(i)));
		}
		
		return XX_result;		
	}
}
