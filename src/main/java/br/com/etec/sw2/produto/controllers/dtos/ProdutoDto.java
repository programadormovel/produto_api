package br.com.etec.sw2.produto.controllers.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

public class ProdutoDto {

    @NotBlank
    @Size(max = 13)
    private String codigoDeBarras;
    @NotBlank
    @Size(max = 200)
    private String descricao;
    private double valor;
    private int quantidade;
    @Null
    private String nomeDaFoto;
    @Null
    private byte[] foto;
    private LocalDateTime dataDeValidade;
    private int ativo;

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

    public LocalDateTime getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(String dataDeValidade) {
        this.dataDeValidade = LocalDateTime.parse(dataDeValidade);
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

}
