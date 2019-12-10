package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.AnimalModel;

public class AnimalDao extends MasterDao{
	private Connection conn;
	private PreparedStatement pst_select, pst_insert, pst_update, pst_delete;
	
	public AnimalDao(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Object obj) throws SQLException {
		String query = "INSERT INTO animal(id, nome, peso, raca, altura, cor, idade, sexo) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
		
		// build query
		pst_insert = conn.prepareStatement(query);
		
		// fill query
		AnimalModel tmp = (AnimalModel) obj;

		Set(pst_insert, 1, tmp.getNome());
		Set(pst_insert, 2, tmp.getPeso());
		Set(pst_insert, 3, tmp.getRaca());
		Set(pst_insert, 4, tmp.getAltura());
		Set(pst_insert, 5, tmp.getCor());
		Set(pst_insert, 6, tmp.getIdade());
		Set(pst_insert, 7, tmp.getSexo());
		
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
		String query = "UPDATE animal SET nome = ?, peso = ?, raca = ?, altura = ?, cor = ?, idade = ?, sexo = ? WHERE id = ?";
		pst_update = conn.prepareStatement(query);
		AnimalModel tmp = (AnimalModel) obj;
		
		Set(pst_update, 1, tmp.getNome());
		Set(pst_update, 2, tmp.getPeso());
		Set(pst_update, 3, tmp.getRaca());
		Set(pst_update, 4, tmp.getAltura());
		Set(pst_update, 5, tmp.getCor());
		Set(pst_update, 6, tmp.getIdade());
		Set(pst_update, 7, tmp.getSexo());
		
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
		String query = "DELETE FROM animal WHERE id = ?";
		pst_delete = conn.prepareStatement(query);
		AnimalModel tmp = (AnimalModel) obj;
		
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
		String query = "SELECT * FROM animal ORDER BY id";

		pst_select = conn.prepareStatement(query);
		
		ResultSet rst = pst_select.executeQuery();

		List<Object> list = new ArrayList<>();
		while (rst.next()){
			AnimalModel tmp = new AnimalModel();
			tmp.setNome(rst.getString("animal"));
			tmp.setPeso(rst.getString("data"));
			tmp.setRaca(rst.getString("servico"));
			tmp.setAltura(rst.getString("id"));
			tmp.setCor(rst.getString("cor"));
			tmp.setIdade(rst.getString("idade"));
			tmp.setSexo(rst.getString("sexo"));
			list.add(tmp);
		}
		
		return list;
	}
}
