<%@ page pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8"/>
<style>
	body{ background:#222D32;margin:0px; }
	.menu-bar a{ color:#fff;text-decoration:none; }
	.menu-bar{ font-size:22px;border-bottom:1px solid #fff;height:40px;line-height:40px;text-indent:18px;letter-spacing:5px; }
	.menu-bar:first-child{border-top:1px solid #fff;}
	.menu-bar:hover{background:#797979;}
	.sider {
		position: fixed;
		top: 100px;
		width: 10%;
		height: 100%;
	}
</style>
</head>
<body>
	<div class="sider">
		<div class="menu-bar">
			<a  href="${pageContext.request.contextPath}/door/list" target="rightFrame">› 门店管理</a>
		</div>
		<div class="menu-bar">
			<a  href="${pageContext.request.contextPath}/order/list" target="rightFrame">› 订单管理</a>
		</div>
	</div>



</body>
</html>