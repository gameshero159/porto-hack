package br.com.portotech.portotech.modules.clima.service;

import br.com.portotech.portotech.dao.clima.TbClimaObj;
import br.com.portotech.portotech.dao.clima.repository.TbClimaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class TbClimaService {

    private final TbClimaRepository tbClimaRepository;

    TbClimaService(TbClimaRepository tbClimaRepository) {
        this.tbClimaRepository = tbClimaRepository;
    }

    public TbClimaObj climaAtual() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plus(1, ChronoUnit.DAYS);
        return tbClimaRepository.findFirstByDtConsultaBetweenOrderByDtConsultaDesc(Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }
}
