package br.com.tadeu.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresaForm {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

		return "forward:formularioNovaEmpresa.jsp";

	}

}
