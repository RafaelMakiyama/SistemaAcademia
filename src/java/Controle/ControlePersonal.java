package Controle;

import DAO.PersonalDAO;
import Modelo.Personal;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControlePersonal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Cria o atributo acao
        String acao = request.getParameter("acao");
        PersonalDAO personalDAO = new PersonalDAO();

        // Lista as informações de Personal trainner consultando pelo (id);
        if (acao.equals("listaPersonal")) {

            Integer idEdicao = Integer.parseInt(request.getParameter("id")); // Pega o Id do Usuario

            Personal personal = personalDAO.pesquisaIdPessoa(idEdicao);

            personalDAO.pesquisaIdPersonal(personal);

            request.setAttribute("personal", personal);     //atribui o atributo pessoa.
            RequestDispatcher rd = request.getRequestDispatcher("Personal/lista-personal.jsp"); // manda pra lista
            rd.forward(request, response);

        } // Edita as informações de acordo com o (id);
        else if (acao.equals("editar")) {
                Integer idEdicao = Integer.parseInt(request.getParameter("id")); // Pega o Id do Usuario

            Personal personal = new Personal();
            personal.setMatricula(idEdicao);
            personalDAO.mostraPersonalIdMatricula(personal);

            request.setAttribute("personal", personal);     //atribui o atributo pessoa.
            RequestDispatcher rd = request.getRequestDispatcher("Personal/editar-personal.jsp"); // manda pra lista
            rd.forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Cria o atributo acao
        String acao = request.getParameter("acao");
        PersonalDAO personalDAO = new PersonalDAO();

        // Cadastro do personal com os parametros de id_pessoa recuperados pela tabela
        if (acao.equals("salvarPersonal")) {
            
            //Criação de todos os objetos
            Personal personal = new Personal();
            Usuario usuario = new Usuario();
            
            
            personal.setInstituicao(request.getParameter("instituicao"));
            personal.setCurso(request.getParameter("curso"));
            personal.setMetodos(request.getParameter("metodo"));

            Integer id = Integer.parseInt(request.getParameter("id_pessoa"));//Seta atributo ID para recuperar
            personal.setIdpessoa(id);
            personalDAO.cadastrarPersonal(personal);
            request.setAttribute("personal", personal);        
            usuario.setPrimeiroAcesso(true);
            HttpSession sessaoUsuario = request.getSession();
            sessaoUsuario.setAttribute("usuario", usuario);
            request.getRequestDispatcher("Personal/lista-personal.jsp").forward(request, response);

        } else if (acao.equals("atualizarPersonal")) {

            String instituicao = request.getParameter("instituicao");
            String curso = request.getParameter("curso");
            String metodos = request.getParameter("metodos");
            int matricula = Integer.parseInt(request.getParameter("idMatricula"));

            Personal personal = new Personal();
            personal.setInstituicao(instituicao);
            personal.setCurso(curso);
            personal.setMetodos(metodos);
            personal.setMatricula(matricula);

            personalDAO.Atualizar(personal);
            personalDAO.pesquisaIdPersonal(personal);

            request.setAttribute("personal", personal);     //atribui o atributo pessoa.
            RequestDispatcher rd = request.getRequestDispatcher("Personal/lista-personal.jsp"); // manda pra lista
            rd.forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
