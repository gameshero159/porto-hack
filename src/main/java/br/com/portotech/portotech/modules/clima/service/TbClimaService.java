package br.com.portotech.portotech.modules.clima.service;

import br.com.portotech.portotech.dao.clima.TbClimaObj;
import br.com.portotech.portotech.dao.clima.repository.TbClimaRepository;
import org.springframework.stereotype.Service;

@Service
public class TbClimaService {

    private final TbClimaRepository tbClimaRepository;

    TbClimaService(TbClimaRepository tbClimaRepository) {
        this.tbClimaRepository = tbClimaRepository;
    }

    public TbClimaObj climaAtual() {
        return tbClimaRepository.findFirstByCdClimaOrderByCdClimaDesc();
    }
}
