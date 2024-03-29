package com.ecole.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecole.model.Eleve;
import com.ecole.model.Professeur;

public class EleveDao {
	private String url = "jdbc:postgresql://localhost:5432/Ecole";
	private String user = "postgres";
	private String password = "n141n4";
	
	private static final String INSERT_ELEVE_SQL = 
			"INSERT INTO eleve" + "(elv_nom, elv_prenom, elv_cls_k) VALUES " + " (?, ?, ?)";
	private static final String SELECT_ELEVE_BY_ID = 
			"SELECT elv_id, elv_nom, elv_prenom, elv_cls_k FROM eleve WHERE elv_id=?";
	private static final String SELECT_ALL_ELEVE = 
			" SELECT * FROM eleve ORDER BY elv_nom ASC";
	private static final String DELETE_ELEVE_SQL = 
			"DELETE FROM eleve WHERE elv_id = ?";
	private static final String UPDATE_ELEVE_SQL = 
			"UPDATE eleve SET elv_nom = ?, elv_prenom = ?, elv_cls_k = ? WHERE elv_id =?";
	
	public EleveDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connexion �chou�e");
			// TODO: handle exception
		}
		return connection;
		
	}
	
	// INSERT ELEVE
	public void insertEleve(Eleve eleve) {
		System.out.println(INSERT_ELEVE_SQL);
		
		try (Connection connection = getConnection();
			
			
			PreparedStatement pstmt = connection.prepareStatement(INSERT_ELEVE_SQL)) {
			pstmt.setString(1, eleve.getElv_nom());
			pstmt.setString(2, eleve.getElv_prenom());
			pstmt.setInt(3, eleve.getElv_cls_k());
			
			System.out.println(pstmt);
			
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// SELECT ELEVE BY ID
	public Eleve selectEleve(int elv_id) {
		
		Eleve eleve = null;
		
		try (Connection connection = getConnection();
			
			
			PreparedStatement pstmt = connection.prepareStatement(SELECT_ELEVE_BY_ID)) {
			pstmt.setInt(1, elv_id);
			
			System.out.println(pstmt);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String elv_nom = rs.getString("elv_nom");
				String elv_prenom = rs.getString("elv_prenom");
				int elv_cls_k = rs.getInt("elv_cls_k");
				eleve = new Eleve(elv_id,elv_nom, elv_prenom,elv_cls_k);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eleve;
	}
	
	//SELECT ALL ELEVE
	public List<Eleve> selectAllEleve() {
			
		List<Eleve> eleve = new ArrayList<>();
			
			try (Connection connection = getConnection(); 
				
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_ELEVE)) {
				
				System.out.println(pstmt);
				
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					int elv_id = rs.getInt("elv_id");
					String elv_nom = rs.getString("elv_nom");
					String elv_prenom = rs.getString("elv_prenom");
					int elv_cls_k = rs.getInt("elv_cls_k");
					eleve.add(new Eleve(elv_id,elv_nom, elv_prenom, elv_cls_k));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return eleve;
	}
	
	// UPDATE ELEVE
	public boolean updateEleve(Eleve eleve)  throws SQLException {
		boolean rowUpdated;
		
			try (Connection connection = getConnection();
				
				
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_ELEVE_SQL)) {
				
				System.out.println("Eleve mis � jour " + pstmt);
				
				pstmt.setString(1, eleve.getElv_nom());
				pstmt.setString(2, eleve.getElv_prenom());
				pstmt.setInt(3, eleve.getElv_cls_k());
				pstmt.setInt(4, eleve.getElv_id());
				
				rowUpdated = pstmt.executeUpdate() > 0;
				
			}
			return rowUpdated;
	}
	
	// DELETE ELEVE
	public boolean deleteEleve(int elv_id) {
		boolean rowDeleted = false;
		
			try (Connection connection = getConnection(); 
				
				
				PreparedStatement pstmt = connection.prepareStatement(DELETE_ELEVE_SQL)) {
				
				pstmt.setInt(1, elv_id);
				rowDeleted = pstmt.executeUpdate() > 0;
				System.out.println("Eleve mis � jour " + pstmt);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rowDeleted;
	}
}
