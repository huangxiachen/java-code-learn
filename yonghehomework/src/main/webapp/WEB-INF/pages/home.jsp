<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
</head>
<style>
	.content {
		position: absolute;
		top: 100px;
		left: 10%;
		bottom: 0;
		right: 0;
		overflow: scroll; /* 或 auto */
		width: 89%;
		height: 90%;
	}
</style>
<body>
		<jsp:include page="_top.jsp"/>
		<jsp:include page="_left.jsp"/>

		<iframe class="content" name="rightFrame" src ="_right" >
		</iframe>
</body>
</html>
