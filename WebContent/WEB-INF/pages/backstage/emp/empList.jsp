<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员管理</title>

<!-- 
	https://github.com/pgkk/kkpager.git
	js分页展示控件 
-->
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.10.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/kkpager.min.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/kkpager_blue.css"/>" />

<script type="text/javascript">
function getParameter(name) { 
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r!=null) return unescape(r[2]); return null;
}

//init
$(function(){
	var totalPage = 20;
	var totalRecords = 390;
	var pageNo = getParameter('pno');
	if(!pageNo){
		pageNo = 1;
	}
	//生成分页
	//有些参数是可选的，比如lang，若不传有默认值
	kkpager.generPageHtml({
		pno : pageNo,
		//总页码
		total : totalPage,
		//总数据条数
		totalRecords : totalRecords,
		//链接前部
		hrefFormer : 'pager_test',
		//链接尾部
		//hrefLatter : '.html',
		getLink : function(n){
			return this.hrefFormer + this.hrefLatter + "?pno="+n;
		}
	});
});
</script>

</head>
<body>
    <div>
        <h2><span>人员管理</span></h2>
        <form action="deletes" method="post">
        <table border="1" width="100%" >
            <tr>
                <th><input type="checkbox" ></th>
                <th>序号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>操作</th>
            </tr>
            <c:forEach var="entity" items="${emps}" varStatus="i">
                <tr>
                    <th><input type="checkbox" name="id" value="${entity.id}"></th>
                    <td>${i.count}</td>
                    <td>${entity.name}</td>
                    <%-- <td><img src="<c:url value="/images/${entity.picture}"/>" height="40"/></td> --%>
                    <td>${entity.sex}</td>
                    <td>${entity.age}</td>
                    <td>
                    <a href="<c:url value="/emp/"/>delete/${entity.id}">删除</a>
                    <a href="<c:url value="/emp/"/>edit/${entity.id}" >编辑</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p>
            <a href="add" >添加</a>
            <input type="submit"  value="批量删除" />
        </p>
        <div id="kkpager"></div>
    </form>
    </div>
</body>
</html>