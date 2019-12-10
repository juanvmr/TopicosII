package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.AgendamentoModel;

public class AgendamentoDao extends MasterDao{
	
	private Connection conn;
	private PreparedStatement pst_select, pst_insert, pst_update, pst_delete;
	
	public AgendamentoDao(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Object obj) throws SQLException {
		String query = "INSERT INTO agendamento(id, data, animal, servico) VALUES (DEFAULT, ?, ?, ?)";
		
		// build query
		pst_insert = conn.prepareStatement(query);
		
		// fill query
		AgendamentoModel tmp = (AgendamentoModel) obj;

		Set(pst_insert, 1, tmp.getDate());
		Set(pst_insert, 2, tmp.getAnimal());
		Set(pst_insert, 3, tmp.getService());
		
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
		String query = "UPDATE agendamento SET data = ?, animal = ?, servico = ? WHERE id = ?";
		pst_update = conn.prepareStatement(query);
		AgendamentoModel tmp = (AgendamentoModel) obj;
		
		Set(pst_update, 1, tmp.getDate());
		Set(pst_update, 2, tmp.getAnimal());
		Set(pst_update, 3, tmp.getService());
		Set(pst_update, 4, tmp.getSchedulingID());
		
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
		String query = "DELETE FROM agendamento WHERE id = ?";
		pst_delete = conn.prepareStatement(query);
		AgendamentoModel tmp = (AgendamentoModel) obj;
		
		Set(pst_delete, 1, tmp.getSchedulingID());
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
			AgendamentoModel tmp = new AgendamentoModel();
			tmp.setAnimal(rst.getString("animal"));
			tmp.setDate(rst.getString("data"));
			tmp.setService(rst.getString("servico"));
			tmp.setSchedulingID(rst.getInt("id"));
			list.add(tmp);
		}
		
		return list;
	}
	
}
