<%@page import="java.util.List"%>
<%@page import="Modelo.Atleta"%>
<%@page import="Modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../tema/header.jsp"/>
<body>
    <%
         Atleta  atleta = (Atleta) request.getAttribute("atleta");
        


        Usuario usuario = (Usuario) session.getAttribute("usuario");

    %>

    <c:import url="../tema/cabecalhoPersonal.jsp"/>
    <c:import url="../tema/menuPersonal.jsp"/>
    <c:import url="../tema/conteudo.jsp"/>    

    <div class="box span12">
        <div class="box-header">
            <h2> Cadastrar treino</h2>
        </div>

        <div class="box-content">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/ControleTreino" method="post">
                <fieldset>

                    <div class="control-group">
                        <label class="control-label"> Nome do exercício. </label>
                        <input type="text" class="form-control" placeholder="Digite o nome do exercício." name="nomeExercicio" id="nomeExercicio" >                        
                    </div>

                    <div class="control-group">
                        <label class="control-label"> Tipo do treinamento</label>
                        <input type="text" class="form-control" placeholder="Digite o tipo do treinamento" name="tipoTreinamento">      
                    </div>
                    
                    <div class="control-group">
                        <label class="control-label"> Tempo estimado</label>
                        <input type="text" class="form-control" placeholder="Digite o tempo estimado do exercício" name="tempo">      
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="date01">Date input</label>
                        <div class="controls">
                            <input type="text" class="input-xlarge datepicker" id="date01" name="txtData" value="25/05/2017" >
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label"> Séries </label>
                        <input type="text" class="form-control" placeholder="Digite a quantidade de séries." name="series">    <br>
                    </div>

                    <div class="form-actions">
                        <button type="submit" name="acao" value="Cadastrar" class="btn btn-primary">Cadastrar Treino</button>
                    </div>

                
                    <td>
                        <input type="hidden" name="idAtleta" value="<%= atleta.getId()%>" />
                    </td>
                   
                </fieldset>
            </form> 
        </div>
    </div>

    <c:import url="../tema/footer.jsp"/>