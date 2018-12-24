package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Mistakes;
import bean.Pdt;
import bean.Student;
import bean.StudentGrade;
import bean.Tkt;
import bean.Xzt;
import caozuo.ManagerInterfaceImplCao;
import caozuo.MistakeInterfaceImplCao;
import caozuo.MistakesInterfaceCao;
import caozuo.StudentGradeInterfaceCao;
import caozuo.StudentGradeInterfaceImplCao;
import caozuo.StudentInterfaceCao;
import caozuo.StudentInterfaceImplCao;
import caozuo.TeacherInterfaceCao;
import caozuo.TeacherInterfaceImplCao;
import db.DBUtil;

/**
 * Servlet implementation class correct_paper
 */
@WebServlet("/correct_paper")
public class correct_paper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public correct_paper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stu_id=(String) request.getParameter("stu_id");
		String paper_id=(String)request.getParameter("paperid");
		System.out.println("stu_id="+stu_id);
		System.out.println(Integer.parseInt(paper_id));
		String papername="";
		TeacherInterfaceCao tc=new TeacherInterfaceImplCao();
		MistakesInterfaceCao mc=new MistakeInterfaceImplCao();
		StudentInterfaceCao sc=new StudentInterfaceImplCao();
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql="select * from studentanswer where stu_number=? and paper_id=?";
		String[] xzt=new String[10];
		String[] tkt=new String[5];
		String[] pdt=new String[3];
		String sql1="select * from paper where id=?";
		int[] xztid=new int[10];
		int[] tktid=new int[5];
		int[] pdtid=new int[3];
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, stu_id);
			pst.setInt(2, Integer.parseInt(paper_id));
			rs = pst.executeQuery();
			while(rs.next()) {
				xzt[0]=rs.getString("xzt1");
				xzt[1]=rs.getString("xzt2");
				xzt[2]=rs.getString("xzt3");
				xzt[3]=rs.getString("xzt4");
				xzt[4]=rs.getString("xzt5");
				xzt[5]=rs.getString("xzt6");
				xzt[6]=rs.getString("xzt7");
				xzt[7]=rs.getString("xzt8");
				xzt[8]=rs.getString("xzt9");
				xzt[9]=rs.getString("xzt10");
				tkt[0]=rs.getString("tkt1");
				tkt[1]=rs.getString("tkt2");
				tkt[2]=rs.getString("tkt3");
				tkt[3]=rs.getString("tkt4");
				tkt[4]=rs.getString("tkt5");
				pdt[0]=rs.getString("pdt1");
				pdt[1]=rs.getString("pdt2");
				pdt[2]=rs.getString("pdt3");
			}
			pst=con.prepareStatement(sql1);
			pst.setInt(1, Integer.parseInt(paper_id));
			rs=pst.executeQuery();
			while(rs.next()) {
				papername=rs.getString("papername");
				xztid[0]=rs.getInt("xzt1");
				xztid[1]=rs.getInt("xzt2");
				xztid[2]=rs.getInt("xzt3");
				xztid[3]=rs.getInt("xzt4");
				xztid[4]=rs.getInt("xzt5");
				xztid[5]=rs.getInt("xzt6");
				xztid[6]=rs.getInt("xzt7");
				xztid[7]=rs.getInt("xzt8");
				xztid[8]=rs.getInt("xzt9");
				xztid[9]=rs.getInt("xzt10");
				tktid[0]=rs.getInt("tkt1");
				tktid[1]=rs.getInt("tkt2");
				tktid[2]=rs.getInt("tkt3");
				tktid[3]=rs.getInt("tkt4");
				tktid[4]=rs.getInt("tkt5");
				pdtid[0]=rs.getInt("pdt1");
				pdtid[1]=rs.getInt("pdt2");
				pdtid[2]=rs.getInt("pdt3");
			}
			int xzt_score=0;
			int tkt_score=0;
			int pdt_score=0;
			
			for(int i=0;i<xztid.length;i++) {
				Xzt x=null;
				x=tc.showPaperbankxzt(xztid[i]);
				if(xzt[i] ==x.getAnswer()) {
					xzt_score+=4;
				}
				else {
					Mistakes mt =new Mistakes(stu_id,x.getQuestiontype(),x.getQuestionpoint(),x.getId());
					boolean b=mc.insert(mt);
					if(b==true) {
						System.out.println("插入成功");
					}
				}
			}
			for(int i=0;i<tktid.length;i++) {
				Tkt t=null;
				t=tc.showPaperbanktkt(tktid[i]);
				if(tkt[i]==t.getAnswer()) {
					tkt_score+=4;
				}
				else {
					Mistakes mt =new Mistakes(stu_id,t.getQuestiontype(),t.getQuestionpoint(),t.getId());
					boolean b=mc.insert(mt);
					if(b==true) {
						System.out.println("插入成功");
					}
				}
			}
			for(int i=0;i<pdtid.length;i++) {
				Pdt p=null;
				p=tc.showPaperbankpdt(pdtid[i]);
				System.out.println(pdt[i]+"       "+p.getAnswer());
				if(pdt[i]==p.getAnswer()) {
					pdt_score+=4;
				}
				else {
					Mistakes mt =new Mistakes(stu_id,p.getQuestiontype(),p.getQuestionpoint(),p.getId());
					boolean b=mc.insert(mt);
					if(b==true) {
						System.out.println("插入成功");
					}
				}
			}
			Student st=null;
			st=sc.showuserinfo(stu_id);
			StudentGrade sg=new StudentGrade(stu_id,st.getName(),xzt_score,tkt_score,pdt_score,papername,Integer.parseInt(paper_id));
			StudentGradeInterfaceCao sgc=new StudentGradeInterfaceImplCao();
			boolean b=sgc.insert(sg);
			if(b==true) {
				System.out.println("添加成绩成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("Student/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
