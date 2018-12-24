package servlet;

import java.util.List;

import bean.Bct;
import bean.Jdt;
import bean.Mistakes;
import bean.Pdt;
import bean.Tkt;
import bean.Xzt;

public interface MistakesInterfaceBiz {
		/**
		 * 增加一道错题
		 */
		public boolean insert(Mistakes mistakes);		
		/**
		 * 删除一道错题
		 */
		public boolean delete(Mistakes mistakes);
		/**
		 * 查询某个学生的全部错题  
		 */
		public List<Mistakes> select(String username);		
		public List<Bct> selectbct(String username);	
		public List<Tkt> selecttkt(String username);	
		public List<Xzt> selectxzt(String username);
		public List<Pdt> selectpdt(String username);
		public List<Jdt> selectjdt(String username);
		/**
		 * 按知识点查询某个学生的全部错题
		 */
		public List<Mistakes> select(String username,String questionpoint);
		
}
