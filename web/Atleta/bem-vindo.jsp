<%@page import="Modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../tema/header.jsp"/>    
<body>
    <%
// Cria usuario e seta primeiro acesso como verdadeiro
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario.isPrimeiroAcesso() == true) {

    %>

    <c:import url="../tema/conteudo.jsp"/>  

    <!-- Adicionando Javascript para achar CEP -->
    <script type="text/javascript" >
        $(document).ready(function () {

            function limpa_formulário_cep() {
                // Limpa valores do formulário de cep.
                $("#rua").val("");
                $("#bairro").val("");
                $("#cidade").val("");
                $("#uf").val("");
                $("#ibge").val("");
            }

            //Quando o campo cep perde o foco.
            $("#cep").blur(function () {

                //Nova variável "cep" somente com dígitos.
                var cep = $(this).val().replace(/\D/g, '');

                //Verifica se campo cep possui valor informado.
                if (cep != "") {

                    //Expressão regular para validar o CEP.
                    var validacep = /^[0-9]{8}$/;

                    //Valida o formato do CEP.
                    if (validacep.test(cep)) {

                        //Preenche os campos com "..." enquanto consulta webservice.
                        $("#rua").val("...");
                        $("#bairro").val("...");
                        $("#cidade").val("...");
                        $("#uf").val("...");
                        $("#ibge").val("...");

                        //Consulta o webservice viacep.com.br/
                        $.getJSON("//viacep.com.br/ws/" + cep + "/json/?callback=?", function (dados) {

                            if (!("erro" in dados)) {
                                //Atualiza os campos com os valores da consulta.
                                $("#rua").val(dados.logradouro);
                                $("#bairro").val(dados.bairro);
                                $("#cidade").val(dados.localidade);
                                $("#uf").val(dados.uf);
                                $("#ibge").val(dados.ibge);
                            } //end if.
                            else {
                                //CEP pesquisado não foi encontrado.
                                limpa_formulário_cep();
                                alert("CEP não encontrado.");
                            }
                        });
                    } //end if.
                    else {
                        //cep é inválido.
                        limpa_formulário_cep();
                        alert("Formato de CEP inválido.");
                    }
                } //end if.
                else {
                    //cep sem valor, limpa formulário.
                    limpa_formulário_cep();
                }
            });
        });

    </script>


  <form method="post" action="${pageContext.request.contextPath}/ControlePessoal" class="horizontal">
        <fieldset>
        <div class="box-header">
            <h2> Cadastrar informações pessoais</h2>
        </div>                

        <div class="control-group">
            <label class="control-label"> Nome completo. </label>
            <input type="text" class="form-control" placeholder="Digite o nome completo." id="nomeCompleto" name="nomeCompleto">                        
        </div>
        <label> Data de nascimento. </label>
        <input type="date" class="form-control" name="aniversario" id="aniversario">                        

        <label> Sexo. </label>
        <select id="sexo" name="sexo"> Selecione
            <option value="Masculino">Masculino</option>
            <option value="Feminino">Feminino</option>
        </select><br>

        <label> Telefone </label>
        <input type="text"  placeholder="Digite o telefone." id="telefone" name="telefone">                        

        <label> Celular </label>
        <input type="text" class="form-control" placeholder="Digite o celular. " id="celular" name="celular">        

        <label> CEP </label>
        <input type="text" class="form-control" placeholder="Digite o cep. " id="cep" name="cep" value="" onblur="pesquisacep(this.value);
               " />        

        <label> Endereço </label>
        <input type="text" class="form-control" placeholder="Digite o endereço. " id="rua" name="rua" size="60">        

        <label> Complemento </label>
        <input type="text" class="form-control" placeholder="Digite o complemento. " id="complemento" name="complemento">        

        <label> Bairro </label>
        <input type="text" class="form-control" placeholder="Digite o bairro. " id="bairro" name="bairro" size="40">        

        <label> Cidade </label>
        <input type="text" class="form-control" placeholder="Digite a cidade. " id="cidade" name="cidade" size="40">        

        <label> Estado </label>
        <input type="text"  placeholder="Digite o estado. "  id="uf" name="uf" size="2">       

        <input type="hidden" name="id_usuario" value="<%= usuario.getIdUsuario()%>" />
        <input type="hidden" name="id_usuario" value="<%= usuario.getPerfilAcesso()%>" />
        <button class="btn btn-default" name="acao" value="cadastrarPessoa" type="submit">Próximo.</button>
        </fieldset>
        
    </form>

        <c:import url="../tema/footer.jsp"/>


        <%
        } else if (usuario.isPrimeiroAcesso() == false) {
        %>

        <c:import url="../tema/cabecalhoAtleta.jsp"/>
        <c:import url="../tema/menuAtleta.jsp"/>

        <c:import url="../tema/conteudo.jsp"/>    

        sssssssss

        <c:import url="../tema/footer.jsp"/>

        <%
            }
        %>