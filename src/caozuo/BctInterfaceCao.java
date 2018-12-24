package caozuo;

import java.util.List;

import bean.Bct;

/**
 * 编程题数据库接口类
 *
 */
public interface BctInterfaceCao {

	/**
	 * 增加一道编程题
	 * @param bct
	 * @return
	 */
	public boolean insert(Bct bct);
	
	/**
	 * 删除一道编程题
	 * @param bct
	 * @return
	 */
	public boolean delete(Bct bct);
	
	/**
	 * 更新修改一道编程题
	 * @param bct
	 * @return
	 */
	public boolean update(Bct bct);
	
	/**
	 * 查询全部编程题
	 * @param 无
	 * @return 编程题集合
	 */
	public List<Bct> select();
	
	/**
	 * 按知识点查询编程题
	 * @param questionpoint 知识点
	 * @return 编程题集合
	 */
	public List<Bct> select(String questionpoint);
	/**
	 * 按id查询编程题
	 * @param id 序号
	 * @return 编程题集合
	 */
	public Bct select(int id);
}
