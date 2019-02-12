package Controle;

import DAO.AtletaDAO;
import DAO.MatriculaDAO;
import DAO.TreinoDAO;
import Modelo.Atleta;
import Modelo.Personal;
import Modelo.Treino;
import Modelo.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControleTreino extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");

        TreinoDAO treinoDAO = new TreinoDAO();
        Personal personal = new Personal();
        Treino treino = new Treino();
        Usuario usuario = new Usuario();
        Atleta atleta = new Atleta();
        MatriculaDAO matriculaDAO = new MatriculaDAO();

        HttpSession sessaoUsuario = request.getSession();

        if (acao.equals("meusAtletas")) {

            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            usuario.setIdUsuario(idUsuario);
            personal.setUsuario(usuario);

            matriculaDAO.consultaIdPessoa(personal);

            List<Atleta> listaAtleta = matriculaDAO.listarAtletaMatriculado(personal);

            request.setAttribute("listaAtleta", listaAtleta);

            RequestDispatcher rd = request.getRequestDispatcher("Personal/meus-atletas-treino.jsp");
            rd.forward(request, response);

        } else if (acao.equals("consultar")) {

            atleta.setId(Integer.parseInt(request.getParameter("atletaId")));

            request.setAttribute("atleta", atleta);

            RequestDispatcher rd = request.getRequestDispatcher("Personal/cadastrar-treino.jsp");
            rd.forward(request, response);
        } else if (acao.equals("listarTreinoAtleta")) {

            atleta.setId(Integer.parseInt(request.getParameter("atletaId")));

            treino.setAtleta(atleta);

            List<Treino> listaTreino = treinoDAO.lista(treino);
            request.setAttribute("listaTreino", listaTreino);

            //envia o request para o jsp lista         
            request.getRequestDispatcher("Personal/lista-treino.jsp").forward(request, response);

        } else if (acao.equals("listarMeuTreinamento")) {
            AtletaDAO atletaDAO = new AtletaDAO();
            atleta.setIdpessoa(Integer.parseInt(request.getParameter("id")));

            atleta = atletaDAO.consultaIdPessoa(atleta);
            atletaDAO.mostraAtletaIdPessoa(atleta);

            treino.setAtleta(atleta);

            List<Treino> listaTreino = treinoDAO.lista(treino);
            request.setAttribute("listaTreino", listaTreino);

            //envia o request para o jsp lista         
            request.getRequestDispatcher("Atleta/lista-treino.jsp").forward(request, response);

// Consulta Treino para Atualizar.
        } else if (acao.equals("consultaTreino")) {

            treino.setId(Integer.parseInt(request.getParameter("id")));

            Treino treino2 = treinoDAO.consultaPorId(treino);

            request.setAttribute("treino", treino2);

            RequestDispatcher rd = request.getRequestDispatcher("Personal/editar-treino.jsp");
            rd.forward(request, response);
        } else if (acao.equals("Excluir")) {
            Treino treinoExcluir = new Treino();
            treinoExcluir.setId(Integer.parseInt(request.getParameter("idTreino")));

            atleta.setId(Integer.parseInt(request.getParameter("idAtleta")));

            treinoDAO.excluir(treinoExcluir);

            treinoExcluir.setAtleta(atleta);
            List<Treino> listaTreino = treinoDAO.lista(treinoExcluir);

            //add a lista no request
            request.setAttribute("listaTreino", listaTreino);

            //envia o request para o jsp lista         
            request.getRequestDispatcher("Personal/lista-treino.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        TreinoDAO treinoDAO = new TreinoDAO();
        Treino treino = new Treino();
        Atleta atleta = new Atleta();
        HttpSession sessaoUsuario = request.getSession();

        // FUNCIONANDO
        if (acao.equals("Cadastrar")) {

            try {

                //Recuperando valores digitado no formulário.
                int idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
                double tempo = Double.parseDouble(request.getParameter("tempo"));
                String txtData = request.getParameter("txtData");

                Date data = new SimpleDateFormat("dd/MM/yyyy").parse(txtData);

                java.sql.Date dataSql = new java.sql.Date(data.getTime());
                
                atleta.setId(idAtleta);
             
//          set Atleta em Treino
                treino.setAtleta(atleta);
                treino.setTipoTreinamento(request.getParameter("tipoTreinamento"));
                treino.setTempo(tempo);
                treino.setSeries(request.getParameter("series"));
                treino.setExercicioNome(request.getParameter("nomeExercicio"));
                treino.setData(dataSql);

                //envia o request para o jsp lista
                treinoDAO.cadastrar(treino);

                treino.setAtleta(atleta);
                List<Treino> listaTreino = treinoDAO.lista(treino);

                //add a lista no request
                request.setAttribute("listaTreino", listaTreino);

                RequestDispatcher rd = request.getRequestDispatcher("Personal/lista-treino.jsp");
                rd.forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ControleTreino.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (acao.equals("Atualizar")) {
            //Recuperando valores digitado no formulário.

            int idTreino = Integer.parseInt(request.getParameter("idTreino"));
            int idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
            double tempo = Integer.parseInt(request.getParameter("tempo"));

            treino.setId(idTreino);
            atleta.setId(idAtleta);

//          set Atleta em Treino
            treino.setAtleta(atleta);
            treino.setTipoTreinamento(request.getParameter("tipoTreinamento"));
            treino.setTempo(tempo);
            treino.setSeries(request.getParameter("series"));
            treino.setExercicioNome(request.getParameter("nomeExercicio"));

            treinoDAO.Atualizar(treino);

            treinoDAO.lista(treino);

            List<Treino> listaTreino = treinoDAO.lista(treino);

            //add a lista no request
            request.setAttribute("listaTreino", listaTreino);

            //envia o request para o jsp lista         
            request.getRequestDispatcher("Personal/lista-treino.jsp").forward(request, response);

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
