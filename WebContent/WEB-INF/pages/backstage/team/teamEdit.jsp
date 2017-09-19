<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>新增班组</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.10.2.min.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/test.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/quick_layout-min.css"/>">
<script type="text/javascript" src="<c:url value="/resources/js/jquery-html5Validate.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/utils.js"/>"></script>
<style>
.error { box-shadow: 0 0 10px #ff4136; }
</style>
<script>

$(function(){
	
	if(${readOnly}){
		
		unEdit();
		
	}
	
});

$("#editForm").html5Validate(function() {
	alert("全部通过！");
	//this.submit();	
}, {
	// novalidate: false,
	// labelDrive: false
});
</script>
</head>
<body>
    <div>
        <h2><span>新增班组</span></h2>
        <form id="editForm" action="<c:url value="/team/save" />" method="post">
        	<input type="hidden" name="id" value="${bean.id }" />
        <fieldset>
            <legend>班组</legend>
            <p>
                <label>班组名称：</label>
                <input type="text" name="name" value="${bean.name }" required />
            </p>
            <p>
              <input type="submit" value="保存" >
            </p>
        </fieldset>
        </form>
        
        <p>
            <a href="<c:url value="/team/teamList?skip=${bean.skip }" />">返回列表</a>
        </p>
    </div>
</body>
</html>