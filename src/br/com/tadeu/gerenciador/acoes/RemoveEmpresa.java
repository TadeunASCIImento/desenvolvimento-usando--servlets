package br.com.tadeu.gerenciador.acoes;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tadeu.gerenciador.models.Banco;

public class RemoveEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String paramId = request.getParameter("id");

		new Banco().remove(new BigInteger(paramId));

		return "redirect:empresa?acao=ListaEmpresas";

	}

}
