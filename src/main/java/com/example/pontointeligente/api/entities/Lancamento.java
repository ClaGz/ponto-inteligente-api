package com.example.pontointeligente.api.entities;

import com.example.pontointeligente.api.enums.TipoEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {
    private static final Long SerialVersionUID = Long.parseLong(UUID.randomUUID().toString());

    private Long id;
    private Date data;
    private String descricao;
    private String localizacao;
    private Date dataCriacao;
    private Date dataAtualizacao;
    private TipoEnum tipo;
    private Funcionario funcionario;

    public Lancamento() {
    }

    public static Long getSerialVersionUID() {
        return SerialVersionUID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Column(name = "descricao", nullable = true)
    public String getDescricao() {
        return descricao;
    }

    @Transient
    public Optional<String> getDescricaoOpt() {
        return Optional.ofNullable(descricao);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "localizacao", nullable = true)
    public String getLocalizacao() {
        return localizacao;
    }

    @Transient
    public Optional<String> getLocalizacaoOpt() {
        return Optional.ofNullable(localizacao);
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Column(name = "data_criacao", nullable = false)
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Column(name = "data_atualizacao", nullable = false)
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    public TipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnum tipo) {
        this.tipo = tipo;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @PreUpdate
    public void preUpdate() {
        dataAtualizacao = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dataCriacao = atual;
        dataAtualizacao = atual;
    }

    @Override
    public String toString() {
        return "Lancamento{" +
                "id=" + id +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", tipo=" + tipo +
                ", funcionario=" + funcionario +
                '}';
    }
}
