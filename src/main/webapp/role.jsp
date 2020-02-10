<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>角色新增</title>
<!-- 引入layui的样式表 -->
<link rel="stylesheet" href="assert/layui/css/layui.css">
</head>
<body style="background-color: #F2F2F2;">
	<div class="layui-fluid">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md12">
				<div class="layui-card">
					<div class="layui-card-header">
						<button type="button" class="layui-btn layui-btn-sm layui-btn-add">
						<i class="layui-icon layui-icon-addition"></i>新增
						</button>
					</div>
					<div class="layui-card-body">
						<!-- lay-filter="form_user" 相当于id="form_user" -->
						<form class="layui-form" id="form_search">
							<div class="layui-search-form">
								<div calss="layui-inline">
									<select name="roleKind">
										<option value>角色类型</option>
										<option value="1">超级角色</option>
										<option value="">普通角色</option>
									</select>
								</div>
								<div class="layui-form-item">
										<input name="roleName" required placeholder="请输入角色名称 " autocomplete="off" class="layui-input">
								</div>
								<div class="layui-inline">
									<!-- 搜索按钮开始 -->
									<button calss="layui-btn layui-btn-primary layui-btn-sm" lay-submit lay-filter="btn_search">
										<i class="layui-icon layui-icon-search"></i>
									</button>
									<!-- 重置按钮 -->
									<button type="reset" calss="layui-btn layui-btn-primary layui-btn-sm">
										<i class="layui-icon layui-icon-refresh"></i>
									</button>
								</div>
							</div>
						</form>
						<table id="table_role" lay-filter="table_role"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="assert/layui/layui.js"></script>
<!-- 书写自己的脚本 -->
<script type="textml" id="userKindTpl">
	{{#  if(d.roleKind == 1){ }}
    <span class="layui-badge layui-bg-red">超级角色</span>
  	{{#  } else { }}
    <span class="layui-badge layui-bg-green">普通角色</span>
  	{{#  } }}
</script>
<!--  -->
<script type="textml" id="roleUp">
    <button type="button" class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit">修改</button>
{{#  if(d.roleKind == 0){ }}
	<button type="button" class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</button>
{{#  } else { }}
<button type="button" class="layui-btn layui-btn-xs layui-btn-disabled">删除</button>
{{#  } }}
</script>
<script type="text/javascript" src="assert/js/role.js">
	
</script>
</html>