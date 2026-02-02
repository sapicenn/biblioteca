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
            System.out.println(e.getMessage());
        }
    }

    public List<Editora> listarEditoras() {
        List<Editora> editoras = new ArrayList<>();
        String sql = "select nome from editora";

        try(Connection con = Conexao.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet result = stm.executeQuery()) {

            while(result.next()) {
                String nome = result.getString("nome");
                Editora editora = new Editora(nome);
                editoras.add(editora);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return editoras;

    }
}
