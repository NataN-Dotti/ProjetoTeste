/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.vo.Estoque;

/**
 *
 * @author NataN
 */
public interface IEstoqueDAO {
    boolean salvar(Estoque categoria);
    
    boolean atualizar(Estoque categoria);
    
    boolean excluir(Estoque categoria);
    
    List<Estoque> listarTodos();
    
    Estoque listarUm(Long id);
}
