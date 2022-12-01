package vttp2022.day21.day21.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vttp2022.day21.day21.model.Categories;
import vttp2022.day21.day21.service.CatService;

@Controller
@RequestMapping(path = {"", "/", "/index"})
public class IndexController {
    
    @Autowired
    private CatService catSrc;

    @GetMapping
    public String catSearch(Model model){
        System.out.println("here");
        List<Categories> catList = catSrc.getCat();
        model.addAttribute("cat", catList);
        return "index";
    }
    
}
