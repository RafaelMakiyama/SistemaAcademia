<%@page import="Modelo.Personal"%>
<%@page import="Modelo.Pessoa"%>
<%@page import="Modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../tema/header.jsp"/>
<body>
    <%

        Usuario usuario = (Usuario) session.getAttribute("usuario");

    %>

    <c:import url="../tema/cabecalhoPersonal.jsp"/>    
    <c:import url="../tema/conteudo.jsp"/>
    <script type="text/javascript" >
        <%         
        
        
        Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
        %>

    </script><h1>Cadastre suas informações profissionais.</h1>
    <div class="col-md-12">
        <form method="post" action="${pageContext.request.contextPath}/ControlePersonal">
            <label>Instituição de ensino</label>
            <input type="text" class="form-control" placeholder="Digie a instituição onde estudou." id="instituicao" name="instituicao">                        

            <label>Curso</label>
            <input type="date" class="form-control" name="curso" id="curso" placeholder="Digite o curso."  >                        

                <label>Métodos de treinamento.</label>
                <input type="date" name="metodo" id="metodo" placeholder="Faça um breve resumo sobre qual é sua preferência sobre os treinamentos."  >

            <input type="hidden" name="id_pessoa" value="<%= pessoa.getIdPessoa()%>" />
            <input type="hidden" name="id_pessoa" value="<%= usuario.getPerfilAcesso()%>" />
            
      <button  name="acao" value="salvarPersonal" type="submit">Finalizar</button>
                 

        </form>
    </div>  

    <c:import url="tema/footer.jsp"/>