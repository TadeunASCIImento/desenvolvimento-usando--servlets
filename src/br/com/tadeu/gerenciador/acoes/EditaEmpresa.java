package br.com.tadeu.gerenciador.acoes;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tadeu.gerenciador.models.Banco;
import br.com.tadeu.gerenciador.models.Empresa;

public class EditaEmpresa {

	public void executa(String paramId, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BigInteger idEmpresa = new BigInteger(paramId);
		Empresa empresa = new Banco().findOne(idEmpresa);
		request.setAttribute("empresa", empresa);
		RequestDispatcher rd = request.getRequestDispatcher("/formularioAlteracao.jsp");
		rd.forward(request, response);
	}

}
