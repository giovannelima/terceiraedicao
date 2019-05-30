package br.com.estacionamentoWeb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estacionamentoWeb.factory.conex�oBD;
import br.com.estacionamentoWeb.object.entrada;

public class saidaDAO {
	// Classe de visualiza��o onde � selecionado somente com o come�o do dado selecionado
	public List<entrada> seleclLike(String modelo, String marca, String cor, String placa) throws ClassNotFoundException, SQLException {  
		 boolean verifica = false; // verifica recebendo falso
		Connection conexao = conex�oBD.conectar();	//saida.seleclLike(like, like2, like3, like4);
		List<entrada> lista = new ArrayList<entrada>();
		try {
			// visualiza��o dos dados inseridos no banco com o like onde pode ser digitado somente o come�o do texto ou numero
			String sql = "select * from  estacionamento.entrada where car_modelo like ? or car_marca like ? or car_cor like ? or car_placa like ?";
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, "%" + modelo + "%"); // like do modelo
			ps.setString(2, "%" + marca + "%"); // like da marca
			ps.setString(3, "%" + cor + "%"); // like da cor
			ps.setString(4, "%" + placa + "%"); // like da placa

			ResultSet buscar = ps.executeQuery();  // o preparedStatement executa a query do codigo -- resultSet recebe a query executada onde verifica se foi selecionado ou n�o
			
			
			while (buscar.next()) {  // com o While o result set pula para o proximo para executar a verifica��o
				
				verifica = true; // verifica se � verdade a infoma��o
				int idPark = buscar.getInt("car_id"); // parametro que recebe o inteiro que recebe do banco
				String modeloPark = buscar.getString("car_modelo"); // parametro que recebe a string que recebe do banco
				String marcaPark = buscar.getString("car_marca");  // parametro que recebe a string que recebe do banco
				String corPark = buscar.getString("car_cor");  // parametro que recebe a string que recebe do banco
				String placaPark = buscar.getString("car_placa"); // parametro que recebe a string que recebe do banco
				
				entrada e = new entrada();
				e.setId(idPark);
				e.setModelo(modeloPark);
				e.setMarca(marcaPark);
				e.setCor(corPark);
				e.setPlaca(placaPark);
				lista.add(e);
				// exemplo de onde mostra o que est� sendo pego pelo select like	
			}
			if (verifica) {
				// se for verdadeiro 
				System.out.println("\nOs dados foram encontrados.!");

			} else {
				// se for falso
				System.out.println("\nOs dados n�o foram encontrados.!");

			}

			buscar.close(); // fechamento do resultSet
			ps.close(); // fechamento preparedStatement

		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println("ERRO" + e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return lista;
	}



}
