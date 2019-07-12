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
import javax.persistence.TypedQuery;
import model.vo.Estoque;

/**
 *
 * @author NataN
 */
public class EstoqueDAO implements IEstoqueDAO{

    EntityManager manager;
    
    public EstoqueDAO() {
        manager = HibernateConnection.getEntityManager();
    }
    
    @Override
    public boolean salvar(Estoque estoque) {
        manager.getTransaction().begin();
        manager.persist(estoque);
        manager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean atualizar(Estoque estoque) {
        manager.getTransaction().begin();
        manager.merge(estoque);
        manager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean excluir(Estoque estoque) {
        manager.getTransaction().begin();
        manager.remove(estoque);
        manager.getTransaction().commit();
        return true;
    }

    @Override
    public List<Estoque> listarTodos() {
        List<Estoque> estoques;
        
        //Query query = manager.createQuery("SELECT c FROM Estoque c");
        TypedQuery<Estoque> query = manager.createQuery("SELECT c FROM Estoque c", Estoque.class);
        
        estoques = query.getResultList();
        
        return estoques;
    }

    @Override
    public Estoque listarUm(Long id) {
        Estoque estoque;
        
        Query query = manager.createQuery("SELECT c FROM Estoque c WHERE c.codigo = " + id);
        estoque = (Estoque)query.getSingleResult();
        
        //estoque = manager.find(Estoque.class, id);
        return estoque;
    }
    
}
