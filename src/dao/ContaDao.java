package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dominio.Cliente;
import dominio.Conta;
import factory.ConnectionFactory;

public class ContaDao {
	Connection conexao;
	
	public ContaDao() throws SQLException {
		this.conexao = ConnectionFactory.getConnection();
	}


	public void save(Conta conta) {
			
		try {
			Statement comando = this.conexao.createStatement();
				
			String insert = "insert into conta (numeroConta,numeroAgencia,saldo,id_cliente) values("
					+ "'" + conta.getNumeroConta()+"'"
					+ ",'" + conta.getNumeroAgencia() + "'"
					+ ",'" + conta.getSaldo() + "'"
					+ ",'" + conta.getId_cliente() + "'"
					+ ");";
				
				comando.execute(insert);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public Conta findByNumeroAgenciaAndNumeroConta(String numeroConta, String numeroAgencia) throws SQLException {
			Conta conta = null;
			
			Statement comando = this.conexao.createStatement();
			
			String pesquisa = "select * from conta where numeroConta = '" + numeroConta +"';";
			pesquisa = "select * from conta where numeroAgencia = '" + numeroAgencia +"';";
			
			if (comando.execute(pesquisa)) {
				ResultSet resultado = comando.getResultSet();
				while(resultado.next()) {
					
					numeroConta = resultado.getString("numeroConta");
					numeroAgencia = resultado.getString("numeroAgencia");
					float saldo = resultado.getFloat("saldo");
					int id_cliente = resultado.getInt("id_cliente");
					
					conta  = new Conta(numeroAgencia, numeroConta, saldo, id_cliente);
					conta.setId(numeroAgencia,numeroConta);
				}
			
			}
			return conta;
			
		}


	}