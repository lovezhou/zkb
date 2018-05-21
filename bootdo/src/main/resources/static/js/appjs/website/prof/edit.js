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
		url : "/website/prof/update",
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
			profId : {
				required : true
			},
			profName : {
				required : true
			},
			profType : {
				required : true
			},
		},
		messages : {
			profId : {
				required : icon + "请输入专业代码"
			},
			profName : {
				required : icon + "请输入专业名称"
			},
			profType : {
				required : icon + "请输入自考类型"
			},
		}
	})
}