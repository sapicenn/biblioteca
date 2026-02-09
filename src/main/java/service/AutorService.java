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

        String nome = autor.getNome().trim();

        if(nome.length() < 2 || nome.length() > 100) {
            throw new IllegalArgumentException("O nome do autor deve ter entre 2 e 100 caracteres");
        }

        if(!nome.matches("[\\p{L} ]+")) {
            throw new IllegalArgumentException("O nome deve conter apenas letras");
        }

        autorDAO.salvarAutor(autor);
    }

    public List<Autor> listarAutores() {
        return autorDAO.listarAutores();
    }
}
