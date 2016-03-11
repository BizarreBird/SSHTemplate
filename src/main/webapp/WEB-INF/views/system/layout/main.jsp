<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/static/plugins/jquery-easyui-1.4.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/static/plugins/jquery-easyui-1.4.3/themes/icon.css">
</head>
<style>
	*{
		margin:0;
		padding:0;
	}
</style>
<body>
	<div id="main" class="easyui-layout" style="width:100%;height:100%;">   
	    <div data-options="region:'north',title:'North Title',split:false,collapsible:false,href:'system/northMapper.htmls'" style="height:75px;"></div>   
	    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true,href:'system/eastMapper.htmls'" style="width:200px;overflow: hidden;"></div>   
	    <div data-options="region:'west',title:'Menu Navication',split:true,href:'system/westMapper.htmls'" style="width:200px;"></div>   
	    <div data-options="region:'center',title:'center title',href:'system/centerMapper.htmls'" style="padding:5px;background:#eee;overflow: hidden;"></div>   
	</div> 
</body>
</html>
<script type="text/javascript"
	src="<%=path%>/static/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/static/plugins/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
