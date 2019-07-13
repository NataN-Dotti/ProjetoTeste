/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author NataN
 */

@Entity
@Table(name = "tb_movimento_estoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "est_id")
    private long id;
    
    @Column(name = "data_movimento" , nullable =  false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMovimento;
    
    @Column(name = "quantidade", nullable =  false)
    private double quantidade;
    
    @Column(name = "tipo_movimentacao" , nullable =  false , length = 45)
    private String tipoMovimentacao;
    
    @ManyToOne
    @JoinColumn(name = "prod_id")
    private Produto produto;

    public Estoque(Date dataMovimento, double quantidade, String tipoMovimentacao, Produto produto) {
        this.dataMovimento = dataMovimento;
        this.quantidade = quantidade;
        this.tipoMovimentacao = tipoMovimentacao;
        this.produto = produto;
    }
    
    public Estoque() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
    
    
}
