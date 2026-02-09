package DAO;

import conexao.Conexao;
import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    public void salvarLivroDAO(Livro livro) {
        String sql = "insert into livro(titulo, ano_publicacao, edicao, disponivel, num_paginas, editora_id, autor_id, genero_id)" +
                "values(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, livro.getTitulo());
            stm.setInt(2, livro.getAnoPublicacao());
            stm.setInt(3, livro.getEdicao());
            stm.setBoolean(4, livro.isDisponivel());
            stm.setInt(5, livro.getNumeroPaginas());
            stm.setInt(6, livro.getEditoraId());
            stm.setInt(7, livro.getAutorId());
            stm.setInt(8, livro.getGeneroId());

            stm.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Livro> listarLivrosDAO() {
        List<Livro> livros = new ArrayList<>();
        String sql = "select id, titulo, ano_publicacao from livro";

        try (Connection con = Conexao.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
             ResultSet result = stm.executeQuery()) {

            while(result.next()) {
                String titulo = result.getString("titulo");
                int id = result.getInt("id");
                int ano = result.getInt("ano_publicacao");
                Livro livro = new Livro(id, titulo, ano);
                livros.add(livro);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return livros;
    }

    public boolean removerLivroDAO(int id) {
        String sql = "delete from livro where id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, id);
            return stm.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
