package com.trungthuc.socketIO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @RequestMapping("/socket")
    public String index(HttpServletRequest request, Model model) {
        String username = (String) request.getSession().getAttribute("username");

        if (username == null || username.isEmpty()) {
            return "redirect:/socket/login";
        }
        model.addAttribute("username", username);

        return "socket/chat";
    }

    @RequestMapping(path = "/socket/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "socket/login";
    }

    @RequestMapping(path = "/socket/login", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, @RequestParam(defaultValue = "") String username) {
        username = username.trim();

        if (username.isEmpty()) {
            return "socket/login";
        }
        request.getSession().setAttribute("username", username);

        return "redirect:/socket";
    }

    @RequestMapping(path = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession(true).invalidate();

        return "redirect:/socket/login";
    }
}
