package dao;
import model.Cliente;
import java.util.List;

public interface DaoCliente {
    public void salvar(Cliente cliente);
    public void excluir(int cpf);
    public void alterar(Cliente cliente, int cpf);
    public List<Cliente>getLista();
}
