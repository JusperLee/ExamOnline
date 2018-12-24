package tool;

import java.io.IOException;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import bean.StudentGrade;

public class WriteExcel {
       public HSSFWorkbook writeExcel(List<StudentGrade> list) throws IOException {
    	   
    	   // 1.����һ��workbook����Ӧһ��Excel�ļ�
    	   HSSFWorkbook wb = new HSSFWorkbook();     
    	   // 2.��workbook�����һ��sheet����ӦExcel�е�һ��sheet   
    	   HSSFSheet sheet = wb.createSheet("ѧ���ɼ���");   
    	   // 3.��sheet����ӱ�ͷ��0�У��ϰ汾poi��excel��������������short     
    	   HSSFRow row = sheet.createRow((int) 0);     
    	   // 4.������Ԫ������ֵ��ͷ�����ñ�ͷ����
    	   HSSFCellStyle style = wb.createCellStyle();  
    	   // ���и�ʽ   
    	   style.setAlignment(HSSFCellStyle.ALIGN_CENTER);     
    	   // ���ñ�ͷ     
    	   HSSFCell cell = row.createCell(0);  
    	   cell.setCellValue("ѧ��");     
    	   cell.setCellStyle(style);     
    	   cell = row.createCell(1);   
    	   cell.setCellValue("ѡ����÷�");   
    	   cell.setCellStyle(style);     
    	   cell = row.createCell(2);     
    	   cell.setCellValue("�����÷�");   
    	   cell.setCellStyle(style);      
    	   cell = row.createCell(3);    
    	   cell.setCellValue("�����÷�");   
    	   cell.setCellStyle(style);    
    	   cell = row.createCell(4);      
    	   cell.setCellValue("�ܷ�");    
    	   cell.setCellStyle(style); 
    	   cell = row.createCell(5);      
    	   cell.setCellValue("�Ծ�����");    
    	   cell.setCellStyle(style); 
    	   
    	// ѭ��������д��Excel   
    	   for (int i = 0; i < list.size(); i++) {    
    		   row = sheet.createRow((int) i + 1);  
    		   StudentGrade sg= list.get(i);  
    		   // ������Ԫ������ֵ         
    		   row.createCell(0).setCellValue(sg.getUserId());   
    		   row.createCell(1).setCellValue(sg.getXztscore()); 
    		   row.createCell(2).setCellValue(sg.getTktscore());   
    		   row.createCell(3).setCellValue(sg.getBctscore()); 
    		   row.createCell(4).setCellValue(sg.getXztscore()+sg.getTktscore()+sg.getBctscore());  
    		   row.createCell(5).setCellValue(sg.getPapername());
    		   } 
    	   
    	     	  
		return wb; 
	
}
}
