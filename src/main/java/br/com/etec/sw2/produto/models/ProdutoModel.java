package br.com.etec.sw2.produto.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Produto")
public class ProdutoModel implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 13)
    private String codigoDeBarras;
    @Column(nullable = false, unique = true, length = 200)
    private String descricao;
    @Column(nullable = false)
    private double valor;
    @Column(nullable = false)
    private int quantidade;
    @Column(nullable = true)
    private String nomeDaFoto;
    @Column(nullable = true)
    private byte[] foto;
    @Column(nullable = false)
    private LocalDateTime dataDeValidade;
    @Column(nullable = false)
    private LocalDateTime dataDeRegistro;
    @Column(nullable = false)
    private int ativo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getcodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setcodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getnomeDaFoto() {
        return nomeDaFoto;
    }

    public void setnomeDaFoto(String nomeDaFoto) {
        this.nomeDaFoto = nomeDaFoto;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public LocalDateTime getdataDeValidade() {
        return dataDeValidade;
    }

    public void setdataDeValidade(LocalDateTime dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public LocalDateTime getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDateTime dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

}
