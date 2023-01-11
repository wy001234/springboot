package kr.co.paperwaffle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("kr.co.paperwaffle.dao")
@SpringBootApplication
public class PaperwaffleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaperwaffleApplication.class, args);
	}

}
