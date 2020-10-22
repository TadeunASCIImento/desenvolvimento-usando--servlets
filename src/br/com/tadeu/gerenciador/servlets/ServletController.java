package br.com.tadeu.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tadeu.gerenciador.acoes.AlteraEmpresa;
import br.com.tadeu.gerenciador.acoes.EditaEmpresa;
import br.com.tadeu.gerenciador.acoes.ListaEmpresas;
import br.com.tadeu.gerenciador.acoes.NovaEmpresa;
import br.com.tadeu.gerenciador.acoes.NovaEmpresaForm;
import br.com.tadeu.gerenciador.acoes.RemoveEmpresa;

@WebServlet("/controller")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// POST
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		String endereco = null;
		switch (paramAcao) {
		case "create":
			endereco = new NovaEmpresa().executa(request, response);
			break;

		case "update":
			endereco = new AlteraEmpresa().executa(request, response);
			break;
		}

		String[] url = endereco.split(":");
		if (url[0].equals("forward")) {
			RequestDispatcher rd2 = request.getRequestDispatcher("WEB-INF/views/" + url[1]);
			rd2.forward(request, response);
		} else if (url[0].equals("redirect")) {
			response.sendRedirect(url[1]);
		}

	}

	// GET
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		String endereco = null;
		switch (paramAcao) {
		case "edit":
			endereco = new EditaEmpresa().executa(request, response);
			break;

		case "delete":
			endereco = new RemoveEmpresa().executa(request, response);
			break;

		case "list":
			endereco = new ListaEmpresas().executa(request, response);
			break;

		case "NovaEmpresaForm":
			endereco = new NovaEmpresaForm().executa(request, response);
			break;
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
