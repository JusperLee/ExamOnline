package servlet;

import java.util.List;

import bean.Pdt;

public interface PdtInterfaceBiz {

		public boolean insert(Pdt xzt);
		
		/**
		 * 删除一道判断题
		 * @param xzt
		 * @return
		 */
		public boolean delete(Pdt xzt);
		
		/**
		 * 更新修改一道判断题
		 * @param xzt
		 * @return
		 */
		public boolean update(Pdt xzt);
		
		/**
		 * 查询全部判断题
		 * @param 无
		 * @return 判断题集合
		 */
		public List<Pdt> select();
		
		/**
		 * 按知识点查询判断题
		 * @param questionpoint 知识点
		 * @return 判断题集合
		 */
		public List<Pdt> select(String questionpoint);
}
