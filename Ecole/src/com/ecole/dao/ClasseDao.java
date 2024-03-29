package com.ecole.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecole.model.Classe;
import com.ecole.model.Matiere;

public class ClasseDao {
	private String url = "jdbc:postgresql://localhost:5432/Ecole";
	private String user = "postgres";
	private String password = "n141n4";
	
	private static final String INSERT_CLASSS_SQL = 
			"INSERT INTO classe" + "(cls_nom) VALUES " + " (?)";
	private static final String SELECT_CLASSS_BY_ID = 
			"SELECT cls_id, cls_nom FROM classe WHERE cls_id=?";
	private static final String SELECT_ALL_CLASSS = 
			" SELECT * FROM classe ";
	private static final String DELETE_CLASSS_SQL = 
			"DELETE FROM classe WHERE cls_id = ?";
	private static final String UPDATE_CLASSS_SQL = 
			"UPDATE classe SET cls_nom = ? WHERE cls_id = ?";
	
	public ClasseDao() {
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
	
	// INSERT CLASSS
	public void insertClasse(Classe classe) {
		System.out.println(INSERT_CLASSS_SQL);
		
		try (Connection connection = getConnection();
			
			
			PreparedStatement pstmt = connection.prepareStatement(INSERT_CLASSS_SQL)) {
			pstmt.setString(1, classe.getCls_nom());
			
			System.out.println(pstmt);
			
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// SELECT CLASSS BY ID
	public Classe selectClasse(int cls_id) {
		
		Classe classe = null;
		
		try (Connection connection = getConnection();
			
			
			PreparedStatement pstmt = connection.prepareStatement(SELECT_CLASSS_BY_ID)) {
			pstmt.setInt(1, cls_id);
			
			System.out.println(pstmt);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String cls_nom = rs.getString("cls_nom");
				classe = new Classe(cls_id, cls_nom);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classe;
	}
	
	//SELECT ALL CLASSS
	public List<Classe> selectAllClasse() {
			
		List<Classe> classe = new ArrayList<>();
			
			try (Connection connection = getConnection(); 
				
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_CLASSS)) {
				
				System.out.println(pstmt);
				
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					int cls_id = rs.getInt("cls_id");
					String cls_nom = rs.getString("cls_nom");
					classe.add(new Classe(cls_id,cls_nom));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return classe;
	}
	
	// UPDATE CLASSS
	public boolean updateClasse(Classe classe) throws SQLException {
		boolean rowUpdated ;
		
			try (Connection connection = getConnection();
				
				
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_CLASSS_SQL)) {
				
				System.out.println("Classe mis � jour " + pstmt);
				
				pstmt.setString(1, classe.getCls_nom());
				pstmt.setInt(2, classe.getCls_id());
				
				rowUpdated = pstmt.executeUpdate() > 0;
				
			} 
			return rowUpdated;
	}
	
	// DELETE CLASSS
	public boolean deleteClasse(int cls_id) {
		boolean rowDeleted = false;
		
			try (Connection connection = getConnection(); 
				
				
				PreparedStatement pstmt = connection.prepareStatement(DELETE_CLASSS_SQL)) {
				
				pstmt.setInt(1, cls_id);
				rowDeleted = pstmt.executeUpdate() > 0;
				System.out.println("Classe mis � jour " + pstmt);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rowDeleted;
	}
}
