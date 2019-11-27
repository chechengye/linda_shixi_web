<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<c:if test="${username != null}">
				<li><a href="login.jsp">欢迎您,${username}</a></li>
			</c:if>
			<c:if test="${username == null}">
				<li><a href="login.jsp">登录</a></li>
				<li><a href="register.jsp">注册</a></li>
			</c:if>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="order_list.jsp">我的订单</a></li>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">首页</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="product_list.htm">手机数码<span class="sr-only">(current)</span></a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group" style="position: relative;">
						<input id="search" type="text" class="form-control" placeholder="Search" onkeyup="searchKey(this)">
						<div id="resultList" style="z-index:1000;height: 200px ; width: 177px; background: white;position: absolute; display: none;"></div>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</nav>
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		function searchKey(obj) {
            var key = $(obj).val();
            var contentStr = "";
            if(key != ""){
                $.ajax({
                    url:"/searchKey",
                    data:{"key":key},
                    type:"POST",
                    dataType:"json",
                    success: function (data) {
                        if(data.length > 0){

                            for (var i = 0 ; i < data.length ; i++){
                                contentStr += "<div style='font-size: 12px; padding: 5px;background: ' onmouseover='mouseoverFn(this)' onmouseout='mouseoutFn(this)' onclick='clickFn(this)'>" + data[i].pname + "</div>";
                            }
                            $("#resultList").html(contentStr);
                            $("#resultList").css("display" , "block");
                        }

                    }
                });
			}else{
                $("#resultList").css("display" , "none");
			}

        }

        function mouseoverFn(obj) {
			$(obj).css("background" , "#2aabd2");
        }
        function mouseoutFn(obj) {
			$(obj).css("background" , "#fff")
        }

        function clickFn(obj){
		    $("#search").val($(obj).html());
            $("#resultList").css("display" , "none");
		}
	</script>
</div>