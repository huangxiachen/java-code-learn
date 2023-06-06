<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>刘宇2006010224</title>
</head>
<body>
<jsp:useBean id="c1" class="liuyu.Count" scope="request"/>
<jsp:setProperty property="*" name="c1"/>
<form action="" method="post">
    <input type="text" name="number1" value="<%= c1.getNumber1()%>"/>
    <select name="op">
        <option><%= c1.getOp() %></option>
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="text" name="number2" value="<%= c1.getNumber2()%>"/>=
    <input type="text" name="result" value="<%= c1.getResult()%>"/>
    <input type="submit" value="计算"/>
</form>
<%--<jsp:getProperty property="number1" name="c1"/>--%>
<%--<jsp:getProperty property="op" name="c1"/>--%>
<%--<jsp:getProperty property="number2" name="c1"/>=--%>
<%--<jsp:getProperty property="result" name="c1"/>--%>
</body>
</html>