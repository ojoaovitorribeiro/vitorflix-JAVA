package model;

public class Funcionario {
    public int rv;
    public String nome;
    public String funcao;
    public float salario;
    public int cpf;

    public Funcionario() {
    }

    public Funcionario(int rv, String nome, String funcao, float salario, int cpf) {
        this.nome = nome;
        this.funcao = funcao;
        this.salario = salario ;
        this.cpf = cpf;
    }

    public int getRv() {
        return rv;
    }

    public void setRv(int rv) {
        this.rv = rv;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    
    
    
}

