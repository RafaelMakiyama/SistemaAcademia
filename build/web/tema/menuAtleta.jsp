<%@page import="Modelo.Usuario"%>

<% Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<div class="container-fluid-full">
    <div class="row-fluid">

        <!-- start: Main Menu -->
        <div id="sidebar-left" class="span2">
            <div class="nav-collapse sidebar-nav">
                <ul class="nav nav-tabs nav-stacked main-menu">	
                    <li><a href="messages.html"><i class="icon-envelope"></i><span class="hidden-tablet"> Email</span></a></li>
                    <li>
                        <a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> Teste Físico</span></a>
                        <ul>
                            <li><a class="submenu" href="${pageContext.request.contextPath}/ControleAvaliacaoFisica?acao=listarAvaliacoes&id=<%= usuario.getIdUsuario() %>"><i class="icon-file-alt"></i><span class="hidden-tablet"> Histórico de teste</span></a></li>
                            <li><a class="submenu" href="#"><i class="icon-pencil"></i><span class="hidden-tablet"> Pedir teste</span></a></li>
                        </ul>	
                    <li>
                        <a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> Treinamento</span></a>
                        <ul>
                            <li><a class="submenu" href="${pageContext.request.contextPath}/ControleTreino?acao=listarMeuTreinamento&id=<%= usuario.getIdUsuario() %>"><i class="icon-calendar"></i><span class="hidden-tablet"> Visualizar treinamento</span></a></li>
                            <li><a class="submenu" href="submenu2.html"><i class="icon-pencil"></i><span class="hidden-tablet"> Pedir treinamento</span></a></li>
                        </ul>	
                    </li>   
                    <li>
                        <a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> Personal Trainner</span></a>
                        <ul>
                            <li><a class="submenu" href="submenu.html"><i class="icon-map-marker"></i><span class="hidden-tablet"> Procurar Personal Trainner</span></a></li>
                            <li><a class="submenu" href="submenu2.html"><i class="icon-trash"></i><span class="hidden-tablet"> Retirar Persoanl Trainner</span></a></li>
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
