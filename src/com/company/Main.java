package com.company;

import com.company.models.Alchemist;
import com.company.models.Hero;
import com.company.utils.ScrapeHeroUtils;
import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        String calledHero = "alchemist";
        Alchemist alchemist;
        alchemist = ScrapeHeroUtils.getAttributes(calledHero);
        alchemist.setCategories(ScrapeHeroUtils.getCategories(calledHero));

        System.out.println("Json Alchemist print: ");
        System.out.println(new Gson().toJson(alchemist));



    }
}
