package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Destino;
import bean.Turistico;


public class TuristicoDAO {
	
	private Connection connection;
	
	public TuristicoDAO() {
		connection = new Conexao().getConnection();
	}
	public int inserir(Turistico t) {
		int inseriu = 0;
		String sql = "insert into pTuristicoDestino values(?, ?, ?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, t.getCidade());
			stmt.setString(2, t.getEstado());
			stmt.setString(3, t.getPais());
			stmt.setString(4, t.getNome());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
		
	}
	
	public ArrayList<Turistico> listar(){
		String sql = "select * from pTuristicoDestino;";
		PreparedStatement stmt;
		Turistico t;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Turistico> turisticos = new ArrayList<>();
			while(rs.next()) {
				t = new Turistico();
				t.setCidade(rs.getString("Cidade"));
				t.setEstado(rs.getString("Estado"));
				t.setPais(rs.getString("Pais"));
				t.setNome(rs.getString("PTuris"));
				turisticos.add(t);
			}
			rs.close();
			stmt.close();
			return turisticos;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean getTuristico(Turistico t) {
		String sql = "select * from pTuristicoDestino where Cidade=? and Estado=? and Pais=? and PTuris=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, t.getCidade());
			stmt.setString(2, t.getEstado());
			stmt.setString(3, t.getPais());
			stmt.setString(4, t.getNome());
			ResultSet rs = stmt.executeQuery();
			ArrayList <Turistico> turisticos = new ArrayList<>();
			while(rs.next()) {
				t = new Turistico();
				t.setCidade(rs.getString("Cidade"));
				t.setEstado(rs.getString("Estado"));
				t.setPais(rs.getString("Pais"));
				t.setNome(rs.getString("PTuris"));
				turisticos.add(t);
			}
			rs.close();
			stmt.close();
			if(turisticos.size() > 0) {
				return true;
			}
			return false;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verifyTuristico(Destino d){
		String sql = "select * from pTuristicoDestino where Cidade = ? and Estado = ? and Pais = ?";
		PreparedStatement stmt;
		Turistico t;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, d.getCidade());
			stmt.setString(2, d.getEstado());
			stmt.setString(3, d.getPais());
			ResultSet rs = stmt.executeQuery();
			ArrayList <Turistico> turisticos = new ArrayList<>();
			while(rs.next()) {
				t = new Turistico();
				t.setCidade(rs.getString("Cidade"));
				t.setEstado(rs.getString("Estado"));
				t.setPais(rs.getString("Pais"));
				t.setNome(rs.getString("PTuris"));
				turisticos.add(t);
			}
			rs.close();
			stmt.close();
			if(turisticos.size() > 0) {
				return true;
			}
			return false;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
