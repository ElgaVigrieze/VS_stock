package com.company.springmvcweb;


import com.company.springmvcweb.data.*;
import com.company.springmvcweb.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.springmvcweb.data.Category.valueOfLabel;

@Controller
public class StockController {

    private ItemRepository repo;
    private ProjectRepository repo1;


    public StockController() {
        repo = new ItemRepository();
        repo1 = new ProjectRepository();
    }

    @GetMapping("/new_item")
    public String addItem(Model model) {
        List<String> categories= Category.getCategoriesPublic();
        model.addAttribute("title", "Pievienot jaunu tehnikas vienību");
        model.addAttribute("categories", categories);
        return "new_item";
    }

    @PostMapping("/new_item")
    public String newItemSelectCat (@ModelAttribute("itemCatDto") ItemCatDto dto, Model model) {
        var category = dto.getCategory();
        var cat=valueOfLabel(category);
        var locations = Arrays.asList(Location.values());
        model.addAttribute("title", "Pievienot jaunu tehnikas vienību");
        model.addAttribute("category", category);
        model.addAttribute("locations", locations);
        switch(cat){
            case SPEAKER,MIC,CONSOLE,STAND,STAGE, CABLE,MISC,VIDEO,TRANSPORT,WORK -> { return "new_item_cat";
            }
            case LIGHTS,MSPOTLIGHT,NMSPOTLIGHT -> { return "new_item_lights";
            }
            case TRUSS -> { return  "new_item_stage";
            }
        }
        return "";
    }

