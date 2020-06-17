package action;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatastoreDao;
import pojo.User;

@SuppressWarnings("serial")
public class UserManagement extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 Random rnd = new Random();
		 User userObj = new User.Builder()
				 	.userName(request.getParameter("uname"))
				 	.mobile(request.getParameter("umobile"))
				 	.roleId(Integer.parseInt(request.getParameter("uroleId")))
				 	.password(rnd.nextInt(999999)+"")
					.build();
		 DatastoreDao dao = new DatastoreDao();
		 response.getWriter().print(dao.createCategory(userObj));
	}

}
