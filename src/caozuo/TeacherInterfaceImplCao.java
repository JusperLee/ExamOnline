/*
 * @author likai
 * @parma 老师功能实现
 * @parma 教师查询个人信息
 * @parma 增加学生
 * @parma 修改教师个人信息仅密码
 * @parma 删除学生
 * @parma 教师查询学生列表
 * @parma 实现学生成绩查询
 * @parma 查看教师个人信息
 */

package caozuo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Bct;
import bean.Paper;
import bean.PaperString;
import bean.Pdt;
import bean.Student;
import bean.StudentGrade;
import bean.Teacher;
import bean.Tkt;
import bean.Xzt;
import caozuo.TeacherInterfaceCao;
import db.DBUtil;
import tool.QuestionInstance;
import tool.SaveData;

public class TeacherInterfaceImplCao implements TeacherInterfaceCao{
	private static Connection con = DBUtil.getConnection();
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	boolean b=false;
	@Override
	/**
	 * 教师查询个人信息
	 */
	public Teacher select(Teacher t, Connection con) throws SQLException {
		Teacher info=null;
		String sql = "select tea_name,tea_pre,AES_DECRYPT(tea_auth,'dimtim')," + 
				"AES_DECRYPT(tea_tel,'dimtim'),AES_DECRYPT(tea_password,'dimtim'),AES_DECRYPT(tea_num,'dimtim') from teacher_info where tea_num = AES_ENCRYPT(?,'dimtim')";
		pst = con.prepareStatement(sql);
		pst.setString(1, t.getId());
		rs = pst.executeQuery();
        if(!rs.next()) {
        	info=new Teacher();
        	info.setId("1");
        	rs.previous();
        }
		if(rs.next())
		{
			rs.previous();
			while(rs.next()) {
				info=new Teacher();
				info.setId(rs.getString(6));
				info.setName(rs.getString(1));
				info.setTelephone(rs.getString(4));
			}
		}
		
		DBUtil.CloseConnection(rs, pst, con);
		return info;
	}

	@Override
	/**
	 * 增加学生
	 */
	public boolean insert(Student s, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		boolean b = false;
		String sql = "insert into student_info values (?,AES_ENCRYPT(?,'dimtim'),AES_ENCRYPT(?,'dimtim'),1,AES_ENCRYPT(?,'dimtim'),AES_ENCRYPT(?,'dimtim'))";
		pst = con.prepareStatement(sql);
		pst.setString(1, s.getName());
		pst.setString(2, s.getStudentclass());
		pst.setString(3, s.getId());
		pst.setString(5, s.getTelephone());
		pst.setString(6, s.getPwd());
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return b;
	}

