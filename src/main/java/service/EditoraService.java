package service;

import DAO.EditoraDAO;
import model.Editora;

import java.util.List;

public class EditoraService {

    private EditoraDAO editoraDAO = new EditoraDAO();

    public void adicionarEditora(Editora editora) throws Exception {
        if(editora.getNome() == null || editora.getNome().isBlank()) {
            throw new IllegalArgumentException("Digite um nome válido.");
        }

        String nome = editora.getNome().trim();

        if(nome.length() < 2 || nome.length() > 100) {
            throw new IllegalArgumentException("O nome da editora deve conter entre 2 a 100 caracteres");
        }

        if(!nome.matches("(?=.*\\p{L})[\\p{L}0-9 ]+")) {
            throw new IllegalArgumentException("O nome da editora deve conter pelo menos 1 letra");
        }

        editoraDAO.adicionarEditora(editora);
    }

    public List<Editora> listarEditoras() {
        return editoraDAO.listarEditoras();
    }

}
