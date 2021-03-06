/**
 * �Խ��� ���� �����ϴ� Action
 */
package com.board.action;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.controller.CommandAction;
 
public class ModifyAction implements CommandAction {
 
    public String requestPro(HttpServletRequest request,
 
    HttpServletResponse response) throws Throwable {
    	
    	Class.forName("com.mysql.jdbc.Driver");
    	String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
    	String dbUser = "root";
    	String dbPass = "dmsxor12";
    	Connection conn = null;
    	Statement stmt = null;    	    	
    		try{
    			
    			HttpSession session = request.getSession();
            	
        		if(session.getAttribute("sessionId") == null){
        	    	System.out.println(4);
        			return "loginerror.jsp";
        		}
    			
    			request.setCharacterEncoding("utf-8");
    			String num = request.getParameter("num");    			
    			String hotelName = request.getParameter("hotelName");
    			String content = request.getParameter("content");
    			
    			conn = DriverManager.getConnection(url,dbUser,dbPass);    			    			    			
    					
    			stmt = conn.createStatement();
   			    			    		
    			String sql = "UPDATE board SET hotelName='" + hotelName + "' ,content='"+ content +    						
    						"' WHERE num=" + num;				
    			stmt.executeUpdate(sql);    			

    			stmt.close();
    			conn.close();    			
    		 
     } catch(SQLException e) {
    	System.out.println( e.toString() );
    } finally{    	
    	if(stmt != null) try{stmt.close();} catch(SQLException ex){}			
		if(conn != null) try{conn.close();} catch(SQLException ex){}
		}
    	
    	
        return "content.do";
 
    }
 
}