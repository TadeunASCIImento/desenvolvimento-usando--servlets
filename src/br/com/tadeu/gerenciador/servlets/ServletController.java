package br.com.tadeu.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tadeu.gerenciador.acoes.Acao;

@WebServlet("/empresa")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		String nome = "br.com.tadeu.gerenciador.acoes." + paramAcao;// nome da classe.
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
