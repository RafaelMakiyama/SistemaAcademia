package DAO;

import Modelo.Personal;
import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonalDAO {

    //  Código SQL 
    private static final String insert = "INSERT INTO personal(idpessoa, instituicao, curso, metodos)VALUES (?, ?, ?, ?);";
    private static final String select = "SELECT id FROM pessoa WHERE id_usuario= ?;";
    private static final String read = "SELECT * FROM personal WHERE idpessoa = ?;";
    private static final String read2 = "SELECT * FROM personal WHERE matricula = ?;";
    private static final String update = "UPDATE personal SET instituicao=?, curso=?, metodos=? WHERE matricula = ? ;";

    Connection conexao = null;
    ResultSet rs = null;

    // INSERT: Cadastrar Personal
    public void cadastrarPersonal(Personal personal) {
        try {
            conexao = ConectaBanco.getConexao();

            PreparedStatement pst = conexao.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);

            pst.setInt(1, personal.getIdPessoa());
            pst.setString(2, personal.getInstituicao());
            pst.setString(3, personal.getCurso());
            pst.setString(4, personal.getMetodos());
            rs = pst.getGeneratedKeys();
            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //SELECT: Consulta o Id da Pessoa dentro da tabela Pessoa.
    public Personal pesquisaIdPessoa(int id) {
        try {

            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(select);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            Personal personal = new Personal();

            if (rs.next()) {
                personal.setIdpessoa(rs.getInt("id"));

            }

            return personal;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // READ: Lista informaçõe de Personal Trainner com parametro idpessoa ;
    public Personal pesquisaIdPersonal(Personal personal) {
        try {

            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(read);
            pstmt.setInt(1, personal.getIdPessoa());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                personal.setMatricula(rs.getInt("matricula"));
                personal.setInstituicao(rs.getString("instituicao"));
                personal.setCurso(rs.getString("curso"));
                personal.setMetodos(rs.getString("metodos"));

            }

            return personal;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // READ: Lista informações de Personal Trainner com parametro matricula
    public Personal mostraPersonalIdMatricula(Personal personal) {
        try {

            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(read2);
            pstmt.setInt(1, personal.getMatricula());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                personal.setMatricula(rs.getInt("matricula"));
                personal.setInstituicao(rs.getString("instituicao"));
                personal.setCurso(rs.getString("curso"));
                personal.setMetodos(rs.getString("metodos"));

            }

            return personal;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // Update: Atualiza informações de Personal Trainner com parametro matricula
    public void Atualizar(Personal personal) {
        try {
            Connection connection = ConectaBanco.getConexao();
            {
                PreparedStatement pstmt = connection.prepareStatement(update);
                //Recuperando valores e inserindo eles.
                pstmt.setString(1, personal.getInstituicao());
                pstmt.setString(2, personal.getCurso());
                pstmt.setString(3, personal.getMetodos());
                pstmt.setInt(4, personal.getMatricula());
                pstmt.execute();    //executando a função.
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
