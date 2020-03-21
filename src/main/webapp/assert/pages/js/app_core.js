var $; //将jQuery的$拿到外面定义,全局可用。
var layer;
//尝试书写公用的JS脚本
layui.use([ 'layer', 'table', 'form' ], function() {
	$ = layui.$;
	layer = layui.layer;
	var table = layui.table;
	var form = layui.form;
	//为了统一的处理页面上的CRUD，现对页面中出现的各种元素的id,或filter,或class 规定如下。
	// 页面中使用的URL 用隐藏域 id="hideURL" 提供。
	// 页面中的数据标题 用隐藏域 id="hideTitle"提供
	// 新增表单按钮  class ="layui-btn-add"
	// 弹出的表单的filter lay-filter="form_add_edit"
	// 表格的id和filter  <table id="list_table" lay-filter="filter_table"/>
	// 搜索的form <form id="form_search" lay-filter="form_search">
	// 修改按钮的 lay-event="edit"
	// 删除按钮的 lay-event="delete"
	//绑定新增按钮
	$(document).off('click', '.layui-btn-add').on('click', '.layui-btn-add',function() {
		var url = $('#hideURL').val()+'/form';
		var title = $('#hideTitle').val()+'新增';
		//调用通用的弹出form层。 如果此方法中的ajax执行成功 会回调  done方法
		openBaseLayer(url,title).done(function(){
			// 让form表单渲染一下。 form_add_edit = <form lay-filter="form_add_edit">
			form.render(null, 'form_user');
		});
	});
	
	// 监听提交动作  submit(but_submit) = <button class="layui-btn" lay-submit lay-filter="but_submit">
	form.on('submit(formDemo)', function(data) {
		//data.field //当前容器的全部表单字段，名值对形式：{name: value}
		var rowId = data.field.rowId;
		//默认为新增
		var type = 'post';
		if(rowId){ // 如果rowId有值,则执行修改
			type='put';
		}
		$.ajax({
			type:type,
			url:$('#hideURL').val(),
			data:$(data.form).serialize(),
			success:function(result){
				if(result){
					// 关闭弹出层
					//layer.close(layer.index);
					layer.closeAll(); //疯狂模式，关闭所有层
					//请求table重新加载数据 list_table = <table id="list_table"/>
					table.reload('list_table');
				}
			}
		});
		
		//不用忘记 return false ,讲按钮原来的功能给屏蔽掉。
		return false;
	});
	
   //注：tool 是工具条事件名，filter_table =<table lay-filter="filter_table">
	table.on('tool(filter_table)',function(obj){
		 var data = obj.data; //获得当前行数据
		 var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		 //var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
		 //通过data将要修改的数据的主键 取出
		 var rowId = data.rowId;
		switch (layEvent) {
		case 'delete':
			//让用户再进行一次确认
			layer.confirm('你确定要删除码？',function(index){
				//index = 弹出层的index，用于关闭的时候使用
				//点击弹出的确认会触发回调函数
				$.ajax({
					type:'delete',
					url:$('#hideURL').val()+'/'+rowId,
					success:function(result){
						if(result){
							//请求table重新加载数据 list_table = <table id="list_table"/>
							table.reload('list_table');
							//尝试将弹出层再关闭一下。
							//layer.closeAll(); //疯狂模式，关闭所有层
							layer.close(index);
						}
					}
				});
			});
			break;
		default:
			break;
		}
	});
});
/**
 * 打开一个通用的layer弹出框 
 * @param url
 * @param title
 * @returns 
 */
function openBaseLayer(url,title){
	// return 整个 ajax
	return $.ajax({
		url : url,
		success : function(htmlData) {
			//通过layer的open方法打开弹出层
			layer.open({
				type : 1, //0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）。 
				title : title,
				area : '800px', //设置宽度，高度自适应
				content : htmlData,// 这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
			});
		}
	});
}
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
			url:'user/checkname',
			data:data,
			success:function(result){
				//判定此名称不可以使用，已经有人用了
				if(result==1){
					msg ='违反唯一值,请重新填写!!';
				}
			}
		});
	}
	//在ajax的外面return 此次检测的结果。
	//如果return的数据有值的话，则 layui就认为是校验不通过。
	//如果return的结果是个空，则layui认为校验通过。
	return msg;
}

