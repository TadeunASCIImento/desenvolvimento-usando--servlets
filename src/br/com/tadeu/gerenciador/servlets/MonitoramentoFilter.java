package br.com.tadeu.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MonitoramentoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("MonitoramentoFilter");
		String acao = request.getParameter("acao");
		Long antes = System.currentTimeMillis();
		chain.doFilter(request, response);
		Long depois = System.currentTimeMillis();
		System.out.printf("Tempo de execução da ação %s: -> %dms\n", acao, (depois - antes));
	}

}
