//init
function initPagers(totalPage,totalSize,currentPage,prefixRequest){
	var totalPage = totalPage;
	var totalRecords = totalSize;
	var pageNo = currentPage;
	if(!pageNo){
		pageNo = 1;
	}
	//生成分页
	kkpager.generPageHtml({
		pno : pageNo,
		//总页码
		total : totalPage,
		//总数据条数
		totalRecords : totalRecords,
		mode : 'click',//默认值是link，可选link或者click
		//链接前部
		//hrefFormer : 'pager_test',
		//链接尾部
		//hrefLatter : '.html',
//		getLink : function(n){
//			// this.hrefFormer +this.hrefLatter +
//			return  "?skip="+n;
//		},
		click : function(n){
			// do something
			//手动选中按钮
			MakeForm(n,prefixRequest);//在无列表查询条件下需创建表单传分页参数
			
			return false;
		}
	});
}

//构建一个 form 
function MakeForm(n,prefixRequest) 
{ 
  var exitForm = document.getElementById("listForm");
  if(exitForm){
	  var input = document.createElement("input"); 
	  // 设置相应参数 
	  input.type = "hidden"; 
	  input.name = "skip"; 
	  input.value = n; 
	  // 将该输入框插入到 form 中 
	  exitForm.appendChild(input); 
	  // form 的提交方式 
	  exitForm.method = "POST"; 
	  // form 提交路径 
	  exitForm.action = prefixRequest; 
	  // 对该 form 执行提交 
	  exitForm.submit(); 
  }else{
	// 创建一个 form 
	  var form1 = document.createElement("form"); 
	  form1.id = "pagerForm"; 
	  form1.name = "pagerForm"; 
	  // 添加到 body 中 
	  document.body.appendChild(form1); 
	  // 创建一个输入 
	  var input = document.createElement("input"); 
	  // 设置相应参数 
	  input.type = "hidden"; 
	  input.name = "skip"; 
	  input.value = n; 
	  // 将该输入框插入到 form 中 
	  form1.appendChild(input); 
	  // form 的提交方式 
	  form1.method = "POST"; 
	  // form 提交路径 
	  form1.action = prefixRequest; 
	  // 对该 form 执行提交 
	  form1.submit(); 
	  // 删除该 form 
	  document.body.removeChild(form1);  
  }
} 