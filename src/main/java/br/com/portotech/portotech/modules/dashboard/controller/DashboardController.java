package br.com.portotech.portotech.modules.dashboard.controller;

import br.com.portotech.portotech.dao.clima.TbClimaObj;
import br.com.portotech.portotech.dao.portosantos.TbProgramadosPortoSantosObj;
import br.com.portotech.portotech.dao.tabuamare.TbTabuaMareObj;
import br.com.portotech.portotech.modules.clima.service.TbClimaService;
import br.com.portotech.portotech.modules.programadosportosantos.service.TbProgramadosPortoSantosService;
import br.com.portotech.portotech.modules.tabuamare.service.TbTabuaMareService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@Controller
public class DashboardController {

    private final TbClimaService tbClimaService;

    private final TbProgramadosPortoSantosService tbProgramadosPortoSantosService;

    private final TbTabuaMareService tbTabuaMareService;

    @GetMapping("/dashboard")
    public ModelAndView show(){
        ModelAndView mv = new ModelAndView();
        List<TbProgramadosPortoSantosObj> tbProgramadosPortoSantosObj = tbProgramadosPortoSantosService.listagemPortoSantosAtual();
        List<TbTabuaMareObj> tbTabuaMareObj = tbTabuaMareService.picoMareAtual();
        TbClimaObj tbClimaObj = tbClimaService.climaAtual();

        mv.addObject("lstProgramados", tbProgramadosPortoSantosObj);
        mv.addObject("tbTabuaMareObj", tbTabuaMareObj);
        mv.addObject("tbClima", tbClimaObj);

        return mv;
    }

}
