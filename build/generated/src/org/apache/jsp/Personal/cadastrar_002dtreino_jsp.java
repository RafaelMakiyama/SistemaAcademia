package org.apache.jsp.Personal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Atleta;
import Modelo.Usuario;

public final class cadastrar_002dtreino_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_c_import_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<body>\n");
      out.write("    ");


        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Atleta sessaoAtleta = (Atleta) session.getAttribute("sessaoAtleta");

    
      out.write("     \n");
      out.write("    ");
      if (_jspx_meth_c_import_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_c_import_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_c_import_3(_jspx_page_context))
        return;
      out.write("    \n");
      out.write("\n");
      out.write("    <div class=\"box span12\">\n");
      out.write("        <div class=\"box-header\">\n");
      out.write("            <h2> Cadastrar treino</h2>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"box-content\">\n");
      out.write("            <form class=\"form-horizontal\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ControleTreino\" method=\"post\">\n");
      out.write("                <fieldset>\n");
      out.write("\n");
      out.write("                    <div class=\"control-group\">\n");
      out.write("                        <label class=\"control-label\"> Nome do exercício. </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Digite o nome do exercício.\" name=\"nomeExercicio\" id=\"nomeExercicio\" >                        \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"control-group\">\n");
      out.write("                        <label class=\"control-label\"> Tipo do treinamento</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Digite o tipo do treinamento\" name=\"tipoTreinamento\">      \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"control-group\">\n");
      out.write("                        <label class=\"control-label\" for=\"date01\">Date input</label>\n");
      out.write("                        <div class=\"controls\">\n");
      out.write("                            <input type=\"text\" class=\"input-xlarge datepicker\" id=\"date01\" value=\"16/05/12\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"control-group\">\n");
      out.write("                        <label class=\"control-label\"> Séries </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Digite a quantidade de séries.\" name=\"series\">    <br>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-actions\">\n");
      out.write("                        <button type=\"submit\" name=\"acao\" value=\"Cadastrar\" class=\"btn btn-primary\">Cadastrar Treino</button>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-actions\">\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        <input type=\"hidden\" name=\"idPersonal\" value=\"");
      out.print( sessaoAtleta.getId());
      out.write("\" />\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </fieldset>\n");
      out.write("            </form> \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_c_import_4(_jspx_page_context))
        return;
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
    _jspx_th_c_import_1.setUrl("../tema/cabecalhoPersonal.jsp");
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
    _jspx_th_c_import_2.setUrl("../tema/menuPersonal.jsp");
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

  private boolean _jspx_meth_c_import_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_3 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_3.setPageContext(_jspx_page_context);
    _jspx_th_c_import_3.setParent(null);
    _jspx_th_c_import_3.setUrl("../tema/conteudo.jsp");
    int[] _jspx_push_body_count_c_import_3 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_3 = _jspx_th_c_import_3.doStartTag();
      if (_jspx_th_c_import_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_3.doFinally();
      _jspx_tagPool_c_import_url_nobody.reuse(_jspx_th_c_import_3);
    }
    return false;
  }

  private boolean _jspx_meth_c_import_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_4 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_4.setPageContext(_jspx_page_context);
    _jspx_th_c_import_4.setParent(null);
    _jspx_th_c_import_4.setUrl("../tema/footer.jsp");
    int[] _jspx_push_body_count_c_import_4 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_4 = _jspx_th_c_import_4.doStartTag();
      if (_jspx_th_c_import_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_4.doFinally();
      _jspx_tagPool_c_import_url_nobody.reuse(_jspx_th_c_import_4);
    }
    return false;
  }
}
