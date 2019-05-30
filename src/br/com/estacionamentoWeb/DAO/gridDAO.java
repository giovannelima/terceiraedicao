package br.com.estacionamentoWeb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import br.com.estacionamentoWeb.factory.conexãoBD;
import br.com.estacionamentoWeb.object.entrada;

public class gridDAO {
	public ArrayList<entrada> selectAll() throws ClassNotFoundException, SQLException {
		boolean verifica = true; // verifica recebendo verdade
		Connection conexao = conexãoBD.conectar(); // saida.seleclLike(like, like2, like3, like4);
		ArrayList<entrada> lista = new ArrayList<entrada>();

		try {

			String sql = (" Select * from  estacionamento.entrada");
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet buscar = ps.executeQuery();
			while (buscar.next()) {
				verifica = true; // verifica se é verdade a infomação
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
			
			}
			if (verifica) {
				System.out.println("\nOs dados foram encontrados.!!\n");
			} else {
				System.out.println("Os dados não foram encontrados.!");
			}
			buscar.close();
			ps.close();

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
