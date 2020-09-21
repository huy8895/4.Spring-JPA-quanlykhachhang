package controller;

import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.IProvinceService;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    IProvinceService provinceService;

    @GetMapping
    public ModelAndView listProvince(){
        Iterable<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinces",provinces);
        return modelAndView;

    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createProvince(Province province){
        provinceService.save(province);

        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id){
        Province province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        if (province != null){
            modelAndView.setViewName("/province/edit");
            modelAndView.addObject("province", province);
        } else {
            modelAndView.setViewName("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(Province province){
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Long id){
        Province province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        if (province != null){
            modelAndView.setViewName("/province/delete");
            modelAndView.addObject("province", province);
        } else {
            modelAndView.setViewName("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(Province province){
        provinceService.remove(province.getId());
        return "redirect:/provinces";
    }
}
