package service;

import DAO.AutorDAO;
import model.Autor;

import java.util.List;

public class AutorService {

    private AutorDAO autorDAO = new AutorDAO();

    public void adicionarAutor(Autor autor) {
        if(autor.getNome() == null || autor.getNome().isBlank()) {
            throw new IllegalArgumentException("Digite um nome válido");
        }

        autorDAO.salvarAutor(autor);
    }

    public List<Autor> listarAutores() {
        return autorDAO.listarAutores();
    }
}
