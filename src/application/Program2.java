package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.CustomerDao;
import model.dao.DaoFactory;
import model.dao.ReceiptDao;
import model.entities.Customer;
import model.entities.Receipt;

public class Program2 {  //CRUD completo funcionando

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		char userAnswer;

		ReceiptDao receiptDao = DaoFactory.createReceiptDao();
		CustomerDao customerDao = DaoFactory.createCustomerDao();

		do {
			System.out.println("=== Choose an option : ===");
			System.out.println("=== 1 - find a receipt by Code === \n" + "=== 2 - list receipts === \n"
					+ "=== 3 - insert a new receipt === \n" + "=== 4 - update a receipt === \n"
					+ "=== 5 - delete a receipt by Code === \n");
			int userChoice = sc.nextInt();

			if (userChoice == 1) {
				System.out.println("\r\n enter the code you want to search");
				int cod = sc.nextInt();
				Receipt receipt = receiptDao.findByCod(cod);
				System.out.println(receipt);
				
				
			} else if (userChoice == 2) {
				System.out.println("\r\n List of all receipts ");
				List<Receipt> list = receiptDao.findAll();
				for (Receipt r : list) {
					System.out.println(r);
				}

			} else if (userChoice == 3) {
				System.out.println("\r\n Enter new receipt data: ");
				System.out.println("Enter with doc number:");
				int cod = sc.nextInt();
				System.out.println("Enter with document type: ");
				String documentType = sc.next();
				System.out.println("Enter with issue date: ");
				Date issueDate = sdf.parse(sc.next());
				System.out.println("Enter with due date: ");
				Date dueDate = sdf.parse(sc.next());
				System.out.println("Enter with the value: ");
				double value = sc.nextDouble();
				System.out.println("Enter with code of the customer: ");
				int idCustomer = sc.nextInt();
<<<<<<< HEAD

				Customer customer = customerDao.findByCod(idCustomer);

				Receipt receipt2 = new Receipt(null, cod, documentType, issueDate, dueDate, value, customer);

				receiptDao.insert(receipt2);
				
				System.out.println("Inserted new ID" + customer.getName());
=======
				Customer client = clientDao.findById(idCustomer);

				Receipt receipt = new Receipt(id, documentType, issueDate, dueDate, value, client);

				receiptDao.insert(receipt);
				System.out.println("Inserted new ID" + client.getId());
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb

			} else if (userChoice == 4) {
				System.out.println("Update a receipt");
				System.out.println("Enter with a code");
				int cod = sc.nextInt();
				System.out.println("If do you want pay this receipt, write PAID");
				String status = sc.next();
				System.out.println("Enter with a pay day: ");
				Date payday = sdf.parse(sc.next());
				System.out.println("Enter with a bank: ");
				String bank = sc.next();
<<<<<<< HEAD
				
				Receipt receipt = receiptDao.findByCod(cod);
				receipt.setPaymentStatus(status);
				receipt.setPayDate(payday);
				receipt.setBank(bank);

				receiptDao.update(receipt);
				System.out.println("Update payment completed!");

			} else if (userChoice == 5) {
				System.out.println("Delete receipt by ID: ");
				System.out.println("Enter with ID: ");
				int cod = sc.nextInt();

				receiptDao.findByCod(cod);
				receiptDao.deleteByCod(cod);
				System.out.println("Delete completed! ");
=======

				Receipt receipt = receiptDao.findById(id);
				receipt.setPaymentStatus(status);
				receipt.setBank(bank);
				receipt.setPayDay(payday);

				receiptDao.updatePayment(receipt);
				System.out.println("Update completed");

			} else if (userChoice == 5) {
				System.out.println("Delete a receipt by ID");
				System.out.println("Enter with id: ");
				int id = sc.nextInt();

				receiptDao.deleteById(id);
				System.out.println("Delete completed");
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb

			} else {
				System.out.println("Choose a valid option");
			}
			System.out.println("Do you wish continue? s/n ");
			userAnswer = sc.next().charAt(0);

		} while (userAnswer == 's');
		System.out.println("Bye bye!");

	}
}

/*
 * System.out.println("=== TEST 1 find by ID ==="); Receipt receipt =
 * receiptDao.findById(2605); System.out.println(receipt);
 */

/*
 * System.out.println("=== TEST 2 find All ==="); List<Receipt> list =
 * receiptDao.findAll(); for (Receipt r : list) { System.out.println(r); }
 */

/*
 * System.out.println("=== TEST 3 insert ==="); Client client =
 * clientDao.findById(64); System.out.println(client); Date date =
 * sdf.parse("30/01/2022");
 * 
 * Receipt receipt = new Receipt(999, "Nota fiscal", new Date(), date, 900.0,
 * client); receiptDao.insert(receipt); System.out.println("Inserted  new ID" +
 * client.getId());
 */

/*
 * System.out.println("=== TEST 4 update payment"); Date date =
 * sdf.parse("30/01/2022");
 * 
 * Receipt receipt = receiptDao.findById(999);
 * 
 * receipt.setPaymentStatus("PAGO"); receipt.setPayDay(date);
 * receipt.setBank("BRADESCO");
 * 
 * receiptDao.updatePayment(receipt); System.out.println("Updated completed");
 */
/*
 * System.out.println("=== TEST 5 delete by ID");receiptDao.deleteById(999);
 * System.out.println("Delete completed");
 */

// Todos os comandos CRUD funcionando para a entidade DOCUMENT
