package com.example.KursDiplomSite.Controller;

import com.example.KursDiplomSite.models.Ssilki;
import com.example.KursDiplomSite.repo.SsilkiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController
{
    public String res = "";

    @Autowired
    private SsilkiRepository ssilkiRepository;

    @GetMapping("/")
    public String home(Model model)
    {
        Iterable<Ssilki> posts = ssilkiRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("res", res);
        return "/home";
    }

    @PostMapping("/")
    public String add(@RequestParam String fullart, @RequestParam String smallart, Model model)
    {
        Ssilki ssilki = new Ssilki(fullart, smallart);
        Iterable<Ssilki> posts = ssilkiRepository.findAll();
        for (Ssilki s : posts)
        {
            if (s.getSmallart().equals(smallart)) {
                res = "Такая ссылка уже есть";
                return "redirect:/";
            }
        }
        ssilkiRepository.save(ssilki);
        res = "Готово";
        return "redirect:/";
    }

}
