package model;

public class Usuario{

	private int id;
	private String username;
	private String password;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername(){
		return username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword(){
		return password;
	}
	
	@Override
	public String toString() {
		return "ID: " + Integer.toString(getId()) + " | Username: "+ getUsername() + " | Password: "+ getPassword();
	}	
}