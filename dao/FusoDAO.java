package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Destino;
import bean.Fuso;

public class FusoDAO {
	private Connection connection;
	
	public FusoDAO() {
		connection = new Conexao().getConnection();
	}
	public int inserir(Fuso f) {
		int inseriu = 0;
		String sql = "insert into fusoDestino values(?, ?, ?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, f.getCidade());
			stmt.setString(2, f.getEstado());
			stmt.setString(3, f.getPais());
			stmt.setInt(4, f.getFuso());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
		
	}
	
	public ArrayList<Fuso> listar(){
		String sql = "select * from fusoDestino;";
		PreparedStatement stmt;
		Fuso f;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Fuso> fusos = new ArrayList<>();
			while(rs.next()) {
				f = new Fuso();
				f.setCidade(rs.getString("Cidade"));
				f.setEstado(rs.getString("Estado"));
				f.setPais(rs.getString("Pais"));
				f.setFuso(rs.getInt("Fuso"));
				fusos.add(f);
			}
			rs.close();
			stmt.close();
			return fusos;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean getFuso(Fuso f) {
		String sql = "select * from fusoDestino where Cidade=? and Estado=? and Pais=? and Fuso=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, f.getCidade());
			stmt.setString(2, f.getEstado());
			stmt.setString(3, f.getPais());
			stmt.setInt(4, f.getFuso());
			ResultSet rs = stmt.executeQuery();
			ArrayList <Fuso> fusos = new ArrayList<>();
			while(rs.next()) {
				f = new Fuso();
				f.setCidade(rs.getString("Cidade"));
				f.setEstado(rs.getString("Estado"));
				f.setPais(rs.getString("Pais"));
				f.setFuso(rs.getInt("Fuso"));
				fusos.add(f);
			}
			rs.close();
			stmt.close();
			if(fusos.size() > 0) {
				return true;
			}
			return false;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verifyFuso(Destino d){
		String sql = "select * from fusoDestino where Cidade = ? and Estado = ? and Pais = ?";
		PreparedStatement stmt;
		Fuso f;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, d.getCidade());
			stmt.setString(2, d.getEstado());
			stmt.setString(3, d.getPais());
			ResultSet rs = stmt.executeQuery();
			ArrayList <Fuso> fusos = new ArrayList<>();
			while(rs.next()) {
				f = new Fuso();
				f.setCidade(rs.getString("Cidade"));
				f.setEstado(rs.getString("Estado"));
				f.setPais(rs.getString("Pais"));
				f.setFuso(rs.getInt("Fuso"));
				fusos.add(f);
			}
			rs.close();
			stmt.close();
			if(fusos.size() > 0) {
				return true;
			}
			return false;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
