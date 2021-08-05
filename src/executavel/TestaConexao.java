package executavel;

import java.sql.SQLException;

import dao.ClienteDao;
import dao.ContaDao;
import dominio.Cliente;
import dominio.Conta;

public class TestaConexao {

	

	public static void main(String[] args) {
		try {
//		
//			Connection con = ConnectionFactory.getConnection();
//			
//			 Statement comando = con.createStatement();
//			  
//			 ResultSet resultado = comando.getResultSet();
//			 
//			 while(resultado.next()) {
//				 
//				 String numeroConta = resultado.getString("numeroConta");
//				 System.out.println( numeroConta);
//			 }
//	
//
//			 con.close();
			
			
			ContaDao contaDao = new ContaDao();
			
			ClienteDao clienteDao = new ClienteDao();
			
			Cliente cliente = new Cliente("joão","01928374657","Maria");
			
			clienteDao.save(cliente);
			
			cliente = clienteDao.findByCPF("01928374657");
			
			contaDao.findByNumeroAgenciaAndNumeroConta("", "");
			
			System.out.println(cliente.getId() + " " + cliente.getNome() );
			
			
			
			
			//Conta conta = new Conta("002","0006",cliente,1000);
			//contaDao.save(conta);
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
