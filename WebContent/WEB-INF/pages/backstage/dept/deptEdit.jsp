<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="../headConfigs/_headers.jsp"%>
<title>新增部门</title>
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
        <h2><span>新增部门</span></h2>
        <form id="editForm" action="<c:url value="/dept/save" />" method="post">
        	<input type="hidden" name="id" value="${bean.id }" />
        <fieldset>
            <legend>部门</legend>
            <p>
                <label>部门名称：</label>
                <input type="text" name="name" value="${bean.name }" required />
            </p>
            <p>
                <label>部门位置：</label>
                <input type="text" name="location" value="${bean.location }" required />
            </p>
            <p>
              <input type="submit" value="保存" >
            </p>
        </fieldset>
        </form>
        
        <p>
            <a href="<c:url value="/dept/deptList?skip=${bean.skip }" />">返回列表</a>
        </p>
    </div>
</body>
</html>