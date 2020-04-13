package com.hams.manager.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = {"com.*.*.*.*.dao","com.hams.manager.erp.*.mapper","com.hams.manager.erp.*.*.mapper"})
@MapperScan(basePackages ={"com.hams.manager.erp.mapper","com.hams.manager.erp.common.mapper"})
public class HamsErpApplication {

    public static void main(String[] args) {
        SpringApplication.run(HamsErpApplication.class, args);
    }

}
