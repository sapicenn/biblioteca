package DAO;

import conexao.Conexao;
import model.Livro;
import model.StatusLivro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    public void salvarLivro(Livro livro) {
        String sql = "insert into livro(titulo, ano_publicacao, edicao, num_paginas, editora_id, autor_id, genero_id, status)" +
                "values(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, livro.getTitulo());
            stm.setInt(2, livro.getAnoPublicacao());
            stm.setInt(3, livro.getEdicao());
            stm.setInt(4, livro.getNumeroPaginas());
            stm.setInt(5, livro.getEditoraId());
            stm.setInt(6, livro.getAutorId());
            stm.setInt(7, livro.getGeneroId());
            stm.setString(8, livro.getStatusLivro().name());

            stm.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar o livro", e);
        }
    }

    public List<Livro> listarLivros() {
        List<Livro> livros = new ArrayList<>();
        String sql = "select id, titulo, ano_publicacao, status from livro";

        try (Connection con = Conexao.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
             ResultSet result = stm.executeQuery()) {

            while(result.next()) {
                String titulo = result.getString("titulo");
                int id = result.getInt("id");
                int ano = result.getInt("ano_publicacao");
                String statusDB = result.getString("status");
                StatusLivro status = StatusLivro.valueOf(statusDB);
                Livro livro = new Livro(id, titulo, ano, status);
                livros.add(livro);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os livros", e);
        }

        return livros;
    }

    public boolean removerLivro(int id) {
        String sql = "delete from livro where id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, id);
            return stm.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover o livro", e);
        }
    }

    public boolean atualizarStatus(int id, StatusLivro status) {
        String sql = "update livro set status = ? where id = ?";

        try (Connection con = Conexao.getConnection();
            PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, status.name());
            stm.setInt(2, id);

            return stm.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o status do livro", e);
        }
    }
}
