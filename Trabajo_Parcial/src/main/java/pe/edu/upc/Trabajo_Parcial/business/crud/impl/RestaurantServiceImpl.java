package pe.edu.upc.Trabajo_Parcial.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.Trabajo_Parcial.business.crud.RestaurantService;
import pe.edu.upc.Trabajo_Parcial.model.entity.Restaurant;
import pe.edu.upc.Trabajo_Parcial.model.repository.JpaRepository;
import pe.edu.upc.Trabajo_Parcial.model.repository.RestaurantRepository;
@Named
@ApplicationScoped
public class RestaurantServiceImpl implements RestaurantService{

	@Inject
	private RestaurantRepository restaurantRepository;
	
	@Override
	public JpaRepository<Restaurant, Integer> getJpaRepository() {
		return this.restaurantRepository;
	}

}
