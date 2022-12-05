package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Destino;
import bean.Transporte;
import bean.Viagem;

public class ViagemDAO {
	private Connection connection;
	
	public ViagemDAO() {
		connection = new Conexao().getConnection();
	}
	
	public int inserir(Viagem v) {
		int inseriu = 0;
		String sql = "insert into viagem values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, v.getCodigo());
			stmt.setString(2, v.getDestino().getCidade());
			stmt.setString(3, v.getDestino().getEstado());
			stmt.setString(4, v.getDestino().getPais());
			stmt.setInt(5, v.getTransporte().getCodigo());
			stmt.setDouble(6, v.getDistancia());
			stmt.setDouble(7, v.getDuracao());
			stmt.setDate(8, v.getPartida());
			stmt.setDate(9, v.getChegada());
			stmt.setDouble(10, v.getValor());
			inseriu = stmt.executeUpdate();
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	} 
	
	public ArrayList<Viagem> listar(){
		String sql = "select * from viagem";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Viagem> viagens = new ArrayList<>();
			while (rs.next()) {
				Destino d = new Destino();
				d.setCidade(rs.getString("Cidade"));
				d.setEstado(rs.getString("Estado"));
				d.setPais(rs.getString("Pais"));
				
				Transporte t = new Transporte();
				t.setCodigo(rs.getInt("codTransporte"));
				
				Viagem v = new Viagem(rs.getInt("codViagem"), d, t, rs.getDouble("Distancia"), rs.getDouble("DuracaoViagem"),  rs.getDate("DataPartida"), rs.getDate("DataChegada"), rs.getDouble("Valor"));
				viagens.add(v);
			}
			rs.close();
			stmt.close();
			return viagens;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int remover(Viagem v) {
		int removeu = 0;
		String sql = "delete from viagem where CodViagem=?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, v.getCodigo());
			removeu = stmt.executeUpdate();
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int alterar(Viagem v) {
		int alterou = 0;
		String sql = "update Distancia=?, DuracaoViagem=?, DataPartida=?, DataChegada=?, Valor=? viagem set  where CodViagem=?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setDouble(1, v.getDistancia());
			stmt.setDouble(2, v.getDuracao());
			stmt.setDate(3, v.getPartida());
			stmt.setDate(4, v.getChegada());
			stmt.setDouble(5, v.getValor());
			stmt.setInt(6, v.getCodigo());
			alterou = stmt.executeUpdate();
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}

	public boolean getViagem(int codigo){
		String sql = "select * from viagem where CodViagem=?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, codigo);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Viagem> viagens = new ArrayList<>();
			while (rs.next()) {
				Destino d = new Destino();
				d.setCidade(rs.getString("Cidade"));
				d.setEstado(rs.getString("Estado"));
				d.setPais(rs.getString("Pais"));
				
				Transporte t = new Transporte();
				t.setCodigo(rs.getInt("codTransporte"));
				
				Viagem v = new Viagem(rs.getInt("codViagem"), d, t, rs.getDouble("Distancia"), rs.getDouble("DuracaoViagem"),  rs.getDate("DataPartida"), rs.getDate("DataChegada"), rs.getDouble("Valor"));
				viagens.add(v);
			};
			rs.close();
			stmt.close();
			if(viagens.size() > 0) {
				return true;
			}
			return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verifyDestino(Destino d){
		String sql = "select * from viagem where Cidade = ? and Estado = ? and Pais = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, d.getCidade());
			stmt.setString(2, d.getEstado());
			stmt.setString(3, d.getPais());
			ResultSet rs = stmt.executeQuery();
			ArrayList<Viagem> viagens = new ArrayList<>();
			while (rs.next()) {
				d = new Destino();
				d.setCidade(rs.getString("Cidade"));
				d.setEstado(rs.getString("Estado"));
				d.setPais(rs.getString("Pais"));
				
				Transporte t = new Transporte();
				t.setCodigo(rs.getInt("codTransporte"));
				
				Viagem v = new Viagem(rs.getInt("codViagem"), d, t, rs.getDouble("Distancia"), rs.getDouble("DuracaoViagem"),  rs.getDate("DataPartida"), rs.getDate("DataChegada"), rs.getDouble("Valor"));
				viagens.add(v);
			}
			rs.close();
			stmt.close();
			if(viagens.size() > 0) {
				return true;
			}
			return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verifyTransporte(Transporte t){
		String sql = "select * from viagem where CodTransporte = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, t.getCodigo());
			ResultSet rs = stmt.executeQuery();
			ArrayList<Viagem> viagens = new ArrayList<>();
			while (rs.next()) {
				Destino d = new Destino();
				d.setCidade(rs.getString("Cidade"));
				d.setEstado(rs.getString("Estado"));
				d.setPais(rs.getString("Pais"));
				
				t = new Transporte();
				t.setCodigo(rs.getInt("codTransporte"));
				
				Viagem v = new Viagem(rs.getInt("codViagem"), d, t, rs.getDouble("Distancia"), rs.getDouble("DuracaoViagem"),  rs.getDate("DataPartida"), rs.getDate("DataChegada"), rs.getDouble("Valor"));
				viagens.add(v);
			}
			rs.close();
			stmt.close();
			if(viagens.size() > 0) {
				return true;
			}
			return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
