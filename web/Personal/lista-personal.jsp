<%@page import="Modelo.Personal"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Pessoa"%>
<%@page import="Modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"  %>
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
            <h2><i class="halflings-icon white align-justify"></i><span class="break"></span>INFORMAÇÕES ACADÊMICAS</h2>
            <div class="box-icon">
                <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
            </div>
        </div>
        <div class="box-content">
            <table class="table table-responsive">
                <thead>
                    <tr>
                        <%                            Personal personal = (Personal) request.getAttribute("personal");

                        %>
                        <th>INSTITUIÇÃO DE ENSINO</th>   
                        <th>CURSO</th>
                        <th>MÉTODOS DE TREINAMENTO</th>
                        <th>EDITAR</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> <%= personal.getInstituicao()%>  </td>
                        <td> <%= personal.getCurso()%> </td>
                        <td> <%= personal.getMetodos()%> </td>
                        <td>
                            <a class="btn btn-info" href="ControlePersonal?acao=editar&id=<%=personal.getMatricula()%>">
                                <i class="halflings-icon white edit"></i>  
                            </a>  </td>
                </tbody>
                <td>
                    <input type="hidden" name="idPersonal" value="<%= personal.getMatricula()%>" />
                <td class="center">

            </table>
        </div>
    </div>
    <c:import url="../tema/footer.jsp"/>

