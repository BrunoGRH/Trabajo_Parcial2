package pe.edu.upc.Trabajo_Parcial.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.Trabajo_Parcial.model.entity.Restaurant;
import pe.edu.upc.Trabajo_Parcial.model.repository.RestaurantRepository;
@Named
@ApplicationScoped
public class RestaurantRepositoryImpl implements RestaurantRepository{

	@PersistenceContext(unitName = "Trabajo_ParcialPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return this.entityManager;
	}

	@Override
	public Optional<Restaurant> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return this.findById(id, Restaurant.class);
	}

	@Override
	public List<Restaurant> findAll() throws Exception {
		String jpql = "SELECT restaurants FROM Restaurant restaurants";
		return this.findByQuery(Restaurant.class, jpql);
	}

	@Override
	public List<Restaurant> findByData(String data) throws Exception {
		String jpql = "SELECT restaurants FROM Restaurant restaurants WHERE restaurants.name_restaurants LIKE '" + data  + "'";
		return this.findByQuery(Restaurant.class, jpql);
	}

}
