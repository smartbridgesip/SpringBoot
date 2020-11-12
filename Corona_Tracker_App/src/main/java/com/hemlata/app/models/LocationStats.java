package com.hemlata.app.models;



public class LocationStats {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="id")
	//private Long id;
    private String state;
    private String country;
    public int cc;
    public int dc;
    public int rc;
    public int ac;
	public String getState() {
		return state;
	}
		public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getDc() {
		return dc;
	}
	public void setDc(int dc) {
		this.dc = dc;
	}
	public int getRc() {
		return rc;
	}
	public void setRc(int rc) {
		this.rc = rc;
	}
	public int getAc() {
		return ac;
	}
	public void setAc(int ac) {
		this.ac = ac;
	}
	@Override
	public String toString() {
		return "LocationStats [state=" + state + ", country=" + country + ", cc=" + cc + ", dc=" + dc + ", rc=" + rc
				+ ", ac=" + ac + "]";
	}

   

}
