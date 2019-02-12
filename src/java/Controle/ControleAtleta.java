package Controle;

import DAO.AtletaDAO;
import Modelo.Atleta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControleAtleta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        AtletaDAO atletaDAO = new AtletaDAO();
        Atleta atleta = new Atleta();
        if (acao.equals("listarAtleta")) {
//          Seta atributo ID para recuperar
            atleta.setIdpessoa(Integer.parseInt(request.getParameter("id")));

            atleta = atletaDAO.consultaIdPessoa(atleta);
            

            atletaDAO.mostraAtletaIdPessoa(atleta);
            request.setAttribute("atleta", atleta);     //atribui o atributo pessoa.
            RequestDispatcher rd = request.getRequestDispatcher("Atleta/lista-atleta.jsp"); // manda pra lista
            rd.forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Cria o atributo acao
        String acao = request.getParameter("acao");
        AtletaDAO atletaDAO = new AtletaDAO();
        Atleta atleta = new Atleta();

        // Cadastro do a com os parametros de id_pessoa recuperados pela tabela
        if (acao.equals("salvarAtleta")) {

            Integer id = Integer.parseInt(request.getParameter("id_pessoa"));//Seta atributo ID para recuperar
            atleta.setIdpessoa(id);

            atleta.setObjetivo(request.getParameter("objetivo"));
            atleta.setAlimentacao(request.getParameter("alimentacao"));
            atleta.setSituacaoMatricula(false);
            atletaDAO.cadastrarAtleta(atleta);

            request.setAttribute("atleta", atleta);
            request.getRequestDispatcher("Atleta/bem-vindo.jsp").forward(request, response);

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
