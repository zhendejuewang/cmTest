<!DOCTYPE html>
<html>
<head style="font-size:35px;">
  <meta name="viewport" content="width=device-width,user-scale=no,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0">

		<style>
			body {
     background-color: #e8e8e8;
     color: #000000;
     width:80%;
     margin:auto;
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
 .fontred {
     color:#ff0000;
}
 table{
     width:25rem;
}
 tr td {
     border-top:0.0625rem solid #e8e8e8;
}
 input[type='text'] {
     color:#e8e8e8;
     border-style:none;
     width:60%;
     height:1.875rem;
     font-size:1.25rem;
     position: relative;
    /*设置position属性*/
     top: 50%;
    /*偏移*/
     transform: translateY(-60%);
     padding-left:0.625rem;
}
 select{
     color:#9ACD32;
     width:50%;
     height:1.875rem;
     font-size:1.25rem;
     position: relative;
    /*设置position属性*/
     top: 50%;
    /*偏移*/
     transform: translateY(-50%);
     border-radius:0.625rem;
}
 .div1 {
     width:80%;
     height:2.5rem;
     line-height:2.5rem;
     font-size:1.25rem;
}
 input[type='checkbox']{
     width: 1.25rem;
     height: 1.25rem;
     background-color: #fff;
     border: 1px solid #c9c9c9;
     border-radius: 0.125rem;
     transform: translateY(10%);
}
 .subr{
     width:5rem;
     height:2.1875rem;
     line-height:2.1875rem;
     background-color:red;
     border:none;
     border-radius:0.625rem;
     color:#ffffff;
     font-size:0.9375rem;
     margin:0.625rem 1.25rem 0.9375rem 1.25rem;
}
 .sub3{
     width:5rem;
     height:2.1875rem;
     line-height:2.1875rem;
     background-color:#ffffff;
     border:none;
     border-radius:0.625rem;
     color:#9ACD32;
     font-size:0.9375rem;
     margin:0.625rem 1.25rem 0.9375rem 1.25rem;
     border: 1px solid #9ACD32;
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
a
{
	text-decoration:none;
	color:#000000;
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
    /* border-bottom: 0.0625rem solid #ccc;
     */
     z-index:19999;
}
 .main{
     width:5rem;
     letter-spacing:0.125rem;
     font-size:0.9375rem;
     border-style:solid;
     border:0.5px solid grey;
     border-color:#000000;
     background-color:#ffffff;
}
 
		</style>
		<title></title>
	</head>

<body>
<center>
<div id="header1">
	            <span>
	                <b>&nbsp;</b>
	            </span>
	        讨论课
	            <span1>
	                <b><li class="dao li1">+
	                <ul class="sub sub1">
						<a href="/cm/student/notification"><li class="main">代办</li></a>
						<a href="/cm/student/person"><li class="main">个人页</li></a>
						<a href="/cm/student/seminar"><li class="main">讨论课</li></a>
				    </ul>
					</li>               
					</b>
					</span1>	            
	        </div> 
</center>

<center>
<#assign index=0>
<#list CourseList as Course>

<div class="div1">
<a href="/cm/student/seminar/${Course.id}/${ClassiList[index].id}"<span>${Course.name}(${ClassiList[index].id})</span>
   <span class="right">></span>
   <#assign index=index+1>
</div>
</#list>
</center>

</body>
</html>