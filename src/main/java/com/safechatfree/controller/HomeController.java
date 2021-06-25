package com.safechatfree.controller;

import com.safechatfree.model.ChatForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("chatForm", new ChatForm());
        return "index";
    }
}
