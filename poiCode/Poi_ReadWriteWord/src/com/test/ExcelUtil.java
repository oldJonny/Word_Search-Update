package com.test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * ������Excelд����������
 * 
 * 
 * */
public class ExcelUtil {

	/**
	 * ���ܣ����ж��е��뵽Excel�������ñ�������ʽ
	 */
	public static void writeArrayToExcel(HSSFWorkbook wb, HSSFSheet sheet,
			String title, int rows, int cells, Object[][] value) {

		Row row[] = new HSSFRow[rows];
		Cell cell[] = new HSSFCell[cells];

		// ���ɱ�������ʽ
		HSSFCellStyle styleTitle = wb.createCellStyle();
		// ������Щ��ʽ
		styleTitle.setFillForegroundColor(HSSFColor.WHITE.index);
		styleTitle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styleTitle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		styleTitle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		styleTitle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		styleTitle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		styleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// ����һ������
		HSSFFont fontTitle = wb.createFont();
		fontTitle.setColor(HSSFColor.BLACK.index);
		fontTitle.setFontHeightInPoints((short) 14);
		fontTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// ������Ӧ�õ���ǰ����ʽ
		styleTitle.setFont(fontTitle);

		HSSFRow row0 = sheet.createRow(0);
		// ���ñ���
		HSSFCell cell0 = row0.createCell(0, HSSFCell.CELL_TYPE_STRING);
		HSSFRichTextString textTitle = new HSSFRichTextString(title);
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, value[0].length - 1));
		cell0.setCellValue(textTitle);
		cell0.setCellStyle(styleTitle);

		// ������������ʽ
		HSSFCellStyle styleData = wb.createCellStyle();
		styleData.setFillForegroundColor(HSSFColor.WHITE.index);
		styleData.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styleData.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		styleData.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		styleData.setBorderRight(HSSFCellStyle.BORDER_THIN);
		styleData.setBorderTop(HSSFCellStyle.BORDER_THIN);
		styleData.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		styleData.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// ������һ������
		HSSFFont fontData = wb.createFont();
		fontData.setColor(HSSFColor.BLACK.index);
		fontData.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// ������Ӧ�õ���ǰ����ʽ
		styleData.setFont(fontData);
		for (int i = 0; i < row.length; i++) {
			row[i] = sheet.createRow(i + 2);
			for (int j = 0; j < cell.length; j++) {
				sheet.setColumnWidth(j, 7000);
				cell[j] = row[i].createCell(j);
				cell[j].setCellValue(convertString(value[i][j]));
				if (i == 0) {
					cell[j].setCellStyle(styleTitle);
				}
				else {
					cell[j].setCellStyle(styleData);
				}
			}
		}
	}

	/**
	 * ���ܣ���HSSFWorkbookд��Excel�ļ�
	 * 
	 * @param wb
	 *            HSSFWorkbook
	 * @param absPath
	 *            д���ļ������·��
	 * @param wbName
	 *            �ļ���
	 */
	public static void writeWorkbook(HSSFWorkbook wb, String fileName) {
		FileOutputStream fos = null;
		File f = new File(fileName);
		try {
			fos = new FileOutputStream(f);
			wb.write(fos);
			int dialog = JOptionPane.showConfirmDialog(null, f.getName()
					+ "�����ɹ����Ƿ�򿪣�", "��ܰ��ʾ", JOptionPane.YES_NO_OPTION);
			if (dialog == JOptionPane.YES_OPTION) {

				Runtime.getRuntime().exec(
						"cmd /c start \"\" \"" + fileName + "\"");
			}

		}
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "��������ǰ��رչ�����");

		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "û�н���ɸѡ");

		}
		finally {
			try {
				if (fos != null) {
					fos.close();
				}
			}
			catch (IOException e) {
			}
		}
	}

	public static String convertString(Object value) {
		if (value == null) {
			return "";
		}
		else {
			return value.toString();
		}
	}

}