package com.jojoldu.book.springboot.web;
import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON 변환

public class HelloController  {

    @GetMapping("/hello") // HTTP Method인 Get요청을 받을 수 있는 API
    public String hello(){
        return "hello";
    }
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto
        //외부에서 API로 넘긴 파라미터를 가저오는 어노테이션이다.
        //외부에서 name(@RequestParam("name"))이라는 이름으로 넘긴 파라미터를 name(String name)에 저장.
    (@RequestParam("name") String name,
     @RequestParam("amount") int amount)
    {
        return new HelloResponseDto(name,amount);
    }



}
