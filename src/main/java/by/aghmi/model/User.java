package by.aghmi.model;

public class User extends RetType{
	
	private int uid;
	private String name;
	private String lastName;
	private String email;
	private String password;
	

	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(int uid, String name, String lastName, String email, String password) {
		super();
		this.uid = uid;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}


	public User(String name, String lastName, String email, String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
