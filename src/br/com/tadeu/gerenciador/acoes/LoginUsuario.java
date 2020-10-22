package br.com.tadeu.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.tadeu.gerenciador.models.Banco;
import br.com.tadeu.gerenciador.models.Usuario;

public class LoginUsuario implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Usuario usuario = new Banco().findUsuario(login, senha);

		if (usuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			return "redirect:empresa?acao=ListaEmpresas";
		} else {
			return "redirect:empresa?acao=LoginUsuarioForm";
		}

	}

}
