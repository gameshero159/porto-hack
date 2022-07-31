package br.com.portotech.portotech.modules.programadosportosantos.service;

import br.com.portotech.portotech.dao.portosantos.TbProgramadosPortoSantosObj;
import br.com.portotech.portotech.dao.portosantos.repository.TbProgramadosPortoSantosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class TbProgramadosPortoSantosService {
    private final TbProgramadosPortoSantosRepository tbProgramadosPortoSantosRepository;

    public List<TbProgramadosPortoSantosObj> listagemPortoSantosAtual() {
        return tbProgramadosPortoSantosRepository.findByDtPrevInicioMore(new Date());
    }
}
