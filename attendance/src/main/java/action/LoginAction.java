package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatastoreDao;
import pojo.User;

@SuppressWarnings("serial")
public class LoginAction extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DatastoreDao dao = new DatastoreDao();
		List<User> userList = dao.getByPhone(request.getParameter("mobile"));
		if(userList.get(0).getPassword().equals(request.getParameter("pass"))) {
			request.setAttribute("userId", userList.get(0).getId());
			request.setAttribute("Name", userList.get(0).getUserName());
			request.setAttribute("Mobile", userList.get(0).getMobile());
			request.setAttribute("Role", userList.get(0).getRoleId());
			if(userList.get(0).getRoleId() == 1) {
				 request.getRequestDispatcher("/student.jsp").forward(request, response);
			}else if(userList.get(0).getRoleId() == 2) {
				 request.getRequestDispatcher("/teacher.jsp").forward(request, response);
			}
		}
	}

}
