package by.it.eslaikouskaya.project.java.filters;

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
	public void doFilter(ServletRequest servletRequest,
	                     ServletResponse servletResponse,
	                     FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String uri = request.getRequestURI();
		String[] parts = uri.split("/");
		String filename = parts[parts.length - 1];
		filename = request.getServletContext()
				.getRealPath("/images") + File.separator + filename;
		if (filename.equals("no-image.png") || (new File(filename).exists())) {
			filterChain.doFilter(request, response);
		} else
			response.sendRedirect("no-image.png");

	}

	@Override
	public void destroy() {

	}
}
