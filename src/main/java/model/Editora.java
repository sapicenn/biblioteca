package model;

public class Editora {
    private int id;
    private String nome;

    public Editora(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Nome: "+getNome();
    }
}
