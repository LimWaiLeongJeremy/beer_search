package vttp2022.day21.day21.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.day21.day21.model.Brewries;
import vttp2022.day21.day21.service.CatService;

@Controller
@RequestMapping(path = "/brewries")
public class BrewriesController {

    @Autowired
    private CatService catSrc;

    @GetMapping
    public String showBrewries(@RequestParam String style_id, Model model){
        List<Brewries> brList = catSrc.getBrewries(style_id);
        
        model.addAttribute("brewries_list", brList);
        return "brewries";
    }
    
}
