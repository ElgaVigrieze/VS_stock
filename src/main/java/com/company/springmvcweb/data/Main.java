package com.company.springmvcweb.data;

import com.fasterxml.jackson.databind.util.EnumValues;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.springmvcweb.data.Category.valueOfLabel;

public class Main {
    public static void main(String[] args) {

        var repo = new ItemRepository();
        var repo1 = new ProjectRepository();




//        System.out.println(cat);
//        var i = (Item)repo.getItem(4);

//        var items =  repo1.getStockListItems((Project)repo1.getProject(6));
//        for (var it: items
//             ) {
//            System.out.println(it.getItemId());
//        }

//        System.out.println(repo1.addStockListItem((Project)repo1.getProject(4),20,2));

//        var items = (Project)repo1.getProject(4);
//        ;
//        System.out.println(items.getItems().get(0).getItemId());
////        var items = repo1.getAllStockList();

//var items =repo1.getProjects();
//        System.out.println(items);

//        System.out.println(items.getItems());

//repo1.addProject(new Project(0,"18.novembris", "Tilta dārzs", LocalDate.parse("2022-11-17"),"lights, big stage"));

}
}