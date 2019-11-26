//跳转提交
function submitpage(){
	var queryPageNo=$("#pageNumber").val();
	$("#pageNo").val(queryPageNo);
	$("#pageSubmit").submit();
}
//查询提交
function submitselect(){
	$("#queryPageNo").val(1);
	$("#selectSubmit").submit();
}
//首页提交
function submitfrist(){
	$("#pageNo").val(1);
	$("#pageSubmit").submit();
}
//尾页提交
function submitlast(pageNo){
	$("#pageNo").val(pageNo);
	$("#pageSubmit").submit();
}
//上一页提交
function submitup(pageNo){
	$("#pageNo").val(pageNo-1);
	$("#pageSubmit").submit();
}
//下一页提交
function submitnext(pageNo){
	$("#pageNo").val(pageNo+1);
	$("#pageSubmit").submit();
}
//编辑
function editSubmit(itemTypeId){
	var queryPageNo=$("#queryPageNo").val();
	var href=contextPath+"/activityType/editUI?itemTypeId="+itemTypeId+"&queryPageNo="+queryPageNo;
	document.getElementById("editSubmit"+itemTypeId).href=href;
	document.getElementById("editClick"+itemTypeId).click();
}
/*
//删除
function deleteSubmit(itemTypeId){
	$('.deleteOne').Dialog('open');
	$("#deleteItemTypeId").val(itemTypeId);
}
$('.deleteOne').Dialog({
	title:'删除信息',
	autoOpen: false,
	width:400,
	height:200
});
$('.deleteOne input[type=button]').click(function(e) {
	$('.deleteOne').Dialog('close');
	if($(this).hasClass('ok')){
		var deleteItemTypeId=$("#deleteItemTypeId").val();
		var data = {"itemTypeId":deleteItemTypeId};
		$.ajax({
			"url":contextPath + "/activityType/findItemInTypeId",
			type:'post',
			dataType:'json',
			data:data,
			success:function(date){
				if(date.status != 1){
					$(".noticeMessage .dialog-content").text(date.message);
					$('.noticeMessage').Dialog('open');
					return ;
				}else{
					var queryPageNo=$("#queryPageNo").val();
					var href=contextPath+"/foodType/delete?itemTypeId="+deleteItemTypeId+"&queryPageNo="+queryPageNo;
					document.getElementById("deleteSubmit"+deleteItemTypeId).href=href;
					document.getElementById("deleteClick"+deleteItemTypeId).click();
				}
			}
		 });
	}
});*/
