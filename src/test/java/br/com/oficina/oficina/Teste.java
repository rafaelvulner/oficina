package br.com.oficina.oficina;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.oficina.oficina.entity.Veiculo;
import br.com.oficina.oficina.repository.Conexao;

public class Teste {
	
	private static PreparedStatement ps;
	private static Conexao conn;
	private final static String SQL_INIT = "insert into veiculo (fabricante_veiculo, marca_veiculo, modelo_veiculo, ano_veiculo, cor_veiculo) values (?,?,?,?,?)";

	public static void main(String[] args) throws NullPointerException, SQLException {
		
		conn = new Conexao();		
		
		List<Veiculo> lista = new ArrayList<>();
		
		String sql = "select * from veiculo";
		
		//insertSql("GM", "Chevrolet", "Corsa sedan", 2000, "Prata");
		
		ps = (PreparedStatement) conn.getConnection().prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			Veiculo veiculo = new Veiculo();
			
			veiculo.setId(rs.getInt("id_veiculo"));
			veiculo.setAno(rs.getInt("ano_veiculo"));
			veiculo.setCor(rs.getString("cor_veiculo"));
			veiculo.setFabricante(rs.getString("fabricante_veiculo"));
			veiculo.setMarca(rs.getString("marca_veiculo"));
			veiculo.setModelo(rs.getString("marca_veiculo"));	
			
			lista.add(veiculo);
		}
			
		
		lista.forEach(System.out::println);
		
		conn.exitConnection();

	}
	
	public static void insertSql(String fabrincante, String marca, String modelo, int ano, String cor) {
		
		try {
			ps = (PreparedStatement) conn.getConnection().prepareStatement(SQL_INIT);
			
			ps.setString(1, fabrincante);
			ps.setString(2, marca);
			ps.setString(3, modelo);
			ps.setInt(4, ano);
			ps.setString(5, cor);
			
			ps.execute();
			
			System.out.println("Query executado");
			
			conn.exitConnection();
		} catch (SQLException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
