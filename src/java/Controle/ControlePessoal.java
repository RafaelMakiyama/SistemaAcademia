    package Controle;

import DAO.EnderecoDAO;
import DAO.PessoaDAO;
import Modelo.Endereco;
import Modelo.Personal;
import Modelo.Pessoa;
import Modelo.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControlePessoal extends HttpServlet {

    @Override
    //FUNCIONANDO 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        HttpSession sessaoUsuario = request.getSession();

        // ok
        if (acao.equals("consulta")) {

            Integer idUsuario = Integer.parseInt(request.getParameter("id"));
            // Pega o Id do Usuario            

            //Criação dos objetos.
            PessoaDAO pessoaDAO = new PessoaDAO();
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            Pessoa pessoa = new Pessoa();

            pessoa.setIdpessoa(idUsuario);
            pessoaDAO.consultaIdUsuario(pessoa);
            //seta o objeto com o id do usuário.

            //Coloca Endereco em Pessoa.
            Endereco endereco = enderecoDAO.consultaId(pessoa.getEndereco());

            request.setAttribute("pessoa", pessoa);
            //atribui o atributo pessoa.

            RequestDispatcher rd = request.getRequestDispatcher("Atleta/lista-informacoes.jsp"); // manda pra lista
            // RequestDispatcher rd = request.getRequestDispatcher("Personal/lista-informacoes.jsp"); // manda pra lista
            rd.forward(request, response);
        } //        Pegar informações pessoais com id_pessoa
        else if (acao.equals("editar")) {
//           Pega o id de Pessoa
            Integer idPessoa = Integer.parseInt(request.getParameter("id"));

            PessoaDAO pessoaDAO = new PessoaDAO();
            Pessoa pessoa = new Pessoa();
            EnderecoDAO enderecoDAO = new EnderecoDAO();

            pessoa.setIdpessoa(idPessoa);
            pessoaDAO.consultaIdPessoa(pessoa);

            Endereco endereco = enderecoDAO.consultaId(pessoa.getEndereco());

            request.setAttribute("pessoa", pessoa);     //atribui o atributo pessoa.
            RequestDispatcher rd = request.getRequestDispatcher("Personal/editar-informacao.jsp"); // manda pra lista
            //  RequestDispatcher rd = request.getRequestDispatcher("Atleta/editar-informacao.jsp"); // manda pra lista
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");

        HttpSession sessaoUsuario = request.getSession();
        PessoaDAO dao = new PessoaDAO();

//         Cadastrar Personal
        if (acao.equals("cadastrarPessoa")) {

            Pessoa pessoa = new Pessoa();
            Usuario usuario = new Usuario(); //Atributo Usuario            
            PessoaDAO pessoaDAO = new PessoaDAO();
            EnderecoDAO enderecoDAO = new EnderecoDAO();

//         Request dos parametros.
            pessoa.setNome(request.getParameter("nomeCompleto"));
            pessoa.setSexo(request.getParameter("sexo"));
            pessoa.setTelefone(request.getParameter("telefone"));
            pessoa.setCelular(request.getParameter("celular"));

            Integer id = Integer.parseInt(request.getParameter("id_usuario"));
            
//          Seta atributo ID para recuperar 
            
            usuario.setIdUsuario(id);
            usuario.setPerfilAcesso(request.getParameter("perfilAcesso"));
            pessoa.setUsuario(usuario);

            Endereco endereco = new Endereco();
            endereco.setCep((request.getParameter("cep")));
            endereco.setUf((request.getParameter("uf")));
            endereco.setCidade(request.getParameter("cidade"));
            endereco.setBairro(request.getParameter("bairro"));
            endereco.setLogradouro(request.getParameter("rua"));
            endereco.setComplemento(request.getParameter("complemento"));
            enderecoDAO.cadastrar(endereco);

            pessoa.setEndereco(endereco);
            pessoaDAO.cadastrarPessoa(pessoa);

            //pessoaDAO.primeiroAcesso(pessoa); //Atualiza Primeiro Acesso para FALSE
            //Devolve atributos usuario
            request.setAttribute("usuario", usuario);
            pessoaDAO.listaPessoa(pessoa); // VERIFICAR

            switch (usuario.getPerfilAcesso()) {
                case "Personal":

                    request.getRequestDispatcher("Personal/cadastrar-personal.jsp").forward(request, response);
                case "Atleta":
                    request.getRequestDispatcher("Atleta/cadastrar-atleta.jsp").forward(request, response);

            }
            request.setAttribute("pessoa", pessoa);

//request.getRequestDispatcher("Atleta/cadastrar-atleta.jsp").forward(request, response);
        }//Precisa ARRUMAR
        /* else if (acao.equals("Atualizar")) {

         Endereco endereco = new Endereco();
         endereco.setCep(request.getParameter("cep"));
         endereco.setLogradouro(request.getParameter("rua"));
         endereco.setComplemento(request.getParameter("complemento"));
         endereco.setBairro(request.getParameter("bairro"));
         endereco.setCidade(request.getParameter("cidade"));
         endereco.setUf(request.getParameter("uf"));

         //Cria novo objeto DAO.
         EnderecoDAO endDAO = new EnderecoDAO();
         //endereco recebe o método cadastrar porque o retorno dele é do tipo Endereco. (
         //RETORNO DO ID.

         endDAO.atualizarEndereco(endereco);

         Pessoa pessoa = new Pessoa();
         //Seta e recupera os parametros.
         pessoa.setNome(request.getParameter("nomeCompleto"));
         pessoa.setSexo(request.getParameter("sexo"));
         pessoa.setTelefone(request.getParameter("telefone"));
         pessoa.setCelular(request.getParameter("celular"));
         pessoa.

         //Cria pessoaDAO
         PessoaDAO pessoaDAO = new PessoaDAO();
            
         pessoaDAO.atualizarPessoa(id, pessoa)
         */
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
