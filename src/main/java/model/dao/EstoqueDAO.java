/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Connection.HibernateConnection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.vo.Estoque;

/**
 *
 * @author NataN
 */
public class EstoqueDAO{

    EntityManager manager;
    
    public EstoqueDAO() {
        manager = HibernateConnection.getEntityManager();
    }
    
    public boolean salvar(Estoque estoque) {
        manager.getTransaction().begin();
        manager.persist(estoque);
        manager.getTransaction().commit();
        return true;
    }

    public boolean atualizar(Estoque estoque) {
        manager.getTransaction().begin();
        manager.merge(estoque);
        manager.getTransaction().commit();
        return true;
    }

    public boolean excluir(Estoque estoque) {
        manager.getTransaction().begin();
        manager.remove(estoque);
        manager.getTransaction().commit();
        return true;
    }

    public List<Estoque> listarTodos() {
        List<Estoque> estoques;
        
        Query query = manager.createQuery("SELECT e FROM tb_movimento_estoque e");
        //TypedQuery<Estoque> query = manager.createQuery("SELECT c FROM Estoque c", Estoque.class);
        
        estoques = query.getResultList();
        
        return estoques;
    }

    public Estoque listarUm(Long id) {
        Estoque estoque;
        
        Query query = manager.createQuery("SELECT e FROM tb_movimento_estoque e WHERE e.codigo = " + id);
        estoque = (Estoque)query.getSingleResult();
        
        //estoque = manager.find(Estoque.class, id);
        return estoque;
    }
    
    public List<Estoque> listagemDinamica(String valor){
        manager = HibernateConnection.getEntityManager();
        String sql = "SELECT prod_id, data_cadastro, descricao, quantidade_minima, valor FROM tb_movimento_estoque  WHERE descricao LIKE '%" + valor + "%'";
        Query query = manager.createQuery(sql);
        List<Estoque> movimentacoes =  query.getResultList();
        manager.close();
        return movimentacoes;
        
        /*manager = HibernateConnection.getEntityManager();
        String sql = "from tb_movimentacoes where descricao like :value";
        Query query = manager.createQuery(sql);
        query.setParameter("value" , "%" + valor + "%");
        List<Estoque> movimentacoes =  query.getResultList();
        manager.close();
        return movimentacoes;*/
    }
    
}
