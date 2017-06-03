<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="app.User" %>

<html>
<head>
    <title>HTTP Response Example</title> </head>
<body>
Welcome to Brainy Software <br>

<form  method="get">
    UserID: <input type="text" name="userID">

    ClientName: <input type="text" name="clientName">
    UserName: <input type="text" name="userdata" >
    <input type="submit" value="submit">
</form>
<%
    if(request.getParameter("userID")!=null){
        String userdata=request.getParameter("userID");
        String clientname=request.getParameter("clientName");
        Integer i=Integer.parseInt(userdata);
        InputStream inputStream= Resources.getResourceAsStream("MybatisConf.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sess=sessionFactory.openSession();

        String statment="richard.mapping.MybatisMapper.getUserOne";

        User user=sess.selectOne(statment,i);
        System.out.println(user.toString().replaceAll("\\D+","_"));
%>
<p>the data is</p>
<%
        out.print(user);
        out.close();
    }

%>
<form  method="get">
    UserID: <input type="text" name="userID">

    ClientName: <input type="text" name="clientName">
    UserName: <input type="text" name="userdata" >
    <input type="submit" value="submit">

</form>
<%
if(request.getParameter("userID")!=null){
String userdata=request.getParameter("userID");
String clientname=request.getParameter("clientName");
Integer i=Integer.parseInt(userdata);
InputStream inputStream= Resources.getResourceAsStream("MybatisConf.xml");
SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
SqlSession sess=sessionFactory.openSession();

String statment="richard.mapping.MybatisMapper.getUserOne";

User user=sess.selectOne(statment,i);
System.out.println(user.toString().replaceAll("\\D+","_"));
%>
<p>the data is</p>
<%
out.print(user);
out.close();
}

%>
</body>
</html>