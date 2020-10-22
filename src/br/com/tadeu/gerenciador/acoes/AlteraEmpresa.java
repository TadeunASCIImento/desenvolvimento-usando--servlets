package br.com.tadeu.gerenciador.acoes;

import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tadeu.gerenciador.models.Banco;
import br.com.tadeu.gerenciador.models.Empresa;

public class AlteraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String paramId = request.getParameter("id");
		String paramNome = request.getParameter("nome");
		String paramData = request.getParameter("dataAbertura");

		Date dataAbertura = null;
		try {
			SimpleDateFormat sdfu = new SimpleDateFormat("yyyy/MM/dd");
			dataAbertura = sdfu.parse(paramData);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		BigInteger idEmpresa = new BigInteger(paramId);
		Empresa empresa = new Banco().findOne(idEmpresa);

		empresa.setId(idEmpresa);
		empresa.setNome(paramNome);
		empresa.setDataAbertura(dataAbertura);

		return "redirect:empresa?acao=ListaEmpresas";

	}

}
