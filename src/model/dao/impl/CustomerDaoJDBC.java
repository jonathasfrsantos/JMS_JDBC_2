package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
<<<<<<< HEAD:src/model/dao/impl/CustomerDaoJDBC.java
import model.dao.CustomerDao;
=======
import model.dao.ClientDao;
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb:src/model/dao/impl/ClientDaoJDBC.java
import model.entities.Customer;

public class CustomerDaoJDBC implements CustomerDao {

	private Connection conn;

	public CustomerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Customer obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
<<<<<<< HEAD:src/model/dao/impl/CustomerDaoJDBC.java
					"INSERT INTO tb_customer (cod_customer, name, feesValue, email, email2) " 
					+ "VALUES (?, ?, ?, ?, ?)",
=======
					"INSERT INTO tb_customer (id_customer, name, feesValue, email, email2) "
							+ "VALUES (?, ?, ?, ?, ?)",
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb:src/model/dao/impl/ClientDaoJDBC.java
					Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, obj.getCodCustomer());
			st.setString(2, obj.getName());
			st.setDouble(3, obj.getFeesValue());
			st.setString(4, obj.getEmail());
			st.setString(5, obj.getEmail2());
<<<<<<< HEAD:src/model/dao/impl/CustomerDaoJDBC.java
=======
		
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb:src/model/dao/impl/ClientDaoJDBC.java

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
			} else {
				throw new DbException("Unexpected error! No rows affected!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Customer obj) {
		PreparedStatement st = null;

		try {
<<<<<<< HEAD:src/model/dao/impl/CustomerDaoJDBC.java
			st = conn.prepareStatement("UPDATE tb_customer SET name = ? WHERE cod_customer = ?");

=======
			st = conn.prepareStatement(
					"UPDATE tb_customer SET name = ? WHERE id_customer = ?");
			
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb:src/model/dao/impl/ClientDaoJDBC.java
			st.setString(1, obj.getName());
			st.setInt(2, obj.getCodCustomer());

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
<<<<<<< HEAD:src/model/dao/impl/CustomerDaoJDBC.java
			st = conn.prepareStatement("DELETE FROM tb_customer WHERE cod_customer = ?");

			st.setInt(1, cod);

=======
			st = conn.prepareStatement(
					"DELETE FROM tb_customer WHERE id_customer = ?");
			
			st.setInt(1, id);
			
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb:src/model/dao/impl/ClientDaoJDBC.java
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());

		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
<<<<<<< HEAD:src/model/dao/impl/CustomerDaoJDBC.java
	public Customer findByCod(Integer cod) {
=======
	public Customer findById(Integer id) {
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb:src/model/dao/impl/ClientDaoJDBC.java
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
<<<<<<< HEAD:src/model/dao/impl/CustomerDaoJDBC.java
			st = conn.prepareStatement("SELECT * FROM tb_customer WHERE cod_customer = ?");
			st.setInt(1, cod);
=======
			st = conn.prepareStatement("SELECT * FROM tb_customer WHERE id_customer = ?");
			st.setInt(1, id);
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb:src/model/dao/impl/ClientDaoJDBC.java
			rs = st.executeQuery();
			if (rs.next()) {
				Customer obj = new Customer();
				obj.setId(rs.getInt("id_customer"));
<<<<<<< HEAD:src/model/dao/impl/CustomerDaoJDBC.java
				obj.setCodCustomer(rs.getInt("cod_customer"));
=======
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb:src/model/dao/impl/ClientDaoJDBC.java
				obj.setName(rs.getString("name"));
				obj.setFeesValue(rs.getDouble("feesValue"));
				return obj;
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
	public List<Customer> findAll() {
<<<<<<< HEAD:src/model/dao/impl/CustomerDaoJDBC.java
=======

>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb:src/model/dao/impl/ClientDaoJDBC.java
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM tb_customer");
<<<<<<< HEAD:src/model/dao/impl/CustomerDaoJDBC.java
			
=======
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb:src/model/dao/impl/ClientDaoJDBC.java
			rs = st.executeQuery();

			List<Customer> list = new ArrayList<>();

			while (rs.next()) {
				Customer obj = new Customer();
				obj.setId(rs.getInt("id_customer"));
<<<<<<< HEAD:src/model/dao/impl/CustomerDaoJDBC.java
				obj.setCodCustomer(rs.getInt("cod_customer"));
=======
>>>>>>> 33e6ee6049822569426dcdea5a4819102a80c1bb:src/model/dao/impl/ClientDaoJDBC.java
				obj.setName(rs.getString("name"));
				obj.setFeesValue(rs.getDouble("feesValue"));
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

}
