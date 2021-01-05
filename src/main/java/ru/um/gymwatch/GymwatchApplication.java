package ru.um.gymwatch;

import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.um.gymwatch.utils.DayOfWeekGetter;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.StringCharacterIterator;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.stream.Stream;

@SpringBootApplication
public class GymwatchApplication {

	public static void main(String[] args){
		SpringApplication.run(GymwatchApplication.class, args);
	}
}
