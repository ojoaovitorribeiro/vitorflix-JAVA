package dao;
import model.Funcionario;
import java.util.List;

public interface DaoFuncionario {
    public void salvar(Funcionario funcionario);
    public void excluir(int rv);
    public void alterar(Funcionario funcionario, int rv);
    public List<Funcionario>getLista();
}
