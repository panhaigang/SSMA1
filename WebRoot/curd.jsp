<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'list.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
	
	//点击两次可以关闭窗口
	var flag=true;
	function a(){
		if(flag){
			document.getElementById("addDiv").style.display='none';
			flag=false;
		}else{
			document.getElementById("addDiv").style.display='block';
			flag=true;
		}
	}
	
	
	//封装了重复的代码
	function sendAjax(url,methodType,param,retnFunction){
		var xmlhttp=null;
		//兼容所有的浏览器 创建XHR对象
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange=function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				retnFunction(xmlhttp.responseText);
			}
		}
		
		if(methodType=="get"||methodType=="GET"){
			xmlhttp.open("GET",url+"?"+param,true);
			xmlhttp.send();
		}else{
			xmlhttp.open("POST",url,true);
			//charset=UTF-8  解决乱码问题
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
			xmlhttp.send(param);
		}
	}
	
	//查询和删除
	function query() {
		var foodname=document.getElementsByName("foodName")[0].value;
		sendAjax("${pageContext.request.contextPath}/queryFoodList","GET",
			"foodname="+foodname,function(responseText){
				var resultJson=responseText;
		    	//转化为js对象  返回为一个集合
		    	var resultObj=JSON.parse(resultJson);
		    	//获取表格id为myTable对象
		    	var table=document.getElementById("myTable");
		    	//获取所有的name为dataTr的tr
		    	var allDataTr=document.getElementsByName("dataTr");
		    	for(var i=0;allDataTr.length;i++){
		    		//数组是动态变化的   删了第一个 第二个会变成第一个
		    		table.removeChild(allDataTr[0]);
		    	}
		    	
		    	//展示查询的结果
		    	for(var i=0;i<resultObj.length;i++){
		    		var obj=resultObj[i];
		    		
		    		//获取td对象
		    		var td=document.createElement("td");
		    		//设值
		    		td.innerText=obj.foodName;
		    		var td1=document.createElement("td");
		    		td1.innerText=obj.price;
		    		//获取一个td对象
		    		var td2=document.createElement("td");
		    		
		    		//删除按钮
		    		var ib=document.createElement("button");
		    		ib.innerText="删除";
		    		td2.appendChild(ib);
		    		
		    		//修改按钮
		    		var ib1=document.createElement("button");
		    		ib1.innerText="修改";
		    		td2.appendChild(ib1);
		    		
		    		
		    		
		    		//获取tr对象
		    		var tr=document.createElement("tr");
		    		//把获取的对象绑定在button按钮上
		    		ib.foodObj=obj;
		    		//把tr绑定在button按钮上
		    		ib.myLineTr=tr;
		    		//删除的事件
		    		ib.addEventListener("click",function(){
		    			//获取当前按钮
		    			var eventSrc=event.srcElement;
		    			table.removeChild(eventSrc.myLineTr);
		    			
		    			sendAjax("${pageContext.request.contextPath}/deleteFood/"+eventSrc.foodObj.foodid,"POST",
		    						"_method=delete",function(responseText){
		    				if(responseText==1){
		    					alert("删除成功");
		    				}else{
		    					alert("删除失败");
		    				}
		    			})
		    		});
		    		
		    		
		    		//修改的事件
		    		ib1.foodObj=obj;
		    		ib1.addEventListener("click",function(){
		    			//获取当前按钮
		    			var eventSrc=event.srcElement;
		    			//显示窗口
		    			document.getElementById('updateDiv').style.display='block';
		    			document.getElementsByName("umyFoodName")[0].value=eventSrc.foodObj.foodName;
		    			document.getElementsByName("umyFoodPrice")[0].value=eventSrc.foodObj.price;
		    			document.getElementsByName("umyFoodid")[0].value=eventSrc.foodObj.foodid;
		    		});
		    		//给tr标签设一个标识
		    		tr.setAttribute("name","dataTr");
					//在tr追加td
					tr.appendChild(td);
					tr.appendChild(td1);
					tr.appendChild(td2);
					//把tr追加到table后
		    		table.appendChild(tr);
	  			}
		});
	}
	
	//新增
	function saveFood(){
		var myFoodName=document.getElementsByName("myFoodName")[0].value;
		var myFoodPrice=document.getElementsByName("myFoodPrice")[0].value;
		sendAjax("${pageContext.request.contextPath}/saveFood","POST",
			"foodname="+myFoodName+"&price="+myFoodPrice,function(responseText){
			    if(responseText==1){
			    	alert("新增成功");
			    	document.getElementById('addDiv').style.display='none';
			    	query();
			    }else{
			    	alert("新增失败");
			    }
		});
	}
	
	function updateFood(){
		var umyFoodName=document.getElementsByName("umyFoodName")[0].value;
		var umyFoodPrice=document.getElementsByName("umyFoodPrice")[0].value;
		var umyFoodid=document.getElementsByName("umyFoodid")[0].value;
		
		sendAjax("${pageContext.request.contextPath}/updateFood/"+umyFoodid,
			"POST","_method=put&foodname="+umyFoodName+"&price="+umyFoodPrice,
			function(responseText){
			    if(responseText==1){
			    	alert("修改成功");
			    	document.getElementById('updateDiv').style.display='none';
			    	query();
			    }else{
			    	alert("修改失败");
			    }
		});
	}
</script>

	</head>

	<body>
		<input type="text" name="foodName">
		<input type="button" value="提交" onclick="query()">&nbsp;<input type="button" value="新增" onclick="a()">
	</body>

	<table id="myTable">
		<tr><th>菜品名</th><th>菜品价格</th><th>操作</th></tr>
	</table>
	
	<!-- 新增弹出的窗口 -->
	<div id="addDiv" style="display:none;position:absolute;left:40%;top:40%;
		z-index:100;border:1px solid black; width:200px;height:200px">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新增<br/>
		菜品名：<input type="text" name="myFoodName"/><br/>
		价格：<input type="text" name="myFoodPrice"/><br/>
		<input type="button" value="保存" onclick="saveFood()"/><input type="button" value="关闭" onclick="a()"/>
	</div>
	
	<!-- 修改弹出的窗口 -->
	<div id="updateDiv" style="display:none;position:absolute;left:40%;top:40%;
		z-index:100;border:1px solid black; width:200px;height:200px">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改<br/>
		<input type="hidden" name="umyFoodid"/>
		菜品名：<input type="text" name="umyFoodName"/><br/>
		价格：<input type="text" name="umyFoodPrice"/><br/>
		<!-- onclick点击事件关闭窗口 -->
		<input type="button" value="确定" onclick="updateFood()"/><input type="button" value="关闭" 
			onclick="document.getElementById('updateDiv').style.display='none'"/>
	</div>
</html>
