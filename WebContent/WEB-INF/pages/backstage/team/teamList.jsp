<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="../headConfigs/_headers.jsp"%>
<title>班组管理</title>
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
			$("#listForm").attr("action","<%=request.getContextPath()%>/team/delete").submit();
			$("#listForm").attr("action","");
		});
		
		//初始化分页插件
		initPagers('${pagers.totalPage}','${pagers.totalSize}','${pagers.currentPage}','${pagers.pageSize}','${pagers.prefixRequest}')
	});
	
</script>
</head>
<body>
    <div>
        <h2><span>班组管理</span></h2>
        <form action='<c:url value="/team/teamList" />' method="post" id="listForm">
        
        <table border="1" width="100%" >
            <tr>
                <th>序号</th>
                <th>班组名称</th>
                <th>操作</th>
            </tr>
            <c:forEach var="entity" items="${pagers.list}" varStatus="i">
                <tr>
                    <td>${i.count}</td>
                    <td>${entity.name}</td>
                    <td>
                    <a href="<c:url value="/team/"/>delete?id=${entity.id}">删除</a>
                    <a href="<c:url value="/team/edit"/>?id=${entity.id}" >编辑</a>
                    <a href="<c:url value="/team/edit"/>?id=${entity.id}&readOnly=true" >详情</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p>
        	<a href="<c:url value="/"/>" ><input type='button' value='返回菜单'/></a>
            <a href="<c:url value="/team/edit"/>" ><input type='button' value='添加'/></a>
        </p>
        
        <!-- 分页插件渲染容器 start -->
        <div id="kkpager"></div>
        <!-- 分页插件渲染容器 end -->
        
    </form>
    </div>
</body>
</html>