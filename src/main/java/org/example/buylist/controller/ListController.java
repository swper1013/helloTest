package org.example.buylist.controller;


import lombok.RequiredArgsConstructor;
import org.example.buylist.dto.ListDto;
import org.example.buylist.service.ListService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class ListController {
    private final ListService listService;

    @GetMapping("/")
    public String page1(Model model) {
        model.addAttribute("item", new ListDto());
        return "page1";
    }

    @PostMapping("/page1")
    public String saveItem(@ModelAttribute ListDto listDto, RedirectAttributes redirectAttributes) {
        listService.save(listDto);
        redirectAttributes.addFlashAttribute("alertMessage","품목이 성공적으로 저장되었습니다!");
        return "redirect:/page2";
    }


    @GetMapping("/page2")
    public String showItemList(Model model) {
        model.addAttribute("items", listService.findAll());
        return "page2";
    }
    @PostMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        listService.delete(id);
        return "redirect:/page2";
    }

}
