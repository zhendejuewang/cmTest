<!DOCTYPE html>
<html>
	<head style="font-size:35px">
	     <meta name="viewport" content="width=device-width,user-scale=no,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0">
	    <link href="login.css" type="text/css" rel="stylesheet"/> 
		<title>�˻�������</title>
	</head>
	<body>
	    <center>
	        <div id="header1">
	        <center>
	            <span>
	                <
	            </span>
	        �˻�������
	            <span1>
	                <li class="dao li1">+
	                <ul class="sub sub1">
						<a href="/cm/teacher/notification"><li <li class="main">����</li></a>
						<a href="/cm/student/setting"><li class="main">����ҳ</li></a>
						<a href="/cm/student/seminar"><li class="main">���ۿ�</li></a>
				    </ul>
					</li>               
					
					</span1>
	        </center>
	            
	        </div>
	    
	    
	    <table class="table0" cellspacing="0" cellpadding="0">
	        <tr><td class="c10">������</td><td class="c4">${curUser.name}</td><td class="c10"></td></tr>
	        <tr><td class="c2">�̹��ţ�</td><td class="c5">${curUser.account}</td><td class="c2"></td></tr>
	        <tr><td class="c10">��ϵ��ʽ(����)��</td><td class="c4">${curUser.email}</td><td class="c10"><u class="u1">�޸�</u></td></tr>
	        <tr><td class="c2">�˻����룺</td><td class="c5">${curUser.password}</td><td class="c2"><span class="right">></span></td></tr>
	        <tr><td class="c10">����Ա���䣺</td><td class="c4">${adminEmail}</td><td class="c10"></td></tr>
	    </table>
	    </center>
	    <center>
		<!--	<form th:action="@{/logout}" method="post"> -->
			<a href="cm/login"><button class="button8">�˳���¼</button></a></br>
			</form>
	   
	    </center>
	</body>
</html>