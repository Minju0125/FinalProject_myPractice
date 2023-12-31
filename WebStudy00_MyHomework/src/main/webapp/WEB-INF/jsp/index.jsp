<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<h4>웰컴페이지</h4>
<br>

 <div id='calendar-container'>
    <div id='calendar'></div>
  </div>
  <script>
    $(function(){ 
      // calendar element 취득
      var calendarEl = $('#calendar')[0];
      // full-calendar 생성하기
      var calendar = new FullCalendar.Calendar(calendarEl, {
        height: '500px', // calendar 높이 설정
       // expandRows: true, // 화면에 맞게 높이 재설정
        slotMinTime: '08:00', // Day 캘린더에서 시작 시간
        slotMaxTime: '20:00', // Day 캘린더에서 종료 시간
        // 해더에 표시할 툴바
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
        },
        initialView: 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
        //initialDate: '2021-07-15', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
        navLinks: true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
        editable: true, // 수정 가능?
        selectable: true, // 달력 일자 드래그 설정가능
        nowIndicator: true, // 현재 시간 마크
        dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
        locale: 'ko', // 한국어 설정
        eventAdd: function(obj) { // 이벤트가 추가되면 발생하는 이벤트
          console.log(obj);
        },
        eventChange: function(obj) { // 이벤트가 수정되면 발생하는 이벤트
          console.log(obj);
        },
        eventRemove: function(obj){ // 이벤트가 삭제되면 발생하는 이벤트
          console.log(obj);
        },
        select: function(arg) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.
          var title = prompt('Event Title:');
          if (title) {
            calendar.addEvent({
              title: title,
              start: arg.start,
              end: arg.end,
              allDay: arg.allDay
            })
          }
          calendar.unselect()
        }
        
      }); //new FullCalendar end
      
      // 캘린더 랜더링
      calendar.render();
    });
</script>

<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Api Type</th>
			<th scope="col">Api Name</th>
			<th scope="col">Link</th>
			<th scope="col">Memo</th>
			<th scope="col">ººº</th>
			<th scope="col">진행상태</th>
		</tr>
	<tbody>
		<tr>
			<th scope="row">1</th>
			<td>문자 발송</td>
			<td>Nurigo api</td>
			<td><a href="https://github.com/coolsms/coolsms-java-examples/commit/43237e5bd9c1928c701f329720ac03846d687cf4#diff-90e217be1211ac74e255621a3d52b286fdac96314c752bb7ea17ec07e36ac8a2">coolSms_git</a></td>
			<td>key 필요함 ! 내 메모장에 적어둠</td>
			<td><input type="button" value="문자전송하기" class="btn btn-primary btn-sm" id="msgSendBtn"/></td>
			<td><button type="button" class="btn btn-success">구현완료</button></td>
		</tr>
		<tr>
			<th scope="row">2</th>
			<td>달력&일정 관리</td>
			<td>FullCalendar api</td>
			<td></td>
			<td>저장눌렀을 시에 DB에 바로 등록되도록 구현, 클릭시 상세 모달창 구현 필요<br>
					복붙한거라 더 조사 필요함</td>
			<td><input type="button" value="캘린더로 이동" class="btn btn-primary btn-sm" id="goCalBtn"/></td>
			<td><button type="button" class="btn btn-warning">진행중</button></td>
		</tr>
		<tr>
			<th scope="row">3</th>
			<td>날씨</td>
			<td>openweathermap api</td>
			<td></td>
			<td>CSS 꾸미는건 알아서 ! 위치정보 활용해서 출력 구현 완료</td>
			<td><input type="button" value="날씨보러 가기" class="btn btn-primary btn-sm" id="goWeahter"/></td>
			<td><button type="button" class="btn btn-success">CSS 알아서 입히기</button></td>
		</tr>
	</tbody>
</table>



<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/app/apiTest/apiTest.js"></script>