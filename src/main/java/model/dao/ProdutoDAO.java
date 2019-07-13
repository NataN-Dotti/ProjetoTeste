/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Connection.HibernateConnection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.vo.Produto;

/**
 *
 * @author NataN
 */
public class ProdutoDAO{
    
    EntityManager manager;

    public ProdutoDAO() {
        this.manager = HibernateConnection.getEntityManager();
    }

    public boolean salvar(Produto produto) {
        this.manager.getTransaction().begin();
        this.manager.persist(produto);
        this.manager.getTransaction().commit();
        return true;
    }

    public boolean atualizar(Produto produto) {
        manager.getTransaction().begin();
        manager.merge(produto);
        manager.getTransaction().commit();
        return true;
    }

    public boolean excluir(Produto produto) {
        manager.getTransaction().begin();
        manager.remove(produto);
        manager.getTransaction().commit();
        return true;
    }

    public List<Produto> listarTodos() {
        List<Produto> produtos;
        
        //Query query = manager.createQuery("SELECT p FROM tb_produto p");
        TypedQuery<Produto> query = manager.createQuery("SELECT p FROM Produto p", Produto.class);
        
        produtos = query.getResultList();
        
        return produtos;
    }

    public Produto listarUm(Long id) {
        Produto produto;
        
        TypedQuery<Produto> query = manager.createQuery("SELECT p FROM Produto p WHERE p.id", Produto.class);
        produto = (Produto)query.getSingleResult();
        
        //produto = manager.find(Produto.class, id);
        return produto;
    }
    
    public List<Produto> listagemDinamica(String valor){        
        List<Produto> produtos;
        
        String sql = "SELECT p FROM Produto p WHERE p.descricao LIKE '%" + valor + "%'";
        TypedQuery<Produto> query = manager.createQuery(sql, Produto.class);
        
        produtos = query.getResultList();
        
        return produtos;
    }
    
}
