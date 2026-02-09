package model;

public class Livro {
    private int id;
    private String titulo;
    private int anoPublicacao;
    private int edicao;
    private int numeroPaginas;
    private int editoraId;
    private int autorId;
    private int generoId;
    private StatusLivro statusLivro;

    public Livro (String titulo, int anoPublicacao, int edicao, int numeroPaginas,
                 int editoraId, int autorId, int generoId, StatusLivro status) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.edicao = edicao;
        this.numeroPaginas = numeroPaginas;
        this.editoraId = editoraId;
        this.autorId = autorId;
        this.generoId = generoId;
        this.statusLivro = status;
    }

    public Livro (int id, String titulo, int ano, StatusLivro status) {
        this.id = id;
        this.titulo = titulo;
        this.anoPublicacao = ano;
        this.statusLivro = status;
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

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public int getEditoraId() {
        return editoraId;
    }

    public int getGeneroId() {
        return generoId;
    }

    public StatusLivro getStatusLivro() {
        return statusLivro;
    }

    public void setStatusLivro(StatusLivro status) {
        this.statusLivro = status;
    }

    @Override
    public String toString() {
        return "Título: "+getTitulo()+" (ID: "+getId()+")";
    }
}
