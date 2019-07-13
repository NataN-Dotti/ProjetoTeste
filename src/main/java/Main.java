
import controller.EstoqueController;
import controller.ProdutoController;
import java.util.Date;
import model.vo.Estoque;
import model.vo.Produto;
import view.FormProduto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NataN
 */
public class Main {

    public static void main(String[] args) {
        
        iniciarBanco();
        
        FormProduto f = new FormProduto();
        
        f.setVisible(true);

    }
    
    public static void iniciarBanco(){
        
        Produto p1 = new Produto("Banana", 10, new Date(), 1.25);
        Produto p2 = new Produto("Maça", 15, new Date(), 20);
        
        Estoque e1 = new Estoque(new Date(), 5, "entrada", p1);
        Estoque e2 = new Estoque(new Date(), 5, "entrada", p2);
        
        ProdutoController pcontroll = new ProdutoController();
        
        EstoqueController econtroll = new EstoqueController();
        
        pcontroll.salvar(p1);
        econtroll.salvar(e1);
        
        pcontroll.salvar(p2);
        econtroll.salvar(e2);
        
    }
}
