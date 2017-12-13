package Services;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Dao.AuthDao;
import JavaBeans.Users;

@Component("authservice")
public class AuthService {

	private AuthDao authdao;
	
	public AuthService() {
		System.out.println("Serivce Starting..");
	}
	
	@Autowired
	public void setAuthService(AuthDao authDao) {
	    this.authdao = authDao;
	}
	
	public boolean CreatnewAccount(Users users) {
	  return authdao.CreatnewAccount(users);
	}

	public boolean exisits(String username) {
		// TODO Auto-generated method stub
		return authdao.exists(username);
	}
	
}
