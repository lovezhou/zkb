var $parentNode = window.parent.document;

function $childNode(name) {
    return window.frames[name]
}

// tooltips
$('.tooltip-demo').tooltip({
    selector: "[data-toggle=tooltip]",
    container: "body"
});

// 使用animation.css修改Bootstrap Modal
$('.modal').appendTo("body");

$("[data-toggle=popover]").popover();

//折叠ibox
$('.collapse-link').click(function () {
    var ibox = $(this).closest('div.ibox');
    var button = $(this).find('i');
    var content = ibox.find('div.ibox-content');
    content.slideToggle(200);
    button.toggleClass('fa-chevron-up').toggleClass('fa-chevron-down');
    ibox.toggleClass('').toggleClass('border-bottom');
    setTimeout(function () {
        ibox.resize();
        ibox.find('[id^=map-]').resize();
    }, 50);
});

//关闭ibox
$('.close-link').click(function () {
    var content = $(this).closest('div.ibox');
    content.remove();
});

//判断当前页面是否在iframe中
//if (top == this) {
//    var gohome = '<div class="gohome"><a class="animated bounceInUp" href="index.html?v=4.0" title="返回首页"><i class="fa fa-home"></i></a></div>';
//    $('body').append(gohome);
//}

//animation.css
function animationHover(element, animation) {
    element = $(element);
    element.hover(
        function () {
            element.addClass('animated ' + animation);
        },
        function () {
            //动画完成之前移除class
            window.setTimeout(function () {
                element.removeClass('animated ' + animation);
            }, 2000);
        });
}

//拖动面板
function WinMove() {
    var element = "[class*=col]";
    var handle = ".ibox-title";
    var connect = "[class*=col]";
    $(element).sortable({
            handle: handle,
            connectWith: connect,
            tolerance: 'pointer',
            forcePlaceholderSize: true,
            opacity: 0.8,
        })
        .disableSelection();
};


//编辑器新增的ajax上传图片函数
function sendFile(files, editor, $editable) {
    var size = files[0].size;
    if((size / 1024 / 1024) > 2) {
        alert("图片大小不能超过2M...");
        return false;
    }
    console.log("size="+size);
    var formData = new FormData();
    formData.append("file", files[0]);
    $.ajax({
        data : formData,
        type : "POST",
        url : "/common/sysFile/upload",    // 图片上传出来的url，返回的是图片上传后的路径，http格式
        cache : false,
        contentType : false,
        processData : false,
        dataType : "json",
        success: function(data) {//data是返回的hash,key之类的值，key是定义的文件名
            $('.summernote').summernote('insertImage',data.fileName);
        },
        error:function(){
            alert("上传失败");
        }
    });
}

//bootstrap 下拉框异步加载zmy 2018/5/2
var selectBox = {
		/**
		 * 异步加载<select>标签下<option>
		 * id/dom ：<select> 标签id属性，或者dom标签 必须
		 * exturl：远程获取数据url连接  必须
		 * defaultVal： 默认选中值 取value
		 * isEmpty：是否有空标签<option></option>
		 * 
		 * 例如：<select class="form-control" id="profType" url="/common/sysDict/list/zk_type" name="profType" th:value="${prof.profType}"></select>
		 */
		selectBox :function(id,isEmpty){
			var dom ="";
			if(typeof id ==='string'){
			    dom=  $("#"+id);
			}else{
				dom =$(id);//包装为Jquery对象
			}
			var url=dom.attr("exturl");//扩展属性
			var defaultVal=dom.attr("value");
			$.ajax({
				   type: 'GET',
				   url: url,
				   dataType: "json",
				   success: function(result){
					   var html="";
					   if(isEmpty){
						   html="<option></option>";
					   }
					   $.each(result, function(i, obj){
						   if(defaultVal!==undefined&& defaultVal!=''){
							   var selected = defaultVal==obj.value?"selected":"";
							   html+="<option value=\""+obj.value+"\" "+selected +" >"+obj.name+"</option>";
						   }else{
							   html+="<option value='"+obj.value+"'>"+obj.name+"</option>";
						   }
					   });
					   if(html.length>0){
						   dom.append(html);
					   }
				   },
				   error: function(result){
					   //xxx;
				   }
		    });
		},
	   /**
	    * 渲染当前页面所有的<select></select> 并赋值
	    */
	   renderBox:function(){
		   var doms=$("select[id]");
		   if(doms.length>0){
			   for(var i=0;i<doms.length;i++){
				   this.selectBox(doms.get(i),true);
			   }
		   }
	   }
}
//
jQuery.extend(selectBox);