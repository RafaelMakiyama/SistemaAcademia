package DAO;

import Modelo.Atleta;
import Modelo.Endereco;
import Modelo.Matricula;
import Modelo.Personal;
import Modelo.Pessoa;
import Modelo.Usuario;
import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MatriculaDAO {

    //Scripts
//    Inserir em Matricula pegando id atleta e id personal
    private static final String insert = "INSERT INTO matricula(idatleta, idpersonal) VALUES (?, ?);";
//    Atualiza atleta sentado a coluna matriulado como verdadeiro.
    private static final String inserirSituacaoAtleta = "UPDATE atleta SET matriculado = true WHERE id = ? ;";
//    lista os Atletas matriculadas no Personal.
    private static final String atletasMatriculados = "select pessoa.nome, pessoa.sexo,  atleta.objetivo, atleta.alimentacao,atleta.id from atleta "
            + "inner join pessoa on ( atleta.idpessoa = pessoa.id) "
            + "inner join matricula on ( matricula.idatleta = atleta.id and matricula.idpersonal = ? );";
//    Lista os Atletas sem Matriculas alguma
    private static final String atletasSemMatricula = "select pessoa.nome, pessoa.sexo,  atleta.objetivo, atleta.alimentacao,atleta.id, endereco.logradouro, endereco.bairro, endereco.cidade, endereco.uf"
            + "           from atleta\n"
            + "           inner join pessoa on ( atleta.idpessoa = pessoa.id)\n"
            + "           inner join endereco on ( endereco.idendereco = pessoa.id_endereco and atleta.matriculado= false);";

    private static final String select = "select personal.matricula from personal, pessoa where pessoa.id_usuario = ? and pessoa.id = personal.idpessoa;";

 //   private static final String listaAtletasMatriculados = "select matricula.idatleta, atleta.id, atleta.idpessoa, pessoa.id from matricula , atleta, pessoa  where atleta.id = matricula.idatleta and atleta.idpessoa = pessoa.id and matricula.idpersonal = ?;";

    Connection conexao = null;
    ResultSet rs = null;

//      INSERT: Cadastrar a matricula do Atleta com os parametros de Personal e Atleta.
    public void cadastrarMatricula(Atleta atleta, Personal personal) {
        try {
            conexao = ConectaBanco.getConexao();

            PreparedStatement pst = conexao.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, atleta.getId()); //parametro do idatleta
            pst.setInt(2, personal.getMatricula()); //parametro do idpersona
            rs = pst.getGeneratedKeys();
            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//      UPDATE: Atualiza a situação do atleta para true   
    public void Atualizar(Atleta atleta) {
        try {
            Connection connection = ConectaBanco.getConexao();
            {
                PreparedStatement pstmt = connection.prepareStatement(inserirSituacaoAtleta);

                //Recupera os valores pra inserção
                pstmt.setInt(1, atleta.getId());
                //executando a função.
                pstmt.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //SELECT: Lista de todos os atletas que não estão matriculados.
    public ArrayList<Atleta> listarAtletaNaoMatriculado() {

        ArrayList<Atleta> listaAtleta = new ArrayList();
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(atletasSemMatricula);
            ResultSet rs = pstmt.executeQuery();
//roda result seta comparando valores
            while (rs.next()) {

                Atleta atleta = new Atleta();
                atleta.setNome(rs.getString("nome"));
                atleta.setSexo(rs.getString("sexo"));
                atleta.setObjetivo(rs.getString("objetivo"));
                atleta.setAlimentacao(rs.getString("alimentacao"));

                atleta.setId(rs.getInt(("id")));

                Endereco endereco = new Endereco();
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setUf(rs.getString("uf"));

                atleta.setEndereco((endereco));
                listaAtleta.add(atleta);
                conexao.close();

            }
            //retorna usuario
            return listaAtleta;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
    
    public ArrayList<Atleta> listarAtletaMatriculado(Personal personal ){

        ArrayList<Atleta> listaAtleta = new ArrayList();
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(atletasMatriculados);
            
            pstmt.setInt(1, personal.getMatricula());
            
            ResultSet rs = pstmt.executeQuery();
//roda result seta comparando valores
            while (rs.next()) {

                Atleta atleta = new Atleta();
                atleta.setNome(rs.getString("nome"));
                atleta.setSexo(rs.getString("sexo"));
                atleta.setObjetivo(rs.getString("objetivo"));
                atleta.setAlimentacao(rs.getString("alimentacao"));
                atleta.setId(rs.getInt(("id")));

             
                listaAtleta.add(atleta);
                conexao.close();

            }
            //retorna usuario
            return listaAtleta;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    
    }
    //SELECT: Consulta o Id da Pessoa dentro da tabela Pessoa.
    public Personal consultaIdPessoa(Personal personal) {
        try {
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(select);

            pstmt.setInt(1, personal.getUsuario().getIdUsuario());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                personal.setMatricula(rs.getInt("matricula"));
            }
            return personal;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //SELECT: Lista de todos os atletas que  estão matriculados.
  

}
