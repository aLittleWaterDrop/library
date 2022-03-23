package com.wjl.library.control;

import com.wjl.library.bean.Sort;
import com.wjl.library.services.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 这是
 * @create 2022-03-02 15:27
 */
@Controller
public class ManagerSortControl {

    @Autowired
    SortService sortService;
    @RequestMapping("/sortManager")
    public String sortManager(Model model){
        sortService.saveSortToAttribute(model);
        return "manager/sortManager";
    }

    @RequestMapping("addSort")
    public String addSort(){
        return "/manager/sortAdd";
    }

    @PostMapping("addSort")
    public String sortAdd(String sortName){
        sortService.addSort(sortName);
        return "redirect:/sortManager";
    }

    @RequestMapping("updateSort/{sortId}")
    public String updateSort(@PathVariable("sortId")Integer sortId,Model model){
        sortService.saveSortByIdToAttribute(sortId,model);
        return "/manager/sortUpdate";
    }

    @PostMapping("updateSort")
    public String updateSort2(@RequestParam("id")Integer sortId,@RequestParam("sortName")String sortName){
        Sort sort = new Sort();
        sort.setId(sortId);
        sort.setSortName(sortName);
        sortService.updateSortName(sort);
        return "redirect:/sortManager";
    }

    @RequestMapping("deleteSort/{id}")
    public String deleteSort(@PathVariable("id")Integer sortId,Model model){
        return sortService.deleteSort(sortId,model);

    }
    @RequestMapping("showSort/{id}")
    public String showSort(@PathVariable("id")Integer sortId,Model model){
        sortService.showSort(sortId,model);
        return "/manager/sortShowBook";


    }
}
