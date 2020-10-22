package br.com.tadeu.gerenciador.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tadeu.gerenciador.acoes.Acao;

public class ControladorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("ControladorFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAcao = request.getParameter("acao");
		String nome = "br.com.tadeu.gerenciador.acoes." + paramAcao;
		Class<?> classe;
		Object object = null;
		String endereco = null;

		try {
			classe = Class.forName(nome);
			object = classe.newInstance();
			endereco = ((Acao) object).executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] url = endereco.split(":");
		if (url[0].equals("forward")) {
			RequestDispatcher rd2 = request.getRequestDispatcher("WEB-INF/views/" + url[1]);
			rd2.forward(request, response);
		} else if (url[0].equals("redirect")) {
			response.sendRedirect(url[1]);
		}

	}

}
