package pl.tweeter.filtres;

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

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class AuthenticationFilter implements Filter {
	public AuthenticationFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain )
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession sess = req.getSession();

		if (sess.getAttribute("user") == null && !req.getRequestURI().equals("/Tweeter/login") && !req.getRequestURI().equals("/Tweeter/user/add")) {
			sess.setAttribute("message", "You have to login");
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			chain.doFilter(request, response);
		}

		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
