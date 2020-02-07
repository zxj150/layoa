<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户新增</title>
<!-- 引入layui的样式表 -->
<link rel="stylesheet" href="assert/layui/css/layui.css">
</head>
<body>
	<!-- lay-filter="form_user" 相当于id="form_user" -->
	<form class="layui-form" lay-filter="form_user">
	<div class="layui-form-item">
			<label class="layui-form-label">角色编号</label>
			<div class="layui-input-block">
				<!-- lay-verify="required"的检验 -->
				<input type="text" name="roleCode" required lay-verify="required" placeholder="请输入角色编号 " autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">角色名称</label>
			<div class="layui-input-block">
				<!-- lay-verify="required"的检验 -->
				<input type="text" name="roleName" required lay-verify="required|checkRoleName" placeholder="请输入角色名称 " autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">角色类型</label>
			<div class="layui-input-block">
				<input type="radio" name="roleKind" value="1" title="超级角色"> <input type="radio" name="roleKind" value="0" title="普通角色" checked>
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">角色简介</label>
			<div class="layui-input-block">
				<textarea name="roleInfo" required lay-verify="required" placeholder="角色简介" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>

</body>

<!-- Layui是按模块开发  
layui.all.js 加载全部模板
layui.js 按需加载模板 -->

<script type="text/javascript" src="assert/layui/layui.js"></script>
<!-- 书写自己的脚本 -->
<script type="text/javascript">
	//Demo
	layui.use([ 'layer', 'form', 'laydate' ], function() {
		//通过一个变量将加载的模块取出
		var layer = layui.layer;
		var form = layui.form;
		var laydate = layui.laydate;
		//layui内置jquery
		var $ = layui.$;

		//表单的自定义校验
		 form.verify({
	  checkRoleName:function(value,item){
		  var msg;
		  $.ajax({
			  type:'get',
			  async:false,
			  url:'role/checkname',
			  data:{"roleName":value},
			  success:function(result){
				  if(result){
					  msg="此角色名已被占用"
				  }
			  }
		  });
		  return msg;
	  }
	  }); 
		//绑定提交按钮
		 form.on('submit(formDemo)', function(data) {
				var data = form.val('form_user');
				console.log(data);
				$.ajax({
					type : 'post',
					url : 'role',
					data : data,
					success : function(result) {
						if (result) {
							layer.msg("提交成功了");
						}
					}
				});
				return false;
			});
	});
</script>
</html>