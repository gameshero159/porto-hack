package br.com.portotech.portotech.dao.portosantos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "tb_programados_porto_santos", schema = "portotech", catalog = "")
public class TbProgramadosPortoSantosObj {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cd_programados_porto_santos", nullable = false)
    private int cdProgramadosPortoSantos;
    
    @Column(name = "dt_prev_inicio")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dtPrevInicio;
    
    @Column(name = "dt_prev_fim", nullable = true)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dtPrevFim;
    
    @Column(name = "tx_berco", nullable = true, length = 45)
    private String txBerco;
    
    @Column(name = "tx_navio", nullable = true, length = 45)
    private String txNavio;
    
    @Column(name = "tx_tipo_carga", nullable = true, length = 45)
    private String txTipoCarga;
    
    @Column(name = "tx_evento", nullable = true, length = 45)
    private String txEvento;
    
    @Column(name = "tx_ref_viagem", nullable = true, length = 45)
    private String txRefViagem;

    @Column(name = "cd_duv", nullable = true)
    private Integer cdDuv;

    @Column(name = "ck_certificado")
    private Integer ckCertificado;

    @Column(name = "cd_pratico")
    private Integer cdPratico;

}
