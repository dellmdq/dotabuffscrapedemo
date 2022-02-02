package com.company;

import com.company.models.Alchemist;
import com.company.utils.HeroAttributeFormat;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static com.company.utils.ScrapeHeroUtils.getCategories;
import static com.company.utils.ScrapeHeroUtils.getDocument;
import static java.lang.Double.parseDouble;


/**Draft class in which I test methods
 * */
public class Testing {

    public static void main(String[] args){

        File input = new File("tmp/input.html");
        System.out.println(input.getAbsolutePath());
        System.out.println(input.exists());

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a hero name: ");
        String calledHero = "alchemist"; //sc.nextLine();
        System.out.println("You have entered: " + calledHero);

        Document doc = getDocument(calledHero);

        Element cellStr = doc.select(".main tr:nth-child(2) td:nth-child(1)").first();
        Element cellAgi = doc.select(".main tr:nth-child(2) td:nth-child(2)").first();
        Element cellInt = doc.select(".main tr:nth-child(2) td:nth-child(3)").first();
        Element cellSpeed = doc.select(".other tr:nth-child(1) td:nth-child(2)").first();
        Element cellSight = doc.select(".other tr:nth-child(2) td:nth-child(2)").first();
        Element cellarmor = doc.select(".other tr:nth-child(3) td:nth-child(2)").first();
        Element cellBase_attack_time = doc.select(".other tr:nth-child(4) td:nth-child(2)").first();
        Element celldamage = doc.select(".other tr:nth-child(5) td:nth-child(2)").first();
        Element cellattack_point = doc.select(".other tr:nth-child(6) td:nth-child(2)").first();

        //String formatting and double parsing str

        Double totalStrenght = HeroAttributeFormat.getTotalAttribute(cellStr);
        Double totalAgility = HeroAttributeFormat.getTotalAttribute(cellAgi);
        Double totalIntelligence = HeroAttributeFormat.getTotalAttribute(cellInt);

        Integer daySight = HeroAttributeFormat.getSplittedAttributePart(cellSight, 0);
        Integer nightSight = HeroAttributeFormat.getSplittedAttributePart(cellSight, 1);

        Integer minDamage = HeroAttributeFormat.getSplittedAttributePart(celldamage,0);
        Integer maxDamage = HeroAttributeFormat.getSplittedAttributePart(celldamage,1);

        Alchemist alchemist = new Alchemist();
        alchemist.setStrength(totalStrenght);
        alchemist.setAgility(totalAgility);
        alchemist.setIntelligence(totalIntelligence);
        alchemist.setMovementSpeed(parseDouble(cellSpeed.text()));
        alchemist.setDaySightRange(daySight);
        alchemist.setNightSightRange(nightSight);
        alchemist.setArmor(parseDouble(cellarmor.text()));
        alchemist.setBaseAttackTime(parseDouble(cellattack_point.text()));
        alchemist.setMin_damage_threshold(minDamage);
        alchemist.setMax_damage_threshold(maxDamage);
        alchemist.setAttackPoint(parseDouble(cellattack_point.text()));

        System.out.println(alchemist);



        //Hero Charactestics
        //Name
        Element nameElement = doc.select(".header-content-title h1").first();
        System.out.println(nameElement);

        //String name = Arrays.stream(nameElement.text().split("<small>")).findFirst().get();
        String name = nameElement.ownText();//trae solo el nombre
        System.out.println("\n" + name);

        //characteristics
        Element categoryElement = doc.select(".header-content-title h1 small").first();
        String[] categories =  categoryElement.text().split(",");
        for (String s : categories){
            System.out.println(s);
        }

        alchemist.setCategories(getCategories(calledHero));

    }
}




