package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dominio.Cliente;
import factory.ConnectionFactory;

public class ClienteDao {
	Connection conexao;

	public ClienteDao() throws SQLException {
		 this.conexao = ConnectionFactory.getConnection();
	}

	public void save(Cliente cliente) {
		
		try {
			Statement comando = this.conexao.createStatement();
			
			String insert = "insert into cliente (nome,cpf,nomeSocial) values("
					+ "'" + cliente.getNome()+"'"
					+ ",'" + cliente.getCPF() + "'"
					+ ",'" + cliente.getNomeSocial() + "'"
					+ ");";
			
			comando.execute(insert);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Cliente findByCPF(String cpf) throws SQLException {
		Cliente cliente = null;
		
		Statement comando = this.conexao.createStatement();
		
		String pesquisa = "select * from cliente where cpf = '" + cpf +"';";
		
		if (comando.execute(pesquisa)) {
			ResultSet resultado = comando.getResultSet();
			while(resultado.next()) {
				
				cpf = resultado.getString("cpf");
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				String nomeSocial = resultado.getString("nomeSocial");
				
				cliente = new Cliente(nome, cpf, nomeSocial);
				cliente.setId(id);
			}
		
		}
		return cliente;
		
	}


}