    @PostMapping("/new_item/add")
    public ModelAndView newItemAdd (@ModelAttribute("itemSaveDto") ItemSaveDto dto) {
        repo.addItem(dto);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/items")
    public String viewItems(Model model) {
        var speakers = repo.getItemsPerCategory(Category.CatValues.SPEAKER);
        var mics =  repo.getItemsPerCategory(Category.CatValues.MIC);
        var consoles =  repo.getItemsPerCategory(Category.CatValues.CONSOLE);
        var nmspotlights =  repo.getItemsPerCategory(Category.CatValues.NMSPOTLIGHT);
        var mspotlights =  repo.getItemsPerCategory(Category.CatValues.MSPOTLIGHT);
        var lights = repo.getItemsPerCategory(Category.CatValues.LIGHTS);
        var stands =  repo.getItemsPerCategory(Category.CatValues.STAND);
        var cables = repo.getItemsPerCategory(Category.CatValues.CABLE);
        var trusses =  repo.getItemsPerCategory(Category.CatValues.TRUSS);
        var stage = repo.getItemsPerCategory(Category.CatValues.STAGE);
        var video =  repo.getItemsPerCategory(Category.CatValues.VIDEO);
        var work =  repo.getItemsPerCategory(Category.CatValues.WORK);
        var transport =  repo.getItemsPerCategory(Category.CatValues.TRANSPORT);
        var misc = repo.getItemsPerCategory(Category.CatValues.MISC);
        model.addAttribute("title", "Tehnikas saraksts");
        model.addAttribute("cables", cables);
        model.addAttribute("mics", mics);
        model.addAttribute("speakers", speakers);
        model.addAttribute("consoles", consoles);
        model.addAttribute("stands", stands);
        model.addAttribute("trusses", trusses);
        model.addAttribute("video", video);
        model.addAttribute("lights", lights);
        model.addAttribute("work", work);
        model.addAttribute("stage", stage);
        model.addAttribute("nmspotlights", nmspotlights);
        model.addAttribute("mspotlights", mspotlights);
        model.addAttribute("misc", misc);
        model.addAttribute("transport", transport);
        return "items";
    }

    @PostMapping("/items")
    public String editItems() {
        return "items_edit";
    }

    @GetMapping("/items/{id}")
    public String editItem(@PathVariable int id, Model model) {
        var item = (Item)repo.getItem(id);
       var categories = Category.getCategoriesPublic();
        List<Location> locations = Arrays.asList(Location.values());
        model.addAttribute("title", "Rediģēt " + item.getName());
        model.addAttribute("locations", locations);
        model.addAttribute("item",item);
        model.addAttribute("categories", categories);
        return "items_edit";
    }

    @PostMapping("/items/{id}")
    public ModelAndView editItemSave(@PathVariable int id, ItemSaveDto dto, Model model) {
        List<String> categories= Category.getCategoriesPublic();
        var item = (Item)repo.getItem(id);
        var updatedItem = new Item(dto.getId(), dto.getName(), dto.getPrice(),dto.isActive(), dto.getLocation(),valueOfLabel(dto.getCategory()),dto.getTotalCount());
        repo.update(updatedItem);
        List<Location> locations = Arrays.asList(Location.values());
        model.addAttribute("title", "Rediģēt " + item.getName());
        model.addAttribute("locations", locations);
        model.addAttribute("categories", categories);
        model.addAttribute("item",item);
        return new ModelAndView("redirect:/items");
    }

    @GetMapping("/projects")
    public String viewProjects(Model model) {
        var projects = repo1.getProjects();
        model.addAttribute("title", "Projekti");
        model.addAttribute("projects", projects);
        return "projects";
    }

    @PostMapping("/projects")
    public String viewProjects() {
        return "projects_detail";
    }

    @GetMapping("/projects/{projectId}")
    public String viewProject(@PathVariable int projectId,Model model) {
        var project = (Project)repo1.getProject(projectId);
        model.addAttribute("title", "Projekts " + project.getTitle());
        model.addAttribute("project", project);
        return "projects_detail";
    }

    @GetMapping("/projects/{projectId}/delete")
    public String deleteProject (@PathVariable int projectId, Model model) {
        var project = (Project)repo1.getProject(projectId);
        model.addAttribute("projectId",projectId);
        model.addAttribute("project", project);
        model.addAttribute("title", "Projekts " + project.getTitle());
        return "projects_id_delete";
    }

    @PostMapping("/projects/{projectId}/delete")
    public ModelAndView deleteProjectConfirm (@PathVariable int projectId) {
        repo1.deleteProject(projectId);
        return new ModelAndView("redirect:/projects");
    }

    @GetMapping("/projects/{projectId}/update")
    public String updateProject (@PathVariable int projectId, Model model) {
        var project = (Project)repo1.getProject(projectId);
        model.addAttribute("projectId",projectId);
        model.addAttribute("project", project);
        model.addAttribute("title", "Projekts " + project.getTitle());
        return "projects_id_update";
    }
    @PostMapping("/projects/{projectId}/update")
    public ModelAndView updateProjectSave (@PathVariable int projectId, ProjectSaveDto dto, Model model) {
        var project = (Project)repo1.getProject(projectId);
        model.addAttribute("projectId",projectId);
        model.addAttribute("project", project);
        var d = dto.getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(d, formatter);
        var projectUpdate = new Project(projectId,dto.getTitle(),dto.getLocation(),date,dto.getDescription(), (List<StockListItem>) repo1.getStockListItems(project));
        repo1.updateProject(projectUpdate);
        return new ModelAndView("redirect:/projects/{projectId}");
    }


    @GetMapping("/projects/{projectId}/list")
    public String viewProjectList(@PathVariable int projectId,Model model) {
        var project = (Project)repo1.getProject(projectId);
        var stockItems = repo1.getStockListItems(project);
        var items = new ArrayList<Item>();
        for (var i: stockItems) {
            var it = (Item)repo.getItem(i.getItemId());
            items.add(new Item(it.getId(), it.getName(), i.getItemQuantity(),it.getCategory(),i.isItemDone()));
        }
        model.addAttribute("title", "Projekts "+project.getTitle());
        model.addAttribute("items", items);
        return "projects_stock_list";
    }

    @GetMapping("/projects/{projectId}/list/edit")
    public String editProjectList(@PathVariable int projectId,@ModelAttribute ItemSaveDto2 dto, Model model) {
        var project = (Project)repo1.getProject(projectId);
        var stockItems = repo1.getStockListItems(project);
        var items = new ArrayList<Item>();
        for (var i: stockItems) {
            var it = (Item)repo.getItem(i.getItemId());
            items.add(new Item(it.getId(), it.getName(), i.getItemQuantity(),it.getCategory(),i.isItemDone()));
        }
        model.addAttribute("title", "Projekts "+project.getTitle());
        model.addAttribute("items", items);
        return "projects_stock_list_edit";
    }

    @PostMapping("/projects/{projectId}/list/edit")
    public ModelAndView editProjectListPost(@PathVariable int projectId,@ModelAttribute ItemSaveDto2 dto, Model model) {
        var project = (Project)repo1.getProject(projectId);
        var stockItems = repo1.getStockListItems(project);
        var items = new ArrayList<Item>();
        for (var i: stockItems) {
            var it = (Item)repo.getItem(i.getItemId());
            items.add(new Item(it.getId(), it.getName(), i.getItemQuantity(),it.getCategory(),i.isItemDone()));
        }
        var qties = dto.getQuantity();
        for (int i = 0; i < qties.size(); i++) {
            if(qties.get(i) !=null){
                repo1.updateStockListItemQuantity(items.get(i).getId(),projectId,qties.get(i));
            }
        }
        var dones = dto.getDone();
        for (var i:stockItems) {
            repo1.updateStockListItemDone(i.getItemId(),projectId,false);
        }
        for (var i:stockItems) {
            for (var j: dones) {
                if(i.getItemId()==j){
                    repo1.updateStockListItemDone(j,projectId,true);
                }
            }
        }
        model.addAttribute("title", "Projekts "+project.getTitle());
        model.addAttribute("items", items);
        return new ModelAndView("redirect:/projects/{projectId}/list");
    }

    @GetMapping("/projects/{projectId}/list/delete/{id}")
    public ModelAndView deleteItemFromProjectList(@PathVariable int projectId, @PathVariable int id, Model model) {
        var project = (Project)repo1.getProject(projectId);
        repo1.deleteStockListItem(id,projectId);
        model.addAttribute("title", "Projekts "+project.getTitle());
        model.addAttribute("id", id);
        return new ModelAndView("redirect:/projects/{projectId}/list");
    }

    @GetMapping("/projects/{projectId}/add")
    public String newProject(@PathVariable int projectId, Model model) {
        var speakers = repo.getItemsPerCategory(Category.CatValues.SPEAKER);
        var mics =  repo.getItemsPerCategory(Category.CatValues.MIC);
        var consoles =  repo.getItemsPerCategory(Category.CatValues.CONSOLE);
        var nmspotlights =  repo.getItemsPerCategory(Category.CatValues.NMSPOTLIGHT);
        var mspotlights =  repo.getItemsPerCategory(Category.CatValues.MSPOTLIGHT);
        var lights = repo.getItemsPerCategory(Category.CatValues.LIGHTS);
        var stands =  repo.getItemsPerCategory(Category.CatValues.STAND);
        var cables = repo.getItemsPerCategory(Category.CatValues.CABLE);
        var trusses =  repo.getItemsPerCategory(Category.CatValues.TRUSS);
        var stage = repo.getItemsPerCategory(Category.CatValues.STAGE);
        var video =  repo.getItemsPerCategory(Category.CatValues.VIDEO);
        var work =  repo.getItemsPerCategory(Category.CatValues.WORK);
        var transport =  repo.getItemsPerCategory(Category.CatValues.TRANSPORT);
        var misc = repo.getItemsPerCategory(Category.CatValues.MISC);
        model.addAttribute("title", "Tehnikas saraksts");
        model.addAttribute("cables", cables);
        model.addAttribute("mics", mics);
        model.addAttribute("speakers", speakers);
        model.addAttribute("consoles", consoles);
        model.addAttribute("stands", stands);
        model.addAttribute("trusses", trusses);
        model.addAttribute("video", video);
        model.addAttribute("lights", lights);
        model.addAttribute("work", work);
        model.addAttribute("stage", stage);
        model.addAttribute("nmspotlights", nmspotlights);
        model.addAttribute("mspotlights", mspotlights);
        model.addAttribute("misc", misc);
        model.addAttribute("transport", transport);
        return "projects_id_add";
    }

    @PostMapping("/projects/{projectId}/add")
    public ModelAndView newProjectQuantities(@PathVariable int projectId, @ModelAttribute ItemSaveDto2 dto, Model model) {
        var project = (Project)repo1.getProject(projectId);
        var qties = dto.getQuantity();
        var items = new ArrayList<Item>();
        var ids = dto.getId();
        for (int i = 0; i < qties.size(); i++) {
            if(qties.get(i) !=null){
                var name = (Item)repo.getItem(ids.get(i));
                items.add(new Item(ids.get(i), name.getName(), qties.get(i)));
            }
        }
        for (var i: items) {
            repo1.addStockListItem((Project)project,i.getId(),i.getQuantity());
        }
        model.addAttribute("items", items);
        model.addAttribute("title", "Projekts "+project.getTitle());
        return new ModelAndView("redirect:/projects/{projectId}/list");
    }

    @GetMapping("/new_project")
    public String addProject(Model model) {
        model.addAttribute("title","Jauns projekts");
        return "new_project";
    }

    @PostMapping("/new_project")
    public ModelAndView saveProject(@ModelAttribute ProjectSaveDto dto) {
        var d = dto.getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(d, formatter);
        repo1.addProject(new Project(0,dto.getTitle(),dto.getLocation(), date, dto.getDescription()));
        return new ModelAndView("redirect:/projects");
    }

    @GetMapping("/new_project/{projectId}/add")
    public String newProjectQuantities(@PathVariable int projectId, Model model) {
        var project = (Project)repo1.getProject(projectId);
        var stockItems = repo1.getStockListItems(project);
        var items = new ArrayList<Item>();
        for (var i: stockItems) {
            var it = (Item)repo.getItem(i.getItemId());
            items.add(new Item(it.getId(), it.getName(), i.getItemQuantity(),it.getCategory(),i.isItemDone()));
        }
        model.addAttribute("title", "Projekts "+project.getTitle());
        model.addAttribute("items", items);
        return "project_stock_list";
    }


}