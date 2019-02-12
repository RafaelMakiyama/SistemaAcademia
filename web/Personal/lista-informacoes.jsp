<%@page import="Modelo.Personal"%>
<%@page import="Modelo.Endereco"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Pessoa"%>
<%@page import="Modelo.ExameFisico"%>
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
            <h2><i class="halflings-icon white align-justify"></i><span class="break"></span>INFORMACÕES PESSOAIS</h2>
            <div class="box-icon">
                <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
            </div>
        </div>
        <div class="box-content">
            <table class="table table-responsive">
                <thead>
                    <tr>
                        <%                            Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
                            Personal personal = (Personal) request.getAttribute("personal");

                        %>
                        <th>Nome</th>   
                        <th>Sexo</th>
                        <th>Data de nascimento</th>
                        <th>Celular</th>
                        <th>Telefone</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>


                        <td> <%= pessoa.getNome()%>  </td>
                        <td> <%= pessoa.getSexo()%> </td>
                        <td> <%= pessoa.getAniversario()%> </td>
                        <td> <%= pessoa.getCelular()%> </td>
                        <td> <%= pessoa.getTelefone()%> </td>


                </tbody>
            </table>

            <h3> Endereço </h3>
            <table class="table table-responsive">
                <thead>
                    <tr>
                        <th>Cep</th>
                        <th>Estado</th>
                        <th>Cidade</th>
                        <th>Bairro</th>
                        <th>Complemento</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> <%= pessoa.getEndereco().getCep() %> </td>
                        <td> <%= pessoa.getEndereco().getUf()%> </td>
                        <td> <%= pessoa.getEndereco().getCidade()%> </td>                        
                        <td> <%= pessoa.getEndereco().getBairro()%> </td>
                        <td> <%= pessoa.getEndereco().getLogradouro()%> </td>
                        <td> <%= pessoa.getEndereco().getComplemento()%></td> 
                        <td class="center">
                            <a class="btn btn-info" href="ControlePessoal?acao=editar&id=<%= pessoa.getIdPessoa()%>">
                                <i class="halflings-icon white edit"></i>  
                            </a>  
                </tbody>
                
            </table>     
        </div>
    </div>
    <c:import url="../tema/footer.jsp"/>

