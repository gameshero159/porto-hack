package br.com.portotech.portotech.modules.clima.service;

import br.com.portotech.portotech.dao.clima.TbClimaObj;
import br.com.portotech.portotech.dao.clima.repository.TbClimaRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class TbClimaService {

    private final TbClimaRepository tbClimaRepository;

    TbClimaService(TbClimaRepository tbClimaRepository) {
        this.tbClimaRepository = tbClimaRepository;
    }

    public TbClimaObj climaAtual() {
        Calendar dtAtual = Calendar.getInstance();
        zeraHoras(dtAtual);

        return tbClimaRepository.findFirstByCdClimaOrderByCdClimaDesc(Date.from(dtAtual.toInstant()), diaFuturo(dtAtual));
    }

    public TbClimaObj climaFuturo() {
        Calendar dtAtual = Calendar.getInstance();
        dtAtual.add(Calendar.DAY_OF_MONTH, 1);
        zeraHoras(dtAtual);

        return tbClimaRepository.findFirstByCdClimaOrderByCdClimaDesc(Date.from(dtAtual.toInstant()), diaFuturo(dtAtual));
    }

    private Date diaFuturo(Calendar dtAtual) {
        Calendar dtFuturo = dtAtual;
        dtFuturo.add(Calendar.DAY_OF_MONTH, 1);
        return Date.from(dtFuturo.toInstant());
    }

    private void zeraHoras(Calendar dtAtual) {
        dtAtual.set(Calendar.HOUR_OF_DAY, 0);
        dtAtual.set(Calendar.MINUTE, 0);
        dtAtual.set(Calendar.SECOND, 0);
        dtAtual.set(Calendar.MILLISECOND, 0);
    }
}
