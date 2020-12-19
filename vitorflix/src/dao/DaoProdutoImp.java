package dao;

import java.util.ArrayList;
import java.util.List;
import model.Produto;
import conexao.Conexao;
import java.sql.*;
import javax.swing.JOptionPane;

public class DaoProdutoImp implements DaoProduto {

    Conexao con = new Conexao();

    public void salvar(Produto produto) {
        //lista.add(produto);
        con.conecta();
//INSERT INTO produto () VALUES (')      
        String sqlinsert = "INSERT INTO produto(nome,tipo,descc,preco) VALUES ('" + produto.getNome() + "','" + produto.getTipo() + "','" + produto.getDesc() + "'," + produto.getPreco() + ")";
        try {
            con.executeSQL("select * from produto");
            con.stm.executeUpdate(sqlinsert);
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar " + erro + " SQL " + sqlinsert);
        }

        con.desconecta();
    }

    public void excluir(int idproduto) {
        int resp;
        resp = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?",
                "Confirmação", JOptionPane.YES_NO_OPTION);
        //Mais adequado seria o switch devido ao tempo de execução
        if (resp == 0) {
            con.conecta();
            con.executeSQL("select * from produto");
            String sqlremove = "DELETE FROM produto WHERE idproduto=" + idproduto;
            try {
                con.stm.executeUpdate(sqlremove);
                JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro!" + erro);
            }

            con.desconecta();
        } else if (resp == 1) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluír o produto " + idproduto);
        } else if (resp == 2) {
            JOptionPane.showMessageDialog(null, "Operação cancelada! " + idproduto);
        }
    }

    public void alterar(Produto produto, int idproduto) {
        con.conecta();
        con.executeSQL("select * from produto");

        String altera = "UPDATE  produto SET  nome = '" + produto.getNome() + "', tipo='" + produto.getTipo() + "',descc='" + produto.getDesc() + "',preco='" + produto.getPreco() + "' WHERE idproduto=" + idproduto;
        try {
            con.stm.executeUpdate(altera);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar " + erro + " SQL " + altera);
        }
        con.desconecta();
    }

    public List<Produto> getLista() {
        List<Produto> lista = new ArrayList<Produto>();
        con.conecta();
        con.executeSQL("select * from produto");
        try {
            con.rs.first();
            do {
                Produto rec = new Produto();
                rec.setIdproduto(con.rs.getInt("idproduto"));
                rec.setNome(con.rs.getString("nome"));
                rec.setTipo(con.rs.getString("tipo"));
                rec.setDesc(con.rs.getString("descc"));
                rec.setPreco(con.rs.getFloat("preco"));
                lista.add(rec);

            } while (con.rs.next());
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao usar buscar os dados!" + erro);
        }
        con.desconecta();
        return lista;
    }

}
