package br.com.testeWEB.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.testeWEB.dao.TenisDAO;
import br.com.testeWEB.model.Tenis;

public class GravaTenis extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(req.getParameter("modelo"));
		System.out.println(req.getParameter("numeracao"));
		System.out.println(req.getParameter("disponivel"));
		System.out.println(req.getParameter("marca"));
		System.out.println(req.getParameter("valor"));

		Connection bd = br.com.testeWEB.util.ConnectionFactory.getConnection();
		TenisDAO dao = new TenisDAO(bd);
		Tenis tenis = new Tenis();

		tenis.setModelo(req.getParameter("modelo"));
		tenis.setNumeracao(Integer.parseInt(req.getParameter(("numeracao"))));
		tenis.setDisponivel(req.getParameter("disponivel").charAt(0));
		tenis.setMarca(req.getParameter("marca"));
		String valor = req.getParameter("valor").replace("R$", "").replace(",", ".");
		tenis.setValor(Double.parseDouble(valor));

		try {
			dao.inserir(tenis);
			PrintWriter gravador = resp.getWriter();
			gravador.println("<html>");
			gravador.println("<head>");
			gravador.println("<title>Tenis gravdo</title>");
			gravador.println("<script type=\"text/javascript\" src=\"js/navegacao.js\"></script>");
			gravador.println("</head>");
			gravador.println("<body>");
			gravador.println("<center>");
			gravador.println("<h1>Cliente gravado com sucesso!!</h1>");
			gravador.println("modelo do tenis: " + tenis.getModelo() + "<br/>");
			gravador.println("numero do tenis: " + tenis.getNumeracao() + "<br/>");
			gravador.println("disponibilidade do tenis: " + tenis.getDisponivel() + "<br/>");
			gravador.println("marca do tenis: " + tenis.getMarca() + "<br/>");
			gravador.println("valor do tenis: " + tenis.getValor() + "<br/>");
			gravador.println("<button type=\"button\" onclick=\"index()\">VOLTAR</button>");
			gravador.println("</Center>");
			gravador.println("</body>");
			gravador.println("</html>");
		} catch (SQLException e) {
			System.out.println("erro ao gravar tenis");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
