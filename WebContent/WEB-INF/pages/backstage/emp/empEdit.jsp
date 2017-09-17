<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>新增人员</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.10.2.min.js"/>"></script>
<style>
.p select option{
width:150px;
height:30px;
}
</style>

<script>
	$(function(){
		initAge();
	});
	
	function initAge(){
		var age = '${bean.age}';
		for(var i = 1;i<100;i++){
			if(age == i){
				$("#age").append("<option selected value='"+i+"'>"+i+"</option>");
			}else{
				$("#age").append("<option value='"+i+"'>"+i+"</option>");
			}
		}
	}
</script>
</head>
<body>
    <div>
        <h2><span>新增人员</span></h2>
        <form action="<c:url value="/emp/save" />" method="post">
        	<input type="hidden" name="id" value="${bean.id }" />
        <fieldset>
            <legend>人员</legend>
            <p>
                <label>人员名称：</label>
                <input type="text" name="name" value="${bean.name }" />
            </p>
            <p>
                <label>人员性别：</label>
                <input type="radio" <c:if test="${bean.sex == 1}">checked="checked"</c:if> name="sex" value="1" /> 男
                <input type="radio" <c:if test="${bean.sex == 2}">checked="checked"</c:if> name="sex" value="2" /> 女
            </p>
            <p>
                <label>人员年龄：</label>
                <select id="age" name="age">
                	<option value=''>请选择</option>
                </select>
            </p>
             <p>
                <label>部门：</label>
                <select id="deptId" name="deptId">
                	<option value=''>请选择</option>
                	<option <c:if test="${bean.deptId == 1}">selected</c:if> value='1'>研发部</option>
                	<option <c:if test="${bean.deptId == 2}">selected</c:if> value='2'>市场部</option>
                </select>
            </p>
            <p>
              <input type="submit" value="保存" >
            </p>
        </fieldset>
        </form>
        
        <p>
            <a href="<c:url value="/emp/empList" />">返回列表</a>
        </p>
    </div>
</body>
</html>