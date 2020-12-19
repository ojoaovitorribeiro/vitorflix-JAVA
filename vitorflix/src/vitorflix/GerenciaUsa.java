package vitorflix;

import dao.DaoClienteImp;
import dao.DaoProdutoImp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Produto;

public class GerenciaUsa {

    public static void main(String[] args) {

        int func = 0;
        do {
            int codigoPtod1;
            DaoProdutoImp acesso = new DaoProdutoImp();
            Produto produto = new Produto();

            func = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n\n1-Cadastrar Titulo\n2-Alterar Titulo\n3-Excluir Titulo\n4-Listar Títulos\n5-Sair\n\nEscolha:"));
            switch (func) {
                case 1:

                    produto.setNome(JOptionPane.showInputDialog("Digite o título:"));
                    produto.setTipo(JOptionPane.showInputDialog("É série ou filme?"));
                    produto.setDesc(JOptionPane.showInputDialog("Qual será a descrição?"));
                    produto.setPreco(Float.parseFloat((JOptionPane.showInputDialog("Digite um preço para ele: "))));
                    acesso.salvar(produto);

                    break;

                case 2:

                    codigoPtod1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do título a ser alterado"));
                    produto.setNome(JOptionPane.showInputDialog("Digite o novo nome"));
                    produto.setTipo(JOptionPane.showInputDialog("Digite o novo tipo"));
                    produto.setDesc(JOptionPane.showInputDialog("Digite a nova descrição"));
                    produto.setPreco(Float.parseFloat((JOptionPane.showInputDialog("Digite um novo preço")))); //alterar
                    acesso.alterar(produto, codigoPtod1);

                    break;

                case 3:

                    codigoPtod1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto para ser excluído"));
                    acesso.excluir(codigoPtod1); //excluir

                    break;
                case 4:
                    List<Produto> lista = new ArrayList<Produto>();
                    lista = acesso.getLista();
                    String filminhos = "";
                    for (int i = 0; i < lista.size(); i++) {
                        filminhos += "Título: " + lista.get(i).getNome() + " - Tipo: " + lista.get(i).getTipo() + " - Descrição: " + lista.get(i).getDesc() + " - Preço: " + lista.get(i).getPreco() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, filminhos);

                    break;
            }
        } while (func != 5);
    }
}
