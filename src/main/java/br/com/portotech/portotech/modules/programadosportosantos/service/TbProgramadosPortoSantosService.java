package br.com.portotech.portotech.modules.programadosportosantos.service;

import br.com.portotech.portotech.dao.portosantos.TbProgramadosPortoSantosObj;
import br.com.portotech.portotech.dao.portosantos.repository.TbProgramadosPortoSantosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbProgramadosPortoSantosService {
    private final TbProgramadosPortoSantosRepository tbProgramadosPortoSantosRepository;

    TbProgramadosPortoSantosService(TbProgramadosPortoSantosRepository tbProgramadosPortoSantosRepository) {
        this.tbProgramadosPortoSantosRepository = tbProgramadosPortoSantosRepository;
    }

    public List<TbProgramadosPortoSantosObj> listar() {
       return tbProgramadosPortoSantosRepository.findAll();
    }
}
