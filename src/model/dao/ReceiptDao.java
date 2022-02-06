package model.dao;

import java.util.List;

import model.entities.Customer;
import model.entities.Receipt;

public interface ReceiptDao {

	
	  void insert(Receipt obj); 
	  void update(Receipt obj);
	  void deleteByCod(Integer cod); 
	  Receipt findByCod(Integer cod);
	  List<Receipt> findAll();
<<<<<<< HEAD
	  List<Receipt> findByCustomer(Customer customer);
	 
=======
	  List<Receipt> findByDepartment(Customer client);
	  void updatePayment(Receipt obj);
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb
	 }