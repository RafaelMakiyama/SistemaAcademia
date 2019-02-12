<%@page import="Modelo.Pessoa"%>
<%@page import="Modelo.Usuario"%> 
<%@page import="Modelo.Endereco"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"  %>
<c:import url="../tema/header.jsp"/>
<body>
    <%

        Usuario usuario = (Usuario) session.getAttribute("usuario");
    %>
    <c:import url="../tema/cabecalhoPersonal.jsp"/>
    <c:import url="../tema/menuPersonal.jsp"/>
    <c:import url="../tema/conteudo.jsp"/>    

    <% Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");%>

    <div class="col-md-12">
        <form method="post" action="ControlePessoal">
            <label> Nome completo. </label>
            <input type="text" class="form-control" placeholder="Digite o nome completo." id="nomeCompleto" name="nomeCompleto" value="<%= pessoa.getNome()%>" >                        
            
            <label> Data de nascimento. </label>
            <input type="date" class="form-control" name="aniversario" id="aniversario" value="" >                        
            <label> Sexo. </label>
            <select id="sexo" name="sexo" > 
                <option value="<%= pessoa.getSexo()%>"></option>
                <option value="Masculino">Masculino</option>
                <option value="Feminino">Feminino</option>
            </select><br>
            <label> Telefone </label>
            <input type="text" class="form-control" placeholder="Digite o telefone." id="telefone" value="<%=pessoa.getTelefone()%>" name="telefone">                        
            <label> Celular </label>
            <input type="text" class="form-control" placeholder="Digite o celular. " id="celular" name="celular" value="<%=pessoa.getCelular()%>">        

            <label> CEP </label>
            <input type="text" class="form-control" placeholder="Digite o cep. " id="cep" name="cep" value="<%=pessoa.getEndereco().getCep()%>" onblur="pesquisacep(this.value);
                   " />        


            <label> Endereço </label>
            <input type="text" class="form-control" placeholder="Digite o endereço. " id="rua" name="rua" size="60"   value="<%=pessoa.getEndereco().getLogradouro()%>">        
            <label> Complemento </label>
            <input type="text" class="form-control" placeholder="Digite o complemento. " id="complemento" name="complemento" value="<%=pessoa.getEndereco().getComplemento()%>">        
            <label> Bairro </label>
            <input type="text" class="form-control" placeholder="Digite o bairro. " id="bairro" name="bairro" size="40" value="<%=pessoa.getEndereco().getBairro()%>">        
            <label> Cidade </label>
            <input type="text" class="form-control" placeholder="Digite a cidade. " id="cidade" name="cidade" size="40" value="<%=pessoa.getEndereco().getCidade()%>">        
            <label> Estado </label>
            <input type="text" class="form-control" placeholder="Digite o estado. "  id="uf" name="uf" size="2" value="<%=pessoa.getEndereco().getUf()%>">       

            <input type="hidden" name="id_usuario" value="<%= usuario.getIdUsuario()%>" />
            <input type="submit" name="acao" value="Atualizar" class="btn btn-default" >  
            </div>

            <c:import url="../tema/footer.jsp"/>    
