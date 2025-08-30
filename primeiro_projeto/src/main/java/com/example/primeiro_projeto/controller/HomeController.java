package com.example.primeiro_projeto.controller;

import com.example.primeiro_projeto.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private MensagemService mensagemService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("mensagem", mensagemService.getMensagem());
        return "home";
    }
}