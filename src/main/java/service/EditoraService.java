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

        editoraDAO.adicionarEditora(editora);
    }

    public List<Editora> listarEditoras() {
        return editoraDAO.listarEditoras();
    }

}
