<%@page import="Modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.ExameFisico"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../tema/header.jsp"/>

<c:import url="../tema/cabecalhoPersonal.jsp"/>
<c:import url="../tema/menuAtleta.jsp"/>
<c:import url="../tema/conteudo.jsp"/>    

<div class="box span12">
    <div class="box-header">
        <h2><i class="halflings-icon white align-justify"></i><span class="break"></span>Lista Avaliações Físicas.</h2>
        <div class="box-icon">
            <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
            <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
            <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
        </div>
    </div>
    <div class="box-content">
        <table class="table table-responsive">
            <thead>
                <tr>
                    <%
//recupar a lista o request
                    List<ExameFisico> listaExame = (List<ExameFisico>) request.getAttribute("listaExame");

                    %>
                    <th>ID</th>
                    <th>Altura</th>
                    <th>Peso</th>
                    <th>Peito</th>
                    <th>Cintura</th>
                    <th>Panturrilha Esquerda</th>
                    <th>Panturrilha Direta</th>    
                    <th>Braço Esquerdo</th>                                   
                    <th>Braço Direito</th>   
                    <th>Antebraço Esquerdo</th> 
                    <th>Antebraço Direito</th>    
                    <th>Gluteo</th>                                       
                </tr>

            </thead>  
            <% for (ExameFisico exame : listaExame) {

            %>
            <tbody>
                <tr>

                    <td class="center"><%= exame.getIdExame()%>  </td>
                    <td class="center"><%= exame.getAltura()%> cm </td>
                    <td class="center"><%= exame.getPeso()%> KG </td>
                    <td class="center"><%= exame.getPeito()%> cm </td>
                    <td class="center"><%= exame.getCintura()%> cm </td>
                    <td class="center"><%= exame.getPantEsquerda()%> cm </td>
                    <td class="center"><%= exame.getPantDireita()%> cm </td>
                    <td class="center"><%= exame.getBracoEsquerdo()%> cm </td>
                    <td class="center"><%= exame.getBracoDireito()%> cm </td>
                    <td class="center"><%= exame.getAntDireito()%> cm </td>
                    <td class="center"><%= exame.getAntEsquerdo()%> cm </td>
                    <td class="center"><%= exame.getGluteo()%> cm </td>

                </tr>
                <%
                    }
                %>

            </tbody>
        </table>
    </div>
</div>
                
                
<c:import url="../tema/footer.jsp"/>   