<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Treino"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.ExameFisico"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../tema/header.jsp"/>
<body>
    <%
        Usuario usuario = (Usuario) session.getAttribute("usuario");
    %> 
    <c:import url="../tema/cabecalhoAtleta.jsp"/>
    <c:import url="../tema/menuAtleta.jsp"/>
    <c:import url="../tema/conteudo.jsp"/>    

    <div class="box span12">
        <div class="box-header">
            <h2><i class="halflings-icon white align-justify"></i><span class="break"></span>Lista treinamento </h2>

        </div>
        <div class="box-content">
            <table class="table table-responsive">
                <thead>
                    <tr>
                        <%
                            //recupar a lista o request
                            List<Treino> listaTreino = (List<Treino>) request.getAttribute("listaTreino");

                        %>
                        
                        <th>Nome Exercicio</th>
                        <th>Tipo de Treinamento</th>
                        <th>Tempo estimado</th>
                        <th>Series</th>
                    </tr>
                </thead>
                <tbody>

                    <%                            for (Treino treino : listaTreino) {

                    %>

                    <tr>
                        <td><%= treino.getExercicioNome()%></td>
                        <td><%= treino.getTipoTreinamento()%></td>
                        <td><%= treino.getTempo()%></td>
                        <td><%= treino.getSeries()%></td>
                       

                    </tr>
                    <%
                        }
                    %>  
                </tbody>

            </table>
        </div>
    </div>
    <c:import url="../tema/footer.jsp"/>   

