<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="../headConfigs/_headers.jsp"%>
<title>部门管理</title>
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
		//初始化分页插件
		initPagers('${pagers.totalPage}','${pagers.totalSize}','${pagers.currentPage}','${pagers.pageSize}','${pagers.prefixRequest}')
	});
	function subgo(size,id){
		if(size == 0){
			window.location.href="<%=request.getContextPath()%>/dept/delete?skip=${dept.skip}&id="+id;
		}else{
			alert("部门下包含人员！请清空人员后删除该部门~");
		}
	}
	
	//保留页码
	function toEdit(id,readOnly){
		if(id){
			window.location.href="<%=request.getContextPath()%>/dept/edit?skip=${dept.skip}&id="+id+"&readOnly="+readOnly;
		}else{
			window.location.href="<%=request.getContextPath()%>/dept/edit?skip="+${dept.skip};
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
	                <th>序号</th>
	                <th>名称</th>
	                <th>位置</th>
	                <th>操作</th>
				</tr>
			  </thead>
			  <tbody>
			  		<c:forEach var="entity" items="${pagers.list}" varStatus="i">
			  			<tr class="parent" id="row_0${i.count }" >
			  				<td colspan="1">${i.count}</td>
			  				<td colspan="1">${entity.name}</td>
			  				<td colspan="1">${entity.location}</td>
			  				<td colspan="2">
			  					<a href="#" onclick="subgo('${fn:length(entity.empList)}','${entity.id}')">删除</a>
			                    <a href="javascript:toEdit(${entity.id},'false')" >编辑</a>
			                    <a href="javascript:toEdit(${entity.id},'true')" >详情</a>
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
            <a href="javascript:void(0);" ><input onclick="javascript:toEdit();" type='button' value='添加'/></a>
        </p>
        
        <!-- 分页插件渲染容器 start -->
        <div id="kkpager"></div>
        <!-- 分页插件渲染容器 end -->
        
    </form>
    </div>
</body>
</html>