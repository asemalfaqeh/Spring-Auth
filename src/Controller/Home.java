package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class Home {
    @RequestMapping("/")
	public String Home() {
		return "home";
	}
    @RequestMapping("/login")
    public String loginform() {
    	return "login";
    }
    
    @RequestMapping("/loggedout")
    public String loggedout() {
    	return "loggedout";
    }
    
}
