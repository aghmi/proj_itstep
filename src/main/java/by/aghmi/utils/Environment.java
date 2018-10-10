package by.aghmi.utils;

public enum Environment {
	DEV("jdbc:mysql://localhost:3306/retailer", "root", ""), 
	PRE_PROD("jdbc:mysql://localhost:3306/Shop", "root" , ""),
	PROD("jdbc:mysql://localhost:3306/retailer", "root", "");
	
	private String url;
	private String user;
	private String pass = "";
	
	private Environment(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
