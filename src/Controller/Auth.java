package Controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import JavaBeans.Users;
import Services.AuthService;


@Controller
public class Auth {

	private AuthService authservices;

	@Autowired
	public void AuthController(AuthService authService) {
		this.authservices = authService;
	}

	@RequestMapping("/Signup")
	public String CreateAccount(Model model) {
		//Users users = new Users();
		model.addAttribute("users", new Users());
		return "CreatenewAccount";
	}

	@RequestMapping(value = "/CreateAccount", method = RequestMethod.POST)
	public String CreatenewAccount(Model model, @Valid Users users, BindingResult bind) {
		if (bind.hasErrors()) {
			java.util.List<ObjectError> obj = bind.getAllErrors();
			for (ObjectError error : obj) {
				System.out.println(error.getDefaultMessage());
				System.out.println(error.getClass());
				return "CreatenewAccount";
			}
			return "CreatenewAccount";
		}
		
		users.setAuthiritey("admin");
		users.setEnabled(true);
		
		if(authservices.exisits(users.getUsername())) {
			bind.rejectValue("username","Duplicate.users.username","Username is Already Exist");
			return "CreatenewAccount";
		}
		
		try {
			authservices.CreatnewAccount(users);
		} catch (DuplicateKeyException dk) {
			// TODO: handle exception
			bind.rejectValue("username","Duplicate.users.username","Username is Already Exist");
			return "CreatenewAccount";
		}
		
		System.out.println("Success Add User");
		return "index";
	}

}







