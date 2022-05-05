package pe.edu.upc.Trabajo_Parcial.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Trabajo_Parcial.business.crud.CategoryService;
import pe.edu.upc.Trabajo_Parcial.model.entity.Category;
import pe.edu.upc.Trabajo_Parcial.model.repository.CategoryRepository;
import pe.edu.upc.Trabajo_Parcial.model.repository.JpaRepository;
@Named
@ApplicationScoped
public class CategoryServiceImpl implements CategoryService{

	@Inject
	private CategoryRepository categoryRepository;
	
	@Override
	public JpaRepository<Category, Integer> getJpaRepository() {
		return this.categoryRepository;
	}

}
