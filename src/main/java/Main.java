
import controller.EstoqueController;
import controller.ProdutoController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        
        FormProduto p = new FormProduto();
        
        p.setVisible(true);

    }
    
    public static void iniciarBanco(){
        
        Produto p = new Produto("Banana", 10, new Date(), 1.25);
        
        Estoque e = new Estoque(new Date(), 5, "entrada", p);
        
        ProdutoController pcontroll = new ProdutoController();
        
        EstoqueController econtroll = new EstoqueController();
        
        pcontroll.salvar(p);
        
        econtroll.salvar(e);
        
    }
}
