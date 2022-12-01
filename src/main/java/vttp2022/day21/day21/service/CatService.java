package vttp2022.day21.day21.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import vttp2022.day21.day21.model.Brewries;
import vttp2022.day21.day21.model.Categories;
import vttp2022.day21.day21.repository.CatRepository;

@Service
public class CatService{
    @Autowired
    private CatRepository catRepo;

    public List<Categories> getCat(){

        List<Categories> catList = new LinkedList<>();

        SqlRowSet rs = catRepo.getCat();

        while (rs.next()){
            Categories c =new Categories();

            c.setId(rs.getString("id"));
            c.setCatName(rs.getString("cat_name"));

            catList.add(c);
        }
        
        return catList;
    }

    public List<Categories> getStyle(String styleId){

        List<Categories> catList = new LinkedList<>();

        SqlRowSet rs = catRepo.getStyle(styleId);
        while (rs.next()){
            Categories c =new Categories();

            c.setId(rs.getString("id"));
            c.setStyleName(rs.getString("style_name")); 

            catList.add(c);
        }
        return catList;
    }

    public List<Brewries> getBrewries(String styleId){

        List<Brewries> brList = new LinkedList<>();
        
        SqlRowSet rsc = catRepo.getBrewriesCount(styleId);
    
            while(rsc.next()){
                if(rsc.getInt("count") <= 0)
                    return brList;
            }
            
            

        SqlRowSet rs = catRepo.getBrewries(styleId);
        while(rs.next()){
            Brewries br = new Brewries();
            System.out.println("here");
            br.setId(rs.getInt("brewery_id"));
            br.setBrewriesName(rs.getString("name"));

            System.out.println(br.getId() + "|" + br.getBrewriesName());

            brList.add(br);
        }

        return brList;
    }
    
    
}
