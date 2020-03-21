layui.use(['form','table'],function(){
	var $ = layui.$;
	var form = layui.form;
	var table = layui.table;
	// 自定义校验
	form.verify({
		checkusername:function(value,item){
			// 调用通用的唯一性校验的方法 #调用这个方法 一定要前面带 return
			return checkUnique(value,item,'user/checkname');
		}
	});
	//绑定搜索按钮
	form.on('submit(btn_search)', function(data) {
		//请求table重新加载数据 list_table = <table id="list_table"/>
	    table.reload('list_table', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        }
	        ,where: $('#form_search').serialize() //重新配置查询额外的数据
	      }, 'data');
		return false;
	});
	// 通过render方法开始渲染 talbe的数据
	table.render({
		elem : '#list_table', // 要绑定的页面元素
		url : 'data', // 数据接口 layui会自动封装成 user/{page}/{limit}
		//where : $('#form_search').serialize(),// 模拟额外的参数#目前引入搜索表单的数据
		page : true,// 开启分页
		cols: [[ // 表头
		      {field: 'userName', title: '用户名称', width:250}
		      ,{field: 'data1', title: '体温/℃'}
		      ,{field: 'createDate', title: '记录时间'}
		      ,{title: '操作', width: 300,templet:'#userBtnTpl'}
		    ]]
	});
	/**
	 * 通用的检测唯一的方法
	 * @value 要校验的值
	 * @item 要校验的DOM对象
	 * @url 发送校验的URL
	 * @where 额外的参数
	 */
	function checkUnique(value, item,url,where){
		var msg ;
		//要处理的input对象
		var $item = $(item);
		//判断是否需要进行唯一性的校验
		//$.data  解析的是 <input data-old ="管理员"/>
		var oldVal = $item.data('old');
		//根据input对象取出name的值
		var key=$item.attr('name');
		//如果原来的值有数据,并且原值和当前的值一样，则不需再进行唯一性校验。
		if(oldVal!=null && oldVal == value){
			//return msg;
		}else{//否则我们需要进行唯一性的校验。
			//组装JSON格式的提交的数据
			 var params = {};
			 params[key] = value;
			//参数
			 var data = $.extend(params, where);
			$.ajax({
				type:'get',
				async:false,//为了让layui可以做唯一性的校验，需要将ajax的异步提交关闭。
				url:url,
				data:data,
				success:function(result){
					//判定此名称不可以使用，已经有人用了
					if(result==1){
						//不要在ajax的success中return
						//return '此名称以有人使用';
						msg ='账号已被使用，请重新填写!!';
						var formerror = $item.data('formerror');
						if(formerror){
							msg = formerror;
						}
					}
				}
			});
		}
		//在ajax的外面return 此次检测的结果。
		//如果return的数据有值的话，则 layui就认为是校验不通过。
		//如果return的结果是个空，则layui认为校验通过。
		return msg;
	}
});
