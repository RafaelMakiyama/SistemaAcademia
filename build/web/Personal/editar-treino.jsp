e<%@page import="Modelo.Treino"%>
<%@page import="Modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../tema/header.jsp"/>
<body>
    <%

        Usuario usuario = (Usuario) session.getAttribute("usuario");

    %> 
    <c:import url="../tema/cabecalhoPersonal.jsp"/>
    <c:import url="../tema/menuPersonal.jsp"/>
    <c:import url="../tema/conteudo.jsp"/>    
    <%  Treino treino = (Treino) request.getAttribute("treino");
    %>
    <div class="box span12">
        <div class="box-header">
            <h2> Cadastrar treino</h2>
        </div>
        <div class="box-content">
            <form class="form-horizontal" action="${request.contextPath}ControleTreino" method="post">
                <fieldset>
                    <div class="control-group">
                        <label class="control-label"> Nome do exercício. </label>
                        <input type="text" class="form-control" placeholder="Digite o nome do exércicio." name="nomeExercicio" value="<%= treino.getExercicioNome()%>">                        
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Tipo do treinamento </label>
                        <input type="text" class="form-control" placeholder="Digite o tipo do treinamento" name="tipoTreinamento" value="<%= treino.getTipoTreinamento()%>" >       
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Tempo </label>
                        <input type="text" class="form-control" placeholder="Digite a duração do exércicio." name="tempo" value="<%= treino.getTempo()%>" >                     
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Séries </label>
                        <input type="text" class="form-control" placeholder="Digite a quantidade de séries." name="series"  value="<%= treino.getSeries()%>"> 
                        <br>
                        <input type="hidden" name="idTreino" value="<%= treino.getId()%>" />
                    </div>
                    <div class="form-actions">
                        <button type="submit" name="acao" value="Atualizar" class="btn btn-primary">ATUALIZAR TREINO</button>
                         <input type="hidden" name="idAtleta" value="<%= treino.getAtleta().getId() %>" />
                    </div>
                </fieldset>
            </form> 
        </div>
    </div>

    <c:import url="../tema/footer.jsp"/>
