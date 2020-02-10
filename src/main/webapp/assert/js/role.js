layui.use([ 'layer', 'form', 'laydate', 'table' ], function() {
	// 通过一个变量将加载的模块取出
	var layer = layui.layer;
	var form = layui.form;
	var laydate = layui.laydate;
	// layui内置jquery
	var $ = layui.$;
	var table = layui.table;

	table.render({
		elem : '#table_role',
		url : 'role/find',
		height : 500 // 全局定义常规单元格的最小宽度，layui 2.2.1 新增
		,
		where : $('#form_search').serialize(),
		page : true,
		cols : [ [

		{
			field : 'rowId',
			width : 80,
			title : 'ID',
			sort : true,
			fixed : 'left'
		}, {
			field : 'roleCode',
			width : 120,
			title : '角色编号'
		}, {
			field : 'roleKind',
			width : 120,
			title : '角色类型',
			templet : '#userKindTpl'
		}, {
			field : 'roleName',
			width : 120,
			title : '角色名称'
		}, {
			field : 'roleInfo',
			title : '角色简介',
			width : '30%',
			minWidth : 100
		}, {
			field : '',
			title : '操作',
			width : 200,
			align : 'center',
			minWidth : 100,
			templet : '#roleUp'

		}, ] ]
	});
	// 对table里面的按钮进行绑定
	table.on('tool(table_role)', function(obj) {
		var data = obj.data;
		var layEvent = obj.event;
		var rowId = data.rowId;
		switch (layEvent) {
		case 'edit':
			openLayerRole(rowId);
			break;
		case 'del':
			// 让用户再次确认
			layer.confirm('你确定要删除吗？', function() {
				// 点击弹出的确认会触发回调函数
				$.ajax({
					type : 'delete',
					url : 'role/' + rowId,
					success : function(result) {
						if (result) {
							// 请求重新加载数据
							table.reload('table_role');
							// 将弹出层再次关闭
							layer.closeAll();// 关闭所有层
						}
					}
				});
			});
			break;
		default:
			break;
		}
	});
	// 绑定新增按钮
	$('.layui-btn-add').off('click').on('click', function() {
		// 打开新增页面表单
		openLayerRole();
	});
	function openLayerRole(rowId) {
		// 设置弹出层标题
		var titleVal = rowId == null ? '用户新增' : '用户修改';
		$.ajax({
			url : 'role/goadd',
			success : function(htmlData) {
				layer.open({
					type : 1,
					title : titleVal,
					area : '800px',
					content : htmlData,
					success : function() {
						if (rowId) {
							// 用ajax的方式根据id查询要修改的数据
							$.ajax({
								type : 'get',
								url : 'role/' + rowId,
								success : function(role) {
									form.val("form_role_add_edit", role);
									// 为了唯一性校验，修改的时候设置一个原来的数据
									$('#roleName').data('old', role.roleName);
									// 让form表单渲染一下
									form.render(null, 'form_role_add_edit');
								}
							});
						} else {
							// 进新增动作
							form.render(null, 'form_role_add_edit');
						}
					}
				});
			}
		});
	}
	//绑定搜索按钮
	form.on('submit(btn_search)',function(data){
		//重新渲染table的数据
		table.reload('table_role',{
			page:{
				curr:1//重新从第一页开始
			},
			where:$('#form_search').serialize()//重新配置查询额外的数据
			
		},'data');
		return false;
	});
});