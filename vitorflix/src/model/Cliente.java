package model;

public class Cliente {
    private int id;
    public String cpf;
    public String nome;
    public String datanasc;
    public String senha;
    public String user;

    public Cliente (String cpf, String nome, String datanasc, String senha, String user) {
        this.cpf = cpf;
        this.nome = nome;
        this.datanasc = datanasc;
        this.senha = senha;
        this.user = user;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
