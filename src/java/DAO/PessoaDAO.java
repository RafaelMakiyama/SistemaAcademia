package DAO;

import Modelo.Endereco;
import Modelo.Pessoa;
import Modelo.Usuario;
import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDAO {

//    Código SQL
    private static final String INSERT = "INSERT INTO pessoa(id_usuario, id_endereco, nome, sexo, telefone, celular) VALUES (?, ?, ?, ?, ?, ?);";
//    INSERT pessoa.
    private static final String PRIMEIROACESSO = "Update usuario set primeiroacesso = FALSE WHERE idusuario = ?;";
//    Seta columa primeiro acesso = false.
    private static final String BUSCA_ID = "select * from pessoa WHERE id_usuario = ? ;";
//    Busca informações de pessoa com id_usuario ( MOTIVO:Não tem dados recebidos de pessoa ainda) ;
    private static final String BUSCA_ID_PESSOA = "select * from pessoa WHERE id = ? ;";
//    Busca informações de pessoa com id_pessoa (MOTIVO: Já possui dados de pessoa em listainformacao.jsp e precisa apenas coletar esses dados. 

    private static final String BUSCA_ID_ENDERECO = "select e.id, e.logradouro, e.complemento, e.bairro, e.cidade, e.uf, p.id_endereco from endereco as e, pessoa as p where  e.id = ? 2 AND p.id_endereco = ?;";
    private static final String UPDATE_PESSOA = "UPDATE pessoa set nome = ? , sexo = ? , telefone = ? ,celular=? where id_usuario = ? ;";

//    CREAT: Cadastro de informações pessoais e usuários.
    public void cadastrarPessoa(Pessoa pessoa) {
        try {
            Connection conexao = null;
            ResultSet rs = null;
            conexao = ConectaBanco.getConexao();

            PreparedStatement pst = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, pessoa.getUsuario().getIdUsuario());
            pst.setInt(2, pessoa.getEndereco().getId());
            pst.setString(3, pessoa.getNome());
            pst.setString(4, pessoa.getSexo());
            pst.setString(5, pessoa.getTelefone());
            pst.setString(6, pessoa.getCelular());
            rs = pst.getGeneratedKeys();
            pst.execute();

        } catch (SQLException ex) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    UPDATE: Altera o atributo primeiroacesso para falso em Usuário.
    public void primeiroAcesso(Pessoa pessoa) {
        try {
            Connection conexao = null;
            ResultSet rs = null;
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(PRIMEIROACESSO);
            pstmt.setInt(1, pessoa.getUsuario().getIdUsuario());

            rs = pstmt.executeQuery();
            if (rs.next()) {
                pessoa.getUsuario().setPrimeiroAcesso(rs.getBoolean("primeiroacesso"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    READ: Lista todos os atributos de Pessoa.
    public Pessoa listaPessoa(Pessoa pessoa) {

        try {
            Connection conexao = null;
            ResultSet rs = null;
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(BUSCA_ID);
            pstmt.setInt(1, pessoa.getUsuario().getIdUsuario());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                pessoa.setIdpessoa(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setCelular(rs.getString("celular"));;

            }

            return pessoa;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

//    READ:  Consulta Informações de Pessoa com ID de Usuário.
    public Pessoa consultaIdUsuario(Pessoa pessoa) {

        try {
            Connection conexao = null;
            ResultSet rs = null;
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(BUSCA_ID);
            pstmt.setInt(1, pessoa.getIdPessoa());
            rs = pstmt.executeQuery();

            Endereco endereco = new Endereco();

            if (rs.next()) {
                pessoa.setIdpessoa(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setCelular(rs.getString("celular"));
                pessoa.setEndereco(endereco);
                pessoa.getEndereco().setId(rs.getInt("id_endereco"));

            }

            return pessoa;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Pessoa consultaIdPessoa(Pessoa pessoa) {

        try {
            Connection conexao = null;
            ResultSet rs = null;
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(BUSCA_ID_PESSOA);
            pstmt.setInt(1, pessoa.getIdPessoa());
            rs = pstmt.executeQuery();

            Endereco endereco = new Endereco();

            if (rs.next()) {
                pessoa.setIdpessoa(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setCelular(rs.getString("celular"));
                pessoa.setEndereco(endereco);
                pessoa.getEndereco().setId(rs.getInt("id_endereco"));

            }

            return pessoa;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Pessoa atualizarPessoa(int id, Pessoa pessoa) {

        try {
            Connection conexao = null;
            ResultSet rs = null;
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE_PESSOA);

            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getSexo());
            pstmt.setString(3, pessoa.getTelefone());
            pstmt.setString(3, pessoa.getCelular());
            pstmt.setInt(4, id);

            //Executa
            pstmt.execute();

            Endereco endereco = new Endereco();
            if (rs.next()) {
                endereco.setId(rs.getInt("id_endereco"));

            }
            // pessoa.setEndereco(endereco);

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pessoa;

    }

}
