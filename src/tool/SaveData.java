/**
 * @author likai
 * @parma 将数据存到数据库
 */
package tool;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.Bct;
import bean.Tkt;
import bean.Xzt;
import caozuo.BacthExcel;

public class SaveData{
	public void savexcel(String path,int questiontype) throws IOException, SQLException {
		ReadExcel xlsMain = new ReadExcel();
		System.out.println(path);
		if(questiontype == 1) {
			Xzt xzt = null;
			List<Xzt> list = xlsMain.readExcelxzt(path);
	
			for (int i = 0; i < list.size(); i++) {
				xzt = list.get(i);
			
				BacthExcel.insert(xzt);			
			}
		}
		if(questiontype == 3) {
			Bct bct = null;
			List<Bct> list = xlsMain.readExcelbct(path);
	
			for (int i = 0; i < list.size(); i++) {
				bct = list.get(i);
			
				BacthExcel.insert(bct);			
			}
		}
		if(questiontype == 2) {
			Tkt tkt = null;
			List<Tkt> list = xlsMain.readExceltkt(path);
			System.out.println("222"+path);

			for (int i = 0; i < list.size(); i++) {
				tkt = list.get(i);
				System.out.println("333  "+i);
				BacthExcel.insert(tkt);			
			}
		}
	}
/**
	
	public void savejpg(String path) throws IOException, SQLException {
		ReadExcel xlsMain = new ReadExcel();
		Xzt xzt = null;
		List<Xzt> list = xlsMain.readExcel(path);

		for (int i = 0; i < list.size(); i++) {
			xzt = list.get(i);
		
			BacthExcel.insert(xzt);
			
		}
	} */
}
