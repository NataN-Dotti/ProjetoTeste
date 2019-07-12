/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.EstoqueDAO;
import model.vo.Estoque;

/**
 *
 * @author NataN
 */
public class EstoqueController {
    EstoqueDAO dao;

    public EstoqueController() {
        this.dao = new EstoqueDAO();
    }
    
    public boolean salvar(Estoque estoque) {
        if(this.dao.salvar(estoque)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean atualizar(Estoque estoque) {
        if(this.dao.atualizar(estoque)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean excluir(Estoque estoque) {
        if(this.dao.excluir(estoque)){
            return true;
        }else{
            return false;
        }
    }
    
    public List<Estoque> listarTodos() {
        List<Estoque> estoques = this.dao.listarTodos();
        
        return estoques;
    }
    
    public Estoque listarUm(Long id) {
        return this.dao.listarUm(id);
    }
}
