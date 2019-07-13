/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.ProdutoDAO;
import model.vo.Produto;

/**
 *
 * @author NataN
 */
public class ProdutoController {

    private ProdutoDAO dao;
    private Produto produto;
    private List<Produto> produtos;
    private String[] colunas;

    DefaultTableModel tableModel;

    public ProdutoController() {
        this.dao = new ProdutoDAO();
        this.colunas = new String[]{"ID" , "Descrição" , "Quantidade Mínima" , "Data de Cadastro" , "Valor" };
        this.tableModel = new DefaultTableModel(null , colunas);
    }

    public void preencherTabela() {
        limparTabela();
        String[] linha = new String[]{null, null, null, null, null};

        //setValueAt(newDomainName, linha, coluna);
        int i = 0;
        for (Produto p : this.produtos) {
            this.tableModel.addRow(linha);
            this.tableModel.setValueAt(p.getId(), i, 0);
            this.tableModel.setValueAt(p.getDescricao(), i, 1);
            this.tableModel.setValueAt(p.getQuantidadeMinima(), i, 2);
            this.tableModel.setValueAt(p.getDataCadastro(), i, 3);
            this.tableModel.setValueAt(p.getValor(), i, 4);
            i++;
        }

    }

    public DefaultTableModel getTableModel() {
        preencherTabela();
        return this.tableModel;
    }

    private void limparTabela() {
        while (this.tableModel.getRowCount() > 0) {
            this.tableModel.removeRow(0);
        }
    }

    public boolean salvar(Produto produto) {
        try {
            this.dao.salvar(produto);
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar o cadastro");
            System.err.println(erro);
            return false;
        }
    }

    public boolean atualizar(Produto produto) {
        try {
            this.dao.atualizar(produto);
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o produto");
            System.err.println(erro);
            return false;
        }
    }

    public boolean excluir(Produto produto) {
        try {
            this.dao.excluir(produto);
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso");
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o cadastro");
            System.err.println(erro);
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

    public List<Produto> listagemDinamica(String pkvalor) {
        this.produtos = this.dao.listagemDinamica(pkvalor);
        preencherTabela();
        return this.produtos;
    }

    public ProdutoDAO getDao() {
        return dao;
    }

    public void setDao(ProdutoDAO dao) {
        this.dao = dao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
