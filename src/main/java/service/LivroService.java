package service;

import model.Livro;
import DAO.LivroDAO;

import java.time.LocalDate;
import java.util.List;

public class LivroService {

    private LivroDAO livroDAO = new LivroDAO();

    public void adicionarLivro(Livro livro) throws Exception {
        if(livro.getTitulo() == null || livro.getTitulo().isBlank()) {
            throw new IllegalArgumentException("O livro deve conter um título");
        }

        if(livro.getAnoPublicacao() > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Digite um ano válido");
        }

        if(livro.getNumeroPaginas() < 1) {
            throw new IllegalArgumentException("O número de páginas precisa ser maior que 0");
        }

        if(livro.getEdicao() < 1 ) {
            throw new IllegalArgumentException("A edição deve ser superior à 0");
        }

        if(livro.getEditoraId() < 1) {
            throw new IllegalArgumentException("Digite um ID válido");
        }

        if(livro.getAutorId() < 1) {
            throw new IllegalArgumentException("Digite um ID válido");
        }

        if(livro.getGeneroId() < 1) {
            throw new IllegalArgumentException("Digite um ID válido");
        }

        livroDAO.salvarLivroDAO(livro);
    }

    public List<Livro> listarLivros() throws Exception {
        return livroDAO.listarLivrosDAO();
    }

    public boolean removerLivro(int id) {
        if(id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        //TODO verificar se o livro existe

        return livroDAO.removerLivroDAO(id);
    }
}
