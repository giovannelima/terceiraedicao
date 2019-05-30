package br.com.estacionamentoWeb.control;

import java.sql.SQLException;
import java.util.List;

import br.com.estacionamentoWeb.DAO.gridDAO;
import br.com.estacionamentoWeb.DAO.saidaDAO;
import br.com.estacionamentoWeb.object.entrada;

public class controle {
	private saidaDAO saida = new saidaDAO();
	private gridDAO grid = new  gridDAO();

	public List<entrada> getCarrosEntradas() throws ClassNotFoundException, SQLException { /// recebe os valores do select like

		List<entrada> entradas= saida.seleclLike("ká", "ford", "cor", "placa");
		System.out.println(entradas);
		return entradas;
	}
	
	public List<entrada> getCarrosTudo() throws ClassNotFoundException, SQLException { /// recebe os valores do select like

		List<entrada> gridCarros = grid.selectAll();
		System.out.println(gridCarros);
		return gridCarros;
	}
}
