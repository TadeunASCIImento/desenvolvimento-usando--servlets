package br.com.tadeu.gerenciador.acoes;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tadeu.gerenciador.models.Banco;

public class RemoveEmpresa {

	public void executa(String paramId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		new Banco().remove(new BigInteger(paramId));
		response.sendRedirect("api?acao=list");

	}

}
