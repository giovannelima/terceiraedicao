package br.com.estacionamentoWeb.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.estacionamentoWeb.DAO.gridDAO;
import br.com.estacionamentoWeb.object.entrada;

@ManagedBean(name = "MBgrid")
@ViewScoped
public class gridBean {
	private ListDataModel<entrada> itens;

	public ListDataModel<entrada> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<entrada> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void prepararPesquisa() {
		gridDAO gDao = new gridDAO();
		try {
			ArrayList<entrada> lista = gDao.selectAll();
			itens = new ListDataModel<entrada>(lista);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
