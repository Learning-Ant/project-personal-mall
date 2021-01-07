<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../template/header.jsp">
	<jsp:param value="로그인" name="title"/>
</jsp:include>

<script>
	$(function(){
		fn_login();
	});
	
	function fn_login() {
		$('#loginBtn').click(function(){
			if($('#m_customer_id').val() == null || $('#m_customer_id').val() == '' ){
				$('#error-message').text('아이디를 입력해주세요');
				$('#m_customer_id').focus();
				return;
			}
			if($('#m_customer_pw').val()==null ||$('#m_customer_pw').val()=='') {
				$('#error-message').text('비밀번호를 입력해주세요');
				$('#m_customer_pw').focus();
				return;
			}
			$.ajax({
				url: '/PersonalMall/LoginPwCheck',
				type: 'post',
				data: $('#login-form').serialize(),
				dataType: 'json',
				success: function(responseObj){
					if(!responseObj.result){
						$('#error-message').text('없는 회원이거나 정보가 일치하지 않습니다.');
						$('#m_customer_id').focus();
					} else {
						alert('${loginDto.m_customer_name}님 반갑습니다!');
						location.href='/PersonalMall/index.jsp';
					}
				},
				error: function(){
				    // alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error)
					alert('실패');
				}
				
			});
		});
		
	}
	
</script>

<div class="login-wrap">
	<form id="login-form" method="post">
		<input type="text" id="m_customer_id" name="m_customer_id" placeholder="아이디 입력" /><br/>
		<input type="password" id="m_customer_pw" name="m_customer_pw" placeholder="비밀번호 입력" /><br/>
		<span id="error-message" ></span><br/>
		<input type="button" value="로그인" id="loginBtn"/>
		<input type="button" value="회원가입" onclick="location.href=''" />
		<a href="location.href=''" >아이디 찾기</a>
		<a href="location.href=''" >비밀번호 찾기</a>
	</form>
</div>

<%@ include file="../template/footer.jsp" %>