package br.com.portotech.portotech.modules.tabuamare.service;

import br.com.portotech.portotech.dao.tabuamare.TbTabuaMareObj;
import br.com.portotech.portotech.dao.tabuamare.repository.TbTabuaMareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class TbTabuaMareService {
    private final TbTabuaMareRepository tbTabuaMareRepository;

    public List<TbTabuaMareObj> picoMareAtual() {
        return tbTabuaMareRepository.findByDtPicoMareMore(new Date());
    }
}
