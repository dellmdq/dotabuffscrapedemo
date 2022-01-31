package com.company.utils;

import org.jsoup.nodes.Element;

import static java.lang.Double.parseDouble;

public class HeroAttributeFormat {

    /**Splits string through the "+" operator and returns the
     * sum of the parts.*/
    public static Double getTotalAttribute(Element e){
        Double baseNumber = parseDouble(e.text().split("\\+")[0]);
        Double extraNumber = parseDouble(e.text().split("\\+")[1]);

        return baseNumber + extraNumber;
    }//todo manejo excepción

    /**Gets the selected part of a splitted attributed.
     * i.e: day or night sight range, min or max damage threshold*/
    public static Integer getSplittedAttributePart (Element e, int index){

        try {
            if (e.text().contains("/")) {
                return Integer.parseInt(e.text().split("/")[index]);
            } else if (e.text().contains(" - ")) {
                return Integer.parseInt(e.text().split(" - ")[index]);
            }
            throw new Exception("Escape characters / or - not found");
        }catch(Exception exc){
            System.out.println(exc.getMessage());
        }
        return -1;
    }
 }
