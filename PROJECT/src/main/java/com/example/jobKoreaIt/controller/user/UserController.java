package com.example.jobKoreaIt.controller.user;


import com.example.jobKoreaIt.domain.common.dto.UserDto;
import com.example.jobKoreaIt.domain.common.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j

public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/user/seeker/login")
    public String seekerLogin() {
        log.info("GET /user/seeker/login...");
        return "seekerLogin";
    }
    @PostMapping("/user/seeker/login")
    public String loginSeeker(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpServletRequest request,
                              Model model) {
        log.info("POST /user/seeker/login...");
        UserDto userDto = userService.loginSeeker(username, password);
        if (userDto != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userDto);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "seekerLogin";
        }
    }
    @GetMapping("/user/offer/login")
    public String offerLogin() {
        log.info("GET /user/offer/login...");
        return "offerLogin";
    }
    @PostMapping("/user/offer/login")
    public String loginOffer(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             HttpServletRequest request,
                             Model model) {
        log.info("POST /user/offer/login...");
        UserDto userDto = userService.loginOffer(username, password);
        if (userDto != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userDto);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "offerLogin";
        }
    }
    @GetMapping("/user/logout")
    public String logout(HttpServletRequest request) {
        log.info("GET /user/logout...");
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/user/join")
    public String join(@RequestParam("username")String username,
                       @RequestParam("password")String password,
                       @RequestParam("email") String email,
                       Model model){
        log.info("POST /user/join");
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setPassword(password);

        boolean UserJoin = userService.UserJoin(userDto);


    }











    @PostMapping("/user/myinfo")
    public void myinfo() {
        log.info("POST /user/myinfo...");
    }
}