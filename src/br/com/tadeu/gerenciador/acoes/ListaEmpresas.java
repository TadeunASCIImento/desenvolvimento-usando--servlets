package br.com.tadeu.gerenciador.acoes;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tadeu.gerenciador.models.Banco;
import br.com.tadeu.gerenciador.models.Empresa;

public class ListaEmpresas {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Empresa> empresas = new Banco().getEmpresas();
		RequestDispatcher rd2 = request.getRequestDispatcher("/listaEmpresas.jsp");
		request.setAttribute("empresas", empresas);
		rd2.forward(request, response);
	}

}
