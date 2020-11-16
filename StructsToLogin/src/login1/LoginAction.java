package login1;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	private static final long serialVersionUID = 1L;
 
	public String authenticate() {
 
		if(LoginAuth.validate(username, password)){  
	        return SUCCESS;  
	    }  
	    else {
	    	// Return action error message
	    	addActionError("Invalid username / password");
	        return ERROR;  
	    }  
	}
 
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
}