<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="../headConfigs/_headers.jsp"%>
<title>新增人员</title>


<style>
.error { box-shadow: 0 0 10px #ff4136; }
</style>
<script>
$("#editForm").html5Validate(function() {
	alert("全部通过！");
	//this.submit();	
}, {
	// novalidate: false,
	// labelDrive: false
});
</script>
<script>
	$(function(){
		
		initAge();
		
		if(${readOnly}){
			
			unEdit();
		}
		
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
        <form id="editForm" action="<c:url value="/emp/save" />" method="post">
        	<input type="hidden" name="id" value="${bean.id }" />
        	<input type="hidden" name="photoSrc" id="photoSrc" value="${bean.photoSrc }" />
        	
        	<!-- 回收垃圾图片 -->
        	<c:if test="${!empty bean.photoSrc}">
        		<input type='hidden' name='tmpPhoto' value='${bean.photoSrc }' />
        	</c:if>
        	
        	<!-- 以下提供上传图片的按钮以及图片预览地址，根据需求进行改动    -->
        	<!-- code start -->
        	<div style="border: 1px solid grey;width: 200px;height: 210px;position: absolute;left: 22%;top: 14%;">
                <div style="text-align: center;padding: 10px;">
                    <a id="upload-target" >添加图片并上传</a>
                </div>
                <div style="margin-left: 20px;" id="upload-image-view" >
                
                	<c:if test="${bean.photoSrc != null }">
						<div class="u-item">
							<div class="u-img">
								<img src="/images/${bean.photoSrc}">
							</div>
							<div class="u-progress-bar" style="opacity: 0.3;">
								<div class="u-progress" style="opacity: 0.5; width: 100%;"></div>
							</div>
						</div>
					</c:if>
                
                </div>
                <div id="log"></div>
            </div>
            <!-- code end -->
        	
	        <fieldset>
	            <legend>人员</legend>
	            <p>
	                <label>人员名称：</label>
	                <input type="text" name="name" value="${bean.name }" required />
	            </p>
	            <p>
	                <label>人员性别：</label>
	                <input type="radio" <c:if test="${bean.sex == 1}">checked="checked"</c:if> name="sex" value="1" required /> 男
	                <input type="radio" <c:if test="${bean.sex == 2}">checked="checked"</c:if> name="sex" value="2" required /> 女
	            </p>
	            <p>
	                <label>人员年龄：</label>
	                <select id="age" name="age" required >
	                	<option value=''>请选择</option>
	                </select>
	            </p>
	             <p>
	                <label>部门：</label>
	                <select id="deptId" name="deptId" required >
	                	<option value=''>请选择</option>
	                	<c:forEach items="${deptList }" var="dept">
	                		<option <c:if test="${bean.deptId == dept.id}">selected</c:if> value='${dept.id }'>${dept.name }</option>
	                	</c:forEach>
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
    
    <script type="text/javascript">
        function log(msg) {
            document.getElementById("log").innerHTML += (msg != undefined ? msg : "") + "<br />";
        }

        var Uploader = Q.Uploader,
            formatSize = Q.formatSize,
            boxView = document.getElementById("upload-image-view");
        var tmpContent = "";
        
        var uploader = new Q.Uploader({
        	
            url: "<%=request.getContextPath()%>/emp/uploadPhoto",
            
            target: document.getElementById("upload-target"),
            
            view: boxView,
            
			dataType: "json",
			
			upName: "upfile",
			
            allows: ".jpg,.png,.gif,.bmp",

            //图片缩放
            scale: {
                //要缩放的图片格式
                types: ".jpg",
                //最大图片大小(width|height)
                maxWidth: 1024
            },

            on: {
                //添加之前触发
                add: function (task) {
                	
                    if (task.disabled) return alert("允许上传的文件格式为：" + this.ops.allows);
                    //保证上传唯一图片   
                    tmpContent = $("#upload-image-view").html();
                    
                    $("#upload-image-view").html("");
                    
                },
                //图片预览后触发
                preview: function (data) {
                	
                	$("#photoSrc").val(data.src);
                	
                    //log(data.task.name + " : " + data.src);
                },
                complete: function(){
                    //this.list  为上传任务列表
                    //this.index 为当前上传任务索引
                    if(this.index >= this.list.length - 1) {
                        //所有任务上传完成
                    }
                },
                //图片压缩后触发,如果图片或浏览器不支持压缩,则不触发
                scale: function (data) {
                    log(data.task.name + " : 已压缩！");
                }
            },
            	//上传完成后，回调函数重置图片地址
	            UI:{
	                over: function(result){
	                	
	                	var map = eval("("+result.response+")");
	                	
	                	if(map.flag){
	                		
	                		$("#photoSrc").val(map.photoSrc);
	                		
	                		//回收垃圾图片
	                		$("#editForm").append("<input type='hidden' name='tmpPhoto' value='"+map.photoSrc+"' />");
	                	}
	                	
	                }
	            }
        });
    </script>
    
</body>
</html>