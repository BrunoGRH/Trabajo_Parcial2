package pe.edu.upc.Trabajo_Parcial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Trabajo_Parcial.business.crud.CategoryService;
import pe.edu.upc.Trabajo_Parcial.business.crud.CrudService;
import pe.edu.upc.Trabajo_Parcial.model.entity.Category;


@Named("CategoryView")
@ViewScoped
public class CategoryView implements Serializable, EntityView<Category, Integer> {

	private static final long serialVersionUID = 1L;

	private List<Category> entities;
	private Category entitySelected;
	private List<Category> entitiesSelected;
	private Category entitySearch;
	
	@Inject
	private CategoryService entityService;
	
	@PostConstruct
	public void init() {
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new Category();
		getAllEntities();
	}
	
	@Override
	public CrudService<Category, Integer> getCrudService() {
		return this.entityService;
	}

	@Override
	public void createNew() {
		this.entitySelected = new Category();
	}

	@Override
	public Integer getIdFromEntitySelected() {
		return this.entitySelected.getCategoryId();
	}

	@Override
	public void searchEntity() {
		try {	// Modificar de acuerdo al atributo a buscar
			this.entities = this.entityService.search(this.entitySearch.getCategoryName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Category> getEntities() {
		return entities;
	}

	public void setEntities(List<Category> entities) {
		this.entities = entities;
	}

	public Category getEntitySelected() {
		return entitySelected;
	}

	public void setEntitySelected(Category entitySelected) {
		this.entitySelected = entitySelected;
	}

	public List<Category> getEntitiesSelected() {
		return entitiesSelected;
	}

	public void setEntitiesSelected(List<Category> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}

	public Category getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(Category entitySearch) {
		this.entitySearch = entitySearch;
	}

	public CategoryService getEntityService() {
		return entityService;
	}

	public void setEntityService(CategoryService entityService) {
		this.entityService = entityService;
	}

}
