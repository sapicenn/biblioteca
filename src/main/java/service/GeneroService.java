package service;

import DAO.GeneroDAO;
import model.Genero;

import java.util.List;

public class GeneroService {

    private GeneroDAO generoDAO = new GeneroDAO();

    public void adicionarGenero(Genero genero) {
        if(genero.getNome() == null || genero.getNome().isBlank()) {
            throw new IllegalArgumentException("Digite um nome válido");
        }

        String nome = genero.getNome().trim();

        if(nome.length() < 2 || nome.length() > 100) {
            throw new IllegalArgumentException("O nome da editora deve conter entre 2 a 100 caracteres");
        }

        if(!nome.matches("(?=.*\\p{L})[\\p{L}0-9 ]+")) {
            throw new IllegalArgumentException("O nome da editora deve conter pelo menos 1 letra");
        }

        generoDAO.adicionarGenero(genero);
    }

    public List<Genero> listarGeneros() {
        return generoDAO.listarGeneros();
    }

}
