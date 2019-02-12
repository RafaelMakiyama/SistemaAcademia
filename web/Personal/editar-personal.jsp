<%@page import="Modelo.Personal"%>
<%@page import="Modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"  %>
<c:import url="../tema/header.jsp"/>
<body>
    <c:import url="../tema/cabecalhoPersonal.jsp"/>
    <c:import url="../tema/menuPersonal.jsp"/>
    <c:import url="../tema/conteudo.jsp"/>    
    <%   Personal personal = (Personal) request.getAttribute("personal");

    %>
    <div class="box span12">
        <div class="box-header">
            <h2> Editar informações Personal</h2>
        </div>
        <div class="box-content">
            <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/ControlePersonal">
                <fieldset>
                    <div class="control-group">
                        <label class="control-label"> Instituicao </label>
                        <input type="text" class="form-control" name="instituicao" value="<%= personal.getInstituicao()%> ">     
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Curso</label>
                        <input type="text" class="form-control" name="curso" value="<%= personal.getCurso() %>">  
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Métodos </label>
                        <input type="text" name="metodos" value="<%= personal.getMetodos() %>">    
                    </div>
                    <input type="hidden" name="idMatricula" value="<%= personal.getMatricula()%>" />
                    <div class="form-actions">
                        <button class="btn btn-default" name="acao" value="atualizarPersonal" type="submit">Atualizar Exame Físico.</button>
                    </div>
                </fieldset>
            </form>
        </div>
        <c:import url="../tema/footer.jsp"/>
