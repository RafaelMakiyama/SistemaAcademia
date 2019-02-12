package DAO;

import Modelo.Atleta;
import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtletaDAO {

//Códigos sql
    //INSERT: INSERT da tabela atleta com foreign key de pessoa.
    private static final String insert = "INSERT INTO atleta(idpessoa, intencaotreinamento, alimentacao,situacao) VALUES (?, ?, ?,?);";
    private static final String select = "SELECT id FROM pessoa WHERE id_usuario= ?;";
    private static final String read = "SELECT * FROM atleta WHERE idpessoa = ?;";

    Connection conexao = null;
    ResultSet rs = null;

    // INSERT: Cadastrar Atleta
    public void cadastrarAtleta(Atleta atleta) {
        try {
            conexao = ConectaBanco.getConexao();

            PreparedStatement pst = conexao.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);

            pst.setInt(1, atleta.getIdPessoa());
            pst.setString(2, atleta.getObjetivo());
            pst.setString(3, atleta.getAlimentacao());
            pst.setBoolean(4, atleta.isSituacaoMatricula());
            rs = pst.getGeneratedKeys();
            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //SELECT: Consulta o Id da Pessoa dentro da tabela Pessoa.
    public Atleta consultaIdPessoa(Atleta atleta) {
        try {
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(select);
            pstmt.setInt(1, atleta.getIdPessoa());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                atleta.setIdpessoa(rs.getInt("id"));
            }
            return atleta;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Atleta mostraAtletaIdPessoa(Atleta atleta) {
        try {

            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(read);
            pstmt.setInt(1, atleta.getIdPessoa());
            rs = pstmt.executeQuery();

            if (rs.next()) {

                atleta.setObjetivo(rs.getString("objetivo"));
                atleta.setAlimentacao(rs.getString("alimentacao"));
                atleta.setSituacaoMatricula(rs.getBoolean("matriculado"));
                atleta.setId(rs.getInt("id"));
            }

            return atleta;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
