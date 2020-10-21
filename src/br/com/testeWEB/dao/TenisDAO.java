package br.com.testeWEB.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.testeWEB.model.Tenis;

public class TenisDAO {

	private Connection bd;

	public TenisDAO(Connection bd) {
		this.bd = bd;
	}

	public void inserir(Tenis tenis) throws SQLException {
		String sql = "INSERT INTO tenis(modelo,numeracao,marca,valor,disponivel) Values(?,?,?,?,?)";
		PreparedStatement comando = (PreparedStatement) bd.prepareStatement(sql);
		comando.setString(1, tenis.getModelo());
		comando.setInt(2, tenis.getNumeracao());
		comando.setString(3, tenis.getMarca());
		comando.setDouble(4, tenis.getValor());
		comando.setString(5, tenis.getDisponivel() + "");
		comando.execute();
	}

}
