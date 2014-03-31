<%-- 
    Document   : activation
    Created on : Mar 31, 2014, 10:18:46 AM
    Author     : User
--%>

<%@page import="com.alisveris.DBOperations"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% DBOperations db = new DBOperations();
    if(request.getParameter("code")!=null){
        db.activateUser(request.getParameter("code"));
        response.sendRedirect("home.xhtml");
    }else{
        
}
%>
