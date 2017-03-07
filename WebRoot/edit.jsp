<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>"><!-- 项目根目录去寻址 -->
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <s:form action="food/food_editFood" ><!-- 第一个food为命名空间，第二个为struts中action，class的名字 -->
    <h1>编辑美食</h1>
    <s:hidden name="food.foodid"></s:hidden>
    <s:textfield name="food.foodname" label="名称"></s:textfield><!--foodName与action里的成员变量一致  -->
    <s:textfield name="food.unitprice" label="单价"></s:textfield>
        <s:textfield name="food.vipprice" label="会员价格"></s:textfield>
    <s:submit value="提交"></s:submit>
    </s:form>
    
  </body>
</html>
