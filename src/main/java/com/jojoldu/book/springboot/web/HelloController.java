package com.jojoldu.book.springboot.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON 변환
public class HelloController {

    @GetMapping("/hello") // HTTP Method인 Get요청을 받을 수 있는 API
    public String hello(){
        return "hello";
    }
}
