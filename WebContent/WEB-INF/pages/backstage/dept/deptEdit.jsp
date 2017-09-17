<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>新增部门</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.10.2.min.js"/>"></script>
</head>
<body>
    <div>
        <h2><span>新增部门</span></h2>
        <form action="<c:url value="/dept/save" />" method="post">
        	<input type="hidden" name="id" value="${bean.id }" />
        <fieldset>
            <legend>部门</legend>
            <p>
                <label>部门名称：</label>
                <input type="text" name="name" value="${bean.name }" />
            </p>
            <p>
                <label>部门位置：</label>
                <input type="text" name="location" value="${bean.location }" />
            </p>
            <p>
              <input type="submit" value="保存" >
            </p>
        </fieldset>
        </form>
        
        <p>
            <a href="<c:url value="/dept/deptList" />">返回列表</a>
        </p>
    </div>
</body>
</html>