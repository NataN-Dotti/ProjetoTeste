/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.vo.Produto;

/**
 *
 * @author NataN
 */
public interface IProdutoDAO {
    boolean salvar(Produto categoria);
    
    boolean atualizar(Produto categoria);
    
    boolean excluir(Produto categoria);
    
    List<Produto> listarTodos();
    
    Produto listarUm(Long id);
}
