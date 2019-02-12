package Controle;

import DAO.AtletaDAO;
import DAO.ExameFisicoDAO;
import DAO.MatriculaDAO;
import DAO.TreinoDAO;
import Modelo.Atleta;
import Modelo.ExameFisico;
import Modelo.Personal;
import Modelo.Treino;
import Modelo.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 Pronto.    
 */
public class ControleAvaliacaoFisica extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        HttpSession sessaoUsuario = request.getSession();
        Personal personal = new Personal();
        Treino treino = new Treino();
        Usuario usuario = new Usuario();
        Atleta atleta = new Atleta();
        ExameFisico exame = new ExameFisico();

        ExameFisicoDAO exameDAO = new ExameFisicoDAO();
        MatriculaDAO matriculaDAO = new MatriculaDAO();

        if (acao.equals("meusAtletas")) {

            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            usuario.setIdUsuario(idUsuario);
            personal.setUsuario(usuario);

            matriculaDAO.consultaIdPessoa(personal);

            List<Atleta> listaAtleta = matriculaDAO.listarAtletaMatriculado(personal);

            request.setAttribute("listaAtleta", listaAtleta);

            RequestDispatcher rd = request.getRequestDispatcher("Personal/meus-atletas-exame.jsp");
            rd.forward(request, response);
        } else if (acao.equals("Lista")) {

            atleta.setId(Integer.parseInt(request.getParameter("atletaId")));

            exame.setAtleta(atleta);

            List<ExameFisico> listaExame = exameDAO.lista(exame);
            request.setAttribute("listaExame", listaExame);

            //envia o request para o jsp lista         
            request.getRequestDispatcher("Personal/lista-avaliacao-fisica.jsp").forward(request, response);
        } else if (acao.equals("consultar")) {
            //requisição do parametro id
            atleta.setId(Integer.parseInt(request.getParameter("atletaId")));
            request.setAttribute("atleta", atleta);
            RequestDispatcher rd = request.getRequestDispatcher("Personal/cadastrar-avaliacao-fisica.jsp");
            rd.forward(request, response);

        } else if (acao.equals("Excluir")) {
            ExameFisico exameExcluir = new ExameFisico();
            exameExcluir.setIdExame(Integer.parseInt(request.getParameter("idTreino")));

            atleta.setId(Integer.parseInt(request.getParameter("idAtleta")));

            exameDAO.excluir(exameExcluir);

            exameExcluir.setAtleta(atleta);
            List<ExameFisico> listaTreino = exameDAO.lista(exameExcluir);

            //add a lista no request
            request.setAttribute("listaTreino", listaTreino);

            //envia o request para o jsp lista         
            request.getRequestDispatcher("Personal/lista-treino.jsp").forward(request, response);

        } else if (acao.equals("listarAvaliacoes")) {

           
            
              AtletaDAO atletaDAO = new AtletaDAO();
            atleta.setIdpessoa(Integer.parseInt(request.getParameter("id")));

            atleta = atletaDAO.consultaIdPessoa(atleta);
            atletaDAO.mostraAtletaIdPessoa(atleta);

            

            exame.setAtleta(atleta);

            List<ExameFisico> listaExame = exameDAO.lista(exame);
            request.setAttribute("listaExame", listaExame);

            //envia o request para o jsp lista         
            request.getRequestDispatcher("Atleta/lista-avaliacao-fisica.jsp").forward(request, response);
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        ExameFisicoDAO dao = new ExameFisicoDAO();
        Atleta atleta = new Atleta();

        //Cria Sessao para recuperar alguns valores
        HttpSession sessaoUsuario = request.getSession();

        if (acao.equals("Cadastrar")) {

            // Recuperando os valores e colocando nas variáveis
            Double altura = Double.parseDouble(request.getParameter("altura"));
            Double peso = Double.parseDouble(request.getParameter("peso"));
            Double peito = Double.parseDouble(request.getParameter("peito"));
            Double cintura = Double.parseDouble(request.getParameter("cintura"));
            Double pantDireita = Double.parseDouble(request.getParameter("pantDireita"));
            Double pantEsquerda = Double.parseDouble(request.getParameter("pantEsquerda"));
            Double bracoDireito = Double.parseDouble(request.getParameter("bracoDireito"));
            Double bracoEsquerdo = Double.parseDouble(request.getParameter("bracoEsquerdo"));
            Double antDireito = Double.parseDouble(request.getParameter("antDireito"));
            Double antEsquerdo = Double.parseDouble(request.getParameter("antEsquerdo"));
            Double gluteo = Double.parseDouble(request.getParameter("gluteo"));
            int idAtleta = Integer.parseInt(request.getParameter("idAtleta"));

            //Criando o objeto e colocando nos métodos.
            ExameFisico exame = new ExameFisico();
            atleta.setId(idAtleta);

            exame.setAtleta(atleta);
            exame.setAltura(altura);
            exame.setPeso(peso);
            exame.setPeito(peito);
            exame.setCintura(cintura);
            exame.setPantDireita(pantDireita);
            exame.setPantEsquerda(pantEsquerda);
            exame.setBracoDireito(bracoDireito);
            exame.setBracoEsquerdo(bracoEsquerdo);
            exame.setAntDireito(antDireito);
            exame.setAntEsquerdo(antEsquerdo);
            exame.setGluteo(gluteo);

            //Criando objeto ,cadastrando e obtendo a lista.
            ExameFisicoDAO exameDAO = new ExameFisicoDAO();
            exameDAO.cadastrar(exame);
            exameDAO.lista(exame);

            List<ExameFisico> listaExame = exameDAO.lista(exame);

            //add a lista no request
            request.setAttribute("listaExame", listaExame);

            RequestDispatcher rd = request.getRequestDispatcher("Personal/lista-avaliacao-fisica.jsp");
            rd.forward(request, response);

            //envia o request para o jsp lista
        } else if (acao.equals("Atualizar")) {
            // Recuperando os valores e colocando nas variáveis
            Double altura = Double.parseDouble(request.getParameter("altura"));
            Double peso = Double.parseDouble(request.getParameter("peso"));
            Double peito = Double.parseDouble(request.getParameter("peito"));
            Double cintura = Double.parseDouble(request.getParameter("cintura"));
            Double pantDireita = Double.parseDouble(request.getParameter("pantDireita"));
            Double pantEsquerda = Double.parseDouble(request.getParameter("pantEsquerda"));
            Double bracoDireito = Double.parseDouble(request.getParameter("bracoDireito"));
            Double bracoEsquerdo = Double.parseDouble(request.getParameter("bracoEsquerdo"));
            Double antDireito = Double.parseDouble(request.getParameter("antDireito"));
            Double antEsquerdo = Double.parseDouble(request.getParameter("antEsquerdo"));
            Double gluteo = Double.parseDouble(request.getParameter("gluteo"));
            int id = Integer.parseInt(request.getParameter("idExame"));

            //Criando o objeto e colocando nos métodos.
            ExameFisico exame = new ExameFisico();
            exame.setAltura(altura);
            exame.setPeso(peso);
            exame.setPeito(peito);
            exame.setCintura(cintura);
            exame.setPantDireita(pantDireita);
            exame.setPantEsquerda(pantEsquerda);
            exame.setBracoDireito(bracoDireito);
            exame.setBracoEsquerdo(bracoEsquerdo);
            exame.setAntDireito(antDireito);
            exame.setAntEsquerdo(antEsquerdo);
            exame.setGluteo(gluteo);
            exame.setIdExame(id);

            //cria objeo e atualiza a dao, e obtem lista
            ExameFisicoDAO atualizarDAO = new ExameFisicoDAO();
            atualizarDAO.Atualizar(exame);
            atualizarDAO.lista(exame);

            //cria lista 
            List<ExameFisico> listaExame = atualizarDAO.lista(exame);

            request.setAttribute("listaExame", listaExame);

            //envia o request para o jsp PERSONAL
            RequestDispatcher rd = request.getRequestDispatcher("personal/lista-avaliacao-fisica.jsp");
            rd.forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
