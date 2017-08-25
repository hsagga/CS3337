package MVC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MVC/guestbook")
public class guestbook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public guestbook() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<GuestBookEntry> entires = new ArrayList<GuestBookEntry>();
		Connection c = null;

		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220ystu21";
			String user = "cs3220ystu21";
			String pass = "oq3g*!Hq";

			c = DriverManager.getConnection(url, user, pass);
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("select * from guestbook");

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String message = rs.getString("message");
				Date date = rs.getDate("date");
				entires.add(new GuestBookEntry(id, name, message, date));
			}

		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}

			request.setAttribute("entries", entires);
			request.getRequestDispatcher("/MVC/GuestBook.jsp").forward(request, response);
			;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
