package com.atguigu.srb.oss;


import ch.qos.logback.core.encoder.EchoEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.atguigu.srb", "com.atguigu.common"})
public class ServiceOssApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(ServiceOssApplication.class, args);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}