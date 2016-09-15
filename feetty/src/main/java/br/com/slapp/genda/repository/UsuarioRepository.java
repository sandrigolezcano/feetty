package br.com.slapp.genda.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.slapp.genda.model.Usuario;

@Repository
public class UsuarioRepository {

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	@SuppressWarnings("unchecked")
	public List<Usuario> getAll() {
		return entityManager.createNativeQuery("select * from usuarios", Usuario.class).getResultList();
	}

	public Usuario getById(Integer id) {
		return entityManager.find(Usuario.class, id);
	}

	public Usuario save(Usuario usuario) {
		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();
		return usuario;
	}
	
	public Usuario update(Usuario usuario) {
		entityManager.getTransaction().begin();
		entityManager.merge(usuario);
		entityManager.getTransaction().commit();
		return usuario;
	}

	public void delete(Usuario usuario) {
		entityManager.remove(usuario);
	}

}
