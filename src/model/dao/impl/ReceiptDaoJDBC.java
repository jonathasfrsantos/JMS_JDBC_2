package model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.ReceiptDao;
import model.entities.Customer;
import model.entities.Receipt;

public class ReceiptDaoJDBC implements ReceiptDao {

	private Connection conn;

	public ReceiptDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Receipt obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
<<<<<<< HEAD
					"INSERT INTO tb_document " 
					+ "(cod_document, documentType, issueDate, dueDate, value, cod_customer) "
					+ "VALUES " + "(?, ?, ?, ?, ?, ?)",
=======
					"INSERT INTO tb_document "
					+ "(id_document, documentType, issueDate, dueDate, value, id_customer) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?)",
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb
					Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, obj.getCodDocument());
			st.setString(2, obj.getDocumentType());
			st.setDate(3, new java.sql.Date(obj.getIssueDate().getTime()));
			st.setDate(4, new java.sql.Date(obj.getDueDate().getTime()));
			st.setDouble(5, obj.getValue());
<<<<<<< HEAD
			st.setInt(6, obj.getCustomer().getCodCustomer());

=======
			st.setInt(6, obj.getCustomer().getId());
			
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Unexpected Error! no rows affected");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Receipt obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
					"UPDATE tb_document "
					+ "SET paymentStatus = ?, bank = ?, payDate = ? "
					+ "WHERE cod_document = ?");

			st.setString(1, obj.getPaymentStatus());
			st.setString(2, obj.getBank());
			st.setDate(3, new java.sql.Date(obj.getPayDate().getTime()));
			st.setInt(4, obj.getCodDocument());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteByCod(Integer cod) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM tb_document WHERE cod_document = ?");

			st.setInt(1,cod);
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public Receipt findByCod(Integer cod) { //ok
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
<<<<<<< HEAD
					"SELECT tb_document.*, B.name " 
					+ "FROM tb_document " 
					+ "INNER JOIN tb_customer B "
					+ "ON tb_document.cod_customer = B.cod_customer " 
					+ "WHERE tb_document.cod_document = ? ");

			st.setInt(1, cod);
=======
					"SELECT tb_document.*, B.name "
					+ "FROM tb_document "
					+ "INNER JOIN tb_customer B "
					+ "ON tb_document.id_customer = B.id_customer "
					+ "WHERE tb_document.id_document = ? ");
			
			st.setInt(1, id);
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb
			rs = st.executeQuery();
			if (rs.next()) {
				Customer customer = instantiateCustomer(rs);
				Receipt receipt = instantiateReceipt(rs, customer);
				return receipt;

			}
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

	@Override
	public List<Receipt> findAll() { //ok
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT tb_document.*, B.name "
					+ "FROM tb_document "
<<<<<<< HEAD
					+ "INNER JOIN tb_customer B " 
					+ "ON tb_document.cod_customer = B.cod_customer " 
=======
					+ "INNER JOIN tb_customer B "
					+ "ON tb_document.id_customer = B.id_customer "
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb
					+ "ORDER BY name");

			rs = st.executeQuery();

			List<Receipt> list = new ArrayList<>();

			Map<Integer, Customer> map = new HashMap<>();

			while (rs.next()) {
<<<<<<< HEAD
				Customer customer = map.get(rs.getInt("cod_customer"));

				if (customer == null) {
					customer = instantiateCustomer(rs);
					map.put(rs.getInt("cod_customer"), customer); // S� dois valores na hora do put do map, por isso dava
																// erro com o terceiro valor que era o campo "valor" do
																// tipo double
=======
				Customer customer = map.get(rs.getInt("id_customer"));

				if (customer == null) {
					customer = instantiateCustomer(rs);
					map.put(rs.getInt("id_customer"), customer);   // S� dois valores na hora do put do map, por isso dava erro com o terceiro valor que era o campo "valor" do tipo double
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb
				}

				Receipt obj = instantiateReceipt(rs, customer);
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
<<<<<<< HEAD
	public List<Receipt> findByCustomer(Customer customer) {
=======
	public List<Receipt> findByDepartment(Customer client) {
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb
		// TODO Auto-generated method stub
		return null;
	}

	private Receipt instantiateReceipt(ResultSet rs, Customer customer) throws SQLException {
		Receipt obj = new Receipt();
		obj.setId(rs.getInt("id_document"));
		obj.setCodDocument(rs.getInt("cod_document"));
		obj.setDocumentType(rs.getNString("documentType"));
		obj.setIssueDate(rs.getDate("issueDate"));
		obj.setDueDate(rs.getDate("dueDate"));
		obj.setValue(rs.getDouble("value"));
		obj.setPaymentStatus(rs.getString("paymentStatus"));
		obj.setBank(rs.getString("bank"));
<<<<<<< HEAD
		obj.setPayDate(rs.getDate("payDate"));
		obj.setClient(customer);
=======
		obj.setPayDay(rs.getDate("payday"));
		obj.setCustomer(customer);
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb
		return obj;

	}

	private Customer instantiateCustomer(ResultSet rs) throws SQLException {
<<<<<<< HEAD
		Customer customer = new Customer();
		customer.setId(rs.getInt("cod_customer"));
		customer.setName(rs.getString("name"));
		// client.setFees_values(rs.getDouble("valor")); // apos  comentar essa linha o
		// programa funcionou
		return customer;
=======
		Customer client = new Customer();
		client.setId(rs.getInt("id_customer"));
		client.setName(rs.getString("name"));
		//client.setFees_values(rs.getDouble("valor"));  // apos comentar essa linha o programa funcionou
		return client;
	}

	@Override
	public void update(Receipt obj) {
		// TODO Auto-generated method stub
		
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb
	}

}