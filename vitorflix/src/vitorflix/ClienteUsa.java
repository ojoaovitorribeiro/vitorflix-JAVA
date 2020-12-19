package vitorflix;

import dao.DaoClienteImp;
import dao.DaoProdutoImp;
import static java.awt.SystemColor.menu;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Produto;

public class ClienteUsa {

    public static void main(String[] args) {
        DaoProdutoImp acesso = new DaoProdutoImp();
        DaoClienteImp acessoc = new DaoClienteImp();

        int oper = 0;
        do {
            oper = Integer.parseInt(JOptionPane.showInputDialog("Digite a Operação:\n\n1-Ver Títulos Disponíveis\n2-Cadastrar-se\n3-Entrar\n4-Sair\n\nEscolha:"));

            Cliente cliente = new Cliente();

            switch (oper) {
                case 1:
                    List<Produto> lista = new ArrayList<Produto>();
                    lista = acesso.getLista();
                    String filminhos = "";
                    for (int i = 0; i < lista.size(); i++) {
                        filminhos += "Título: " + lista.get(i).getNome() + " - Tipo: " + lista.get(i).getTipo() + " - Descrição: " + lista.get(i).getDesc() + " - Preço: " + lista.get(i).getPreco() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, filminhos);
                    break;

                case 2:
                    cliente.setNome(JOptionPane.showInputDialog("Nome Completo:"));
                    cliente.setDatanasc(JOptionPane.showInputDialog("Data de Nascimento: "));
                    cliente.setCpf(JOptionPane.showInputDialog("CPF:"));
                    cliente.setUser(JOptionPane.showInputDialog("Nome de Usuario: "));
                    cliente.setSenha(JOptionPane.showInputDialog("Senha: ex: 1234"));

                    acessoc.salvar(cliente);

                    break;

                case 3:

                    DaoClienteImp daoc = new DaoClienteImp();
                    cliente = new Cliente();
                    String usuario;
                    String senha;
                    int log = 0,id=0;
                    do {
                        usuario = JOptionPane.showInputDialog("Digite o nome de usuário");
                        senha = JOptionPane.showInputDialog("Digite a senha");
                        List<Cliente> rec = new ArrayList<Cliente>();
                        rec = acessoc.getLista();
                        for (int i = 0; i < rec.size(); i++) {
                            if (usuario.equals(rec.get(i).getUser()) && senha.equals(rec.get(i).getSenha())) {
                                log++;
                                id=rec.get(i).getId();
                            }
                        }
                    } while (log == 0);
                    JOptionPane.showMessageDialog(null, "Bem vindo ao VITORFLIX, " + usuario);

                    int logado = 0;
                    do {
                        int codigoCliente1;

                        logado = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n\n1-Ver Títulos Disponíveis\n2-Conta\n3-Comprar\n4-Sair\n\nEscolha:"));

                        switch (logado) {
                            case 1:

                                List<Produto> lista2 = new ArrayList<Produto>();
                                lista2 = acesso.getLista();
                                String film2 = "";
                                for (int i = 0; i < lista2.size(); i++) {
                                    film2 += "Título: " + lista2.get(i).getNome() + " - Tipo: " + lista2.get(i).getTipo() + " - Descrição: " + lista2.get(i).getDesc() + " - Preço: " + lista2.get(i).getPreco() + "\n";
                                }
                                JOptionPane.showMessageDialog(null, film2);
                                break;

                            case 2:
                                int conta = 0;
                                do {

                                    conta = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n\n1-Ver Meus Dados\n2- Alterar Conta\n3-Excluir Conta\n4-Sair\n\nEscolha:"));

                                    switch (conta) {

                                        //ver
                                        case 1:
                                            Cliente cli = new Cliente();
                                            cli = acessoc.getClienteById(id);
                                           
                                                JOptionPane.showMessageDialog(null, "Nome completo: " + cli.getNome()
                                                        + "\n" + "CPF: " + cli.getCpf() + "\n" + "Data de Nascimento: "
                                                        + cli.getDatanasc() + "\n" + "Nome de Usuário: " + cli.getUser() + "\n" + "Senha " + cli.getSenha() + "\n");
                                            
                                            break;

                                        //alterar
                                        case 2:
                                            
                                            cliente.setNome(JOptionPane.showInputDialog("Digite o novo nome"));
                                            cliente.setDatanasc(JOptionPane.showInputDialog("Digite a nova Data de Nascimento"));
                                            cliente.setUser(JOptionPane.showInputDialog("Digite um novo nome de usuário")); //alterar
                                            cliente.setSenha(JOptionPane.showInputDialog("Digite um nova senha")); //alterar
                                            acessoc.alterar(cliente, id);

                                            break;

                                        //EXCLUIRRR
                                        case 3:
                                            codigoCliente1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o seu código de ID: "));
                                            acesso.excluir(codigoCliente1); //excluir
                                            break;
                                    }
                                } while (logado != 1);

                                break;

                            case 3:
                                //COMPRAAAA
                                List<Produto> listacompra = new ArrayList<Produto>();
                                listacompra = acesso.getLista();
                                String listatitulos = "";
                                for (int i = 0; i < listacompra.size(); i++) {
                                    listatitulos += (i + 1) + " - Título: " + listacompra.get(i).getNome() + " - Tipo: " + listacompra.get(i).getTipo() + " - Descrição: " + listacompra.get(i).getDesc() + " - Preço: " + listacompra.get(i).getPreco() + "\n";
                                }
                                int escolha = Integer.parseInt(JOptionPane.showInputDialog(listatitulos));
                                int dia = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de dias que você vai ficar com o filme disponível: "));

                                double total = listacompra.get(escolha - 1).getPreco() * dia;

                                JOptionPane.showMessageDialog(null, "O total da locação foi: " + total + ". Aproveite seus " + dia + " dias com o título disponível!");

                                break;
                        }
                    } while (logado != 4);

                    break;

            }
        } while (oper != 4);
    }
}
