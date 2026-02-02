package DAO;

import conexao.Conexao;
import model.Editora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditoraDAO {
    public void adicionarEditora(Editora editora) {
        String sql = "insert into editora(nome) values (?)";

        try(Connection con = Conexao.getConnection();
            PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, editora.getNome());
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
