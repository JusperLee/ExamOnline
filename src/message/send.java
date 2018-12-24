package message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
/**
 * Servlet implementation class send
 */
@WebServlet("/send")
public class send extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public send() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tel=request.getParameter("tel");
		String number=request.getParameter("number");
		String[] tele=new String[1];
		tele[0]=tel;
		String[] num=new String[1];
		num[0]=number;
		System.out.println(num[0]);
		System.out.println(tele[0]);
		// ����Ӧ��SDK AppID
		int appid = 1400102495; // 1400��ͷ
		// ����Ӧ��SDK AppKey
		String appkey = "abfedab61a176069723c718d4e328da8";;
		// ����ģ��ID����Ҫ�ڶ���Ӧ��������
		int templateId = 141016; // NOTE: �����ģ��ID`7839`ֻ��һ��ʾ������ʵ��ģ��ID��Ҫ�ڶ��ſ���̨������
		//templateId7839��Ӧ��������"������֤����: {1}"
		// ǩ��
		String smsSign = "һ��Ų��"; // NOTE: �����ǩ��"��Ѷ��"ֻ��һ��ʾ������ʵ��ǩ����Ҫ�ڶ��ſ���̨�����룬����ǩ������ʹ�õ���`ǩ������`��������`ǩ��ID`
		try {
			//��������Ԫ�ظ�����ģ���б�����������һ�£�����������templateId:5678��Ӧһ������������������Ԫ�ظ���Ҳ������һ��
		    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
		    SmsSingleSenderResult result = ssender.sendWithParam("86", tele[0],
		        templateId, num, smsSign, "", "");  // ǩ������δ�ṩ����Ϊ��ʱ����ʹ��Ĭ��ǩ�����Ͷ���
		    System.out.println(result);
		} catch (HTTPException e) {
		    // HTTP��Ӧ�����
		    e.printStackTrace();
		} catch (JSONException e) {
		    // json��������
		    e.printStackTrace();
		} catch (IOException e) {
		    // ����IO����
		    e.printStackTrace();
		}
		System.out.println("����");
		request.getSession().setAttribute("yan1", num[0]);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
