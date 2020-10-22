package br.com.tadeu.gerenciador.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MonitoramentoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("MonitoramentoFilter");
		String acao = request.getParameter("acao");
		Long antes = System.currentTimeMillis();
		chain.doFilter(request, response);
		Long depois = System.currentTimeMillis();
		System.out.printf("Tempo de execu��o da a��o %s: -> %dms\n", acao, (depois - antes));
	}

}