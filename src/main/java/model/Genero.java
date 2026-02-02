package model;

public class Genero {
    private int id;
    private String nome;

    public Genero(String nome) {
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
        return getNome();
    }
}
