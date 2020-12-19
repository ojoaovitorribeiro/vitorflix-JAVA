package model;

public class Produto {
    public int idproduto;
    public String nome;
    public String tipo;
    public String desc;
    public float preco;

    public Produto() {
    }

    public Produto(int idproduto, String nome, String tipo, String desc, float preco) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.tipo = tipo;
        this.desc = desc;
        this.preco = preco;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
