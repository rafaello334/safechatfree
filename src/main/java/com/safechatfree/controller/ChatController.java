package com.safechatfree.controller;

import com.safechatfree.model.ChatForm;
import com.safechatfree.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/enterChat")
    public String enterChat(@ModelAttribute ChatForm chatForm, Model model, HttpServletRequest request) {
        request.getSession().setAttribute("chatName", chatForm.getChatName());
        request.getSession().setAttribute("username", chatForm.getUsername());
        model.addAttribute("chat", chatService.getChat(chatForm.getChatName()));

        return "chat";
    }

    @GetMapping("/refreshChat")
    public String enterChatGet(Model model, HttpServletRequest request) {
        model.addAttribute("chat", chatService.getChat((String)request.getSession().getAttribute("chatName")));

        return "chat";
    }

    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam("") String message, HttpServletRequest request) {
        if(request.getSession().getAttribute("chatName") != null) {
            chatService.sendMessage((String) request.getSession().getAttribute("chatName"), (String) request.getSession().getAttribute("username"), message);
        } else {
            return "sessionExpired";
        }

        return "redirect:/refreshChat";
    }
}
