
package conexao;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {
    Connection conexao;
    public final String url = "jdbc:mysql://localhost:3306/vitorflix";
    public final String usuario = "root";
    public final String senha = "";
    public final String driver = "com.mysql.jdbc.Driver";
    
    public Statement stm;
    public ResultSet rs;
    
    public boolean conecta(){
        boolean result = true;
        try{
        Class.forName(driver);
        conexao = DriverManager.getConnection(url,usuario,senha);
        JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso.");
        }    
        catch(ClassNotFoundException Driver){    
        JOptionPane.showMessageDialog(null, "Driver não localizado: ");
        result = false;
        }
        catch(SQLException Fonte){    
        JOptionPane.showMessageDialog(null, "Erro na conexão: ");
        result = false;
        }
        return result;
    }
    
    public void desconecta(){
        boolean result = true;
        try{
            conexao.close();
            JOptionPane.showMessageDialog(null, "Conexão finalizada.");
        }
        catch(SQLException Erro)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível finalizar o banco de dados."+Erro);
            result = false;
        }
    }
        public void executeSQL(String sql){
            try{
            stm = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            }
            catch(SQLException Query){
                JOptionPane.showMessageDialog(null, "Erro: "+Query+"SQL"+sql);
            }
        }    
}
