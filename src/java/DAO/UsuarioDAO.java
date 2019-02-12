package DAO;

import Modelo.Usuario;
import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
// Scripts utilizados para consulta no BD

    private static final String INSERT = "insert into usuario (email,login, senha, perfilacesso, primeiroacesso ) values (?,?,crypt(?, gen_salt('bf',8)),?, ?)";
    private static final String SELECT = "select * from usuario where (login = ?) and (senha = crypt( ?, senha ))";
    private static final String SELECTPERFIL = "select perfilacesso from usuario where login = ?";
    private static final String BUSCA = "SELECT * FROM usuario WHERE idUsuario= ?";
    private static final String consulta_email = "SELECT * FROM usuario WHERE email = ?; ";
    private static final String atualiza_senha = "UPDATE usuario SET senha = crypt(?  , senha ) where email = ? ;";

    //private static final String UPDATE = "UPDATE examefisico   SET idexame=?, altura=?, peso=?, imc=?, peito=?, cintura=?, "
    //     + "panturrilhaesquerda=?,  panturrilhadireita=?, bracoesquerdo=?, bracodireito=?, antebracoesquerdo=?, "
    //   + "antebracodireito=?, gluteo=? WHERE idexame= ?";
    //LOGIN
    public Usuario validar(Usuario usuario) {
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT);
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            ResultSet rs = pstmt.executeQuery();
//roda result seta comparando valores
            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setPerfilAcesso(rs.getString("perfilacesso"));
                usuario.setPrimeiroAcesso(rs.getBoolean("primeiroacesso"));
            } else {

                usuario = null;
            }
            pstmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //retorna usuario
        return usuario;
    }

    
    
    
     public Usuario selectPerfil(Usuario usuario) {
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECTPERFIL);
            pstmt.setString(1, usuario.getLogin());
            ResultSet rs = pstmt.executeQuery();
//roda result seta comparando valores
            if (rs.next()) {
                usuario.setPerfilAcesso(rs.getString("perfilacesso"));
            } else {

                usuario = null;
            }
            pstmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //retorna usuario
        return usuario;
    }
    
    

    
        //Salva todas as informações do usuario.
    public void salvar(Usuario usuario) {
        Connection conexao = null;
        ResultSet rs = null;
        try {
            conexao = ConectaBanco.getConexao();

            PreparedStatement pst = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, usuario.getEmail());
            pst.setString(2, usuario.getLogin());
            pst.setString(3, usuario.getSenha());
            pst.setString(4, usuario.getPerfilAcesso());
            pst.setBoolean(5, usuario.isPrimeiroAcesso());
            pst.execute();
            rs = pst.getGeneratedKeys();

            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Consulta por Email 
    public Usuario consultaPorEmail(String email) {
        Connection conexao = null;
        Usuario usuario = null;

        try {

            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(consulta_email);

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Usuario user = new Usuario();

                user.setEmail(rs.getString("email"));
                user.setLogin(rs.getString("login"));

                usuario = user;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
        return usuario;
    }

    //Altera a SENHA.
    public void atualizaSenha(Usuario usuario) {
        Connection conexao = null;
        conexao = ConectaBanco.getConexao();

        try {

            PreparedStatement pstmt = conexao.prepareStatement(atualiza_senha);

            pstmt.setString(1, usuario.getSenha());
            pstmt.setString(2, usuario.getEmail());
            pstmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
