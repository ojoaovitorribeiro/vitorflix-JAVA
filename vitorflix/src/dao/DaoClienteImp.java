package dao;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import conexao.Conexao;
import java.sql.*;
import javax.swing.JOptionPane;
import model.Produto;

public class DaoClienteImp implements DaoCliente {

    Conexao con = new Conexao();

    public void salvar(Cliente cliente) {
        //lista.add(cliente);
        con.conecta();
//INSERT INTO tb_cliente (cpf,nome,datanasc) VALUES ('12336547896', 'João', '12/04/2002')      
        String sqlinsert = "INSERT INTO cliente(nome,datanasc,cpf,user,senha) VALUES"
                + " ('" + cliente.getNome() + "','" + cliente.getDatanasc() + "', '" + cliente.getCpf() + "', '" + cliente.getUser() + "', '" + cliente.getSenha() + "' )";
        try {
            con.executeSQL("select * from cliente");
            con.stm.executeUpdate(sqlinsert);
            JOptionPane.showMessageDialog(null, "cliente inserido com sucesso!");
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
            con.executeSQL("select * from tb_cliente");
            String sqlremove = "DELETE FROM cliente WHERE id=" + idproduto;
            try {
                con.stm.executeUpdate(sqlremove);
                JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro!" + erro);
            }
            con.desconecta();
        } else if (resp == 1) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluír o titulo");
        } else if (resp == 2) {
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }
    }

    public void alterar(Cliente cliente, int idcliente) {
        con.conecta();
        con.executeSQL("select * from cliente");

        
        String altera = "UPDATE cliente SET  nome = '" + cliente.getNome() + "', datanasc='" + cliente.getDatanasc() + "', user='" + cliente.getUser() + "', senha='" + cliente.getSenha()+ "' WHERE idcliente=" + idcliente;
        try {
            con.stm.executeUpdate(altera);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar " + erro + " SQL " + altera);
        }
        con.desconecta();
    }

    public List<Cliente> getLista() {
        List<Cliente> listac = new ArrayList<Cliente>();
        con.conecta();
        con.executeSQL("select * from cliente");
        try {
            con.rs.first();
            do {
                Cliente rec = new Cliente();
                rec.setCpf(con.rs.getString("cpf"));
                rec.setNome(con.rs.getString("nome"));
                rec.setDatanasc(con.rs.getString("datanasc"));
                rec.setUser(con.rs.getString("user"));
                rec.setSenha(con.rs.getString("senha"));

                listac.add(rec);

            } while (con.rs.next());
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao usar buscar os dados!" + erro);
        }
        con.desconecta();
        return listac;
    }
public Cliente getClienteById(int id) {
        Cliente cli = new Cliente();
        con.conecta();
        con.executeSQL("select * from cliente where idcliente="+id);
        try {
            con.rs.first();
         
                Cliente rec = new Cliente();
                rec.setCpf(con.rs.getString("cpf"));
                rec.setNome(con.rs.getString("nome"));
                rec.setDatanasc(con.rs.getString("datanasc"));
                rec.setUser(con.rs.getString("user"));
                rec.setSenha(con.rs.getString("senha"));

                

            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao usar buscar os dados!" + erro);
        }
        con.desconecta();
        return cli;
    }
}
