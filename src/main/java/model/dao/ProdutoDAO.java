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
import model.vo.Produto;

/**
 *
 * @author NataN
 */
public class ProdutoDAO implements IProdutoDAO{
    
    EntityManager manager;

    public ProdutoDAO() {
        this.manager = HibernateConnection.getEntityManager();
    }

    @Override
    public boolean salvar(Produto produto) {
        this.manager.getTransaction().begin();
        this.manager.persist(produto);
        this.manager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean atualizar(Produto produto) {
        manager.getTransaction().begin();
        manager.merge(produto);
        manager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean excluir(Produto produto) {
        manager.getTransaction().begin();
        manager.remove(produto);
        manager.getTransaction().commit();
        return true;
    }

    @Override
    public List<Produto> listarTodos() {
        List<Produto> produtos;
        
        //Query query = manager.createQuery("SELECT c FROM Produto c");
        TypedQuery<Produto> query = manager.createQuery("SELECT c FROM Produto c", Produto.class);
        
        produtos = query.getResultList();
        
        return produtos;
    }

    @Override
    public Produto listarUm(Long id) {
        Produto produto;
        
        Query query = manager.createQuery("SELECT c FROM Produto c WHERE c.codigo = " + id);
        produto = (Produto)query.getSingleResult();
        
        //produto = manager.find(Produto.class, id);
        return produto;
    }
    
}
