package by.it.akhmelev.project08.java.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageEncoder implements Filter {
    private String encode;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encode=filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        String characterEncoding = request.getCharacterEncoding();
        if (characterEncoding==null || !characterEncoding.equals(encode))
            request.setCharacterEncoding(encode);

        HttpServletResponse response= (HttpServletResponse) servletResponse;
        characterEncoding = response.getCharacterEncoding();
        if (characterEncoding==null || !characterEncoding.equals(encode))
            response.setCharacterEncoding(encode);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
