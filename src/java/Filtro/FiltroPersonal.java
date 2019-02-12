package Filtro;

import Modelo.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FiltroPersonal implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession();

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null && usuario.getPerfilAcesso().equals("Personal")) {
            
            chain.doFilter(request, response);
            
        } else {
            ((HttpServletResponse) response).sendRedirect("../nao-autenticado.jsp");
        }
        /* 
         *    session.setAttribute("msg", "voce nao é logado");
         *    ((HttpServletResponse) response).sendRedirect("../nao-autenticado.jsp");
         */

    }

    @Override
    public void destroy() {

    }
}
