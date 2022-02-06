package application;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import model.dao.CustomerDao;
import model.dao.DaoFactory;
import model.entities.Customer;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		CustomerDao customerDao = DaoFactory.createCustomerDao();
		char userAnswer;
	
		do {
			System.out.println("=== Choose an option : ===");
			System.out.println("=== 1 - find a customer by code === \n"
								+ "=== 2 - list customers === \n"
								+ "=== 3 - insert a new customer === \n" 
								+ "=== 4 - update a customer === \n"
								+ "=== 5 - delete a customer by code === \n");
			int userChoice = sc.nextInt();
		

			
			if (userChoice == 1) {
<<<<<<< HEAD
				System.out.println("\r\n enter the code of customer you want to search");
				int cod = sc.nextInt();
				Customer client = customerDao.findByCod(cod);
=======
				System.out.println("\r\n enter the id you want to search");
				int id = sc.nextInt();
				Customer client = clientDao.findById(id);
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb
				System.out.println(client);

			} else if (userChoice == 2) {
				System.out.println("\r\n List of all customers ");
<<<<<<< HEAD
				List<Customer> list = customerDao.findAll();
=======
				List<Customer> list = clientDao.findAll();
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb
				for (Customer c : list) {
					System.out.println(c);
					
				}
			} else if (userChoice == 3) {
				Locale.setDefault(Locale.US);
				System.out.println("\r\n Enter new customer data: ");
				System.out.println("Enter with Cod:");
				int cod = sc.nextInt();
				System.out.println("Enter with name:");
				String name = sc.next();
				System.out.println("Enter with fees value:");
				double feesValue = sc.nextDouble();

<<<<<<< HEAD
				Customer newCustomer = new Customer(null, cod , name, feesValue, null, null);
				customerDao.insert(newCustomer);
				System.out.println("Inserted! " + newCustomer);
=======
				Customer newClient = new Customer(id, name, feesValue, null, null);
				clientDao.insert(newClient);
				System.out.println("Inserted! " + newClient);
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb
				

			} else if (userChoice == 4) {
				System.out.println("Enter with update of customer ");
				System.out.println("Enter with code ");
				int cod = sc.nextInt();
				System.out.println("Enter with new name: ");
				String name = sc.next();

<<<<<<< HEAD
				Customer client3 = customerDao.findByCod(cod);
=======
				Customer client3 = clientDao.findById(id);
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb
				client3.setName(name);
				customerDao.update(client3);
				System.out.println("Update completed");
				

			} else if (userChoice == 5) {
				System.out.println("Delete customer by code: ");
				System.out.println("Enter with code: ");
				int code = sc.nextInt();
				customerDao.deleteByCod(code);
				System.out.println("Customer deleted! ");
				
			} else {
				System.out.println("Choose a valid option");
				
			}
			System.out.println("Do you wish continue? s/n ");
			userAnswer = sc.next().charAt(0);
		} while (userAnswer == 's');
		System.out.println("Bye bye");
	}
	
}

/*
 * System.out.println("=== TEST 1 find by ID ==="); Client client =
 * clientDao.findById(88); System.out.println(client);
 */


/*  System.out.println("=== TEST 2 find all==="); 
  List<Customer> list = customerDao.findAll(); 
  for (Customer c: list) { System.out.println(c);
  
  	}
  }
}*/

/*
 * System.out.println("=== TEST 3 insert ==="); Client newClient = new
 * Client(989,"Rato LTDA", 1000.00, null, null); clientDao.insert(newClient);
 * System.out.println("Inserted! new id" + newClient);
 */

/*
 * System.out.println("=== TEST 4 update ==="); Client client2 =
 * clientDao.findById(989); client2.setName("Lixo ratonico LTDA");
 * clientDao.update(client2); System.out.println("Updated completed");
 */

/*
 * System.out.println("=== TEST 5 delete by id"); clientDao.deleteById(989);
 * System.out.println("Delete completed");
 */

// Todos os comandos CRUD funcionando para a entidade CLIENTE
