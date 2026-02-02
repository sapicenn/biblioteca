package DAO;

import conexao.Conexao;
import model.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {
    public void adicionarAutor(Autor autor) {

        String sql = "insert into autor(nome) values (?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, autor.getNome());
            stm.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Autor> listarAutores() {
        String sql = "select nome from autor";
        List<Autor> autores = new ArrayList<>();

        try (Connection con = Conexao.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet result = stm.executeQuery()) {

            while(result.next()) {
                String nome = result.getString("nome");
                Autor autor = new Autor(nome);
                autores.add(autor);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return autores;
    }
}
