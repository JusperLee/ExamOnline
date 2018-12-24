package caozuo;

import java.util.List;

import bean.Pdt;



/**
 * 判断题数据库接口类
 *
 */
public interface PdtInterfaceCao {


	/**
	 * 增加一道判断题
	 * @param xzt
	 * @return
	 */
	public boolean insert(Pdt pdt);
	
	/**
	 * 删除一道判断题
	 * @param xzt
	 * @return
	 */
	public boolean delete(Pdt pdt);
	
	/**
	 * 更新修改一道判断题
	 * @param xzt
	 * @return
	 */
	public boolean update(Pdt pdt);
	
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
	/**
	 * 按id查询判断题
	 * @param id 编号
	 * @return 判断题集合
	 */
	public Pdt select(int id);
}