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
    }

    public List<Genero> listarGeneros() {
        return generoDAO.listarGeneros();
    }

}
