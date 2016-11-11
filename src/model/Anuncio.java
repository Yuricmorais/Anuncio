package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Anuncio {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private Double valor;
	
	private String fabricante;
	
	private String modelo;
	
	private int ano;
	
	private String potenciaM;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPotenciaM() {
		return potenciaM;
	}

	public void setPotenciaM(String potenciaM) {
		this.potenciaM = potenciaM;
	}
	
	
	
	
	
	
	

}
