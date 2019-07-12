/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.ProdutoDAO;
import model.vo.Produto;

/**
 *
 * @author NataN
 */
public class ProdutoController {
    ProdutoDAO dao;

    public ProdutoController() {
        this.dao = new ProdutoDAO();
    }
    
    public boolean salvar(Produto produto) {
        if(this.dao.salvar(produto)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean atualizar(Produto produto) {
        if(this.dao.atualizar(produto)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean excluir(Produto produto) {
        if(this.dao.excluir(produto)){
            return true;
        }else{
            return false;
        }
    }
    
    public List<Produto> listarTodos() {
        List<Produto> produtos = this.dao.listarTodos();
        
        return produtos;
    }
    
    public Produto listarUm(Long id) {
        return this.dao.listarUm(id);
    }
    
}
