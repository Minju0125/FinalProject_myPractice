package com.springboard.pracitceApi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weatherApi")
public class weatherApiTest {

	@GetMapping("weather")
	public String getWeather() {
		return "weather/weatherView";// weather.jsp
	}

}
