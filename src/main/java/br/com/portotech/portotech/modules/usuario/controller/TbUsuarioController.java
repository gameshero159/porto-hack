package br.com.portotech.portotech.modules.usuario.controller;

import br.com.portotech.portotech.dao.usuario.TbUsuarioObj;
import br.com.portotech.portotech.modules.usuario.services.TbUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
public class TbUsuarioController {

    private final TbUsuarioService tbUsuarioService;

    @GetMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping(value = "/registro")
    public ModelAndView registro() {
        return new ModelAndView("register");
    }

    @PostMapping(value = "/registro")
    public ModelAndView salvaRegistro(@Validated TbUsuarioObj tbUsuarioObj) {
        TbUsuarioObj usuarioObj = tbUsuarioService.createUser(tbUsuarioObj);

        if (usuarioObj != null) {
            return new ModelAndView("redirect:/login");
        } else {
            return new ModelAndView("redirect:/registro");
        }
    }
}
