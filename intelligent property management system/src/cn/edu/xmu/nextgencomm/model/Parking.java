package cn.edu.xmu.nextgencomm.model;

public class Parking {
	private int id; //自增id	
	private String pid; //车位id
	private String ptype; //类型：租用车位或临时车位或通用车位
	private String pstatus;//状态：租赁占用、临时占用、空
	private String pposition;//位置：地上或地下
	private String pcarnum;//车牌号
	private String pphename; //所属小区：haiyun或wuyuanwan
	private User user; //关联实体User
	private String pbegintime;//开始时间	
	private String pendtime; //结束时间
	private String plasttime; //租用车位上次缴费时间
	
	public Parking()
	{}



	public Parking(int id, String pid, String ptype, String pstatus,
			String pposition, String pcarnum, String pphename, User user,
			String pbegintime, String pendtime, String plasttime) {
		super();
		this.id = id;
		this.pid = pid;
		this.ptype = ptype;
		this.pstatus = pstatus;
		this.pposition = pposition;
		this.pcarnum = pcarnum;
		this.pphename = pphename;
		this.user = user;
		this.pbegintime = pbegintime;
		this.pendtime = pendtime;
		this.plasttime = plasttime;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	public String getPposition() {
		return pposition;
	}
	

	public void setPposition(String pposition) {
		this.pposition = pposition;
	}

	
	public String getPcarnum() {
		return pcarnum;
	}

	public void setPcarnum(String pcarnum) {
		this.pcarnum = pcarnum;
	}

	public String getPphename() {
		return pphename;
	}

	public void setPphename(String pphename) {
		this.pphename = pphename;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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



	public String getPlasttime() {
		return plasttime;
	}



	public void setPlasttime(String plasttime) {
		this.plasttime = plasttime;
	}
	
	
}



