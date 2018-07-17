package cn;




	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.ResultSet;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.json.JSONException;
	import org.json.JSONObject;

import cn.DBConnection;

	public class insert extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doPost(request, response);
		}

		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			response.setContentType("text/plain;charset=utf-8");
			
			String score = request.getParameter("score");
			System.out.println("score:"+score);
			String time = request.getParameter("time");
			System.out.println("time:"+time);
			
			
			
			try {
				////////////
				// do something
				////////////
				DBConnection db = new DBConnection();
				String sql = "insert into information(userid,score,time) values('1507','"+score+"','"+time+"')";
				db.execute(sql);
		     	db.close();
				

		     	response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				JSONObject obj = new JSONObject();
				
				obj.put("result", "ok");
				
				System.out.println(obj.toString());
				out.print(obj.toString());
				out.flush();
				out.close();
				
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
		


	}



