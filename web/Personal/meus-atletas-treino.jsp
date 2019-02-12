<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Atleta"%>
<%@page import="java.util.List"%>
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
            <h2><i class="halflings-icon white align-justify"></i><span class="break"></span>Meus atletas</h2>
            <div class="box-icon">
                <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
            </div>
        </div>
        <div class="box-content">
            <table class="table table-responsive">
                <thead>
                    <tr>
                        <%
                            //recupar a lista o request
                            List<Atleta> listaAtleta = (List<Atleta>) request.getAttribute("listaAtleta");

                        %>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Sexo</th>
                        <th>Objetivo</th>
                        <th>Alimentação</th>
                        <th>Cadastrar treino</th>
                        <th>Listar treino</th>
                    </tr>
                </thead>
                <tbody>

                    <%                            for (Atleta atleta : listaAtleta) {

                    %>

                    <tr>
                        <td><%= atleta.getId()%></td>   
                        <td><%= atleta.getNome()%></td>
                        <td><%= atleta.getSexo()%></td>
                        <td><%= atleta.getObjetivo()%></td>
                        <td><%= atleta.getAlimentacao()%></td>
                        <td>
                            <a class="btn btn-info" href="${pageContext.request.contextPath}/ControleTreino?acao=consultar&atletaId=<%=atleta.getId()%>">
                                <i class="halflings-icon white edit"></i>  
                            </a> 
                        </td>
                        <td>
                            <a class="btn btn-info" href="${pageContext.request.contextPath}/ControleTreino?acao=listarTreinoAtleta&atletaId=<%=atleta.getId()%>">
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

