package learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan({"learn.javalearnproject.mapper","learn.ERP.HRM.mapper"})
@SpringBootApplication
public class JavaLearnProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaLearnProjectApplication.class, args);
    }

}
