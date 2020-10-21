package br.com.tadeu.gerenciador.servlets;

import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tadeu.gerenciador.acoes.EditaEmpresa;
import br.com.tadeu.gerenciador.acoes.ListaEmpresas;
import br.com.tadeu.gerenciador.acoes.RemoveEmpresa;
import br.com.tadeu.gerenciador.models.Banco;
import br.com.tadeu.gerenciador.models.Empresa;

@WebServlet("/api")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		String paramId = request.getParameter("id");
		String paramNome = request.getParameter("nome");
		String paramData = request.getParameter("dataAbertura");
		Date dataAbertura;
		Banco bd = new Banco();
		Empresa empresa = new Empresa();

		switch (paramAcao) {
		case "create":

			try {
				SimpleDateFormat sdfc = new SimpleDateFormat("yyyy-MM-dd");
				dataAbertura = sdfc.parse(paramData);
			} catch (ParseException e) {
				throw new ServletException(e);
			}
			empresa.setNome(paramNome);
			empresa.setId(new BigInteger(paramId));
			empresa.setDataAbertura(dataAbertura);
			bd.adiciona(empresa);
			response.sendRedirect("api?acao=list");

			break;

		case "update":
			try {
				SimpleDateFormat sdfu = new SimpleDateFormat("yyyy/MM/dd");
				dataAbertura = sdfu.parse(paramData);
			} catch (ParseException e) {
				throw new ServletException(e);
			}

			BigInteger idEmpresa = new BigInteger(paramId);
			empresa = new Banco().findOne(idEmpresa);
			empresa.setId(idEmpresa);
			empresa.setNome(paramNome);
			empresa.setDataAbertura(dataAbertura);
			response.sendRedirect("api?acao=list");
			break;
		}

	}

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
