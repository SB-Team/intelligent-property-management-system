package cn.edu.xmu.nextgencomm.model;

public class TempBill {
	private int id;
	private String pcarnum; //车牌号
	private String phename;//所属小区
	private String pbegintime;//开始时间
	private String pendtime; //结束时间
	private int phour; //收费小时
	private int pbill;//收费费用
	private String plasttime;//租车上次收费时间
	private int pday; //收费天数
	public TempBill()
	{}


	public TempBill(int id, String pcarnum, String phename, String pbegintime,
			String pendtime, int phour, int pbill, String plasttime, int pday) {
		super();
		this.id = id;
		this.pcarnum = pcarnum;
		this.phename = phename;
		this.pbegintime = pbegintime;
		this.pendtime = pendtime;
		this.phour = phour;
		this.pbill = pbill;
		this.plasttime = plasttime;
		this.pday = pday;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPcarnum() {
		return pcarnum;
	}

	public void setPcarnum(String pcarnum) {
		this.pcarnum = pcarnum;
	}

	public String getPhename() {
		return phename;
	}

	public void setPhename(String phename) {
		this.phename = phename;
	}

	public String getPbegintime() {
		return pbegintime;
	}

	public void setPbegintime(String pbegintime) {
		this.pbegintime = pbegintime;
	}

	public String getPendtime() {
		return pendtime;
	}

	public void setPendtime(String pendtime) {
		this.pendtime = pendtime;
	}

	public int getPhour() {
		return phour;
	}

	public void setPhour(int phour) {
		this.phour = phour;
	}

	public int getPbill() {
		return pbill;
	}

	public void setPbill(int pbill) {
		this.pbill = pbill;
	}


	public String getPlasttime() {
		return plasttime;
	}


	public void setPlasttime(String plasttime) {
		this.plasttime = plasttime;
	}


	public int getPday() {
		return pday;
	}


	public void setPday(int pday) {
		this.pday = pday;
	}
	

}
