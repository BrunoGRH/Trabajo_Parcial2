package pe.edu.upc.Trabajo_Parcial.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.Trabajo_Parcial.model.entity.Category;
import pe.edu.upc.Trabajo_Parcial.model.repository.CategoryRepository;
@Named
@ApplicationScoped
public class CategoryRepositoryImpl implements CategoryRepository{

	@PersistenceContext(unitName = "Trabajo_ParcialPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return this.entityManager;
	}

	@Override
	public Optional<Category> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return this.findById(id, Category.class);
	}

	@Override
	public List<Category> findAll() throws Exception {
		String jpql = "SELECT categorys FROM Category categorys";
		return this.findByQuery(Category.class, jpql);
	}

	@Override
	public List<Category> findByData(String data) throws Exception {
		String jpql = "SELECT categorys FROM Category categorys WHERE categorys.name_category\" LIKE '" + data  + "'";
		return this.findByQuery(Category.class, jpql);
	}

}
