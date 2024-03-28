package com.codingbox.core3.web.basic;

import com.codingbox.core3.web.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
public class BasicController {
    @GetMapping("/text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello Spring");
        return "basic/text-basic";
    }
    @GetMapping("/basic/text-unescaped")
    public String textBasicUnescaped(Model model) {
        model.addAttribute("data", "Hello Spring");
        return "basic/text-unescaped";
    }
    @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User();
        User userB = new User();
        List<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        Map<String, User> map = new HashMap<>();
        map.put("userA",userA);
        map.put("userB",userB);

        model.addAttribute("user",userA);
        model.addAttribute("users", list);
        model.addAttribute("usersmap", map);

        return "basic/variable";
    }
}
