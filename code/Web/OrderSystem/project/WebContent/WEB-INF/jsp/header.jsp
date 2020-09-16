<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <div class="main_header">
   		当前用户: <c:out value="${requestScope.userName }"></c:out>
   		<a href="/OrderWeb/Logout"> 登出</a>
   </div>