package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Anuncio;

import persistence.AnuncioDAO;


@ManagedBean
@SessionScoped
public class AnuncioBean {

	private Anuncio anuncio;
	

	private List<Anuncio> anuncios = new ArrayList<Anuncio>();

	public AnuncioBean() {
		
		anuncios = new AnuncioDAO().listarTodos();
		anuncio = new Anuncio();

	}

	public String salvar() {
		
		new AnuncioDAO().salvar(anuncio);
		anuncios = new AnuncioDAO().listarTodos();
		anuncio = new Anuncio();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Anuncio cadastrado com sucesso!"));
		return "index?faces-redirect=true";
	}

	public String editar(Anuncio anuncio) {
		this.anuncio = anuncio;

		return "cadastro_anuncio?faces-redirect=true";
	}

	public void deletar(Anuncio anuncio) {
		new AnuncioDAO().deletar(anuncio);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario deletado com sucesso!"));
		anuncios = new AnuncioDAO().listarTodos();

	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

}
