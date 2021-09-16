package pl.matt.smartTravelling.Home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "/home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpServletResponse response) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "/home";
        }
        List<User> users1 = userService.userGetByEmail(user.getLogin(), user.getPassword());
        List<User> users = userService.userGetByLogin(user.getLogin(), user.getPassword());
        if (users.size() == 0 && users1.size() == 0) {
            model.addAttribute("user", user);
            return "/home";
        }

        Cookie cLogin = new Cookie("login", user.getLogin());
        Cookie cPassword = new Cookie("password", user.getPassword());
        response.addCookie(cLogin);
        response.addCookie(cPassword);
        return "redirect:/trips/all";

    }

    @GetMapping(value = "/register")
    public String Register(Model model) {
        model.addAttribute("user", new User());
        return "/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String Register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpServletResponse response) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "/register";
        } else {
            userService.add(user);
            return "redirect:/login";
        }

    }

}


