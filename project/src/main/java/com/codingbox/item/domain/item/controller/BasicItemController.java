package com.codingbox.item.domain.item.controller;

import com.codingbox.item.domain.item.Item;
import com.codingbox.item.repository.ItemRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor // lombok 라이브러리에서 생성자를 자동으로 만들어줌
public class BasicItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);
        return "basic/items";
    }
    @GetMapping("/{itemid}")
    public String item(@PathVariable Long itemid,Model model) {
        Item item = itemRepository.findById(itemid);
        model.addAttribute("item",item);
        return "basic/item";
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
