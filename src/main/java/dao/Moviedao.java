package dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Movie;

public class Moviedao 
{
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("Mohan");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();

	public void saveMovie(Movie movie) 
	{
		transaction.begin();
		manager.persist(movie);
		transaction.commit();
	}
	public List<Movie>fetchmovies()
	{
		return manager.createNativeQuery("select s from movie s").getResultList();
	}
}
