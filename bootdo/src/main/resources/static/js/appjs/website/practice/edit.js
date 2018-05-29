$().ready(function() {
	$.renderBox();
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/website/practice/update",
		data : $('#signupForm').serialize(),
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			num : {
				required : true
			},
			type : {
				required : true
			},
			question : {
				required : true
			},
			exeId : {
				required : true
			}
		},
		messages : {
			num : {
				required : icon + "请输入题目编号"
			},
			type : {
				required : icon + "请输入题目类型"
			},
			question : {
				required : icon + "请输入题目"
			},
			exeId : {
				required : icon + "请输入试卷名称"
			}
		}
	})
}