<%@page import="Modelo.Atleta"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Pessoa"%>
<%@page import="Modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"  %>
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
            <h2><i class="halflings-icon white align-justify"></i><span class="break"></span>Informações do Atleta </h2>
            <div class="box-icon">
                <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
            </div>
        </div>
        <div class="box-content">
            <table class="table table-responsive">
                <thead>
                    <tr>
                        <%                            Atleta atleta = (Atleta) request.getAttribute("atleta");

                        %>
                        <th>Objetivo</th>   
                        <th>Alimentação do Atleta</th>
                        <th>Matriculado</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> <%= atleta.getObjetivo() %>  </td>
                        <td> <%= atleta.getAlimentacao() %> </td>
                        <td> <%= atleta.isSituacaoMatricula() %> </td>
                       
                </tbody>
                <td>
                  
                <td class="center">

            </table>
        </div>
    </div>
    <c:import url="../tema/footer.jsp"/>

