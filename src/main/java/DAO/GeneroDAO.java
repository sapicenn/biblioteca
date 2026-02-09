package DAO;

import conexao.Conexao;
import model.Editora;
import model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {
    public void adicionarGenero(Genero genero) {
        String sql = "insert into genero(nome) values (?)";

        try(Connection con = Conexao.getConnection();
            PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, genero.getNome());
            stm.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar gênero", e);
        }
    }

    public List<Genero> listarGeneros() {
        List<Genero> generos = new ArrayList<>();
        String sql = "select nome from genero";

        try(Connection con = Conexao.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet result = stm.executeQuery()) {

            while(result.next()) {
                String nome = result.getString("nome");
                Genero genero = new Genero(nome);
                generos.add(genero);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar gêneros", e);
        }

        return generos;

    }
}
