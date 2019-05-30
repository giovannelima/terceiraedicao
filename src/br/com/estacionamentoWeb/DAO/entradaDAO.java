package br.com.estacionamentoWeb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.estacionamentoWeb.factory.conex�oBD;
import br.com.estacionamentoWeb.object.entrada;


// classe entradaDAO � a entrada do veiculo no estacionamento 
public class entradaDAO {
	public void insert(entrada insere) throws ClassNotFoundException, SQLException { // insere chama a classe entrada onde contem os gets e sets
		Connection conexao = conex�oBD.conectar();  // chama a classe conex�oBD onde est� sentando o banco com a URL, USUARIO, SENHA
		// A string SQL insere os dados cadastrados do sistema para o armazenamento no  banco de dado
		String sql = "insert into estacionamento.entrada (car_modelo, car_marca, car_cor, car_placa)" 
				+ " values (?,?,?,?)";

		PreparedStatement ps = conexao.prepareStatement(sql);  
		ps.setString(1, insere.getModelo()); // insere na coluna modelo
		ps.setString(2, insere.getMarca()); // insere na coluna marca
		ps.setString(3, insere.getCor()); // insere na coluna cor
		ps.setString(4, insere.getPlaca()); // insere na coluna placa
		ps.executeUpdate(); // comando para executar a query 

		ps.close(); // fecha a query 
	}
	
	public static void main(String[] args) throws SQLException {

		entradaDAO banco = new entradaDAO();
		entrada entrada = new entrada();
		
		entrada.setModelo("k�");
		entrada.setMarca("ford");
		entrada.setCor("branco");
		entrada.setPlaca("axv1212");

		try {
			banco.insert(entrada);
			System.out.println("Os dados foram gravados");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Os dados n�o foram gravados");

		}
	}

}
