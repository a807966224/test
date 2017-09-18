<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>

<!-- 
	https://github.com/pgkk/kkpager.git
	js分页展示控件 
-->
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.10.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/kkpager.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/pagers.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/kkpager_blue.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/test.css"/>">

<style>

table{ border:0;border-collapse:collapse;}
td{ font:normal 12px/17px Arial;padding:20px;width:100px;text-align:center; }
th{ font:bold 12px/17px Arial;text-align:center;padding:20px;border-bottom:1px solid #333;width:100px;background:#d3dfed;}
.parent { background:#3f8fed;cursor:pointer;color:#fff;} 
.selected{ background:#ecf5ff;color:#000;}
</style>
<script type="text/javascript">
$(function(){
 $('tr.parent').click(function(){   // 获取所谓的父行
   $(this)
    .toggleClass("selected")   // 添加/删除高亮
    .siblings('.child_'+this.id).toggle();  // 隐藏/显示所谓的子行
 }).click();
})
</script>

<style>

table td{text-align: center;}

</style>

<script>
	$(function(){
		
		$("#checkAll").click(function(){
			if(this.checked){
				$("input[name='id']").prop("checked","true"); 
			}else{
				$("input[name='id']").removeAttr("checked"); 
			}
		});
		
		$("input[name='id']").click(function(){
			if(this.checked){
				
				var allSize = $("input[name='id']").length;
				var checkedSize = $("input[name='id']:checkbox:checked").length;
				if(allSize == checkedSize){
					$("#checkAll").prop("checked","true"); 
				}
			}else{
				$("#checkAll").removeAttr("checked"); 
			} 
		});
		
		$("input[id='delOpt']").click(function(){
			$("#listForm").attr("action","<%=request.getContextPath()%>/dept/delete").submit();
			$("#listForm").attr("action","");
		});
		
		//初始化分页插件
		initPagers('${pagers.totalPage}','${pagers.totalSize}','${pagers.currentPage}','${pagers.prefixRequest}')
	});
	function subgo(size,id){
		if(size == 0){
			window.location.href="<%=request.getContextPath()%>/dept/delete?id="+id;
		}else{
			alert("部门下包含人员！请清空人员后删除该部门~");
		}
	}
</script>
</head>
<body>
    <div>
        <h2><span>部门管理</span></h2>
        <form action="" method="post" id="listForm">
        
       	  <table width="100%">
			  <thead>
				<tr>
					<th><input type="checkbox" id="checkAll" ></th>
	                <th>序号</th>
	                <th>名称</th>
	                <th>位置</th>
	                <th>操作</th>
				</tr>
			  </thead>
			  <tbody>
			  		<c:forEach var="entity" items="${pagers.list}" varStatus="i">
			  			<tr class="parent" id="row_0${i.count }" >
			  				<td><input type="checkbox" name="id" value="${entity.id}"></td>
			  				<td colspan="1">${i.count}</td>
			  				<td colspan="1">${entity.name}</td>
			  				<td colspan="1">${entity.location}</td>
			  				<td colspan="2">
			  					<a href="#" onclick="subgo('${fn:length(entity.empList)}','${entity.id}')">删除</a>
			                    <a href="<c:url value="/dept/edit"/>?id=${entity.id}" >编辑</a>
			                    <a href="<c:url value="/dept/edit"/>?id=${entity.id}&readOnly=true" >详情</a>
			  				</td>
			  			</tr>
		                <c:forEach var="emp" items="${entity.empList }" varStatus="k">
		                	<tr class="child_row_0${i.count }" style="background: #d3dfed;">
		                		<td colspan="5">
		                			${emp.name}
		                			<c:if test="${emp.sex == 1}">男</c:if>
									<c:if test="${emp.sex == 2}">女</c:if>
		               			</td>
		               		</tr>
		                </c:forEach>
            		</c:forEach>
			  </tbody>
		 </table>
        
        <p>
        	<a href="<c:url value="/"/>" ><input type='button' value='返回菜单'/></a>
            <a href="<c:url value="/dept/edit"/>" ><input type='button' value='添加'/></a>
            <input type="button" id="delOpt" value="批量删除" />
        </p>
        <div id="kkpager"></div>
    </form>
    </div>
</body>
</html>