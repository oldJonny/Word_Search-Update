package com.test;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CarMan extends JFrame implements ActionListener {

	// 保存按钮
	private JButton save, update, delete, export;

	private final JTable table = new JTable();

	private final DefaultTableModel model = new DefaultTableModel();

	// 工序名称 产品名称 产量 工序综合能耗 单位产品综合能耗 标准值 结论
	JTextField stepText, productText, engineText, totalText, unitText,
			standardText, resultText;

	// 企业综合能耗 工业总产值 万元产值综合能耗
	JTextField t1Text, t2Text, t3Text;

	// 工序名称 产品名称 产量 工序综合能耗 单位产品综合能耗 标准值 结论
	JLabel stepLab, productLab, engineLab, totalLab, unitLab, standardLab,
			resultLab;

	JLabel t1Lab, t2Lab, t3Lab;

	// 滚动条声明
	private JScrollPane panel;

	public CarMan() {
		super("能耗核查核算系统");
		initComponent();
	}

	// 数据显示界面
	public void FillTable() {
		model.setRowCount(0);
		Vector v = getCarData();
		for (int i = 0; i < v.size(); i++) {
			model.addRow((Vector) v.get(i));
		}

		table.setModel(model);
	}

	// 读取文件查询数据
	private Vector getCarData() {
		Vector v = new Vector();
		try {
			Connection conn = Conn.getConnection();
			Statement s = conn.createStatement();
			ResultSet r = s
					.executeQuery("select id, step, product, engine, total, unit, standard, result from carInfo");
			while (r.next()) {
				Vector vv = new Vector();
				vv.add(r.getInt(1));
				vv.add(r.getString(2));
				vv.add(r.getString(3));
				vv.add(r.getString(4));
				vv.add(r.getString(5));
				vv.add(r.getString(6));
				vv.add(r.getString(7));
				vv.add(r.getString(8));
				v.add(vv);
			}
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	// 初始化界面
	private void initComponent() {
		model.addColumn("ID");
		model.addColumn("工序名称");
		model.addColumn("产品名称");
		model.addColumn("产量");
		model.addColumn("工序综合能耗");
		model.addColumn("单位产品综合能耗");
		model.addColumn("标准值");
		model.addColumn("结论");
		this.setSize(1140, 760);
		Font font = new Font("宋体", Font.BOLD, 20);
		panel = new JScrollPane(table);
		panel.setBounds(10, 40, 1100, 400);
		save = new JButton("保存");
		save.setBounds(200, 630, 120, 35);
		save.setFont(font);
		save.addActionListener(this);
		update = new JButton("修改");
		update.setBounds(400, 630, 120, 35);
		update.setFont(font);
		update.addActionListener(this);
		delete = new JButton("删除");
		delete.setBounds(600, 630, 120, 35);
		delete.setFont(font);
		delete.addActionListener(this);
		export = new JButton("导出");
		export.setBounds(800, 630, 120, 35);
		export.setFont(font);
		export.addActionListener(this);
		table.setRowHeight(50);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		table.setFont(new Font(null, Font.PLAIN, 15));
		table.getTableHeader().setFont(new Font(null, Font.BOLD, 17));
		this.getContentPane().setLayout(null);
		this.getContentPane().add(panel);
		this.getContentPane().add(save);
		this.getContentPane().add(update);
		this.getContentPane().add(delete);
		this.getContentPane().add(export);
		stepLab = new JLabel("1:");
		productLab = new JLabel("2:");
		engineLab = new JLabel("3:");
		totalLab = new JLabel("4:");
		unitLab = new JLabel("5:");
		standardLab = new JLabel("6:");
		resultLab = new JLabel("7:");
		t1Lab = new JLabel("企业综合能耗:");
		t2Lab = new JLabel("工业总产值:");
		t3Lab = new JLabel("万元产值综合能耗:");

		stepLab.setBounds(30, 480, 60, 35);
		productLab.setBounds(190, 480, 60, 35);
		engineLab.setBounds(330, 480, 60, 35);
		totalLab.setBounds(480, 480, 60, 35);
		unitLab.setBounds(630, 480, 60, 35);
		standardLab.setBounds(780, 480, 60, 35);
		resultLab.setBounds(930, 480, 60, 35);
		t1Lab.setBounds(30, 560, 120, 35);
		t2Lab.setBounds(300, 560, 120, 35);
		t3Lab.setBounds(550, 560, 120, 35);

		stepText = new JTextField();
		productText = new JTextField();
		engineText = new JTextField();
		totalText = new JTextField();
		unitText = new JTextField();
		standardText = new JTextField();
		resultText = new JTextField();
		t1Text = new JTextField();
		t2Text = new JTextField();
		t3Text = new JTextField();

		stepText.setBounds(50, 480, 110, 35);
		productText.setBounds(210, 480, 110, 35);
		engineText.setBounds(360, 480, 110, 35);
		totalText.setBounds(510, 480, 110, 35);
		unitText.setBounds(660, 480, 110, 35);
		standardText.setBounds(810, 480, 110, 35);
		resultText.setBounds(960, 480, 110, 35);
		t1Text.setBounds(140, 560, 120, 35);
		t2Text.setBounds(390, 560, 120, 35);
		t3Text.setBounds(680, 560, 120, 35);
		this.getContentPane().add(stepText);
		this.getContentPane().add(productText);
		this.getContentPane().add(engineText);
		this.getContentPane().add(totalText);
		this.getContentPane().add(unitText);
		this.getContentPane().add(standardText);
		this.getContentPane().add(resultText);
		this.getContentPane().add(t1Text);
		this.getContentPane().add(t2Text);
		this.getContentPane().add(t3Text);

		this.getContentPane().add(stepLab);
		this.getContentPane().add(productLab);
		this.getContentPane().add(engineLab);
		this.getContentPane().add(totalLab);
		this.getContentPane().add(unitLab);
		this.getContentPane().add(standardLab);
		this.getContentPane().add(resultLab);
		this.getContentPane().add(t1Lab);
		this.getContentPane().add(t2Lab);
		this.getContentPane().add(t3Lab);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		FillTable();
	}

	/**
	 * 按钮事件
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.equals(save)) {
			String stepType = stepText.getText();
			String product = productText.getText();
			String engine = engineText.getText();
			String total = totalText.getText();
			String unit = unitText.getText();
			String standard = standardText.getText();
			String result = resultText.getText();
			if (stepType == null || "".equals(stepType)) {
				JOptionPane.showMessageDialog(null, "工序名称不能为空!!", "通知", 1);
				return;
			}
			try {
				Connection conn = Conn.getConnection();
				PreparedStatement s = conn
						.prepareStatement("insert into carInfo(step,product,engine,total,unit,standard,result) values(?,?,?,?,?,?,?)");
				s.setString(1, stepType);
				s.setString(2, product);
				s.setString(3, engine);
				s.setString(4, total);
				s.setString(5, unit);
				s.setString(6, standard);
				s.setString(7, result);
				s.execute();
				conn.close();
				JOptionPane.showMessageDialog(null, "已经新增成功", "通知", 1);
				Vector v = new Vector();
				v.add(getMaxReducer());
				v.add(stepType);
				v.add(product);
				v.add(engine);
				v.add(total);
				v.add(unit);
				v.add(standard);
				v.add(result);
				model.addRow(v);
				stepText.setText("");
				productText.setText("");
				engineText.setText("");
				totalText.setText("");
				unitText.setText("");
				standardText.setText("");
				resultText.setText("");
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (button.equals(update)) {
			String stepType = stepText.getText();
			String product = productText.getText();
			String engine = engineText.getText();
			String total = totalText.getText();
			String unit = unitText.getText();
			String standard = standardText.getText();
			String result = resultText.getText();
			if (stepType == null || "".equals(stepType)) {
				JOptionPane.showMessageDialog(null, "工序名称不能为空!!", "通知", 1);
				return;
			}
			int row = table.getSelectedRow();
			// 判断是否选中项
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "您未选择数据出库!!", "通知", 1);
				return;
			}
			Integer id = (Integer) table.getValueAt(row, 0);
			Connection conn = Conn.getConnection();
			PreparedStatement s;
			try {
				s = conn.prepareStatement("update carInfo set step=?,product=?,engine=?,total=?,unit=?,standard=?,result=? where id=?");
				s.setString(1, stepType);
				s.setString(2, product);
				s.setString(3, engine);
				s.setString(4, total);
				s.setString(5, unit);
				s.setString(6, standard);
				s.setString(7, result);
				s.setInt(8, id);
				s.execute();
				if (conn != null) {
					conn.close();
				}
				JOptionPane.showMessageDialog(null, "已经修改成功", "通知", 1);
				model.setValueAt(stepType, row, 1);
				model.setValueAt(product, row, 2);
				model.setValueAt(engine, row, 3);
				model.setValueAt(total, row, 4);
				model.setValueAt(unit, row, 5);
				model.setValueAt(standard, row, 6);
				model.setValueAt(result, row, 7);
			}
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if (button.equals(delete)) {
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "您未选择修改的核算信息!!", "通知", 1);
				return;
			}
			int a = JOptionPane.showConfirmDialog(null, "您确定要删除该核算信息吗!!", "通知",
					2);
			if (a == 1 || a == 2) {

				return;
			}
			Integer id = (Integer) table.getValueAt(row, 0);
			try {
				Connection conn = Conn.getConnection();
				PreparedStatement ps = null;
				String sql = "delete from carinfo where id=?";
				int x = 0;
				try {
					ps = conn.prepareStatement(sql);
					ps.setInt(1, id);
					x = ps.executeUpdate();
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
				finally {
					try {
						if (ps != null) {
							ps.close();
						}
						if (conn != null) {
							conn.close();
						}
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (x >= 1) {
					JOptionPane.showMessageDialog(null, "删除核算信息成功!!", "通知", 1);
					model.removeRow(row);
				}
				else {
					JOptionPane.showMessageDialog(null,
							"你选择的核算内容有误，删除未成功，请核实!!", "通知", 0);
				}
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (button.equals(export)) {
			Vector v = getCarData();
			if (v == null || v.isEmpty()) {
				JOptionPane.showMessageDialog(null, "没有数据导出!!", "通知", 1);
				return;
			}
			String t1 = t1Text.getText();
			String t2 = t2Text.getText();
			String t3 = t3Text.getText();
			Vector vv = new Vector();
			vv.add("企业综合能耗");
			vv.add(t1);
			vv.add("工业总产值");
			vv.add(t2);
			vv.add("万元产值综合能耗	");
			vv.add(t3);
			vv.add("");
			vv.add("");
			v.add(vv);
			File selectedFile = getSelectedFile(".xls");
			if (selectedFile != null) {
				String path = selectedFile.getPath();
				ToExcel(path, v);
			}
		}
	}

	private File getSelectedFile(final String type) {
		String name = getName();
		JFileChooser pathChooser = new JFileChooser();
		pathChooser.setFileFilter(new FileFilter() {

			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {

					return true;
				}
				else {
					if (f.getName().toLowerCase().endsWith(type)) {

						return true;
					}

					return false;
				}
			}

			@Override
			public String getDescription() {
				return "文件格式（" + type + "）";
			}
		});
		if (name == null) {
			name = "表_";
		}
		pathChooser.setSelectedFile(new File(name + type));
		int showSaveDialog = pathChooser.showSaveDialog(this);
		if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
			return pathChooser.getSelectedFile();
		}
		else {

			return null;
		}
	}

	// 选择最大的表ID 用来显示界面上
	public int getMaxReducer() {
		int max = 0;
		Connection conn;
		try {
			conn = Conn.getConnection();
			// max id
			PreparedStatement s = conn
					.prepareStatement("select max(id) from carInfo");
			ResultSet r = s.executeQuery();
			if (r.next()) {
				max = r.getInt(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return max;
	}

	public static void ToExcel(String path, Vector<Vector<Object>> v) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("XX企业能耗核查核算表");
		String[] n = { "工序名称", "产品名称", "产量", "工序综合能耗", "单位产品综合能耗", "标准值", "结论" };

		Object[][] value = new Object[v.size() + 1][7];
		for (int m = 0; m < n.length; m++) {
			value[0][m] = n[m];
		}
		Vector<Object> s;
		for (int i = 0; i < v.size(); i++) {
			s = v.get(i);
			value[i + 1][0] = s.get(0);
			value[i + 1][1] = s.get(1);
			value[i + 1][2] = s.get(2);
			value[i + 1][3] = s.get(3);
			value[i + 1][4] = s.get(4);
			value[i + 1][5] = s.get(5);
			value[i + 1][6] = s.get(6);
		}
		String title = "XX企业能耗核查核算表";
		ExcelUtil.writeArrayToExcel(wb, sheet, title, v.size() + 1, 7, value);
		ExcelUtil.writeWorkbook(wb, path);
	}

	
}
