package model.dao;

import java.util.List;

import model.entities.Customer;

public interface ClientDao {

	void insert(Customer obj);
	void update(Customer obj);
	void deleteById(Integer id);
	Customer findById(Integer id);
	List<Customer> findAll();
}