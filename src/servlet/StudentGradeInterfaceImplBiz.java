package servlet;

import java.util.List;

import bean.StudentGrade;
import caozuo.StudentGradeInterfaceCao;
import caozuo.StudentGradeInterfaceImplCao;
import servlet.StudentGradeInterfaceBiz;

public class StudentGradeInterfaceImplBiz implements StudentGradeInterfaceBiz {
StudentGradeInterfaceCao sgi=new StudentGradeInterfaceImplCao();
	@Override
	public boolean insert(StudentGrade studentGrade) {
		return sgi.insert(studentGrade);
	}

	@Override
	public boolean delete(StudentGrade studentGrade) {
		return sgi.delete(studentGrade);
	}

	@Override
	public boolean update(int bctscore,int jdtscore,int score,String username,String papername) {
		return sgi.update(bctscore,jdtscore,score,username,papername);
	}

	@Override
	public List<StudentGrade> select(String username) {
		return sgi.select(username);
	}

	@Override
	public List<StudentGrade> select(String studentclass, String papername) {
		return sgi.select(studentclass, papername);
	}

}
