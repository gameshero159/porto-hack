package br.com.portotech.portotech.modules.dashboard.controller;

import br.com.portotech.portotech.modules.clima.service.TbClimaService;
import br.com.portotech.portotech.modules.programadosportosantos.service.TbProgramadosPortoSantosService;
import br.com.portotech.portotech.modules.tabuamare.service.TbTabuaMareService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
public class DashboardController {

    private final TbClimaService tbClimaService;

    private final TbProgramadosPortoSantosService tbProgramadosPortoSantosService;

    private final TbTabuaMareService tbTabuaMareService;

    @GetMapping("/dashboard")
    public ModelAndView show(){
        ModelAndView mv = new ModelAndView();

        mv.addObject("lstProgramados", tbProgramadosPortoSantosService.listagemPortoSantosAtual());
        mv.addObject("tbTabuaMareObj", tbTabuaMareService.picoMareAtual());
        mv.addObject("tbClima", tbClimaService.climaAtual());
        mv.addObject("tbClimaFuturo", tbClimaService.climaFuturo());

        return mv;
    }

}
