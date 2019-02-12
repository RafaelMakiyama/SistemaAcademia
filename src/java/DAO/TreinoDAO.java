package DAO;

import Modelo.Atleta;
import Modelo.Treino;
import Util.ConectaBanco;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TreinoDAO {

    // códigos do banco de dados
    private static final String INSERT = "INSERT INTO treino(idatleta, tipotreinamento, tempo, series, nome_exercicio, data) VALUES (?, ?, ?, ?, ?,?);";
    private static final String LISTA = "SELECT * from treino where idatleta = ?  ORDER BY data ";
    private static final String UPDATE = "UPDATE treino set nome_exercicio = ? , tipotreinamento = ?, series = ?, tempo = ? WHERE id=?";
    private static final String DELETE = "DELETE from treino WHERE id = ?";

    private static final String BUSCA = "SELECT * FROM treino WHERE id= ?";

    //Função Cadastrar Treinamento. OK
    public void cadastrar(Treino treino) {
        try {
            Connection connection = ConectaBanco.getConexao();
            {
                PreparedStatement pstmt = connection.prepareStatement(INSERT);
                //Recuperando valores e inserindo eles.
                pstmt.setInt(1, treino.getAtleta().getId());
                pstmt.setString(2, treino.getTipoTreinamento());
                pstmt.setDouble(3, treino.getTempo());
                pstmt.setString(4, treino.getSeries());
                pstmt.setString(5, treino.getExercicioNome());
                pstmt.setDate(6, treino.getData());
                //executando a função.
                pstmt.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    //Função Listar Treinamentos por Id.  OK
    public List<Treino> lista(Treino treino) {

        try {
            Connection Conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = Conexao.prepareStatement(LISTA);
            pstmt.setInt(1, treino.getAtleta().getId());

            ResultSet rs = pstmt.executeQuery();
            List<Treino> listaTreino = new ArrayList<Treino>();

            while (rs.next()) {
                Treino novoTreino = new Treino();
                Atleta atleta = new Atleta();
                novoTreino.setId(rs.getInt("id"));
                atleta.setId(rs.getInt("idatleta"));
                
                
                novoTreino.setTipoTreinamento(rs.getString("tipoTreinamento"));
                novoTreino.setTempo(rs.getInt("tempo"));
                novoTreino.setSeries(rs.getString("series"));
                novoTreino.setExercicioNome(rs.getString("nome_exercicio"));
                novoTreino.setData(rs.getDate("data"));

                novoTreino.setAtleta(atleta);
                listaTreino.add(novoTreino);

                Conexao.close();
            }

            return listaTreino;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    //Consultar por ID. OK
    public Treino consultaPorId(Treino treino) {

        try {

            Connection Conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = Conexao.prepareStatement(BUSCA);

            pstmt.setInt(1, treino.getId());
            ResultSet rs = pstmt.executeQuery();
            Atleta atleta = new Atleta();
            if (rs.next()) {
                treino.setId(rs.getInt("id"));                
                atleta.setId(rs.getInt("idatleta"));
                
                treino.setAtleta(atleta);
                treino.setId(rs.getInt("idatleta"));
                treino.setExercicioNome(rs.getString("nome_exercicio"));
                treino.setTipoTreinamento(rs.getString("tipoTreinamento"));
                treino.setTempo(rs.getInt("tempo"));
                treino.setSeries(rs.getString("series"));
            }

            return treino;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Função Atualizar Treinamento.
    public void Atualizar(Treino treino) {
        try {
            Connection connection = ConectaBanco.getConexao();
            {
                PreparedStatement pstmt = connection.prepareStatement(UPDATE);
                //Recuperando valores e inserindo eles.
                pstmt.setString(1, treino.getExercicioNome());
                pstmt.setString(2, treino.getTipoTreinamento());
                pstmt.setString(3, treino.getSeries());
                pstmt.setDouble(4, treino.getTempo());
                pstmt.setInt(5, treino.getId());
                //executando a função.
                
                pstmt.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



//    //Excluindo por ID
    public void excluir(Treino treino) {
        try {
            Connection Conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = Conexao.prepareStatement(DELETE);

            
            pstmt.setInt(1, treino.getId());
            pstmt.execute();          

            Conexao.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

}
}