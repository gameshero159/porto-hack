package br.com.portotech.portotech.modules.dashboard.controller;

import br.com.portotech.portotech.dao.portosantos.TbProgramadosPortoSantosObj;
import br.com.portotech.portotech.dao.portosantos.repository.TbProgramadosPortoSantosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private TbProgramadosPortoSantosRepository tbProgramadosPortoSantosRepository;

    @GetMapping("/dashboard")
    public ModelAndView show(){
        ModelAndView mv = new ModelAndView();
        List<TbProgramadosPortoSantosObj> tbProgramadosPortoSantosObj = tbProgramadosPortoSantosRepository.findAll();

        mv.addObject("lstProgramados", tbProgramadosPortoSantosObj);

        return mv;
    }

}
