    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ExameFisico;
import Modelo.Treino;
import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class ExameFisicoDAO {

    //parametros de busca
    private static final String INSERT = "INSERT INTO examefisico(altura, peso, peito, cintura, panturrilhaesquerda,"
            + " panturrilhadireita, bracoesquerdo, bracodireito, antebracoesquerdo,antebracodireito, gluteo, idatleta) "
            + " VALUES ( ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,? )";
    private static final String LISTA = "SELECT * from examefisico where idatleta = ?  ORDER BY idexame ASC";
    private static final String BUSCA = "SELECT * FROM examefisico WHERE idexame= ?";
    private static final String DELETE = "DELETE from examefisico WHERE idexame = ?";
    private static final String UPDATE = "UPDATE examefisico   SET  altura=?, peso=?,  peito=?, cintura=?, "
            + "panturrilhaesquerda=?,  panturrilhadireita=?, bracoesquerdo=?, bracodireito=?, antebracoesquerdo=?, "
            + "antebracodireito=?, gluteo=? WHERE idexame= ?";

    public void cadastrar(ExameFisico exameFisico) {
        try {
            Connection connection = ConectaBanco.getConexao();
            {
                PreparedStatement pstmt = connection.prepareStatement(INSERT);

                //Recupera os valores pra inserção
                pstmt.setDouble(1, exameFisico.getAltura());
                pstmt.setDouble(2, exameFisico.getPeso());
                pstmt.setDouble(3, exameFisico.getPeito());
                pstmt.setDouble(4, exameFisico.getCintura());
                pstmt.setDouble(5, exameFisico.getPantEsquerda());
                pstmt.setDouble(6, exameFisico.getPantDireita());
                pstmt.setDouble(7, exameFisico.getBracoEsquerdo());
                pstmt.setDouble(8, exameFisico.getBracoDireito());
                pstmt.setDouble(9, exameFisico.getAntEsquerdo());
                pstmt.setDouble(10, exameFisico.getAntDireito());
                pstmt.setDouble(11, exameFisico.getGluteo());
                pstmt.setDouble(12, exameFisico.getAtleta().getId());

                //Executa a Função
                pstmt.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Lista
    public List<ExameFisico> lista(ExameFisico exame) {

        try {//Abre a conexão
            Connection Conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = Conexao.prepareStatement(LISTA);
            
            pstmt.setInt(1, exame.getAtleta().getId());
            ResultSet rs = pstmt.executeQuery();

            //Abre um atributo do tipo list
            List<ExameFisico> listaExame = new ArrayList<ExameFisico>();
            //Roda com o RESULT SET setando as variaveis
            while (rs.next()) {
                ExameFisico exameFisico = new ExameFisico();

                exameFisico.setIdExame(rs.getInt("idexame"));
                exameFisico.setAltura(rs.getDouble("altura"));
                exameFisico.setPeito(rs.getDouble("peito"));
                exameFisico.setPeso(rs.getDouble("peso"));
                exameFisico.setCintura(rs.getDouble("cintura"));
                exameFisico.setPantEsquerda(rs.getDouble("panturrilhaesquerda"));
                exameFisico.setPantDireita(rs.getDouble("panturrilhadireita"));
                exameFisico.setBracoEsquerdo(rs.getDouble("bracoesquerdo"));
                exameFisico.setBracoDireito(rs.getDouble("bracodireito"));
                exameFisico.setAntEsquerdo(rs.getDouble("antebracoesquerdo"));
                exameFisico.setAntDireito(rs.getDouble("antebracodireito"));
                exameFisico.setGluteo(rs.getDouble("gluteo"));

                listaExame.add(exameFisico);
                Conexao.close();

            }

            return listaExame;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //consulta por um determinado id
    public ExameFisico consultaPorId(int id) {

        try {
            Connection Conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = Conexao.prepareStatement(BUSCA);

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            //cria objeto e pega os objetos no banco.
            ExameFisico exameFisico = new ExameFisico();
            if (rs.next()) {

                exameFisico.setIdExame(rs.getInt("idexame"));
                exameFisico.setAltura(rs.getDouble("altura"));
                exameFisico.setPeito(rs.getDouble("peito"));
                exameFisico.setPeso(rs.getDouble("peso"));
                exameFisico.setCintura(rs.getDouble("cintura"));
                exameFisico.setPantEsquerda(rs.getDouble("panturrilhaesquerda"));
                exameFisico.setPantDireita(rs.getDouble("panturrilhadireita"));
                exameFisico.setBracoEsquerdo(rs.getDouble("bracoesquerdo"));
                exameFisico.setBracoDireito(rs.getDouble("bracodireito"));
                exameFisico.setAntEsquerdo(rs.getDouble("antebracoesquerdo"));
                exameFisico.setAntDireito(rs.getDouble("antebracodireito"));
                exameFisico.setGluteo(rs.getDouble("gluteo"));
            }
            //retorno do objeto
            return exameFisico;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //atualizar
    public void Atualizar(ExameFisico exameFisico) {
        try {
            Connection connection = ConectaBanco.getConexao();
            {
                PreparedStatement pstmt = connection.prepareStatement(UPDATE);

                //Recupera os valores pra inserção
                pstmt.setDouble(1, exameFisico.getAltura());
                pstmt.setDouble(2, exameFisico.getPeso());
                pstmt.setDouble(3, exameFisico.getPeito());
                pstmt.setDouble(4, exameFisico.getCintura());
                pstmt.setDouble(5, exameFisico.getPantEsquerda());
                pstmt.setDouble(6, exameFisico.getPantDireita());
                pstmt.setDouble(7, exameFisico.getBracoEsquerdo());
                pstmt.setDouble(8, exameFisico.getBracoDireito());
                pstmt.setDouble(9, exameFisico.getAntEsquerdo());
                pstmt.setDouble(10, exameFisico.getAntDireito());
                pstmt.setDouble(11, exameFisico.getGluteo());
                pstmt.setDouble(12, exameFisico.getIdExame());
                //executando a função.
                pstmt.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Excluindo por ID
    public void excluir(ExameFisico exame) {
        try {
            Connection Conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = Conexao.prepareStatement(DELETE);
            pstmt.setInt(1, exame.getIdExame() );
            pstmt.execute();
            Conexao.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
