package dao;
import model.Produto;
import java.util.List;

public interface DaoProduto {
    public void salvar(Produto produto);
    public void excluir(int idproduto);
    public void alterar(Produto produto, int idproduto);
    public List<Produto>getLista();
}
