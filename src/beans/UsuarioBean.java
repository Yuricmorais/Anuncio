package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Usuario;
import persistence.UsuarioDAO;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private Usuario usuario;

	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public UsuarioBean() {
		usuarios = new UsuarioDAO().listarTodos();
		usuario = new Usuario();

	}

	public String salvar() {
		
		new UsuarioDAO().salvar(usuario);
		usuarios = new UsuarioDAO().listarTodos();
		usuario = new Usuario();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario cadastrado com sucesso!"));
		return "login?faces-redirect=true";
	}

	public String editar(Usuario usuario) {
		this.usuario = usuario;

		return "cadastro?faces-redirect=true";
	}

	public void deletar(Usuario usuario) {
		new UsuarioDAO().deletar(usuario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario deletado com sucesso!"));
		usuarios = new UsuarioDAO().listarTodos();

	}

	public String verificarUsuario() throws Exception {
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario us;
		String resultado;

		try {
			us = usuDAO.verificarDados(this.usuario);

			if (us != null) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
			

				resultado = "index?faces-redirect=true";
			} else {
				resultado = "Error";
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario não existe"));
			}

		} catch (Exception e) {
			throw e;
		}

		return resultado;
	}

	// verificar se o usuario esta logado
	public boolean verificarSessao() {
		boolean estado;

		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") == null) {
			estado = false;
		} else {
			estado = true;
		}
		return estado;
	}

	// logout
	public String encerrarSessao() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		System.out.println("usei metodo");
		return "index?faces-redirect=true";
	}
	
	public void getAttribute(Integer id) {
		FacesContext fc = FacesContext.getCurrentInstance();
		 fc.getExternalContext().getSession(false);
			
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
