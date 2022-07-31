package br.com.portotech.portotech.modules.dashboard.controller;

import br.com.portotech.portotech.dao.portosantos.TbProgramadosPortoSantosObj;
import br.com.portotech.portotech.dao.portosantos.VwTbProgramadosPortoSantosObj;
import br.com.portotech.portotech.dao.portosantos.repository.TbProgramadosPortoSantosRepository;
import br.com.portotech.portotech.dao.portosantos.repository.VwTbProgramadosPortoSantosRepository;
import br.com.portotech.portotech.dao.tabuamare.TbTabuaMareObj;
import br.com.portotech.portotech.dao.tabuamare.repository.TbTabuaMareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private TbTabuaMareRepository tbTabuaMareRepository;

    @Autowired
    private VwTbProgramadosPortoSantosRepository vwTbProgramadosPortoSantosRepository;

    @GetMapping("/dashboard")
    public ModelAndView show(){
        ModelAndView mv = new ModelAndView();
        List<VwTbProgramadosPortoSantosObj> tbProgramadosPortoSantosObj = vwTbProgramadosPortoSantosRepository.findByDtPrevInicioMore(new Date());
        List<TbTabuaMareObj> tbTabuaMareObj = tbTabuaMareRepository.findByDtPicoMareMore(new Date());

        mv.addObject("lstProgramados", tbProgramadosPortoSantosObj);
        mv.addObject("tbTabuaMareObj", tbTabuaMareObj);

        return mv;
    }

}
