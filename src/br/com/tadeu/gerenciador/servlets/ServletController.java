package br.com.tadeu.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tadeu.gerenciador.acoes.AlteraEmpresa;
import br.com.tadeu.gerenciador.acoes.EditaEmpresa;
import br.com.tadeu.gerenciador.acoes.ListaEmpresas;
import br.com.tadeu.gerenciador.acoes.NovaEmpresa;
import br.com.tadeu.gerenciador.acoes.RemoveEmpresa;

@WebServlet("/controller")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// POST
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		String paramId = request.getParameter("id");
		String paramNome = request.getParameter("nome");
		String paramData = request.getParameter("dataAbertura");

		switch (paramAcao) {
		case "create":
			new NovaEmpresa().executa(paramData, paramNome, paramId, request, response);
			break;

		case "update":
			new AlteraEmpresa().executa(paramData, paramId, paramNome, request, response);
			break;
		}

	}

	// GET
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		String paramId = request.getParameter("id");

		switch (paramAcao) {
		case "edit":
			new EditaEmpresa().executa(paramId, request, response);
			break;

		case "delete":
			new RemoveEmpresa().executa(paramId, request, response);
			break;

		case "list":
			new ListaEmpresas().executa(request, response);
			break;
		}

	}

}
