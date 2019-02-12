<%@page import="Modelo.Usuario"%>

<div class="container-fluid-full">
    <div class="row-fluid">

        <!-- start: Main Menu -->
        <div id="sidebar-left" class="span2">
            <div class="nav-collapse sidebar-nav">
                <ul class="nav nav-tabs nav-stacked main-menu">	
                    <li><a href="messages.html"><i class="icon-envelope"></i><span class="hidden-tablet"> Email</span></a></li>
                    <li>
                        <a class="dropmenu" href="#"><i class="icon-user"></i><span class="hidden-tablet"> Aluno</span></a>
                        <ul>

                            <% Usuario usuario = (Usuario) session.getAttribute("usuario");
                            %>
                            <li><a class="submenu" href="${pageContext.request.contextPath}/ControleMatricula?acao=listarNaoMatriculados"><i class="icon-user"></i><span class="hidden-tablet"> Procurar aluno</span></a></li>
                            <li><a class="submenu" href="${pageContext.request.contextPath}/ControleMatricula?acao=meusAtletas&idUsuario=<%= usuario.getIdUsuario()%>"><i class="icon-trash"></i><span class="hidden-tablet"> Meus atletas</span></a></li>
                        </ul>	
                    </li>
                    <li>
                        <a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> Treino</span></a>
                        <ul>
                            <li><a class="submenu" href="${pageContext.request.contextPath}/ControleTreino?acao=meusAtletas&idUsuario=<%= usuario.getIdUsuario()%>"><i class="icon-calendar"></i><span class="hidden-tablet"> Cadastrar treino</span></a></li>
                            <li><a class="submenu" href="${pageContext.request.contextPath}/ControleTreino?acao=listar"><i class="icon-pencil"></i><span class="hidden-tablet"> Alterar treino</span></a></li>
                        </ul>	
                    </li>
                    <li>
                        <a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> Teste Físico</span></a>
                        <ul>
                            <li><a class="submenu" href="${pageContext.request.contextPath}/ControleAvaliacaoFisica?acao=meusAtletas&idUsuario=<%= usuario.getIdUsuario()%>"><i class="icon-camera"></i><span class="hidden-tablet"> Cadastrar teste</span></a></li>
                            <li><a class="submenu" href="${pageContext.request.contextPath}/ControleAvaliacaoFisica?acao=Lista"><i class="icon-pencil"></i><span class="hidden-tablet"> Histórico de teste</span></a></li>
                        </ul>	
                    </li>
                </ul>
            </div>
        </div>
        <!-- end: Main Menu -->

        <noscript>
        <div class="alert alert-block span10">
            <h4 class="alert-heading">Warning!</h4>
            <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
        </div>
        </noscript>