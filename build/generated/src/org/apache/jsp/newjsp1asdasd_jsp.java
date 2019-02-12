package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Usuario;

public final class newjsp1asdasd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_import_url_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_import_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_import_url_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      if (_jspx_meth_c_import_0(_jspx_page_context))
        return;
      out.write("    \n");
      out.write("<body>\n");
      out.write("   \n");
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_c_import_1(_jspx_page_context))
        return;
      out.write("  \n");
      out.write("\n");
      out.write("    <!-- Adicionando Javascript para achar CEP -->\n");
      out.write("    <script type=\"text/javascript\" >\n");
      out.write("        $(document).ready(function () {\n");
      out.write("\n");
      out.write("            function limpa_formulário_cep() {\n");
      out.write("                // Limpa valores do formulário de cep.\n");
      out.write("                $(\"#rua\").val(\"\");\n");
      out.write("                $(\"#bairro\").val(\"\");\n");
      out.write("                $(\"#cidade\").val(\"\");\n");
      out.write("                $(\"#uf\").val(\"\");\n");
      out.write("                $(\"#ibge\").val(\"\");\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            //Quando o campo cep perde o foco.\n");
      out.write("            $(\"#cep\").blur(function () {\n");
      out.write("\n");
      out.write("                //Nova variável \"cep\" somente com dígitos.\n");
      out.write("                var cep = $(this).val().replace(/\\D/g, '');\n");
      out.write("\n");
      out.write("                //Verifica se campo cep possui valor informado.\n");
      out.write("                if (cep != \"\") {\n");
      out.write("\n");
      out.write("                    //Expressão regular para validar o CEP.\n");
      out.write("                    var validacep = /^[0-9]{8}$/;\n");
      out.write("\n");
      out.write("                    //Valida o formato do CEP.\n");
      out.write("                    if (validacep.test(cep)) {\n");
      out.write("\n");
      out.write("                        //Preenche os campos com \"...\" enquanto consulta webservice.\n");
      out.write("                        $(\"#rua\").val(\"...\");\n");
      out.write("                        $(\"#bairro\").val(\"...\");\n");
      out.write("                        $(\"#cidade\").val(\"...\");\n");
      out.write("                        $(\"#uf\").val(\"...\");\n");
      out.write("                        $(\"#ibge\").val(\"...\");\n");
      out.write("\n");
      out.write("                        //Consulta o webservice viacep.com.br/\n");
      out.write("                        $.getJSON(\"//viacep.com.br/ws/\" + cep + \"/json/?callback=?\", function (dados) {\n");
      out.write("\n");
      out.write("                            if (!(\"erro\" in dados)) {\n");
      out.write("                                //Atualiza os campos com os valores da consulta.\n");
      out.write("                                $(\"#rua\").val(dados.logradouro);\n");
      out.write("                                $(\"#bairro\").val(dados.bairro);\n");
      out.write("                                $(\"#cidade\").val(dados.localidade);\n");
      out.write("                                $(\"#uf\").val(dados.uf);\n");
      out.write("                                $(\"#ibge\").val(dados.ibge);\n");
      out.write("                            } //end if.\n");
      out.write("                            else {\n");
      out.write("                                //CEP pesquisado não foi encontrado.\n");
      out.write("                                limpa_formulário_cep();\n");
      out.write("                                alert(\"CEP não encontrado.\");\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                    } //end if.\n");
      out.write("                    else {\n");
      out.write("                        //cep é inválido.\n");
      out.write("                        limpa_formulário_cep();\n");
      out.write("                        alert(\"Formato de CEP inválido.\");\n");
      out.write("                    }\n");
      out.write("                } //end if.\n");
      out.write("                else {\n");
      out.write("                    //cep sem valor, limpa formulário.\n");
      out.write("                    limpa_formulário_cep();\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Formulário Pessoa -->\n");
      out.write("    <div class=\"col-md-12\"></h1>\n");
      out.write("        <p> Cadastre suas informações pessoais. </p>\n");
      out.write("        <div class=\"col-md-12\">\n");
      out.write("            <form method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ControlePessoal\">\n");
      out.write("                <label> Nome completo. </label>\n");
      out.write("                <input type=\"text\"  placeholder=\"Digite o nome completo.\" id=\"nomeCompleto\" name=\"nomeCompleto\">                        \n");
      out.write("                <label> Data de nascimento. </label>\n");
      out.write("                <input type=\"date\" class=\"form-control\" name=\"aniversario\" id=\"aniversario\">                        \n");
      out.write("                <label> Sexo. </label>\n");
      out.write("                <select id=\"sexo\" name=\"sexo\" > \n");
      out.write("                    <option value=\"Feminino\">Feminino</option>\n");
      out.write("                    <option value=\"Masculino\">Masculino</option>\n");
      out.write("                </select><br>\n");
      out.write("                <label> Telefone </label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"Digite o telefone.\" id=\"telefone\" name=\"telefone\">                        \n");
      out.write("                <label> Celular </label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"Digite o celular. \" id=\"celular\" name=\"celular\"> \n");
      out.write("\n");
      out.write("\n");
      out.write("                <label> CEP </label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"Digite o cep. \" id=\"cep\" name=\"cep\" value=\"\" onblur=\"pesquisacep(this.value);\n");
      out.write("                       \" />        \n");
      out.write("                <label> Endereço </label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"Digite o endereço. \" id=\"rua\" name=\"rua\" size=\"60\">        \n");
      out.write("                <label> Bairro </label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"Digite o bairro. \" id=\"bairro\" name=\"bairro\" size=\"40\">        \n");
      out.write("                <label> Cidade </label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"Digite a cidade. \" id=\"cidade\" name=\"cidade\" size=\"40\">        \n");
      out.write("                <label> Estado </label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"Digite o estado. \"  id=\"uf\" name=\"uf\" size=\"2\"> \n");
      out.write("\n");
      out.write("                <input type=\"hidden\" name=\"id_usuario\" value=\"()%>\" />\n");
      out.write("                <button class=\"btn btn-default\" name=\"acao\" value=\"cadastrarPessoa\" type=\"submit\">Próximo.</button>\n");
      out.write("\n");
      out.write("        </div>  \n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_import_2(_jspx_page_context))
        return;
      out.write('\n');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_import_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_0.setPageContext(_jspx_page_context);
    _jspx_th_c_import_0.setParent(null);
    _jspx_th_c_import_0.setUrl("../tema/header.jsp");
    int[] _jspx_push_body_count_c_import_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_0 = _jspx_th_c_import_0.doStartTag();
      if (_jspx_th_c_import_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_0.doFinally();
      _jspx_tagPool_c_import_url_nobody.reuse(_jspx_th_c_import_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_import_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_1 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_1.setPageContext(_jspx_page_context);
    _jspx_th_c_import_1.setParent(null);
    _jspx_th_c_import_1.setUrl("../tema/conteudo.jsp");
    int[] _jspx_push_body_count_c_import_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_1 = _jspx_th_c_import_1.doStartTag();
      if (_jspx_th_c_import_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_1.doFinally();
      _jspx_tagPool_c_import_url_nobody.reuse(_jspx_th_c_import_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_import_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_2 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_2.setPageContext(_jspx_page_context);
    _jspx_th_c_import_2.setParent(null);
    _jspx_th_c_import_2.setUrl("../tema/footer.jsp");
    int[] _jspx_push_body_count_c_import_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_2 = _jspx_th_c_import_2.doStartTag();
      if (_jspx_th_c_import_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_2.doFinally();
      _jspx_tagPool_c_import_url_nobody.reuse(_jspx_th_c_import_2);
    }
    return false;
  }
}
