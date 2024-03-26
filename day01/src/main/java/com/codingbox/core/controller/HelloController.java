package com.codingbox.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello") //주소에서 /hello 로 매핑이 됨
    public String hello(Model model) {
        model.addAttribute("data","firstData");
        return "/hello";
    }

    /*
    * url : get 방식
    *       /hello-mvc
    * data :    key -> name, value -> name
    * 화면 : hello-template.html(name 데이터 출력)
    * 35 분 까지
    * */
    // @GetMapping 애노테이션을 사용하여 "/hello-mvc" 경로로 들어오는 GET 요청을 이 메서드가 처리하도록 설정합니다.
    @GetMapping("/hello-mvc")
    public String helloMvc(
            // @RequestParam 애노테이션은 요청 파라미터 중 "name"이라는 이름의 파라미터를 String 타입의 변수 name에 바인딩합니다.
            // required = false는 이 파라미터가 필수가 아니라는 것을 의미하며, defaultValue = "집 가고 싶다"는
            // 요청에서 "name" 파라미터가 없을 경우 기본값으로 "집 가고 싶다"를 사용한다는 것을 나타냅니다.
            @RequestParam(value = "name", required = false, defaultValue = "집 가고 싶다") String name,
            // Model 객체는 컨트롤러와 뷰 사이의 데이터를 전달하는 데 사용됩니다.
            Model model) {
        // model.addAttribute 메서드를 사용하여 "name"이라는 이름으로 name 변수의 값을 뷰에 전달합니다.
        model.addAttribute("name", name);
        // 메서드는 "/hello-template"이라는 이름의 뷰를 반환합니다.
        // 실제로 이 문자열은 뷰 리졸버(view resolver)에 의해 처리되어 해당하는 뷰 템플릿으로 매핑됩니다.
        return "/hello-template";
    }


}
