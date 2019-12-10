package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.ClienteModel;

public class ClienteDao extends MasterDao{
	private Connection conn;
	private PreparedStatement pst_select, pst_insert, pst_update, pst_delete;
	
	public ClienteDao(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Object obj) throws SQLException {
		String query = "INSERT INTO cliente(id, nome, endereco, email, cpf) VALUES (DEFAULT, ?, ?, ?, ?)";
		
		// build query
		pst_insert = conn.prepareStatement(query);
		
		// fill query
		ClienteModel tmp = (ClienteModel) obj;

		Set(pst_insert, 1, tmp.getNome());
		Set(pst_insert, 2, tmp.getEndereco());
		Set(pst_insert, 3, tmp.getEmail());
		Set(pst_insert, 4, tmp.getCPF());
		
		// run query
		pst_insert.execute();

		// check if query worked
		if (pst_insert.getUpdateCount() > 0) {
			this.conn.commit();
		}
		else {
			conn.rollback();
		}
	}

	@Override
	public void update(Object obj) throws SQLException {
		String query = "UPDATE cliente SET nome = ?, endereco = ?, email = ?, cpf = ? WHERE id = ?";
		pst_update = conn.prepareStatement(query);
		ClienteModel tmp = (ClienteModel) obj;
		
		Set(pst_update, 1, tmp.getNome());
		Set(pst_update, 2, tmp.getEndereco());
		Set(pst_update, 3, tmp.getEmail());
		Set(pst_update, 4, tmp.getCPF());
		Set(pst_update, 5, tmp.getId());
		
		pst_update.execute();
		
		if(pst_update.getUpdateCount()>0) {
			this.conn.commit();
		}
		else {
			this.conn.rollback();
		}
	}

	@Override
	public void delete(Object obj) throws SQLException {
		String query = "DELETE FROM cliente WHERE id = ?";
		pst_delete = conn.prepareStatement(query);
		ClienteModel tmp = (ClienteModel) obj;
		
		Set(pst_delete, 1, tmp.getId());
		pst_delete.execute();
		
		if(pst_delete.getUpdateCount()>0) {
			this.conn.commit();
		}
		else {
			this.conn.rollback();
		}
	}

	@Override
	public List<Object> select() throws SQLException {
		String query = "SELECT * FROM agendamento ORDER BY data";

		pst_select = conn.prepareStatement(query);
		
		ResultSet rst = pst_select.executeQuery();

		List<Object> list = new ArrayList<>();
		while (rst.next()){
			ClienteModel tmp = new ClienteModel();
			tmp.setNome(rst.getString("nome"));
			tmp.setEndereco(rst.getString("endereco"));
			tmp.setEmail(rst.getString("email"));
			tmp.setCPF(rst.getString("cpf"));
			tmp.setId(rst.getInt("id"));
			list.add(tmp);
		}
		
		return list;
	}
}
