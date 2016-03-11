<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">

<title>欢迎登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/static/plugins/jquery-easyui-1.4.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/static/plugins/jquery-easyui-1.4.3/themes/icon.css">
<link rel="shortcut icon" href="<%=path%>/static/image/java-icon.ico"
	type="image/x-icon" />
</head>
<style type="text/css">
* {
	font-family: "微软雅黑";
}
</style>
<body onkeydown="keyLogin();">
	<div id='Loading'
		style="position: absolute; z-index: 1000; top: 0px; left: 0px; width: 100%; height: 100%; background: white; text-align: left;">
	</div>
	<div id="loginWin" class="easyui-window"
		style="width: 350px; height: 200px; padding: 5px;" minimizable="false"
		maximizable="false" resizable="false" closable="false"
		collapsible="false" draggable="false" modal="true" title="&nbsp;欢迎登录">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 5px; background: #fff; border: 1px solid #ccc; height: 150px;">
				<form id="loginForm" method="post" autocomplete="off">
					<div style="padding: 15px 0; text-align: center;">
						<label style="vertical-align: middle; display: inline-block;">用户名:</label>
						<input class="easyui-textbox" type="text"
							data-options="iconCls:'icon-man',iconAlign:'left'"
							style="width: 150px; vertical-align: middle;" name="username"
							id="username">
					</div>
					<div style="padding: 0 0 10px 0; text-align: center;">
						<label for="password"
							style="vertical-align: middle; display: inline-block;">密&nbsp;&nbsp;&nbsp;码:</label>
						<input class="easyui-textbox" type="password"
							data-options="iconCls:'icon-lock',iconAlign:'left'"
							style="width: 150px; vertical-align: middle;" name="password"
							id="password">
					</div>
					<div id="message"
						style="width: 100%; height: 10px; text-align: center; line-height: 10px; display: block; color: red;">
					</div>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: right; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok"
					onclick="validateLogin()">登录</a> <a class="easyui-linkbutton"
					iconCls="icon-cancel" onclick="reset();">重置</a>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript"
	src="<%=path%>/static/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/static/plugins/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/commons.js"></script>
<script type="text/javascript">
	function closemask() {
		$("#Loading").fadeOut("normal", function() {
			$(this).remove();
		});
	}

	var pc;
	$.parser.onComplete = function() {
		if (pc) {
			clearTimeout(pc);
		}
		pc = setTimeout(closemask(), 10);
	}

	/*
		表单登录验证
	 */
	function validateLogin() {
		var url = "system/login.htmls";
		var username = $("#username").val();
		var password = $("#password").val();
		if (isEmpty(username) || isEmpty(password)) {
			clearI();
			$("#message").append("请输入用户名与密码!");
			return false;
		}
		var params = {
			"username" : username,
			"password" : password,
			timestamp : new Date().getTime()
		};
		$.post(url, params, function(data) {
			if (data.code == 404 || data.code == 400) {
				clearI();
				$("#message").append(data.message);
				return false;
			} else {
				window.location.href = "system/mainMapper.htmls";
			}
		});
	}

	/*
		判断用户是否存在
	 */
	function isExsit() {
		var url = "system/isExist.htmls";
		var username = $("#username").val();
		if (username == null || username == "") {
			$("#message").append("请填写用户名!");
			return false;
		}
		var params = {
			"username" : username,
			timestamp : new Date().getTime()
		}
		$.post(url, params, function(data) {
			if (data.code == 404) {
				clearI();
				$("#message").append(data.message);
			} else {
				clearI();
			}
		});
	}

	/*
		表单清空
	 */
	function reset() {
		$('#loginForm').form('clear');//如果采用$('input').val("")写法会有缓存
	}

	function clearI() {
		$("#message").text("");
	}

	function keyLogin() {
		if (event.keyCode == 13) {
			validateLogin();
		}
	}

	$(document).ready(function() {
		$("input", $("#username").next("span")).blur(function() {
			isExsit();
		});
		$("input", $("#username").next("span")).focus(function() {
			clearI();
		})
		$("input", $("#password").next("span")).focus(function() {
			clearI();
		})
	});
</script>