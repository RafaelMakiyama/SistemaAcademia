<%@page import="Modelo.Atleta"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"  %>
<c:import url="../tema/header.jsp"/>
<body>
    <script src="${request.contextPath}js/jquery.js" type="text/javascript" ></script>
    <script src="${request.contextPath}js/inputmask.bundle.js" type="text/javascript" ></script>
    <script src="${request.contextPath}js/validaAvaliacao.js" type="text/javascript" ></script>
    <%

        Usuario usuario = (Usuario) session.getAttribute("usuario");


    %> 
    <c:import url="../tema/cabecalhoPersonal.jsp"/>
    <c:import url="../tema/menuPersonal.jsp"/>
    <c:import url="../tema/conteudo.jsp"/>    

    <div class="box span12">
        <div class="box-header">
            <h2><i class="halflings-icon white align-justify"></i><span class="break"></span></h2>
            <div class="box-icon">
                <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
            </div>
        </div>
        <div class="box-content">
            <form action="${request.contextPath}ControleMatriculasssssssssssssos" method="get">
            <fieldset>
                <legend>Procurar</legend>
                <input type="text" name="procurar" value="${param.procurar}"/>
                <input type="submit" value="Procurar">
                
                
            </fieldset>
            </form>
            <table class="table table-responsive">
                <thead>
                    <tr>
                        <%                            //recupar a lista o request
                            List<Atleta> listaAtleta = (List<Atleta>) request.getAttribute("listaAtleta");

                        %>
                        <th>Nome</th>
                        <th>Sexo</th>
                        <th>Objetivo</th>
                        <th>Rua</th>
                        <th>Bairro</th>
                        <th>Cidade</th>
                        <th>Uf</th>
                        <th>Cadastrar</th>

                    </tr>
                </thead>
                <tbody>
                    <%                            for (Atleta atleta : listaAtleta) {

                    %>

                    <tr>
                        <td><%= atleta.getNome()%></td>
                        <td><%= atleta.getSexo()%></td>
                        <td><%= atleta.getObjetivo()%></td>
                        <td><%= atleta.getEndereco().getLogradouro()  %></td>
                        <td><%= atleta.getEndereco().getBairro() %></td>
                        <td><%= atleta.getEndereco().getCidade() %></td>
                        <td><%= atleta.getEndereco().getUf() %></td>
                         <td>
                            <a class="btn btn-info" href="${request.contextPath}ControleMatricula?acao=cadastrarMatricula&id=<%=atleta.getId()%>&idUsuario=<%= usuario.getIdUsuario()%>">
                                <i class="halflings-icon white edit"></i>  
                            </a>           
                        <td>
                        
                        
                        
                    </tr>
                    <%
                        }
                    %>

                </tbody>
            </table>
        </div>
    </div>
    <c:import url="../tema/footer.jsp"/>s