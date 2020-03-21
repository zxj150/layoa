<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form class="layui-form" lay-filter="form_add_edit">
	<!-- layui的隐藏域  -->
	<input class="layui-hide" name="rowId" />
	<!-- <div class="layui-form-item">
		<label class="layui-form-label">用户名称</label>
		<div class="layui-input-block">
			lay-verify 这个layui的自定义属性 ，设置表单的校验，多个校验 用 ‘|’ 隔开 
			<input name="userName" lay-verify="required|checkusercode" placeholder="请输入用户名称"
				autocomplete="off" class="layui-input">
		</div>
	</div> -->
	<div class="layui-form-item">
		<label class="layui-form-label">用户体温/℃</label>
		<div class="layui-input-block">
			<!-- lay-verify 这个layui的自定义属性 ，设置表单的校验，多个校验 用 ‘|’ 隔开  -->
			<input name="data1" lay-verify="required|checkusercode"
				id="data1" placeholder="请输入体温" autocomplete="off"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit lay-filter="formDemo">提交</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</div>
</form>
