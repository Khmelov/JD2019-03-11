package by.it.khlystunova.project.java.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class ImageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String[] parts = req.getRequestURI().split("/");
        String name = parts[parts.length - 1];
        String path = req.getServletContext().getRealPath("/images") + File.separator + name;
        if (name.equals("no-image.jpg") || new File(path).exists()){
            filterChain.doFilter(req, resp);
        }
        else req.getRequestDispatcher("/images/no-image.jpg").forward(req,resp);

    }

    @Override
    public void destroy() {

    }
}
