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
		 * ����һ������
		 */
		public boolean insert(Mistakes mistakes);		
		/**
		 * ɾ��һ������
		 */
		public boolean delete(Mistakes mistakes);
		/**
		 * ��ѯĳ��ѧ����ȫ������  
		 */
		public List<Mistakes> select(String username);		
		public List<Bct> selectbct(String username);	
		public List<Tkt> selecttkt(String username);	
		public List<Xzt> selectxzt(String username);
		public List<Pdt> selectpdt(String username);
		public List<Jdt> selectjdt(String username);
		/**
		 * ��֪ʶ���ѯĳ��ѧ����ȫ������
		 */
		public List<Mistakes> select(String username,String questionpoint);
		
}
