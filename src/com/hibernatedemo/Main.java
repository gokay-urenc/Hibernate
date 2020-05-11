package com.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(City.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			// SELECT OPERATIONS
			
			// FROM City c WHERE c.countryCode = 'TUR' AND c.district = 'Ankara'
			// FROM City c WHERE c.name LIKE '%kar%'
			// FROM City c ORDER BY c.name ASC
			// FROM City c ORDER BY c.name DESC
			
			/*
			List<City> cities = session.createQuery("FROM City c ORDER BY c.name DESC").getResultList();
			for (City city : cities) {
				System.out.println(city.getName());
			}
			*/
			
			/*
			List<String> countryCodes = session.createQuery("SELECT c.countryCode FROM City c GROUP BY c.countryCode").getResultList();
			for (String countryCode : countryCodes) {
				System.out.println(countryCode);
			}
			*/
			
			// INSERT
			/*
			City city = new City();
			city.setName("TestCity");
			city.setCountryCode("TUR");
			city.setDistrict("TestDistrict");
			city.setPopulation(100000);
			session.save(city);
			System.out.println(city.getName() + " added.");
			*/
			
			// UPDATE
			/*
			City city = session.get(City.class, 4097);
			city.setPopulation(110000);
			session.save(city);
			System.out.println(city.getName() + " updated.");
			*/
			
			// DELETE
			/*
			City city = session.get(City.class, 4097);
			session.delete(city);
			*/
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}
}












