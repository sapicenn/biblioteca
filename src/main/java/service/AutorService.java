package service;

import DAO.AutorDAO;
import model.Autor;

public class AutorService {

    private AutorDAO autorDAO = new AutorDAO();

    public void adicionarAutor(Autor autor) {
        if(autor.getNome() == null || autor.getNome().isBlank()) {
            throw new IllegalArgumentException("Digite um nome válido");
        }

        autorDAO.salvarAutorDAO(autor);
    }
}
