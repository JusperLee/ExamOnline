package bean;

import java.io.Serializable;

/**
 * 学生成绩类
 */
public class StudentGrade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private String Userid;
	private String name;
	private int xztscore;
	private int tktscore;
	private int bctscore=-1;
	private int jdtscore=-1;
	private int pdtscore;
	private int score=0;
	private String papername;
	private int paperid;
	
	
	
	
   
	/**
	 * @param username 学生用户名	
	 * @param score 学生成绩
	 * @param papername 试卷名
	 */
	public StudentGrade(String Userid,String name, int xztscore,int tktscore,int pdtscore, String papername,int paperid) {
		super();
		this.Userid = Userid;
		this.name=name;
		this.xztscore=xztscore;
		this.tktscore=tktscore;
		this.pdtscore=pdtscore;
		this.papername = papername;
		this.paperid=paperid;
	}
	
	public StudentGrade() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getUserId() {
		return Userid;
	}
	public void setUserId(String Userid) {
		this.Userid = Userid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	 public int getPdtscore() {
			return pdtscore;
		}
		public void setPdtscore(int pdtscore) {
			this.pdtscore = pdtscore;
		}
	public int getJdtscore() {
		return jdtscore;
		}
	public void setJdtscore(int jdtscore) {
		this.jdtscore = jdtscore;
		}
	 public int getscore() {
			return score;
		}
		public void setscore(int score) {
			this.score = score;
		}
	 public int getXztscore() {
			return xztscore;
		}
		public void setXztscore(int xztscore) {
			this.xztscore = xztscore;
		}
		public int getTktscore() {
			return tktscore;
		}
		public void setTktscore(int tktscore) {
			this.tktscore = tktscore;
		}
		public int getBctscore() {
			return bctscore;
		}
		public void setBctscore(int bctscore) {
			this.bctscore = bctscore;
		}
	
	public String getPapername() {
		return papername;
	}
	public void setPapername(String papername) {
		this.papername = papername;
	}
	public int getPaperId() {
		return paperid;
	}
	public void setPaperId(int paperid) {
		this.paperid = paperid;
	}

	@Override
	public String toString() {
		return "StudentGrade [id=" + Userid + ", xztscore=" + xztscore + ", tktscore=" + tktscore
				+ ", bctscore=" + bctscore + ",pdtscore="+pdtscore+",jdtscore="+jdtscore+",score="+score+", papername=" + papername + "]";
	}
	
	
}

