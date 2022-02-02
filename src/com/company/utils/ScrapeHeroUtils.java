package com.company.utils;

import com.company.models.Category;
import com.company.models.Hero;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import static java.lang.Double.parseDouble;

/**This class will return the connection to access Alchemist webpage data
 * */
public class ScrapeHeroUtils {

    private static final String url = "https://dotabuff.com/heroes/";

    public ScrapeHeroUtils(Document doc) {

    }

    public String getUrl() {
        return url;
    }


    public static Document getDocument(String hero){
        Document doc;
        try {
            doc = Jsoup.connect(url + hero).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return doc;
    }

    //Todo atomizar
    public static <T extends Hero> T getAttributes(String heroClass){
        Document doc = getDocument(heroClass);

        Element cellStr = doc.select(".main tr:nth-child(2) td:nth-child(1)").first();
        Element cellAgi = doc.select(".main tr:nth-child(2) td:nth-child(2)").first();
        Element cellInt = doc.select(".main tr:nth-child(2) td:nth-child(3)").first();
        Element cellSpeed = doc.select(".other tr:nth-child(1) td:nth-child(2)").first();
        Element cellSight = doc.select(".other tr:nth-child(2) td:nth-child(2)").first();
        Element cellarmor = doc.select(".other tr:nth-child(3) td:nth-child(2)").first();
        Element cellBase_attack_time = doc.select(".other tr:nth-child(4) td:nth-child(2)").first();
        Element celldamage = doc.select(".other tr:nth-child(5) td:nth-child(2)").first();
        Element cellattack_point = doc.select(".other tr:nth-child(6) td:nth-child(2)").first();


        Double totalStrenght = HeroAttributeFormat.getTotalAttribute(cellStr);
        Double totalAgility = HeroAttributeFormat.getTotalAttribute(cellAgi);
        Double totalIntelligence = HeroAttributeFormat.getTotalAttribute(cellInt);

        Integer daySight = HeroAttributeFormat.getSplittedAttributePart(cellSight, 0);
        Integer nightSight = HeroAttributeFormat.getSplittedAttributePart(cellSight, 1);

        Integer minDamage = HeroAttributeFormat.getSplittedAttributePart(celldamage,0);
        Integer maxDamage = HeroAttributeFormat.getSplittedAttributePart(celldamage,1);

        T heroScraped = null;

        try {
            heroScraped = (T) Class.forName("com.company.models." + StringUtils.upperCaseFirst(heroClass)).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        heroScraped.setName(heroClass);
        heroScraped.setStrength(totalStrenght);
        heroScraped.setAgility(totalAgility);
        heroScraped.setIntelligence(totalIntelligence);
        heroScraped.setMovementSpeed(parseDouble(cellSpeed.text()));
        heroScraped.setDaySightRange(daySight);
        heroScraped.setNightSightRange(nightSight);
        heroScraped.setArmor(parseDouble(cellarmor.text()));
        heroScraped.setBaseAttackTime(parseDouble(cellattack_point.text()));
        heroScraped.setMin_damage_threshold(minDamage);
        heroScraped.setMax_damage_threshold(maxDamage);
        heroScraped.setAttackPoint(parseDouble(cellattack_point.text()));

        return heroScraped;
    }

    public static Set<Category> getCategories(String heroClass){
        Document doc = getDocument(heroClass);
        Set<Category> categorySet = new HashSet<>();

        Element categoryElement = doc.select(".header-content-title h1 small").first();
        String[] categories =  categoryElement.text().split(",");

        Category category = new Category();
        for(String s : categories) {
            category.setName(s);
            categorySet.add(category);
        }
        return categorySet;
    }


}
