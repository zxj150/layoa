<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="layui-fluid">
	<div class="layui-row layui-col-space15">
		<div class="layui-col-md12">
			<div class="layui-card">
				<div class="layui-card-header">
					用户管理
						<!-- 新增按钮 开始 -->
						<button type="button" class="layui-btn layui-btn-sm layui-btn-add">
							<i class="layui-icon layui-icon-addition"></i>新增
						</button>
					<!-- 新增按钮 结束 -->
				</div>
				<div class="layui-card-body">
					<!-- 搜索表单 开始  -->
					<form class="layui-form" id="form_search" lay-filter="form_search">
						<div class="layui-search-form">
							<div class="layui-inline">
								<input name="userName" placeholder="用户名称" autocomplete="off"
									class="layui-input">
							</div>
							<div class="layui-inline">
								<!-- 搜索按钮 -开始 -->
								<button lay-submit lay-filter="btn_search" title="搜索"
									class="layui-btn layui-btn-primary layui-btn-sm layui-tips">
									<i class="layui-icon layui-icon-search"></i>搜索
								</button>
								<!-- 搜索按钮 -结束 -->
								<!-- 重置按钮 - 开始 -->
								<!--想自动弹出tip信息 两个条件  class="layui-tips" title="信息" -->
								<button type="reset" title="重置"
									class="layui-btn layui-btn-primary layui-btn-sm layui-tips">
									<i class="layui-icon layui-icon-refresh"></i>重置
								</button>
								<!-- 重置按钮 - 结束 -->
							</div>
						</div>
					</form>
					<!-- 搜索表单 结束  -->
					<!-- 页面表格 开始  -->
					<table id="list_table" lay-filter="filter_table"></table>
					<!-- 页面表格 结束  -->
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 页面上的隐藏域，提供信息给通用的JS脚本使用 -->
<input type="hidden" id="hideURL" value="data" />
<input type="hidden" id="hideTitle" value="体温数据" />
<!-- 修改，删除 按钮 -->
<!-- 此处注意：必须有lay-event 才能通过table.on完成事件的绑定 -->
<script type="text/html" id="userBtnTpl">
	<button type="button" class="layui-btn layui-btn-xs layui-btn-danger" lay-event="delete">删除</button>
</script>
<!-- 引入自定义的JS脚本 -->
<script src="assert/pages/js/sys/user.js"></script>
