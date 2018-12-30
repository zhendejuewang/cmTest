<!DOCTYPE html>
<html>
	<head style="font-size:35px;">
<meta name="viewport" content="width=device-width,user-scale=no,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0">

	<style>
body {
     background-color: #e8e8e8;
     color: #000000;
     margin:auto;
     width:80%;
}
a
{
	text-decoration:none;
	color:#000000;
}
 .header{
     font-size:1.5625rem;
     height:3.125rem;
     line-height:3.125rem;
     letter-spacing:0.625rem;
     background-color:#ffffff;
}
 div{
     width:80%;
     border-bottom: 0.0625rem solid #d1d1d1;
     font-size:1.25rem;
     background-color:#ffffff;
}
 input {
     color:#9c9c9c;
     border-style:none;
     margin:0.3125rem;
     height:2.5rem;
     font-size:1.25rem;
     background-color:#ffffff;
}
 .left{
     float:left;
     margin-left:10%;
     position:relative;
}
 .right{
     margin-right:10%;
     ;
     float:right;
     position:relative;
}
 .rule {
     height:2.5rem;
     line-height:2.5rem;
     font-size:1.25rem;
}
 .sumbackgroundw {
     background-color:#ffffff;
     height:2.5rem;
     text-align:center;
     display: table-cell;
     vertical-align:middle;
     font-size:1.5625rem;
}
 .fontgreen {
     color:#9ACD32;
}
 table{
     width:25rem;
}
 tr td {
     border-top:0.0625rem solid #e8e8e8;
}
 #backcolor {
     background-color:#e8e8e8;
     height:2.5rem;
     line-height:2.5rem;
     width:100% 
}
 #header1{
     background-color:#9ACD32;
     width:80%;
     font-size:1.5625rem;
     height:2.5rem;
     line-height:2.5rem;
     letter-spacing:0.625rem;
     margin-bottom:0.3125rem;
}
 #header1 span{
     display:inline-block;
     margin-left:0.625rem;
     float:left;
     font-size:2.5rem;
     line-height:2.1875rem;
}
 #header1 span1{
     display:inline-block;
     margin-right:0.625rem;
     float:right;
     font-size:2.5rem;
     line-height:2.1875rem;
}
 li{
     list-style: none;
}
 ul{
     list-style: none;
     margin: 0rem;
     padding: 0rem;
}
 .sub{
     margin-top:1.875rem;
     position: absolute;
     right: 0.3125rem;
     background: #ffffff;
     top:0;
     display: none;
}
 .li1:hover .sub1{
     display: block;
}
 .dao{
     width:100%;
     height:2.5rem ;
     line-height: 2.5rem;
     position: relative;
     border-style:none;
     z-index:19999;
    /* border-bottom: 0.0625rem solid #ccc;
     */
}
 .main{
     width:5rem;
     letter-spacing:0.125rem;
     font-size:0.9375rem;
     border-style:solid;
     border:0.5px solid grey;
     border-color:#000000 
}
 	
	</style>
		<title>Enter your title here</title>
	</head>
	<body>
		<center>		
			<div id="header1" style="background-color:#ffffff;">
	            <span>
	                <b><</b>
	            </span>
	        课程管理
	            <span1>
	                <b><li class="dao li1">+
	                <ul class="sub sub1">
						<a href="/cm/teacher/notification"><li class="main">代办</li></a>
						<a href="/cm/teacher/person"><li class="main">个人页</li></a>
						<a href="/cm/teacher/seminar"><li class="main">讨论课</li></a>
				    </ul>
					</li>               
					</b>
					</span1>	            
	        </div> 
			
			<div style="height:0.75rem;background-color:#e8e8e8"> </div>
			
			<div>		
			<details>
			<!--老师开的好多课程-->
			<#list CourseList as Course>
				<summary  class="sumbackgroundw">${Course.name}</summary>
				<a href="/cm/teacher/course/grade/${Course.id}"><div id="backcolor">
		学生成绩
	    <span class="right">></span>
	    <br/>
				</div>	</a>
				<a href="/cm/teacher/course/team/${Course.id}"><div id="backcolor">
		学生组队
	    <span class="right">></span>
	    <br/>
				</div>	
	<a href="/cm/teacher/course/${Course.id}"><div id="backcolor">
		课程信息
	    <span class="right">></span>
	    <br/>
	</div>	</a>
	<a href="/cm/teacher/course/classi/${Course.id}"><div id="backcolor">
		班级信息
	    <span class="right">></span>
	    <br/>
	</div>	</a>
	<a href="/cm/teacher/course/seminarset/${Course.id}"><div id="backcolor">
		讨论课设置
	    <span class="right">></span>
	    <br/>
	</div>	</a>
	<a href="/cm/teacher/course/shareset/${Course.id}"><div id="backcolor">
		共享设置
	    <span class="right">></span>
	    <br/>
	</div>	</a>
	</#list>
			</details>
			
			</div>
			<div style="height:3.75rem;background-color:#e8e8e8"></div>
			<a href="/cm/teacher/addcourse"><div class="header">
		+新建课程
	    <span class="right">></span>
	    <br/>
	</div>	</a>
		</center>



	</body>
</html>
