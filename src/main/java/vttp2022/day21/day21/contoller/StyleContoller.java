package vttp2022.day21.day21.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.day21.day21.model.Categories;
import vttp2022.day21.day21.service.CatService;

@Controller
@RequestMapping(path = "/style")
public class StyleContoller {

    @Autowired
    private CatService catSrc;

    @GetMapping
    public String stykeSearch(@RequestParam String beer_cat, Model model){
        List<Categories> styleList =  catSrc.getStyle(beer_cat);
        model.addAttribute("style", styleList);
        return "style";
    }
}