	@Override
	/**
	 * 修改教师个人信息仅密码
	 */
	public boolean updata(Teacher t, Connection con) throws SQLException {
		PreparedStatement pst=null;
		boolean b = false;
		String sql = "updata teacher_info set tea_password = AES_ENCRYPT(?,'dimtim') where tea_num = AES_ENCRYPT(?,'dimtim') and tea_tel = AES_ENCRYPT(?,'dimtim')";
		pst = con.prepareStatement(sql);
		pst.setString(1, t.getPwd());
		pst.setString(2, t.getId());
		pst.setString(3, t.getTelephone());
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return b;
	}
	/**
	 * find
	 */
	public boolean find(Teacher t, Connection con) throws SQLException {
		PreparedStatement pst=null;
		boolean b = false;
		String sql = "updata teacher_info set tea_password = AES_ENCRYPT(?,'dimtim') where tea_num = AES_ENCRYPT(?,'dimtim') and tea_tel=AES_ENCRYPT(?,'dimtim')";
		pst = con.prepareStatement(sql);
		pst.setString(1, t.getPwd());
		pst.setString(2, t.getId());
		pst.setString(3, t.getTelephone());
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return b;
	}
	@Override
	/**
	 * 删除学生
	 */
	public boolean delete(String Userid,String studentclass, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		boolean b = false;
		String sql = "delete from student_info  where stu_num = AES_ENCRYPT(?,'dimtim') and stu_class = AES_ENCRYPT(?,'dimtim')";
		pst = con.prepareStatement(sql);
		pst.setString(1, Userid);
		pst.setString(2, studentclass);
		int n = pst.executeUpdate();
		if(n>0) {
			b = true;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return b;
	}

	@Override
	/**
	 * 教师查询学生列表
	 */
	public List<Student> select(String sc, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		Student info =null;
		PreparedStatement pst=null;
		List<Student> list  = new ArrayList<Student>();	
		ResultSet rs = null;
		String sql = "select stu_name,AES_DECRYPT(stu_class,'dimtim'),AES_DECRYPT(stu_number,'dimtim')" + 
				",AES_DECRYPT(stu_tel,'dimtim'),AES_DECRYPT(stu_password,'dimtim') from student_info where stu_class= AES_ENCRYPT(?,'dimtim') ";
		pst = con.prepareStatement(sql);
		pst.setString(1, sc);
		rs = pst.executeQuery();
		while(rs.next()) {
			info = new Student();
			info.setName(rs.getString(1));
			info.setStudentclass(rs.getString(2));
			info.setId(rs.getString(3));
			info.setRu(1);
			info.setTelephone(rs.getString(4));
			list.add(info);
		}
		DBUtil.CloseConnection(rs, pst, con);
		return list;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see caozuo.TeacherInterfaceCao#studentgrade(java.lang.String, java.lang.String)
	 * @parma 实现学生成绩查询
	 */
	public List<StudentGrade> studentgrade(String studentclass,String Papername) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		ArrayList<StudentGrade> list = new ArrayList<StudentGrade>();
		try {
			String sql="select * from studentgrade  where papername=? and stu_number = ("
					+ "select AES_DECRYPT(stu_number,'dimtim') from student_info where stu_class = AES_ENCRYPT(?,'dimtim')) ";
			pst = con.prepareStatement(sql);
			pst.setString(1, Papername);
			pst.setString(2, studentclass);
			rs = pst.executeQuery();
			while (rs.next()) {
				StudentGrade sg=new StudentGrade();
				sg.setUserId(rs.getString(1));
				sg.setXztscore(rs.getInt(2));
				sg.setTktscore(rs.getInt(3));
				sg.setBctscore(rs.getInt(4));
				sg.setPapername(rs.getString(5));
				list.add(sg);
	}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return list;


}
/**
 * 查看教师个人信息
 */
	@Override
	public Teacher showTeacherInfo(String Userid) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		
		Teacher u=null;
		String sql="select tea_name,tea_pre,AES_DECRYPT(tea_auth,'dimtim')," + 
				"AES_DECRYPT(tea_tel,'dimtim'),AES_DECRYPT(tea_password,'dimtim'),AES_DECRYPT(tea_num,'dimtim') from teacher_info where tea_num = AES_ENCRYPT(?,'dimtim')";
		pst = con.prepareStatement(sql);
		pst.setString(1, Userid);
		rs = pst.executeQuery();
		while (rs.next()) {
		 u=new Teacher();
		u.setId(rs.getString(6));
		u.setName(rs.getString(1));
        u.setTelephone(rs.getString(4));
        u.setauth(rs.getString(3));
        u.setPwd(rs.getString(5));
		System.out.println(u.toString());
		}
		return u;
	}


/*
 * (non-Javadoc)
 * @see caozuo.TeacherInterfaceCao#batchquestion(int, java.lang.String, java.lang.String)
 * 上传题目
 */
@Override
public boolean batchquestion(int questiontype,String filename,String path) {
	SaveData sd=new SaveData();
	boolean b = false;
	if(questiontype == 1) {
		try {
			try {
				sd.savexcel(path+"\\upload\\"+filename, 1);
				b = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	if(questiontype == 2) {
		try {
			try {
				sd.savexcel(path+"\\upload\\"+filename, 2);
				b = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		}
	if(questiontype == 3) {
		try {
			try {
				sd.savexcel(path+"\\upload\\"+filename, 3);
				b = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	return b;
}

@Override
/*
 * 制作试卷
 */
public boolean  setPaper(int[] questionxztid,int[] questiontktid, int[] questionbctid ) throws SQLException {
	boolean  b = false;
	List<Xzt> xzts=new ArrayList<Xzt>();
	List<Tkt> tkts=new ArrayList<Tkt>();
	List<Bct> bcts=new ArrayList<Bct>();
	for(int i  = 0; i<questionxztid.length;i++){
		xzts.add(QuestionInstance.getXzt(questionxztid[i]));
	}
	for(int j  = 0; j<questionxztid.length;j++){
		tkts.add(QuestionInstance.getTkt(questiontktid[j]));	
	}
	for(int k  = 0; k<questionxztid.length;k++){
		bcts.add(QuestionInstance.getBct(questionbctid[k]));	
	}
	if(xzts != null && tkts != null && bcts != null) {
		b = true;
	}
	return b;
}	


@Override
/*
 * 批改试卷
 */
public boolean correctPaper(int score) throws SQLException {
	// TODO Auto-generated method stub
	return false;
}

@Override
/*
 *显示试题题目
 */
public PaperString showPaper(String papername) throws SQLException {
	String sql = " select * from paper where papername = ?";
	pst=con.prepareStatement(sql);
	pst.setString(1, papername);
	rs = pst.executeQuery();
	Paper paper  = null;
	while(rs.next()) {
	    paper  = new Paper();
		pst.setTimestamp(1, paper.getStarttime());
		pst.setTimestamp(2, paper.getEndtime());
		pst.setString(3, paper.getPapername());
		pst.setInt(4, paper.getXzt1());
		pst.setInt(5, paper.getXzt2());
		pst.setInt(6, paper.getXzt3());
		pst.setInt(7, paper.getXzt3());
		pst.setInt(8, paper.getXzt4());
		pst.setInt(9, paper.getXzt5());
		pst.setInt(10, paper.getXzt6());
		pst.setInt(11, paper.getXzt7());
		pst.setInt(12, paper.getXzt8());
		pst.setInt(13, paper.getXzt9());
		pst.setInt(14, paper.getXzt10());
		
		
		pst.setInt(15, paper.getTkt1());
		pst.setInt(16, paper.getTkt2());
		pst.setInt(17, paper.getTkt3());
		pst.setInt(18, paper.getTkt4());
		pst.setInt(19, paper.getTkt5());
		
		pst.setInt(20, paper.getBct1());
		pst.setInt(21, paper.getBct2());	
	}
	PaperString ps=QuestionInstance.changeToPaperString(paper);
	return ps;
	
}

@Override
/*
 * 选择题批分数
 */
public Xzt showPaperbankxzt(int id) throws SQLException {
	Xzt xzt=new Xzt();
	String sql = " select * from xzt where id=?";
	pst=con.prepareStatement(sql);
	pst.setInt(1, id);
	rs = pst.executeQuery();
	while(rs.next()) {
		xzt= new Xzt();
		xzt.setId(rs.getInt(1));
		xzt.setQuestion(rs.getString(2));
		xzt.setAnswer(rs.getString(3));
		xzt.setOptionA(rs.getString(4));
		xzt.setOptionB(rs.getString(5));
		xzt.setOptionC(rs.getString(6));
		xzt.setOptionD(rs.getString(7));
		xzt.setQuestiontype(rs.getInt(8));
		xzt.setQuestionpoint(rs.getString(9));
	}
	return xzt;
}

@Override
/*
 * 填空题改题
 */
public Tkt showPaperbanktkt(int id) throws SQLException {
	Tkt tkt= null;
	String sql = " select * from tkt where id=?";
	pst=con.prepareStatement(sql);
	pst.setInt(1, id);
	rs = pst.executeQuery();
	while(rs.next()) {
		 tkt= new Tkt();
		tkt.setId(rs.getInt(1));
		tkt.setQuestion(rs.getString(2));
		tkt.setAnswer(rs.getString(3));
		tkt.setQuestiontype(rs.getInt(4));
		tkt.setQuestionpoint(rs.getString(5));
	}
	return tkt;
}

@Override
/*
 * 判断题批改
 */
public Pdt showPaperbankpdt(int id) throws SQLException {
	Pdt pdt= new Pdt();
	String sql = " select * from pdt where id=?";
	pst=con.prepareStatement(sql);
	pst.setInt(1, id);
	rs = pst.executeQuery();
	while(rs.next()) {
		pdt.setId(rs.getInt(1));
		pdt.setQuestion(rs.getString(2));
		pdt.setAnswer(rs.getString(3));
		pdt.setQuestiontype(rs.getInt(4));
		pdt.setQuestionpoint(rs.getString(5));
	}
	return pdt;
}

@Override
public Teacher login(String Userid, String pwd,String tel) throws SQLException {
	Connection con = DBUtil.getConnection();
	Teacher info=null;
	String sql = "select tea_name,tea_pre,AES_DECRYPT(tea_auth,'dimtim'),AES_DECRYPT(tea_tel,'dimtim'),AES_DECRYPT(tea_password,'dimtim'),AES_DECRYPT(tea_num,'dimtim') "
			+ " from teacher_info where tea_num = AES_ENCRYPT(?,'dimtim') and tea_password=AES_ENCRYPT(?,'dimtim') and tea_tel=AES_ENCRYPT(?,'dimtim')";
	pst = con.prepareStatement(sql);
	pst.setString(1, Userid);
	pst.setString(2,pwd);
	pst.setString(3, tel);
	rs = pst.executeQuery();
	if(rs.next()) {
		info=new Teacher();
		info.setName(rs.getString(1));
		info.setRu(2);
		info.setauth(rs.getString(3));
		info.setTelephone(rs.getString(4));
		info.setPwd(rs.getString(5));
		info.setId(rs.getString(6));
	}
	DBUtil.CloseConnection(rs, pst, con);
	return info;
}

@Override
public String[] selectclass() throws SQLException {
	Connection con = DBUtil.getConnection();
	PreparedStatement pst = null;
	ResultSet rs = null;
	String sql = "select AES_DECRYPT(stu_class,'dimtim') from student_info";
	String[] studentclass = null;
	int i =0;
	pst = con.prepareStatement(sql);
	rs = pst.executeQuery();
	rs.last(); 
	int length=rs.getRow();
	rs.beforeFirst();
	System.out.println(length);
	studentclass=new String[length];
while(rs.next()){
	
		studentclass[i]= rs.getString(1);
		System.out.println(studentclass[i]);
		i++;
}
	DBUtil.CloseConnection(rs, pst, con);
	return studentclass;
}

public static void main(String[] args) {
	TeacherInterfaceCao a=new TeacherInterfaceImplCao();
	try {
		a.selectclass();
		a.selectpaper();
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
}
@Override
public String[] selectpaper() throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select  papername from paper";
		String[] papername=null;
		int i =0;
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		rs.last();
		int length=rs.getRow();
		rs.beforeFirst();
		papername = new String[length];
		while(rs.next()) {	
			papername[i]= rs.getString(1);
		
			System.out.println(papername[i]);
			i++;
		}
		DBUtil.CloseConnection(rs, pst, con);
		return papername;
}

	
}




