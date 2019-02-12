<%@page import="Modelo.ExameFisico"%>
<%@page import="Modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"  %>
<c:import url="tema/header.jsp"/>
<body>
    <%

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario != null) {
            if (usuario.getPerfilAcesso().equals("Personal")) {

    %> 
    <c:import url="tema/cabecalho.jsp"/>
    <c:import url="tema/menuPersonal.jsp"/>
    <c:import url="tema/conteudo.jsp"/>    
  <% ExameFisico exame = (ExameFisico) request.getAttribute("exame");

        %>
    <div class="box span12">
        <div class="box-header">
            <h2> Cadastrar treino</h2>
        </div>
        <div class="box-content">
            <form class="form-horizontal" method="post" action="ControleExameFisico">
                <fieldset>
                    <div class="control-group">
                        <label class="control-label"> Altura. </label>
                        <input type="text" class="form-control" placeholder="Digite a altura" name="altura" value=" <%=exame.getAltura()%> ">     
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Peso</label>
                        <input type="text" class="form-control" placeholder="Digite o peso" name="peso" value=" <%= exame.getPeso()%>">  
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Peito </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." name="peito" value="<%= exame.getPeito()%>">    
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Cintura </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." name="cintura" value="<%= exame.getCintura()%> "> 
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Panturrilha Direita </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." name="pantDireita" value="<%= exame.getPantDireita() %>" >
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Panturrilha Esquerda </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." name="pantEsquerda" value="<%= exame.getPantEsquerda() %>"> 
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Braço Direito </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." name="bracoDireito" value="<%= exame.getBracoDireito() %>"> 
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Braço Esquerdo </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." name="bracoEsquerdo" value="<%= exame.getBracoEsquerdo() %>"> 
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Antebraco Direito </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." name="antDireito" value="<%= exame.getAntDireito() %>"> 
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Antebraco Esquerdo </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." name="antEsquerdo" value="<%= exame.getAntEsquerdo() %>"> 
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Glúteo </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." name="gluteo" value="<%= exame.getGluteo() %>"> 
                    </div>
                    <div class="form-actions">
                        <button class="btn btn-default" name="acao" value="Cadastrar" type="submit">Cadastrar Exame Físico.</button>
                    </div>
                </fieldset>
            </form>
        </div>
        <c:import url="tema/footer.jsp"/>
        <%     } else {
        %>
        <c:import url="nao-autenticado.jsp"/>
        <%
            }
        %>


        <%
        } else {
        %>
        <p style="color: blue"> Sua sessão expirou...</p>
        <p> Clique <a href="index.jsp" style="color: blue">aqui</a> para logar novamente.</p>

        <%
            }
        %>
</body>