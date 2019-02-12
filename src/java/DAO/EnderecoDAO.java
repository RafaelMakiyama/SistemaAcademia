package DAO;

import Modelo.Endereco;
import Modelo.Pessoa;
import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDAO {

    private static final String INSERT = "INSERT INTO endereco(cep,uf,cidade,bairro,logradouro,complemento) VALUES ( ?, ?, ?, ?, ?, ?); ";
    
    private static final String SELECT = "select endereco.cep, endereco.uf,"
            + "endereco.cidade, endereco.bairro, endereco.logradouro,endereco.complemento from endereco "
            + "inner join  pessoa on (pessoa.id_endereco = idendereco) "
            + "where pessoa.id_endereco = ?;";

    private static final String UPDATE = "UPDATE endereco SET  logradouro= ?, complemento= ? , bairro=? ,cidade=?, uf=? WHERE id = ?;";

//Salva todas as informações do usuario.
    public Endereco cadastrar(Endereco endereco) {
        Connection conexao = null;
        ResultSet rs = null;
        try {
            conexao = ConectaBanco.getConexao();

            PreparedStatement pst = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, endereco.getCep());
            pst.setString(2, endereco.getUf());
            pst.setString(3, endereco.getCidade());
            pst.setString(4, endereco.getBairro());
            pst.setString(5, endereco.getLogradouro());
            pst.setString(6, endereco.getComplemento());
            pst.execute();
            rs = pst.getGeneratedKeys();

            if (rs.next()) {
                endereco.setId(rs.getInt("idendereco"));

            } else {

                endereco = null;
            }
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return endereco;
    }

    public Endereco consultaId(Endereco endereco) {

        try {
            Connection conexao = null;
            ResultSet rs = null;
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT);
            pstmt.setInt(1, endereco.getId() );
            rs = pstmt.executeQuery();

            if (rs.next()) {
                endereco.setCep(rs.getString("cep"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setUf(rs.getString("uf"));
            }

            return endereco;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Endereco atualizarEndereco(Endereco endereco) {
        Connection conexao = null;
        ResultSet rs = null;
        try {
            conexao = ConectaBanco.getConexao();

            PreparedStatement pst = conexao.prepareStatement(UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, endereco.getLogradouro());
            pst.setString(2, endereco.getComplemento());
            pst.setString(3, endereco.getBairro());
            pst.setString(4, endereco.getCidade());
            pst.setString(5, endereco.getUf());
            pst.setInt(6, endereco.getId());
            pst.execute();
            rs = pst.getGeneratedKeys();

            if (rs.next()) {
                endereco.setId(rs.getInt("id"));

            } else {

                endereco = null;
            }
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return endereco;

    }

}
