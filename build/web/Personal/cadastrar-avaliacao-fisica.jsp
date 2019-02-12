<%@page import="Modelo.Atleta"%>
<%@page import="Modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"  %>
<c:import url="../tema/header.jsp"/>
<body>
    <script src="${request.contextPath}js/jquery.js" type="text/javascript" ></script>
    <script src="${request.contextPath}js/inputmask.bundle.js" type="text/javascript" ></script>
    <script src="${request.contextPath}js/validaAvaliacao.js" type="text/javascript" ></script>
    <%
        Atleta atleta = (Atleta) request.getAttribute("atleta");
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
            <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/ControleAvaliacaoFisica" name="cad" onsubmit="return validar();">
                <fieldset>
                    <div class="control-group">
                        <label class="control-label"> Altura. </label>
                        <input type="text" class="form-control" placeholder="Digite a altura"  name="altura" id="altura">     
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Peso</label>
                        <input type="text" class="form-control" placeholder="Digite o peso" id="peso" name="peso">  
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Peito </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." id="peito" name="peito">    
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Cintura </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." id="cintura" name="cintura"> 
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Panturrilha Direita </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." id="pantDireita" name="pantDireita">
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Panturrilha Esquerda </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." id="pantEsquerda" name="pantEsquerda"> 
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Braço Direito </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." id="bracoDireito" name="bracoDireito"> 
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Braço Esquerdo </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." id="bracoEsquerdo" name="bracoEsquerdo"> 
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Antebraco Direito </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." id="antDireito" name="antDireito"> 
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Antebraco Esquerdo </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." id="antEsquerdo" name="antEsquerdo"> 
                    </div>
                    <div class="control-group">
                        <label class="control-label"> Glúteo </label>
                        <input type="text" class="form-control" placeholder="Digite a medida." id="gluteo" name="gluteo"> 
                    </div>
                    <div class="form-actions">
                        <button class="btn btn-default" name="acao" value="Cadastrar" type="submit">Cadastrar Exame Físico.</button>
                    </div>

                    <td>
                        <input type="hidden" name="idAtleta" value="<%= atleta.getId()%>" />
                    </td>
                </fieldset>
            </form>

        </div>
    </div>
        <c:import url="../tema/footer2.jsp"/>s