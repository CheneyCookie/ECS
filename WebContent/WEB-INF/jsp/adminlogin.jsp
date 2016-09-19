<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<style type="text/css">
		*{
			margin:0px;
			padding:0px;
		}

		body{
			color:#444444;
			font-size:13px;
			background:#f2f2f2;
			font-family:"Microsoft YaHei";
		}

		#content{
			margin:15px auto;
			text-align:center;
			width:600px;
			position:relative;
			height:100%;
		}

		#content h1{
			color:#ccc;
			font-size:36px;
			text-shadow:1px 1px 1px #fff;
			padding:20px;
		};

		#wrapper{
			box-shadow:0px 0px 3px #aaa;
			border-radius:10px;
			border:2px solid #fff;
			background-color:#f9f9f9;
			width:600px;
			overflow:hidden;
		}

		#steps{
			width:3200px;
			overflow:hidden;
		}

		.step{
			float:left;
			width:600px;
		}

		#steps form fieldset{
			border:none;
			padding-bottom:20px;
		}

		#steps form legend{
			text-align:center;
			background-color:#f0f0f0;
			
			color:#666;
			font-size:24px;
			text-shadow:1px 1px 1px #fff;
			font-weight:bold;
			float:left;
			width:590px;
			padding:5px 0px 5px 10px;
			margin:10px 0px;
			border-bottom:1px solid #fff;
			border-top:1px solid #d9d9d9;
		}
		
		#steps form p{
			float:left;
			clear:both;
			margin:5px 0px;
			background-color:#f4f4f4;
			border:1px solid #fff;
			width:400px;
			padding:10px;
			margin-left:100px;
			border-radius:5px;
			box-shadow:0px 0px 3px #aaa;
		}

		#steps form p label{
			width:160px;
			float:left;
			text-align:right;
			margin-right:15px;
			line-height:26px;
			color:#666;
			text-shadow:1px 1px 1px #fff;
			font-weight:bold;
		}

		#steps form input:not([type=radio]),
		#steps form textarea,
		#steps form select{
			background:#ffffff;
			border:1px solid #ddd;
			border-radius:3px;
			outline:none;
			padding:5px;
			width:200px;
			float:left;
		}

		#steos form p .error{
			background-color:rgb(255,237,239);
		}	

		#steps form input:focus{
			box-shwdow:0px 0px 3px #aaa;
			background-color:#FFFEEF;
		}
		


	</style>
	<title></title>
</head>
<body>
	<div id="content">
		<h1></h1>
		<div id="wrapper">
			<div id="steps">
				<form action="adminLogin" id="formElem" method="post">
					<fieldset class="step">
					<legend>电子商务系统</legend>
					<p>
						<label for="adminname">管理员</label>
						<input id="adminname" type="text" name="adminname">
					</p>

					<p>
						<label for="password">密码</label>
						<input type="password" id="password" name="password" AUTOCOMPLETE=OFF>
					</p>
					<p>
						<input type="button" value="登陆" onclick="this.form.submit()">
						<input type="button" value="退出">
					</p>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>