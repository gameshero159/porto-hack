package br.com.portotech.portotech.dao.portosantos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "vw_tb_programados_porto_santos", schema = "portotech")
public class VwTbProgramadosPortoSantosObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_programados_porto_santos")
    private Integer cdProgramadosPortoSantos;

    @Column(name = "tx_navio")
    private String txNavio;

    @Column(name = "tx_ref_viagem")
    private String txRefViagem;

    @Column(name = "tx_berco")
    private String txBerco;

    @Column(name = "dt_prev_inicio")
    private Date dtPrevInicio;

    @Column(name = "ck_anuencia")
    private Integer ckAnuencia;

    @Column(name = "ck_certificado")
    private Integer ckCertificado;

    @Column(name = "cd_pratico")
    private Integer cdPratico;
}
