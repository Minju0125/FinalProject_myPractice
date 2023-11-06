/**
 * 
 */

$(function(){
	const cPath = $(this.body).data("contextPath");
	
	$(msgSendBtn).on("click", function(){
		console.log(cPath);
		console.log(baseUrl);
		
		$.ajax({
			type: 'post',   //get방식으로 명시
			url : `${cPath}/api/nurigo/send-one`,  //이동할 jsp 파일 주소
			success: function(){   //데이터 주고받기 성공했을 경우 실행할 결과
	            //function(data)를 쓰게 되면 전달받은 데이터가 data안에 담아서 들어오게 된다. 
				alert("임시비밀번호를 발송하였습니다.");   
			},
			error:function(){   //데이터 주고받기가 실패했을 경우 실행할 결과
				alert('임시비밀번호 발송 실패');
			}
		})//아작스
	})//전송버튼 클릭 이벤트 끝
	
	$("#goWeahter").on("click", function(){
		location.href=`${cPath}/weatherApi/weather`;
	})
})
