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

public class AlteraEmpresa {

	public void executa(String paramData, String paramId, String paramNome, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		SimpleDateFormat sdfu = new SimpleDateFormat("yyyy/MM/dd");
		Date dataAbertura = null;
		try {
			dataAbertura = sdfu.parse(paramData);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		BigInteger idEmpresa = new BigInteger(paramId);
		Empresa empresa = new Banco().findOne(idEmpresa);
		empresa.setId(idEmpresa);
		empresa.setNome(paramNome);
		empresa.setDataAbertura(dataAbertura);

		response.sendRedirect("controller?acao=list");

	}

}
