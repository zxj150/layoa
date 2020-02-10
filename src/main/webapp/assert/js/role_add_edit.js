layui.use(['form','layer','table'],function(){
		var form=layui.form;
		var $=layui.$;
		var layer=layui.layer;
		var table=layui.table;
		//监听提交动作
		form.on('submit(formDemo)',function(data){
			var rowId = data.field.rowId;
			layer.confirm(rowId);
			//默认为新增
			var type='post';
			if(rowId){
				type='put';
			}
			$.ajax({
				type:type,
				url:'role',
				data:$(data.form).serialize(),
				success:function(result){
					if(result){
						layer.closeAll(); //关闭所有层
						table.reload('table_role');
					}
				}
			});
			return false;
		});
		//自定义表单校验
		form.verify({
			checkrolename:function(value,item){
				var msg;
				var oldVal=$(item).data('old');
				if(oldVal!=null && oldVal==value){
					return msg;
				}else{
					$.ajax({
						type:'get',
						async:false,
						url:'role/checkname',
						data:{"roleName":value},
						success:function(result){
							if(result==1){
								msg='此名称已被使用，请重新输入！';
							}
						}
					});
					return msg;
				}
			}
		});

	});