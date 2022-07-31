package br.com.portotech.portotech.modules.dashboard.controller;

import br.com.portotech.portotech.dao.portosantos.TbProgramadosPortoSantosObj;
import br.com.portotech.portotech.dao.portosantos.repository.TbProgramadosPortoSantosRepository;
import br.com.portotech.portotech.modules.programadosportosantos.service.TbProgramadosPortoSantosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DashboardController {

    private final TbProgramadosPortoSantosService tbProgramadosPortoSantosService;

    DashboardController(TbProgramadosPortoSantosService tbProgramadosPortoSantosService) {
        this.tbProgramadosPortoSantosService = tbProgramadosPortoSantosService;
    }

    @GetMapping("/dashboard")
    public ModelAndView show(){
        ModelAndView mv = new ModelAndView();
        List<TbProgramadosPortoSantosObj> tbProgramadosPortoSantosObj = tbProgramadosPortoSantosService.listar();

        mv.addObject("lstProgramados", tbProgramadosPortoSantosObj);

        return mv;
    }
}
