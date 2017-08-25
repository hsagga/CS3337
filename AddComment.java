package MVC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MVC/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddComment() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		Connection c = null;
		
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220ystu21";
			String user = "cs3220ystu21";
			String pass = "oq3g*!Hq";
			
			c = DriverManager.getConnection(url, user, pass);
			String sql = "insert into guestbook (name, message) values (\"" + name + "\", \"" + message + "\")";
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if ( c != null) c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
		response.sendRedirect("guestbook");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
