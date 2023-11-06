<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<span class="nowtime"></span>
<span>현재날씨</span>

<h3 class="here"></h3>
<h3 class="Icon"></h3>
<h3 class="Nowtemp">현재기온:</h3>
<h3 class="Lowtemp">최저기온:</h3>
<h3 class="Hightemp">최대기온:</h3>

<script>
    const API_KEY = "f745bbc33e89568573cfeeb99dd67ca4";

    $(document).ready(function () {
        function onGeoOk(position) {
            const lat = position.coords.latitude;
            const lon = position.coords.longitude;
            const url = `https:\api.openweathermap.org/data/2.5/weather?lat=\${lat}&lon=\${lon}&appid=\${API_KEY}&units=metric`;

            $.get(url, function (data) {
                const weatherDescription = data.weather[0].description;
                const currentTemperature = data.main.temp;
                const minTemperature = data.main.temp_min;
                const maxTemperature = data.main.temp_max;
                console.log(data.name);

                // 플레이스홀더에 값을 설정하거나 화면에 표시하는 예시
                $('.Nowtemp').text(`현재기온: \${currentTemperature}°C`);
                $('.Lowtemp').text(`최저기온: \${minTemperature}°C`);
                $('.Hightemp').text(`최대기온: \${maxTemperature}°C`);
                $('.Icon').text(weatherDescription);
                $('.here').text(data.name);
            });
        }

        function onGeoError() {
            alert("위치 정보를 찾을 수 없습니다.");
        }

        navigator.geolocation.getCurrentPosition(onGeoOk, onGeoError);
    });
</script>
