<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="../headConfigs/_headers.jsp"%>
<title>人员管理</title>
<style>
table td{text-align: center;}
#searchTable tr td{padding:10px;}
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
			$("#listForm").attr("action","<%=request.getContextPath()%>/emp/delete").submit();
			$("#listForm").attr("action","");
		});
		
		//初始化分页插件
		initPagers('${pagers.totalPage}','${pagers.totalSize}','${pagers.currentPage}','${pagers.pageSize}','${pagers.prefixRequest}')
	});
	
	function searchList(){
		
		$("#listForm").submit();
		
	}
	
	function cleanUp(){
		
	 	$(':input','#listForm')

       .not(':button,:submit,:reset,:hidden')   //将myform表单中input元素type为button、submit、reset、hidden排除

       .val('')  //将input元素的value设为空值

       .removeAttr('checked')

       .removeAttr('checked') // 如果任何radio/checkbox/select inputs有checked or selected 属性，将其移除
	}
	
</script>
</head>
<body>
    <div>
        <h2><span>人员管理</span></h2>
        <form action='<c:url value="/emp/empList" />' method="post" id="listForm">
        
        <table id="searchTable" style="margin-bottom: 10px;padding: 5px;" >
        	<tr>
        		<td>姓名</td>
        		<td><input type='text' name="name" value="${bean.name }" /></td>
        		<td>部门</td>
        		<td>
        			<select id="deptId" name="deptId" style="width: 200px;" >
	                	<option value=''>请选择</option>
	                	<c:forEach items="${deptList }" var="dept">
	                		<option <c:if test="${bean.deptId == dept.id}">selected</c:if> value='${dept.id }'>${dept.name }</option>
	                	</c:forEach>
	                </select>
        		</td>
        		<td>
        			<input type='button' style="width: 80px;padding-top: 3px;padding-bottom: 3px;" onclick="javascript:searchList();" value="查询" />
        			<input type='button' style="width: 80px;padding-top: 3px;padding-bottom: 3px;" onclick="javascript:cleanUp();" value="重置" />
       			</td>
        	</tr>
        </table>
        
        <table border="1" width="100%" >
            <tr>
                <th><input type="checkbox" id="checkAll" ></th>
                <th>序号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>部门</th>
                <th>操作</th>
            </tr>
            <c:forEach var="entity" items="${pagers.list}" varStatus="i">
                <tr>
                    <th>
                    	<input type="checkbox" name="id" value="${entity.id}">
                    	<input type="hidden" name="delPhotoSrc" value="${entity.photoSrc}">
                   	</th>
                    <td>${i.count}</td>
                    <td>${entity.name}</td>
                    <td>
                    	<c:if test="${entity.sex == 1}">男</c:if>
						<c:if test="${entity.sex == 2}">女</c:if>
					</td>
                    <td>${entity.age}</td>
                    <td>${entity.deptName}</td>
                    <td>
                    <a href="<c:url value="/emp/"/>delete?id=${entity.id}&delPhotoSrc='${entity.photoSrc}'">删除</a>
                    <a href="<c:url value="/emp/edit"/>?id=${entity.id}" >编辑</a>
                    <a href="<c:url value="/emp/edit"/>?id=${entity.id}&readOnly=true" >详情</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p>
        	<a href="<c:url value="/"/>" ><input type='button' value='返回菜单'/></a>
            <a href="<c:url value="/emp/edit"/>" ><input type='button' value='添加'/></a>
            <input type="button" id="delOpt" value="批量删除" />
        </p>
        
        <!-- 分页插件渲染容器 start -->
        <div id="kkpager"></div>
        <!-- 分页插件渲染容器 end -->
        
    </form>
    </div>
</body>
</html>