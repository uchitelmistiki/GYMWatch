package ru.um.gymwatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.um.gymwatch.utils.DayOfWeekGetter;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

@SpringBootApplication
public class GymwatchApplication {

	public static void main(String[] args){
		SpringApplication.run(GymwatchApplication.class, args);
	}
}
