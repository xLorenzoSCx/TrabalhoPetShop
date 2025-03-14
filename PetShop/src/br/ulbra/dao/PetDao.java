package br.ulbra.dao;

import br.ulbra.entity.Pet;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PetDao {

    Connection con;

    public PetDao() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

    public boolean checkLogin(String email, String senha) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }

    public void create(Pet u) {
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO tbpet (nomePet, raca, anoNascimento, sexo, corPelo) VALUES (?,?,?,?,?)");

            stmt.setString(1, u.getNomePet());
            stmt.setString(2, u.getRaca());
            stmt.setString(4, u.getAnoNascimento());
            stmt.setString(5, u.getSexo());
            stmt.setString(5, u.getCorPelo());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
