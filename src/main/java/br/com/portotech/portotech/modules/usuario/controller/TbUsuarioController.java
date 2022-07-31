package br.com.portotech.portotech.modules.usuario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TbUsuarioController {
    @GetMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
}
