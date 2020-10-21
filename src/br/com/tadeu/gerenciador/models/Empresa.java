package br.com.tadeu.gerenciador.models;

import java.math.BigInteger;
import java.util.Date;

public class Empresa {

	private BigInteger id;
	private String nome;
	private Date dataAbertura;

	public Empresa(BigInteger id, String nome, Date dataAbertura) {
		this.id = id;
		this.nome = nome;
		this.dataAbertura = dataAbertura;
	}

	public Empresa() {

	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

}
