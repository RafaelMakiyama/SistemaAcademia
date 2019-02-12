<%@page import="Modelo.Personal"%>
<%@page import="Modelo.Pessoa"%>
<%@page import="Modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../tema/header.jsp"/>
<body>
    <%

        //Cria usuario
        Usuario usuario = (Usuario) session.getAttribute("usuario");

    %>

    <c:import url="../tema/cabecalhoPersonal.jsp"/>    
    <c:import url="../tema/conteudo.jsp"/>
    <script type="text/javascript" >


        <%            //Cria e pega atributo Pessoa
            Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
        %>

    </script>

    <h1>Cadastre suas informações profissionais.</h1>

    <div class="col-md-12">
        <form method="post" action="${pageContext.request.contextPath}/ControleAtleta">
            <div class="form-group">
                <label>INTENÇÃO TREINAMENTO</label>
                <input type="text" class="form-control-static" placeholder="Digite a intenção do treinamento." id="intencao" name="intencao">                        
            </div>
            <div class="form-group">
                <label>ALIMENTAÇÃO</label>
                <input type="text" class="form-control" placeholder="Escreve o que você gosta de comer, sua alimentação diária, a base de informações." id="alimentacao" name="alimentacao">                        
            </div>
            
            <input type="hidden" name="id_pessoa" value="<%= pessoa.getIdPessoa()%>" />
            <button  name="acao" value="salvarAtleta" type="submit">Finalizar</button>
        </form>
    </div>  

    <c:import url="../tema/footer.jsp"/>