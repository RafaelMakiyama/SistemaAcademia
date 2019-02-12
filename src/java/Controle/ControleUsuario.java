    package Controle;

import DAO.UsuarioDAO;
import Modelo.JavaMail;
import Modelo.Usuario;
import Modelo.GeradorSenhas;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControleUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // recupera a ação do Usuario e armazena na variavel acao.
        
        PrintWriter out = response.getWriter();
        String acao = request.getParameter("acao");
        //cria um novo usuario
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();

        if (acao.equals("validar")) {
            //Pega os parametros
            String login = request.getParameter("txtLogin");
            String senha = request.getParameter("txtSenha");

            //setando parametros
            usuario.setLogin(login);
            usuario.setSenha(senha);

            //autenticação
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuarioAutenticado = usuarioDAO.validar(usuario);

            if (usuarioAutenticado != null) {
                HttpSession sessaoUsuario = request.getSession();
                sessaoUsuario.setAttribute("usuario", usuarioAutenticado);

                usuarioDAO.selectPerfil(usuarioAutenticado);

                switch (usuarioAutenticado.getPerfilAcesso()) {
                    case "Personal":
                        response.sendRedirect("Personal/bem-vindo.jsp");
                        break;
                    case "Atleta":
                        response.sendRedirect("Atleta/bem-vindo.jsp");
                        break;
                }
            } else {
                //não autorizado 
                request.setAttribute("falhalogin", "true");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);

            }
        } else if (acao.equals("logout")) {
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        } 
    }

        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String acao = request.getParameter("acao");
            UsuarioDAO dao = new UsuarioDAO();
            if (acao.equals("salvarUsuario")) {

                String Email = (request.getParameter("txtEmail"));
                //cria objeto
                Usuario usuario = new Usuario();
                //seta parametros
                usuario.setEmail(Email);
                
                
                
                
                
                usuario.setLogin(request.getParameter("txtLogin"));
                usuario.setSenha(request.getParameter("txtSenha"));
                usuario.setPerfilAcesso(request.getParameter("txtPerfil"));
                usuario.setPrimeiroAcesso(true);

            //Cria o objeto JavaMail
                // JavaMail envio = new JavaMail();
                //Chama o metodo sendEmail
                // envio.sendEmail("Email ca");
                if (usuario.getIdUsuario() == 0) {
                    //salva usuario na dao.
                    dao.salvar(usuario);
                    //manda para a index.
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    // usuario não salvo
                    response.sendRedirect("ControleUsuario");
                }
            } else if (acao.equals("AtualizarSenha")) {

                String Email = (request.getParameter("txtEmail"));
                Usuario usuario = new Usuario();
                usuario.setEmail(Email);

                dao.consultaPorEmail(Email);

                if (usuario != null) {
                    String login = usuario.getLogin();

                    GeradorSenhas gerador = new GeradorSenhas();
                    String newSenha = gerador.gerarSenhas();

                    usuario.setSenha(newSenha);
                    dao.atualizaSenha(usuario);

                    //Enviar email
                    String subject = "Alteração de senha";
                    String quebraLinha = System.getProperty("line.separator");
                    String msg = login + "," + quebraLinha + "Sua senha foi alterada com Sucesso, a nova senha é: " + newSenha;

                    JavaMail enviar = new JavaMail();
                    enviar.sendEmail(Email, subject, msg);
                //fim envio de Email
                    //fim envio de Email

                    request.setAttribute("senhaComSucesso", "true");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                } else {

                    request.setAttribute("senhaSemSucesso", "true");
                    RequestDispatcher rd = request.getRequestDispatcher("reset-senha.jsp");
                    rd.forward(request, response);

                }
            }

        }

        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }
    }
