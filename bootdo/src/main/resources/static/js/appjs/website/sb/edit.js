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
		url : "/website/sb/update",
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
			sbCode : {
				required : true
			},
			sbName : {
				required : true
			},
			sbType : {
				required : true
			},
			profId : {
				required : true
			},
		},
		messages : {
			sbCode : {
				required : icon + "请输入科目代码"
			},
			sbName : {
				required : icon + "请输入科目名称"
			},
			sbType : {
				required : icon + "请输入类型"
			},
			profId : {
				required : icon + "请输入专业代码"
			},
		}
	})
}