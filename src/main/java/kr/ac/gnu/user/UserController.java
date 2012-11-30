
package kr.ac.gnu.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user/*")

public class UserController {

	@RequestMapping
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/user/addUser");
		return mv;
	}
}
