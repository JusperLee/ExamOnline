package caozuo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Paper;
import bean.Student;
import caozuo.PaperInterfaceCao;
import db.DBUtil;

public class PaperInterfaceImplCao implements PaperInterfaceCao{
	private static Connection con = DBUtil.getConnection();
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	boolean b=false;
	@Override
	public boolean insert(Paper paper) {
		System.out.println(paper.toString());
		 String sql="insert into paper values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	        try {
				pst=con.prepareStatement(sql);
				
				 java.sql.Timestamp starttime = new java.sql.Timestamp(paper.getStarttime().getTime());
				 java.sql.Timestamp endtime = new java.sql.Timestamp(paper.getEndtime().getTime());
				System.out.println(starttime);
	        	pst.setTimestamp(1, starttime);
				pst.setTimestamp(2, endtime);
				pst.setString(3, paper.getPapername());
				pst.setInt(4, paper.getXzt1());
				pst.setInt(5, paper.getXzt2());
				pst.setInt(6, paper.getXzt3());
				pst.setInt(7, paper.getXzt4());
				pst.setInt(8, paper.getXzt5());
				pst.setInt(9, paper.getXzt6());
				pst.setInt(10, paper.getXzt7());
				pst.setInt(11, paper.getXzt8());
				pst.setInt(12, paper.getXzt9());
				pst.setInt(13, paper.getXzt10());
					
				pst.setInt(14, paper.getTkt1());
				pst.setInt(15, paper.getTkt2());
				pst.setInt(16, paper.getTkt3());
				pst.setInt(17, paper.getTkt4());
				pst.setInt(18, paper.getTkt5());
				
				pst.setInt(19, paper.getPdt1());
				pst.setInt(20, paper.getPdt2());
				pst.setInt(21, paper.getPdt3());
				
				pst.setInt(22, paper.getJdt1());
				pst.setInt(23, paper.getJdt2());
				
				pst.setInt(24, paper.getBct1());
				pst.setInt(25, paper.getBct2());
				
				pst.setString(26, paper.getClass1());
				pst.setString(27, paper.getpaperPoint());
				pst.setTime(28, paper.getTime());
				int n=pst.executeUpdate();		
				if(n>0) {
					b=true;
				}
	        	} catch (SQLException e) {
					e.printStackTrace();
				}
	        finally {
				DBUtil.CloseConnection(rs, pst, con);
			}
	        System.out.println("插入試捲成功");
			return b;
	}

	@Override
	public boolean delete(Paper paper) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "delete from Paper  where id = ? ";
		System.out.println(paper.getId());
		try {
		pst=con.prepareStatement(sql);
		pst.setInt(1, paper.getId());
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pst, con);
		}
		return b;
	}

	//@Override
	//public boolean update(Paper paper) {
		
	//}

	@Override
	public List<Paper> select() {
		Paper pap=null;
		Connection con=DBUtil.getConnection();
		PreparedStatement pr =null;
		ResultSet rs =null;
		List<Paper> list  = new ArrayList<Paper>();	
		String sql = "select * from paper";
		System.out.println("selectall");
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				pap=new Paper();
				pap.setId(rs.getInt(1));
				pap.setStarttime(rs.getTimestamp(2));
				pap.setEndtime(rs.getTimestamp(3));
				pap.setPapername(rs.getString(4));
				pap.setXzt1(rs.getInt(5));
				pap.setXzt2(rs.getInt(6));
				pap.setXzt3(rs.getInt(7));
				pap.setXzt4(rs.getInt(8));
				pap.setXzt5(rs.getInt(9));
				pap.setXzt6(rs.getInt(10));
				pap.setXzt7(rs.getInt(11));
				pap.setXzt8(rs.getInt(12));
				pap.setXzt9(rs.getInt(13));
				pap.setXzt10(rs.getInt(14));
				
				
				pap.setTkt1(rs.getInt(15));
				pap.setTkt2(rs.getInt(16));
				pap.setTkt3(rs.getInt(17));
				pap.setTkt4(rs.getInt(18));
				pap.setTkt5(rs.getInt(19));
			    
				pap.setPdt1(rs.getInt(20));
				pap.setPdt2(rs.getInt(21));
				pap.setPdt3(rs.getInt(22));
				
				pap.setJdt1(rs.getInt(23));
				pap.setJdt2(rs.getInt(24));
				
				pap.setBct1(rs.getInt(25));
				pap.setBct2(rs.getInt(26));
				
				pap.setClass1(rs.getString(27));
				pap.setpaperPoint(rs.getString(28));
				pap.setTime(rs.getTime(29));
				list.add(pap);
		}} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pst, con);
		}
		return list;
	}

	public Paper select(int id) {
		Paper pap=null;
		Connection con=DBUtil.getConnection();
		PreparedStatement pr =null;
		ResultSet rs =null;
		String sql = "select * from paper where id=?";
		System.out.println("selectall");
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				pap=new Paper();
				pap.setId(rs.getInt(1));
				pap.setStarttime(rs.getTimestamp(2));
				pap.setEndtime(rs.getTimestamp(3));
				pap.setPapername(rs.getString(4));
				pap.setXzt1(rs.getInt(5));
				pap.setXzt2(rs.getInt(6));
				pap.setXzt3(rs.getInt(7));
				pap.setXzt4(rs.getInt(8));
				pap.setXzt5(rs.getInt(9));
				pap.setXzt6(rs.getInt(10));
				pap.setXzt7(rs.getInt(11));
				pap.setXzt8(rs.getInt(12));
				pap.setXzt9(rs.getInt(13));
				pap.setXzt10(rs.getInt(14));
				
				
				pap.setTkt1(rs.getInt(15));
				pap.setTkt2(rs.getInt(16));
				pap.setTkt3(rs.getInt(17));
				pap.setTkt4(rs.getInt(18));
				pap.setTkt5(rs.getInt(19));
			    
				pap.setPdt1(rs.getInt(20));
				pap.setPdt2(rs.getInt(21));
				pap.setPdt3(rs.getInt(22));
				
				pap.setJdt1(rs.getInt(23));
				pap.setJdt2(rs.getInt(24));
				
				pap.setBct1(rs.getInt(25));
				pap.setBct2(rs.getInt(26));
				
				pap.setClass1(rs.getString(27));
				pap.setpaperPoint(rs.getString(28));
				pap.setTime(rs.getTime(29));
		}} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pst, con);
		}
		return pap;
	}
	
	
	
	
	@Override
	public List<Paper> select(String questionpoint) {
		Paper pap=null;
		List<Paper> list  = new ArrayList<Paper>();
		Connection con=DBUtil.getConnection();
		PreparedStatement pr =null;
		ResultSet rs =null;
		String sql = "select * from paper where paperpoint=?";
		System.out.println("questionpoint");
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, questionpoint);
			rs = pst.executeQuery();
			while(rs.next()) {
				pap=new Paper();
				pap.setId(rs.getInt(1));
				
				System.out.println(rs.getString(4));
				
				pap.setStarttime(rs.getTimestamp(2));
				pap.setEndtime(rs.getTimestamp(3));
				pap.setPapername(rs.getString(4));
				pap.setXzt1(rs.getInt(5));
				pap.setXzt2(rs.getInt(6));
				pap.setXzt3(rs.getInt(7));
				pap.setXzt4(rs.getInt(8));
				pap.setXzt5(rs.getInt(9));
				pap.setXzt6(rs.getInt(10));
				pap.setXzt7(rs.getInt(11));
				pap.setXzt8(rs.getInt(12));
				pap.setXzt9(rs.getInt(13));
				pap.setXzt10(rs.getInt(14));
				
				
				pap.setTkt1(rs.getInt(15));
				pap.setTkt2(rs.getInt(16));
				pap.setTkt3(rs.getInt(17));
				pap.setTkt4(rs.getInt(18));
				pap.setTkt5(rs.getInt(19));
			    
				pap.setPdt1(rs.getInt(20));
				pap.setPdt2(rs.getInt(21));
				pap.setPdt3(rs.getInt(22));
				
				pap.setJdt1(rs.getInt(23));
				pap.setJdt2(rs.getInt(24));
				
				pap.setBct1(rs.getInt(25));
				pap.setBct2(rs.getInt(26));
				
				pap.setClass1(rs.getString(27));
				pap.setpaperPoint(rs.getString(28));
				pap.setTime(rs.getTime(29));
				list.add(pap);
		}} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pst, con);
		}
		return list;
	}

	@Override
	public List<Paper> showbeforePaper(String username) {
		//已经结束的考试
		Student s=null;
		StudentInterfaceCao stuc = new StudentInterfaceImplCao();
		try {
			s=stuc.showuserinfo(username);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Paper> before=new ArrayList<Paper>();
		//设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// new Date()为获取当前系统时间
		String d1=df.format(new Date());
		Timestamp d=Timestamp.valueOf(d1);
		System.out.println(d);
		String sql="select * from paper";
		Connection con=DBUtil.getConnection();
		PreparedStatement pr =null;
		ResultSet rs =null;
		Paper pap=null;
		try {
			 pr = con.prepareStatement(sql);
			 rs = pr.executeQuery();
			 while (rs.next()) {
				//对象赋值
				 //17个对象
				 pap=new Paper();
					pap.setId(rs.getInt(1));
					pap.setStarttime(rs.getTimestamp(2));
					pap.setEndtime(rs.getTimestamp(3));
					pap.setPapername(rs.getString(4));
					pap.setXzt1(rs.getInt(5));
					pap.setXzt2(rs.getInt(6));
					pap.setXzt3(rs.getInt(7));
					pap.setXzt4(rs.getInt(8));
					pap.setXzt5(rs.getInt(9));
					pap.setXzt6(rs.getInt(10));
					pap.setXzt7(rs.getInt(11));
					pap.setXzt8(rs.getInt(12));
					pap.setXzt9(rs.getInt(13));
					pap.setXzt10(rs.getInt(14));
					
					
					pap.setTkt1(rs.getInt(15));
					pap.setTkt2(rs.getInt(16));
					pap.setTkt3(rs.getInt(17));
					pap.setTkt4(rs.getInt(18));
					pap.setTkt5(rs.getInt(19));
				    
					pap.setPdt1(rs.getInt(20));
					pap.setPdt2(rs.getInt(21));
					pap.setPdt3(rs.getInt(22));
					
					pap.setJdt1(rs.getInt(23));
					pap.setJdt2(rs.getInt(24));
					
					pap.setBct1(rs.getInt(25));
					pap.setBct2(rs.getInt(26));
					
					pap.setClass1(rs.getString(27));
					pap.setpaperPoint(rs.getString(28));
					pap.setTime(rs.getTime(29));
				if (pap.getClass1().toString().equals(s.getStudentclass().toString()) && pap.getStarttime().before(d) && pap.getEndtime().before(d) || IsDone(username,pap.getId())) {
					before.add(pap);
				}
			 }		 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            DBUtil.CloseConnection(rs, pr, con);
		}
		return before;	
	}
	
	
	@Override
	public List<Paper> showafterPaper(String username) {
		//未来的考试
		Student s=null;
		StudentInterfaceCao stuc = new StudentInterfaceImplCao();
		try {
			s=stuc.showuserinfo(username);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Paper> after=new ArrayList<Paper>();
		//设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// new Date()为获取当前系统时间
		String d1=df.format(new Date());
		Timestamp d=Timestamp.valueOf(d1);
		String sql="select * from paper";
		Connection con=DBUtil.getConnection();
		PreparedStatement pr =null;
		ResultSet rs =null;
		Paper pap=null;
		try {
			 pr = con.prepareStatement(sql);
			 rs = pr.executeQuery();
			 while (rs.next()) {
				//对象赋值
				 //17个对象
				pap= new Paper();
				pap=new Paper();
				pap.setId(rs.getInt(1));
				pap.setStarttime(rs.getTimestamp(2));
				pap.setEndtime(rs.getTimestamp(3));
				pap.setPapername(rs.getString(4));
				pap.setXzt1(rs.getInt(5));
				pap.setXzt2(rs.getInt(6));
				pap.setXzt3(rs.getInt(7));
				pap.setXzt4(rs.getInt(8));
				pap.setXzt5(rs.getInt(9));
				pap.setXzt6(rs.getInt(10));
				pap.setXzt7(rs.getInt(11));
				pap.setXzt8(rs.getInt(12));
				pap.setXzt9(rs.getInt(13));
				pap.setXzt10(rs.getInt(14));
				
				
				pap.setTkt1(rs.getInt(15));
				pap.setTkt2(rs.getInt(16));
				pap.setTkt3(rs.getInt(17));
				pap.setTkt4(rs.getInt(18));
				pap.setTkt5(rs.getInt(19));
			    
				pap.setPdt1(rs.getInt(20));
				pap.setPdt2(rs.getInt(21));
				pap.setPdt3(rs.getInt(22));
				
				pap.setJdt1(rs.getInt(23));
				pap.setJdt2(rs.getInt(24));
				
				pap.setBct1(rs.getInt(25));
				pap.setBct2(rs.getInt(26));
				
				pap.setClass1(rs.getString(27));
				pap.setpaperPoint(rs.getString(28));
				pap.setTime(rs.getTime(29));
				 if (pap.getStarttime().after(d) && pap.getEndtime().after(d) && pap.getClass1().toString().equals(s.getStudentclass().toString())) {
					after.add(pap);
					boolean b = pap.getStarttime().after(d);
					System.out.println(b);
				}}}	 
		 catch (SQLException e) {
			e.printStackTrace();
		} finally {
            DBUtil.CloseConnection(rs, pr, con);
		}
		return after;	
	}
	
	@Override
	public List<Paper> shownowPaper(String username) {
		//当前可以进行的考试
		Student s=null;
		StudentInterfaceCao stuc = new StudentInterfaceImplCao();
		try {
			s=stuc.showuserinfo(username);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Paper> now=new ArrayList<Paper>();
		//设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// new Date()为获取当前系统时间
		String d1=df.format(new Date());
		Timestamp d=Timestamp.valueOf(d1);
		String sql="select * from paper";
		Connection con=DBUtil.getConnection();
		PreparedStatement pr =null;
		ResultSet rs =null;
		Paper pap=null;
		try {
			 pr = con.prepareStatement(sql);
			 rs = pr.executeQuery();
			 while (rs.next()) {
				//对象赋值
				 //17个对象
				 pap=new Paper();
					pap.setId(rs.getInt(1));
					pap.setStarttime(rs.getTimestamp(2));		
					pap.setEndtime(rs.getTimestamp(3));
					pap.setPapername(rs.getString(4));
					pap.setXzt1(rs.getInt(5));
					pap.setXzt2(rs.getInt(6));
					pap.setXzt3(rs.getInt(7));
					pap.setXzt4(rs.getInt(8));
					pap.setXzt5(rs.getInt(9));
					pap.setXzt6(rs.getInt(10));
					pap.setXzt7(rs.getInt(11));
					pap.setXzt8(rs.getInt(12));
					pap.setXzt9(rs.getInt(13));
					pap.setXzt10(rs.getInt(14));
					
					
					pap.setTkt1(rs.getInt(15));
					pap.setTkt2(rs.getInt(16));
					pap.setTkt3(rs.getInt(17));
					pap.setTkt4(rs.getInt(18));
					pap.setTkt5(rs.getInt(19));
				    
					pap.setPdt1(rs.getInt(20));
					pap.setPdt2(rs.getInt(21));
					pap.setPdt3(rs.getInt(22));
					
					pap.setJdt1(rs.getInt(23));
					pap.setJdt2(rs.getInt(24));
					
					pap.setBct1(rs.getInt(25));
					pap.setBct2(rs.getInt(26));
					
					pap.setClass1(rs.getString(27));
					pap.setpaperPoint(rs.getString(28));
					pap.setTime(rs.getTime("time"));
				if(pap.getStarttime().before(d) && pap.getEndtime().after(d) && pap.getClass1().toString().equals(s.getStudentclass().toString())&& !IsDone(username,pap.getId())) {
					now.add(pap);		
					System.out.println(rs.getTime(29));
		} }}catch (SQLException e) {
			e.printStackTrace();
		} finally {
            DBUtil.CloseConnection(rs, pr, con);
		}
		return now;	
	}

	public List<Paper> select_class_Paper(String class1){
		//选择班级试卷
				List<Paper> now=new ArrayList<Paper>();
				String sql="select * from paper";
				Connection con=DBUtil.getConnection();
				PreparedStatement pr =null;
				ResultSet rs =null;
				Paper pap=null;
				try {
					 pr = con.prepareStatement(sql);
					 rs = pr.executeQuery();
					 while (rs.next()) {
						//对象赋值
						 //17个对象
						 pap=new Paper();
							pap.setId(rs.getInt(1));
							pap.setStarttime(rs.getTimestamp(2));
							pap.setEndtime(rs.getTimestamp(3));
							pap.setPapername(rs.getString(4));
							pap.setXzt1(rs.getInt(5));
							pap.setXzt2(rs.getInt(6));
							pap.setXzt3(rs.getInt(7));
							pap.setXzt4(rs.getInt(8));
							pap.setXzt5(rs.getInt(9));
							pap.setXzt6(rs.getInt(10));
							pap.setXzt7(rs.getInt(11));
							pap.setXzt8(rs.getInt(12));
							pap.setXzt9(rs.getInt(13));
							pap.setXzt10(rs.getInt(14));
							
							
							pap.setTkt1(rs.getInt(15));
							pap.setTkt2(rs.getInt(16));
							pap.setTkt3(rs.getInt(17));
							pap.setTkt4(rs.getInt(18));
							pap.setTkt5(rs.getInt(19));
						    
							pap.setPdt1(rs.getInt(20));
							pap.setPdt2(rs.getInt(21));
							pap.setPdt3(rs.getInt(22));
							
							pap.setJdt1(rs.getInt(23));
							pap.setJdt2(rs.getInt(24));
							
							pap.setBct1(rs.getInt(25));
							pap.setBct2(rs.getInt(26));
							
							pap.setClass1(rs.getString(27));
							pap.setpaperPoint(rs.getString(28));
							pap.setTime(rs.getTime(29));
						if(pap.getClass1()==class1) {
							now.add(pap);						 		 
				} }}catch (SQLException e) {
					e.printStackTrace();
				} finally {
		            DBUtil.CloseConnection(rs, pr, con);
				}
				return now;	
	}
	@Override
	public Paper selectInstance(String papername) {
		Paper pap=new Paper();
		String sql = "select * from Paper where papername=?";
		Connection con=null;
		try {
			con=DBUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, papername);
			rs = pst.executeQuery();
			while(rs.next()) {
				pap=new Paper();
				pap.setId(rs.getInt(1));
				pap.setStarttime(rs.getTimestamp(2));
				pap.setEndtime(rs.getTimestamp(3));
				pap.setPapername(rs.getString(4));
				pap.setXzt1(rs.getInt(5));
				pap.setXzt2(rs.getInt(6));
				pap.setXzt3(rs.getInt(7));
				pap.setXzt4(rs.getInt(8));
				pap.setXzt5(rs.getInt(9));
				pap.setXzt6(rs.getInt(10));
				pap.setXzt7(rs.getInt(11));
				pap.setXzt8(rs.getInt(12));
				pap.setXzt9(rs.getInt(13));
				pap.setXzt10(rs.getInt(14));
				
				
				pap.setTkt1(rs.getInt(15));
				pap.setTkt2(rs.getInt(16));
				pap.setTkt3(rs.getInt(17));
				pap.setTkt4(rs.getInt(18));
				pap.setTkt5(rs.getInt(19));
			    
				pap.setPdt1(rs.getInt(20));
				pap.setPdt2(rs.getInt(21));
				pap.setPdt3(rs.getInt(22));
				
				pap.setJdt1(rs.getInt(23));
				pap.setJdt2(rs.getInt(24));
				
				pap.setBct1(rs.getInt(25));
				pap.setBct2(rs.getInt(26));
				
				pap.setClass1(rs.getString(27));
				pap.setpaperPoint(rs.getString(28));
				pap.setTime(rs.getTime(29));
		}} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pst, con);
		}
		return pap;
	}

	@Override
	public boolean IsDone(String username, int paperid) {
	
		String sql="select * from studentgrade where stu_number=? and paperid=?";
		  con=DBUtil.getConnection();
		  int flag=0;
		  try {
			pst=con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setInt(2, paperid);
			rs=pst.executeQuery();
			if (rs.next()==true) {
			     flag=1;
			     System.out.println("flag="+String.valueOf(flag));
			     return true;
			}
			if(rs.next()==false) {
				System.out.println("flag="+String.valueOf(flag));
				flag=0;
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.CloseConnection(rs, pst, con);
		}	
		return false;
	}

}
