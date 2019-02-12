<%@page import="Modelo.Usuario"%>

        <!-- start: Header -->
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="${pageContext.request.contextPath}/Atleta/bem-vindo.jsp"><span>iTrainner</span></a>

                    <!-- start: Header Menu -->
                    <div class="nav-no-collapse header-nav">
                        <ul class="nav pull-right">
                            

                            <!-- start: User Dropdown -->
                            <li class="dropdown">
                                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="halflings-icon white user"></i> 
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="dropdown-menu-title">
                                        <span>Definições da conta</span>
                                    </li>
                                    <% Usuario usuario = (Usuario) session.getAttribute("usuario");
                                          %>
                                          
                                                <li><a href=""><i class="halflings-icon user">
                                            </i> 
                                            <%= usuario.getLogin() %>
                                        
                                        </a></li>
                                    <li><a href="${pageContext.request.contextPath}/ControlePessoal?acao=consulta&id=<%= usuario.getIdUsuario()%>"><i class="halflings-icon avatar"></i>Dados pessoais</a></li>
                                    <li><a href="${pageContext.request.contextPath}/ControleAtleta?acao=listarAtleta&id=<%= usuario.getIdUsuario()%>"><i class="halflings-icon avatar"></i>Dados atleta</a></li>
                                    <li><a href="${pageContext.request.contextPath}/ControleUsuario?acao=logout"><i class="halflings-icon off"></i>Sair</a></li>
                                </ul>
                            </li>
                            <!-- end: User Dropdown -->
                        </ul>
                    </div>
                    <!-- end: Header Menu -->



                </div>
            </div>
        </div>      
        
