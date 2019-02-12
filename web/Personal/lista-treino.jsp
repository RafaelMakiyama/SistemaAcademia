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
    <c:import url="../tema/cabecalhoPersonal.jsp"/>
    <c:import url="../tema/menuPersonal.jsp"/>
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
                        <th>ID</th>
                        <th>Dia</th>
                        <th>Nome Exercicio</th>
                        <th>Tipo de Treinamento</th>
                        <th>Tempo estimado</th>
                        <th>Series</th>
                        <th>Editar </th>
                        <th>Excluir</th>                        
                        <th>Novo treino</th>
                    </tr>
                </thead>
                <tbody>

                    <%                            for (Treino treino : listaTreino) {

                    %>

                    <tr>
                        <td><%= treino.getId()%></td>   
                        <td><%= treino.getData()%></td>   
                        <td><%= treino.getExercicioNome()%></td>
                        <td><%= treino.getTipoTreinamento()%></td>
                        <td><%= treino.getTempo()%></td>
                        <td><%= treino.getSeries()%></td>
                        <td align="center">
                            <a class="btn btn-info" href="${request.contextPath}ControleTreino?acao=consultaTreino&id=<%=treino.getId()%>">
                                <i class="halflings-icon white edit"></i>  
                            </a>           
                        <td>
                            <a class="btn btn-danger" href="ControleTreino?acao=Excluir&idTreino=<%=treino.getId()%>&idAtleta=<%=treino.getAtleta().getId()%>">
                                <i class="halflings-icon white trash"></i> 
                            </a></td>

                        <td>
                            <a class="btn btn-info" href="${pageContext.request.contextPath}/ControleTreino?acao=consultar&atletaId=<%=treino.getAtleta().getId()%>">
                                <i class="halflings-icon white edit"></i>  
                            </a> 
                        </td>


                    </tr>
                    <%
                        }
                    %>  
                </tbody>

            </table>
        </div>
    </div>
    <c:import url="../tema/footer.jsp"/>   

