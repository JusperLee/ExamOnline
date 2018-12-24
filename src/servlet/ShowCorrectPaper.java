package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.StudentGrade;
import servlet.StudentGradeInterfaceBiz;
import servlet.StudentGradeInterfaceImplBiz;



public class ShowCorrectPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowCorrectPaper() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String papername = (String) request.getParameter("papername");
		String studentclass = (String) request.getParameter("studentclass");
		System.out.println(papername+" * "+studentclass);
		StudentGradeInterfaceBiz studentGradeInterfaceBiz= new StudentGradeInterfaceImplBiz();
		ArrayList<StudentGrade> list = (ArrayList<StudentGrade>) studentGradeInterfaceBiz.select(studentclass, papername);
		ArrayList<StudentGrade> listno = new ArrayList<StudentGrade>();
		ArrayList<StudentGrade> listyes = new ArrayList<StudentGrade>();
		for(int i = 0; i< list.size();i++){
			if(list.get(i).getBctscore() == -1 ){
				listno.add(list.get(i));
			}
			else{
				listyes.add(list.get(i));
			}
		}
		list.forEach(i->System.out.println(i.toString()+"aaa"));
		listno.forEach(i->System.out.println(i.toString()+"bbb"));
		listyes.forEach(i->System.out.println(i.toString()+"ccc"));
		request.getSession().setAttribute("listno", listno);
		request.getSession().setAttribute("listyes", listyes);
		//��list�Ƿ����Ĺ���ѧ���������Ծ������أ�
				//�ض���
				response.sendRedirect("teacher/checkPaper.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
