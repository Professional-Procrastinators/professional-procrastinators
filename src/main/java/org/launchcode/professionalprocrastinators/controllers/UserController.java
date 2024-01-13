package org.launchcode.professionalprocrastinators.controllers;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.launchcode.professionalprocrastinators.models.User;
import org.launchcode.professionalprocrastinators.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @GetMapping(value = "/login")
    public String loginProcessForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(Model model) {
        return ":redirect";
    }

    @GetMapping(value = "/create_account")
    public String createAccountProcessFrom(Model model) {
        return "create-account";
    }


    @Autowired
    private UserRepository userRepository;
//In case we get Spring Security up and running this is a method to get current user that can be called by other controllers.
//    @GetMapping("/current-user")
//    public String getCurrentUser(Model model) {
//        User currentUser = getCurrentAuthenticatedUser();
//        model.addAttribute("currentUser", currentUser);
//        return "user/currentUser";
//    }
//
//    public User getCurrentAuthenticatedUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated()) {
//            String username = authentication.name();
//            return userRepository.findByUsername(username);
//        }
//        return null;
//
//    }
}