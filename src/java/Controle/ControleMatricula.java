package Controle;

import DAO.MatriculaDAO;
import DAO.UsuarioDAO;
import Modelo.Atleta;
import Modelo.Matricula;
import Modelo.Personal;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControleMatricula extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String acao = request.getParameter("acao");
        //cria um novo usuario
        UsuarioDAO dao = new UsuarioDAO();
        MatriculaDAO matriculaDAO = new MatriculaDAO();
        Atleta atleta = new Atleta();
        Personal personal = new Personal();

        if (acao.equals("listarNaoMatriculados")) {
            List<Atleta> listaAtleta = matriculaDAO.listarAtletaNaoMatriculado();
            request.setAttribute("listaAtleta", listaAtleta);

            //envia o request para o jsp lista           
            RequestDispatcher rd = request.getRequestDispatcher("Personal/cadastrar-atleta.jsp");
            rd.forward(request, response);

        } else if (acao.equals("meusAtletas")) {
            
            Usuario usuario = new Usuario();
            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            usuario.setIdUsuario(idUsuario);
            personal.setUsuario(usuario);

            matriculaDAO.consultaIdPessoa(personal);
            
          List<Atleta> listaAtleta = matriculaDAO.listarAtletaMatriculado(personal);

            
            
            request.setAttribute("listaAtleta", listaAtleta);

            RequestDispatcher rd = request.getRequestDispatcher("Personal/meus-atletas.jsp");
            rd.forward( request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String acao = request.getParameter("acao");
//      cria um novo usuario
        MatriculaDAO matriculaDAO = new MatriculaDAO();
        Atleta atleta = new Atleta();
        UsuarioDAO dao = new UsuarioDAO();
        Personal personal = new Personal();

        if (acao.equals("cadastrarMatricula")) {
//          Recupera id de Atleta
            Integer id = Integer.parseInt(request.getParameter("id"));
            atleta.setId(id);
            matriculaDAO.Atualizar(atleta);
//          Recupera id de Usuário.
            Usuario usuario = new Usuario();
            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            usuario.setIdUsuario(idUsuario);
            personal.setUsuario(usuario);

            
//            Personal pega as informações de Usuário(idUsuario) e as consulta, trazendo informações de Personal.
            
            matriculaDAO.consultaIdPessoa(personal);
            matriculaDAO.cadastrarMatricula(atleta, personal);

            RequestDispatcher rd = request.getRequestDispatcher("Personal/bem-vindo.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
