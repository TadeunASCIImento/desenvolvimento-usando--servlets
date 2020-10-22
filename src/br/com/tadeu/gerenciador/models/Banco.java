package br.com.tadeu.gerenciador.models;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<Empresa>();
	private static List<Usuario> usuarios = new ArrayList<Usuario>();

	static {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataAberturaEmpresa1 = null, dataAberturaEmpresa2 = null;
		try {
			dataAberturaEmpresa1 = sdf.parse("1986-09-12");
			dataAberturaEmpresa2 = sdf.parse("1990-11-30");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Empresa empresa1 = new Empresa();
		empresa1.setId(new BigInteger("65000115967"));
		empresa1.setNome("Google");
		empresa1.setDataAbertura(dataAberturaEmpresa1);

		Empresa empresa2 = new Empresa();
		empresa2.setId(new BigInteger("64000115690"));
		empresa2.setNome("Facebook");
		empresa2.setDataAbertura(dataAberturaEmpresa2);
		empresas.add(empresa1);
		empresas.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setLogin("tadeu");
		u1.setSenha("12345");
		Usuario u2 = new Usuario();
		u2.setLogin("angela");
		u2.setSenha("12345");
		usuarios.add(u1);
		usuarios.add(u2);

	}

	public void adiciona(Empresa empresa) {
		Banco.empresas.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

	public void remove(BigInteger id) {
		Empresa empresaRemovida = new Empresa();
		for (Empresa empresa : empresas) {
			if (empresa.getId().equals(id)) {
				empresaRemovida = empresa;
			}
		}
		empresas.remove(empresaRemovida);
	}

	public Empresa findOne(BigInteger idEmpresa) {
		for (Empresa empresa : empresas) {
			if (empresa.getId().equals(idEmpresa)) {
				return empresa;
			}
		}

		return null;
	}

	public Usuario findUsuario(String login, String senha) {
		for (Usuario usuario : usuarios) {
			if (usuario.validaUsuario(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
