package br.com.tadeu.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/empresa")
public class MonitoramentoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String acao = request.getParameter("acao");

		Long antes = System.currentTimeMillis();
		chain.doFilter(request, response);
		Long depois = System.currentTimeMillis();

		System.out.printf("Tempo de execução da ação %s: -> %dms\n", acao, (depois - antes));
	}

}
