package dao;

import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import conexao.Conexao;
import java.sql.*;
import javax.swing.JOptionPane;

public class DaoFuncionarioImp implements DaoFuncionario{
    Conexao con = new Conexao();
    
    public void salvar(Funcionario funcionario) {
        //lista.add(notebook);
        con.conecta();
//INSERT INTO tb_notebook (modelo,marca,serie,cor) VALUES ('João', 'Fazer o app', '1100100000000100', '111111111')      
        String sqlinsert = "INSERT INTO tb_funcionario(nome,funcao,salario,cpf) VALUES"
+ " ('"+funcionario.getNome()+"','"+funcionario.getFuncao()+"','"+funcionario.getSalario()+"','"+funcionario.getCpf()+"')";
        try{
        con.executeSQL("select * from tb_funcionario");
        con.stm.executeUpdate(sqlinsert);
        JOptionPane.showMessageDialog(null,"Funcionario inserido com sucesso!");
        }catch(SQLException erro){
        JOptionPane.showMessageDialog(null,"Erro ao cadastrar"+erro+"SQL"+sqlinsert);
        }
        
        con.desconecta();
    }
    
    public void excluir(int rv) {
        int resp;
        resp = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?",
                "Confirmação",JOptionPane.YES_NO_OPTION);
        //Mais adequado seria o switch devido ao tempo de execução
        if(resp == 0){
            con.conecta();
            con.executeSQL("select * from tb_funcionario");
            String sqlremove = "DELETE FROM tb_funcionario WHERE id="+rv;
            try{
            con.stm.executeUpdate(sqlremove);
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Erro!"+erro);
            }
            con.desconecta();
        }else if(resp == 1){
            JOptionPane.showMessageDialog(null, "Não foi possível excluír o rv"+rv);
        }else if(resp == 2){
            JOptionPane.showMessageDialog(null, "Operação cancelada!"+rv);
        }
    }

    public void alterar(Funcionario funcionario,int rv) {
        con.conecta();
        con.executeSQL("select * from tb_funcionario");
        
        String altera = "UPDATE  tb_funcionario SET  nome = '"+ funcionario.getNome()+"', funcao='"+ funcionario.getFuncao()+"',salario='"+ funcionario.getSalario()+"',cpf='"+funcionario.getCpf()+"' WHERE rv="+rv;
         try{
        con.stm.executeUpdate(altera);
        }
        catch(SQLException erro)
       {
           JOptionPane.showMessageDialog(null,"Erro ao alterar "+erro + " SQL "+altera);
       }
        con.desconecta();
    }
    

    public List<Funcionario> getLista() {
        List<Funcionario> lista = new ArrayList<Funcionario>();
        con.conecta();
        con.executeSQL("select * from tb_funcionario");
        try{
        con.rs.first();
        do{
            Funcionario rec = new Funcionario();
            rec.setRv(con.rs.getInt("rv"));
            rec.setNome(con.rs.getString("nome"));
            rec.setFuncao(con.rs.getString("funcao"));
            rec.setSalario(con.rs.getFloat("salario"));
            rec.setCpf(con.rs.getInt("cpf"));
            lista.add(rec);
            
        }while(con.rs.next());}catch(SQLException erro){
        JOptionPane.showMessageDialog(null, "Erro ao usar buscar os dados!"+erro);
        }
        con.desconecta();
        return lista;
    }
    
}
