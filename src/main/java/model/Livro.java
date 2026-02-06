package model;

public class Livro {
    private int id;
    private String titulo;
    private int anoPublicacao;
    private int edicao;
    private boolean disponivel;
    private int numeroPaginas;
    private int editoraId;
    private int autorId;
    private int generoId;

    public Livro (String titulo, int anoPublicacao, int edicao, boolean disponivel, int numeroPaginas,
                 int editoraId, int autorId, int generoId) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.edicao = edicao;
        this.disponivel = disponivel;
        this.numeroPaginas = numeroPaginas;
        this.editoraId = editoraId;
        this.autorId = autorId;
        this.generoId = generoId;
    }

    public Livro (int id, String titulo, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.anoPublicacao = ano;
    }

    public int getAutorId() {
        return autorId;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getEdicao() {
        return edicao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public int getEditoraId() {
        return editoraId;
    }

    public int getGeneroId() {
        return generoId;
    }

    @Override
    public String toString() {
        return "Título: "+getTitulo()+" (ID: "+getId()+")";
    }
}
