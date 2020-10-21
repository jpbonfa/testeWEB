package br.com.testeWEB.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.testeWEB.dao.TenisDAO;
import br.com.testeWEB.model.Tenis;
import br.com.testeWEB.util.ConnectionFactory;
import br.com.testeWEB.util.Mensagem;

public class TestaInserirTenis {

	public static void main(String[] args) {
		Tenis tenis = new Tenis();
		tenis.setModelo("Tênis Triple S");
		tenis.setNumeracao(40);
		tenis.setMarca("Balenciaga");
		tenis.setValor(9270);
		tenis.setDisponivel('S');

		Connection bd = ConnectionFactory.getConnection();

		TenisDAO dao = new TenisDAO(bd);
		try {
			dao.inserir(tenis);
			System.out.println(Mensagem.sucesso);
		} catch (SQLException e) {
			System.out.println(Mensagem.erro );
			e.printStackTrace();
		}
	}
}
