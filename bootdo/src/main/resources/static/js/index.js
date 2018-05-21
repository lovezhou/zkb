//
var prof = {  
  z_show:true,
  b_show:true,
  showOrhide :function (key){
	   if(key==1){
			if(this.z_show){
				$("div[id^='1_']").hide();
				this.z_show=false;
			}else{
				$("div[id^='1_']").show();
				this.z_show=true;
			}
		}else{
			if(this.b_show){
				$("div[id^='2_']").hide();
				this.b_show=false;
			}else{
				$("div[id^='2_']").show();
				this.b_show=true;
			}
		}
	}
}
// 
var practice = {  
		  bArr  :new Array(),
		  submit:function(){
			var arr = new Array();
			var $answer = $("h3[id^='answer_']");
			$.each($answer, function(i, n){
				var ans = n.innerText;
				if(ans.trim()!=''){
					arr.push(n.innerText);
				}
		    });
			var data=$('#practiceForm').serialize();
			var result =new Array(arr.length);
			if(data.trim()!==''){
				var res = data.split("&");
				for(j = 0,len=res.length; j < len; j++) {
					var tmp= res[j].split("=");
					var index = Number(tmp[0].replace("num_",""))-1;
					result[index]=tmp[1];
				}
			}
			var html="";
			this.bArr=new Array();
			for(j = 0,len=arr.length; j < len; j++) {
				var bresult={};//num,res,anw,flag
				if(arr[j]==result[j]){
					bresult.flag=true;
				}else{
					bresult.flag=false;
				}
				bresult.anw=arr[j];
				bresult.res=result[j]==undefined?'-A':result[j];
				bresult.num=j+1;
				this.bArr.push(bresult);
				var clazz=bresult.flag?"circle-green":"circle-red";
				html=html+"<div class='col-xs-2 col-sm-2 col-md-1'><div class='"+clazz+"'>"+bresult.num+"</div></div>";
			}
			$("#div_res_comp").html("");
			$("#div_res_comp").append(html);
			$("#div_res_comp").show();
			$("#div_res_button").show();
		  },
		  viewResult:function(flag){
         	  //查看错误解析
			  var datas= new Array();
        	  if(flag==1){
        		  for(j = 0,len=this.bArr.length; j < len; j++) {
        			  if(!this.bArr[j].flag){
        				  datas.push(this.bArr[j]);
        			  }
				}
        	  }else{
        		 datas=this.bArr;
        	  }
        	  var obj={};
        	  obj.id=$("#txt_exeId").val();
        	  obj.arr=datas;
        	  obj.flagAll=flag==0;
        	  $.ajax({
        			type : "POST",
        			url  : "compare",
                    contentType: "application/json; charset=utf-8",    
        			data : JSON.stringify(obj) ,
        			async: false,
        			error: function(request) {
        				parent.layer.alert("Connection error");
        			},
        			success : function(data) {
        				console.log(data);
        				if (data.code == 0) {
        				    window.location.href="/web/practView/"+data.msg;
        				} else {
        					parent.layer.alert(data.msg);
        				}
        			}
        		});
          },
}