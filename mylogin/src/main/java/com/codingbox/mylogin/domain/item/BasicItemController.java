package com.codingbox.mylogin.domain.item;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor // lombok 라이브러리에서 생성자를 자동으로 만들어줌
public class BasicItemController {
    private final ItemRepository itemRepository;

//    @GetMapping
    public String items(Model model) {
        // 로구인 여부 체크
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);
        return "basic/items";
    }
    @GetMapping
    public String itemsV2(Model model) {
        // 로구인 여부 체크
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);
        return "basic/items";
    }
    @GetMapping("/{itemid}")
    public String item(@PathVariable Long itemid, Model model) {
        // 로그인 여부 체크
        Item item = itemRepository.findById(itemid);
        model.addAttribute("item",item);
        return "basic/item";
    }

    // @getmapping
    // url : {itemid}/edit
    // 화면 : return basic/editForm
    @GetMapping("/{itemid}/edit")
    public String edit(@PathVariable("itemid") Long itemid,Model model) {
        // 로그인 여부 체크
        Item item = itemRepository.findById(itemid);
        model.addAttribute("item",item);
        return "basic/editForm";
    }

    @GetMapping("/add")
    public String add(Model model) {
        // 로그인 여부 체크
        return "basic/addForm";
    }
    @PostMapping("/{itemid}/edit")
    public String update(@PathVariable("itemid") Long itemid,@ModelAttribute("item") Item item) {
        // 로그인 여부 체크
        itemRepository.update(itemid,item);
        return "redirect:/basic/items/{itemid}";
    }
    @PostMapping("/add")
    public String saveV5(Item item) {
        // 로그인 여부 체크
        itemRepository.save(item);
        return "redirect:/basic/items/"+item.getId();
    }

    // 테스트용 데이터 추가
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("testA",10000,10));
        itemRepository.save(new Item("testB",20000,20));
    }

    @PostConstruct
    public void init2() {
    }

    @PreDestroy
    public void destory() {
    }
}
