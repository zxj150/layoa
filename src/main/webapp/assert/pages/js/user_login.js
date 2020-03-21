var form;
var $;
layui.use(['form'], function () {
        var form = layui.form,
         $ = layui.$,
         layer = layui.layer;

        // 登录过期的时候，跳出ifram框架
        if (top.location != self.location) top.location = self.location;

        // 粒子线条背景
        $(document).ready(function(){
            $('.layui-container').particleground({
                dotColor:'#5cbdaa',
                lineColor:'#5cbdaa'
            });
        });
        // 进行登录操作
        form.on('submit(login)', function (data) {
            data = data.field;
            if (data.username == '') {
                layer.msg('用户名不能为空');
                return false;
            }
            if (data.password == '') {
                layer.msg('密码不能为空');
                return false;
            }
            $.ajax({
       		 type:'get',
       		 url:'user/dologin',
       		 data:$('#form_login').serialize(),
       		 success:function(result){
       			var code=result.code;
       			if(code==0){
       				layer.msg(result.msg);
       			}else if(code==1){
       				layer.msg('登录成功');
       			 window.location = 'user/dataIndex';
       			}
       		 }
       	 });
           
            return false;
        });
      //绑定 省 change
    	form.on('select(provinceCode)', function(data){
    		var parentCode =data.value;
    		console.log(data.value);
    		initAreaData(parentCode,'cityCode');
    		
    		});
        
    	//绑定 市 change
    	form.on('select(cityCode)', function(data){
    		var parentCode =data.value;
    		console.log(data.value);
    		initAreaData(parentCode,'areaCode');
    		
    		});

    //查询二级的Area数据
    function initAreaData(parentCode,id,selectAreaCode){

    return $.ajax({
    		type:'get',
    		url:'user/findByCode/'+parentCode,
    		success:function(areaList){
    			var options ='<option value=>市信息</option>';
    			if(id=='areaCode'){
    				options ='<option value=>区信息</option>';
    			}
    			var $select = $('#'+id);
    			$select.html(options);
    			if(areaList){
    				$.each(areaList,function(index,area){
    					var areaCode = area.areaCode;
    					var areaName = area.areaName;
    					var option ='<option value="'+areaCode+'">'+areaName+'</option>';
    					options +=option;
    				});
    			}
    			$select.html(options);
    			//console.log(options);
    			form.render('select');
    		}
    	});
    }
});
 