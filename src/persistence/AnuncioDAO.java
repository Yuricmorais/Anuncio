package persistence;

import java.util.List;

import javax.persistence.EntityManager;


import model.Anuncio;

import util.JPAUtil;

public class AnuncioDAO {

	public void salvar(Anuncio usuario) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		gerente.merge(usuario);
		gerente.getTransaction().commit();
		gerente.close();

	}
	
	@SuppressWarnings("unchecked")
	public List<Anuncio> buscarPorNome(String nome){
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		return gerente.createQuery("from Anuncio a where a,nome like nome").getResultList();
		
	}

	@SuppressWarnings("unchecked")
	public List<Anuncio> listarTodos() {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();

		return gerente.createQuery("from Anuncio").getResultList();

	}

	public void Editar(Anuncio usuario) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		gerente.merge(usuario);
		gerente.getTransaction().commit();
		gerente.close();

	}


	public void deletar(Anuncio usuario) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		usuario = gerente.merge(usuario);
		gerente.remove(usuario);
		gerente.getTransaction().commit();
		gerente.close();
	}

}
