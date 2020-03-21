<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- lay-filter="form_user" 相当于id="form_user" -->
	<form class="layui-form" lay-filter="form_user">
	<input class="layui-hide" name="rowId" />
		<div class="layui-form-item">
			<label class="layui-form-label">用户名称</label>
			<div class="layui-input-block">
				<!-- lay-verify="required"的检验 -->
				<input type="text" name="userName" required lay-verify="required|checkusername" placeholder="请输入用户名称 " autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用户性别</label>
			<div class="layui-input-block">
				<input type="radio" name="userAge" value="1" title="男"> 
				<input type="radio" name="userAge" value="0" title="女">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">用户账号</label>
			<div class="layui-input-block">
				<!-- lay-verify="required"的检验 -->
				<input type="text" name="userCode" required lay-verify="required|checkusername" placeholder="请输入用户账号 " autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用户密码</label>
			<div class="layui-input-block">
				<!-- lay-verify="required"的检验 -->
				<input type="password" name="userPass" required placeholder="请输入用户密码 " autocomplete="off" class="layui-input">
			</div>
		</div>
	<div class="layui-form-item">
			<label class="layui-form-label">身份证号</label>
			<div class="layui-input-block">
				<!-- lay-verify="required"的检验 -->
				<input type="text" name="userCard" required lay-verify="required|checkusername" placeholder="请输入身份证号 " autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
		<label class="layui-form-label">用户地址</label>
		<div class="layui-input-inline">
			<select lay-filter="provinceCode" id="provinceCode" name="provinceCode">
			<option>省</option>
				<c:if test="${!empty areaList}">
					<c:forEach items="${areaList}" var="area">
						<option value="${area.areaCode }">${area.areaName }</option>
					</c:forEach>
				</c:if>
			</select>
		</div>
		<div class="layui-input-inline">
			<select lay-filter="cityCode" id="cityCode" name="cityCode">
			</select>
		</div>
		<div class="layui-input-inline">
			<select lay-filter="areaCode" name="areaCode" id="areaCode">
			</select>
		</div>
	</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
