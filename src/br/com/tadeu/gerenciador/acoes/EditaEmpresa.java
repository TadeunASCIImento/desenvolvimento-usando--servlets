package br.com.tadeu.gerenciador.acoes;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tadeu.gerenciador.models.Banco;
import br.com.tadeu.gerenciador.models.Empresa;

public class EditaEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramId = request.getParameter("id");
		BigInteger idEmpresa = new BigInteger(paramId);
		Empresa empresa = new Banco().findOne(idEmpresa);

		request.setAttribute("empresa", empresa);

		return "forward:formularioAlteracao.jsp";

	}

}
