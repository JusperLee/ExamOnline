package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import bean.Bct;
import bean.Jdt;
import bean.Pdt;
import bean.Tkt;
import bean.Xzt;
import caozuo.BctInterfaceCao;
import caozuo.TeacherInterfaceCao;
import caozuo.TktInterfaceCao;
import caozuo.XztInterfaceCao;
import caozuo.BctInterfaceImplCao;
import caozuo.JdtInterfaceCao;
import caozuo.JdtInterfaceImplCao;
import caozuo.PdtInterfaceCao;
import caozuo.PdtInterfaceImplCao;
import caozuo.TeacherInterfaceImplCao;
import caozuo.TktInterfaceImplCao;
import caozuo.XztInterfaceImplCao;


public class InsertQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * �ϴ����
		 */
		request.setCharacterEncoding("UTF-8");
		String a = request.getParameter("questiontype");
		System.out.println(a);
		
		if(a.equals("xzt")||a.equals("bct")||a.equals("tkt")||a.equals("pdt")||a.equals("jdt")){
		
		/**
		 * �����߼���
		 */

		if(a.equals("xzt")){
			String question  = request.getParameter("question");
			String answer = request.getParameter("answer");
			String OptionA  = request.getParameter("OptionA");
			String OptionB  = request.getParameter("OptionB");
			String OptionC  = request.getParameter("OptionC");
			String OptionD  = request.getParameter("OptionD");
System.out.println(question);
System.out.println(answer);
			String questionpoint =request.getParameter("questionpoint");
			Xzt xzt = new Xzt(question,answer,OptionA,OptionB,OptionC,OptionD,questionpoint);
			XztInterfaceCao xf=new XztInterfaceImplCao();
			if(xf.insert(xzt)){
				System.out.println("xzt����ɹ�");
			}
		}
		else if(a.equals("tkt")){
			String question  = request.getParameter("question");
			String answer = request.getParameter("answer");
			String questionpoint =request.getParameter("questionpoint");
			Tkt tkt = new Tkt(question,answer,questionpoint);
			TktInterfaceCao tf=new TktInterfaceImplCao();
			if(tf.insert(tkt)){
				System.out.println("tkt����ɹ�");
			}
		}
		else if(a.equals("bct")){
			String question  = request.getParameter("question");
			String questionpoint =request.getParameter("questionpoint");
			Bct bct = new Bct(question,questionpoint);
			BctInterfaceCao bf=new BctInterfaceImplCao();			
			if(bf.insert(bct)){
				System.out.println("bct����ɹ�");
			}			
		}}
		else if(a.equals("jdt")) {
			String question  = request.getParameter("question");
			String questionpoint =request.getParameter("questionpoint");
			Jdt jdt = new Jdt(question,questionpoint);
			JdtInterfaceCao jf=new JdtInterfaceImplCao();	
			if(jf.insert(jdt)) {
				System.out.println("jdt����ɹ�");
			}
		}
		else if(a.equals("pdt")) {
			String question  = request.getParameter("question");
			String questionpoint =request.getParameter("questionpoint");
			String answer = request.getParameter("answer");
			Pdt pdt=new Pdt(question,answer,questionpoint);
			PdtInterfaceCao pf=new PdtInterfaceImplCao();
			if(pf.insert(pdt)) {
				System.out.println("�ж������ɹ�");
			}
		}
		else{
		
		/**
		 * �����߼���
		 */
		SmartUpload su = new SmartUpload();
		String filePath = getServletContext().getRealPath("\\") + "\\upload\\";
		File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
		PageContext pageContext=JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		// ��ʼ��
		su.initialize(pageContext);
		// �����ļ��ϴ����Ե�����
		su.setAllowedFilesList("xls,xlsx");
		// �����ϴ������ļ��Ĵ�С
		su.setMaxFileSize(1024 * 1024 * 10);// 10mb
		// �������ϴ��ļ��Ĵ�С
		su.setTotalMaxFileSize(1024 * 1024 * 10 * 5);
		// 50mb
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// ��ʼ�����ϴ�
		// ��ȡ���ϴ����ļ�
		//SmartRequest sRequest=su.getRequest();
	
		SmartFiles sfs = su.getFiles();
		// ��ȡһ��
		SmartFile sf = sfs.getFile(0);
		try {
			//String fname = sf.getFileName();
			System.out.println(filePath+sf.getFileName());
			//sf.saveAs("/upload//"+sf.getFileName() ,1);
			sf.saveAs(filePath+sf.getFileName());
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		String path = request.getServletContext().getRealPath("/");
		System.out.println("�ļ��ϴ��ɹ���");
		TeacherInterfaceCao teacherInterfaceCao = new TeacherInterfaceImplCao();
		System.out.println("  1111   " + sf.getFileName()+"1111"+path);
		
		
		
		 if(a.equals("xztbatch")){
			int b = 1;
			try {
				if(teacherInterfaceCao.batchquestion(b,sf.getFileName(),path)){
				System.out.println("xzt����ɹ�");}
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		else if(a.equals("tktbatch")){
			int b = 2;
			try {
				if(teacherInterfaceCao.batchquestion(b,sf.getFileName(),path)){	
				System.out.println("tkt����ɹ�");}
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		else{
			int b = 3;
			try {
				if(teacherInterfaceCao.batchquestion(b,sf.getFileName(),path)){
				System.out.println("bct����ɹ�");}
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		//��תҳ�����
		
	}
		request.getRequestDispatcher("teacher/insert_success.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
