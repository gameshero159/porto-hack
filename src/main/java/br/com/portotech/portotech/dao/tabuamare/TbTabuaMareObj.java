package br.com.portotech.portotech.dao.tabuamare;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_tabua_mare", schema = "portotech")
public class TbTabuaMareObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_tabua_mare")
    private Integer cdTabuaMare;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "dt_pico_mare")
    private Date dtPicoMare;

    @Column(name = "vl_pico")
    private Double vlPico;
}
