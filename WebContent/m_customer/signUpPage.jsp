<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../template/header.jsp">
	<jsp:param value="이메일인증" name="title"/>
</jsp:include>

<style>
	h2{
		text-align: center;
		margin-top: 150px;
	}
	.email-auth-box{
		width: 600px;
		height: 400px;
		margin: 30px auto;
	}
	#email-form {
		border-top: 3px solid black;
		border-bottom: 3px solid black;
		padding: 20px 0;
		height: 150px;
	}
	label {
		display: inline-block;
		width: 200px;
		height: 40px;
		line-height: 40px;
		text-align: center;
	}
	#auth-btn{
		display: block;
		margin: 10px auto;
		width: 150px;
		background: black;
		color: white;
		height: 50px;
		border-radius: 5px;
	}
	input[name^="m_customer_email"]{
		height:40px;
		padding-left: 10px;
	}
</style>
<script>
	$(function(){
		fn_emailAuthentication();
	})
	
	function fn_emailAuthentication(){
		$('#auth-btn').click(function(){
			// Todo 이메일 인증 모듈 만들기
			
		});
	}
</script>


<h2>이메일 인증</h2>
<div class="email-auth-box">
	<form id="email-form" method="post">
		<label for="email">본인 이메일 입력</label>
		<input type="text" id="email" name="m_customer_email1" placeholder="example12"/>
		<input list="email-list" type="text" name="m_customer_email2" placeholder="@shoppingmall.com" />
		<datalist id="email-list">
			<option value="@naver.com" />
			<option value="@daum.net" />
			<option value="@google.com" />
		</datalist>
		<%-- hidden --%>
		<input type="hidden" id="m_customer_email" />
		<input type="button" id="auth-btn" value="이메일 인증하기"/>
	</form>
</div>

<%@ include file="../template/footer.jsp" %>