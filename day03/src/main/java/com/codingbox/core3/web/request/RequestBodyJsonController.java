package com.codingbox.core3.web.request;

import com.codingbox.core3.web.dto.HelloData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
public class RequestBodyJsonController {
    // JSON 변환을 위한 ObjectMapper 인스턴스를 생성합니다.
    private ObjectMapper objectMapper = new ObjectMapper();

    // "/request-body-json-v1" 경로로 POST 요청이 오는 경우 이 메소드를 실행합니다.
    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 요청으로부터 입력 스트림을 가져옵니다.
        ServletInputStream inputStream = req.getInputStream();
        // 입력 스트림을 UTF-8 문자열로 변환합니다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        // 변환된 문자열을 콘솔에 출력합니다.
        System.out.println("messageBody : " + messageBody);
        // 문자열을 HelloData 객체로 변환합니다.
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        // HelloData 객체의 username 필드 값을 콘솔에 출력합니다.
        System.out.println("username : " + helloData.getUsername());
        // HelloData 객체의 age 필드 값을 콘솔에 출력합니다.
        System.out.println("age : " + helloData.getAge());
        // 응답으로 "OK" 문자열을 클라이언트에 전송합니다.
        resp.getWriter().write("OK");
    }
    /*
    * @ResponseBody : 응답 메시지
    * */
    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String  requestBodyJsonV2(@RequestBody String messageBody) throws JsonProcessingException {
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        // HelloData 객체의 username 필드 값을 콘솔에 출력합니다.
        System.out.println("username : " + helloData.getUsername());
        // HelloData 객체의 age 필드 값을 콘솔에 출력합니다.
        System.out.println("age : " + helloData.getAge());
        return "OK";
    }
    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String  requestBodyJsonV3(@RequestBody HelloData data) {
        // HelloData 객체의 username 필드 값을 콘솔에 출력합니다.
        System.out.println("username : " + data.getUsername());
        // HelloData 객체의 age 필드 값을 콘솔에 출력합니다.
        System.out.println("age : " + data.getAge());
        return "OK";
    }
    @ResponseBody
    @PostMapping("/request-body-json-v4")
    public String  requestBodyJsonV4(HttpEntity<HelloData> httpEntity) {
        HelloData data = httpEntity.getBody();
        // HelloData 객체의 username 필드 값을 콘솔에 출력합니다.
        System.out.println("username : " + data.getUsername());
        // HelloData 객체의 age 필드 값을 콘솔에 출력합니다.
        System.out.println("age : " + data.getAge());
        return "OK";
    }

    /*
    @ResponseBody, @RequestBody
        내부적으로 httpMessageconverter 객체를 사용
    * */
    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public HelloData  requestBodyJsonV5(@RequestBody HelloData data) {
        // HelloData 객체의 username 필드 값을 콘솔에 출력합니다.
        System.out.println("username : " + data.getUsername());
        // HelloData 객체의 age 필드 값을 콘솔에 출력합니다.
        System.out.println("age : " + data.getAge());
        return data;
    }
}
