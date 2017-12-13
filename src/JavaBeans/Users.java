package JavaBeans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public class Users {
  
	@NotBlank
	@Size(min=5,max=20)
	private String username;
	
	@NotNull(message="Password Required")
	@Size(min=5,message="Password not Coorect")
	private String password;
	
	@NotNull(message="Email Required")
	@Pattern(regexp=".*\\@.*\\..*", message="This does not appear to be a valid email address")
	@Size(min=5,max=50,message="Email Not Correct") 
	private String email;
	
	private boolean enabled;
	private String authiritey; 
	
	
	
	public Users() {
		
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
		this.password = password  ;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthiritey() {
		return authiritey;
	}

	public void setAuthiritey(String authiritey) {
		this.authiritey = authiritey;
	}


	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", email=" + email + ", enabled=" + enabled
				+ ", authiritey=" + authiritey + "]";
	}
	
	
	
}
