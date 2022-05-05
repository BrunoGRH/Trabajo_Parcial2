package pe.edu.upc.Trabajo_Parcial.controller;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Trabajo_Parcial.business.crud.CrudService;
import pe.edu.upc.Trabajo_Parcial.business.crud.RestaurantService;
import pe.edu.upc.Trabajo_Parcial.model.entity.Category;
import pe.edu.upc.Trabajo_Parcial.model.entity.Restaurant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named("RestaurantView")
@ViewScoped
public class RestaurantView implements Serializable, EntityView<Restaurant, Integer> {

	private static final long serialVersionUID = 1L;
	
	private List<Restaurant> entities;
	private Restaurant entitySelected;
	private List<Restaurant> entitiesSelected;
	private Restaurant entitySearch;
	
	@Inject
	private RestaurantService entityService;
	
	@PostConstruct
	public void init() {
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new Restaurant();
		getAllEntities();
	}
	
	@Override
	public CrudService<Restaurant, Integer> getCrudService() {
		return this.entityService;
	}

	@Override
	public void createNew() {
		this.entitySelected = new Restaurant();
		this.entitySelected.setCategoryId(new Category());
	}

	@Override
	public Integer getIdFromEntitySelected() {
		return this.entitySelected.getRestaurantId();
	}

	public void searchEntity() {
		try {	// Modificar de acuerdo al atributo a buscar
			this.entities = this.entityService.search(this.entitySearch.getName_restaurant());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public List<Restaurant> getEntities() {
		return entities;
	}

	public void setEntities(List<Restaurant> entities) {
		this.entities = entities;
	}

	public Restaurant getEntitySelected() {
		return entitySelected;
	}

	public void setEntitySelected(Restaurant entitySelected) {
		this.entitySelected = entitySelected;
	}

	public List<Restaurant> getEntitiesSelected() {
		return entitiesSelected;
	}

	public void setEntitiesSelected(List<Restaurant> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}

	public Restaurant getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(Restaurant entitySearch) {
		this.entitySearch = entitySearch;
	}

	public RestaurantService getEntityService() {
		return entityService;
	}

	public void setEntityService(RestaurantService entityService) {
		this.entityService = entityService;
	}
	
		
	
}
