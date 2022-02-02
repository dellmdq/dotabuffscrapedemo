package com.company.models;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class Hero {

    private Long id;
    private String name;
    private Double strength;
    private Double agility;
    private Double intelligence;
    private Double movementSpeed;
    private Integer daySightRange;
    private Integer nightSightRange;
    private Double armor;
    private Double baseAttackTime;
    private Integer damageMinThreshold;
    private Integer damageMaxThreshold;
    private Double attackPoint;
    private Set<Category> categories;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getStrength() {
        return strength;
    }

    public void setStrength(Double strength) {
        this.strength = strength;
    }

    public Double getAgility() {
        return agility;
    }

    public void setAgility(Double agility) {
        this.agility = agility;
    }

    public Double getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(Double movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public Integer getDaySightRange() {
        return daySightRange;
    }

    public void setDaySightRange(Integer daySightRange) {
        this.daySightRange = daySightRange;
    }

    public Integer getNightSightRange() {
        return nightSightRange;
    }

    public void setNightSightRange(Integer nightSightRange) {
        this.nightSightRange = nightSightRange;
    }

    public Double getArmor() {
        return armor;
    }

    public void setArmor(Double armor) {
        this.armor = armor;
    }

    public Double getBaseAttackTime() {
        return baseAttackTime;
    }

    public void setBaseAttackTime(Double baseAttackTime) {
        this.baseAttackTime = baseAttackTime;
    }

    public Integer getMin_damage_threshold() {
        return damageMinThreshold;
    }

    public void setMin_damage_threshold(Integer min_damage_threshold) {
        this.damageMinThreshold = min_damage_threshold;
    }

    public Integer getMax_damage_threshold() {
        return damageMaxThreshold;
    }

    public void setMax_damage_threshold(Integer max_damage_threshold) {
        this.damageMaxThreshold = max_damage_threshold;
    }

    public Double getAttackPoint() {
        return attackPoint;
    }

    public void setAttackPoint(Double attackPoint) {
        this.attackPoint = attackPoint;
    }

    public Double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Double intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getDamageMinThreshold() {
        return damageMinThreshold;
    }

    public void setDamageMinThreshold(Integer damageMinThreshold) {
        this.damageMinThreshold = damageMinThreshold;
    }

    public Integer getDamageMaxThreshold() {
        return damageMaxThreshold;
    }

    public void setDamageMaxThreshold(Integer damageMaxThreshold) {
        this.damageMaxThreshold = damageMaxThreshold;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "\nname='" + name + '\'' +
                "\n, strength=" + strength +
                "\n, agility=" + agility +
                "\n, intelligence=" + intelligence +
                "\n, movementSpeed=" + movementSpeed +
                "\n, daySightRange=" + daySightRange +
                "\n, nightSightRange=" + nightSightRange +
                "\n, armor=" + armor +
                "\n, baseAttackTime=" + baseAttackTime +
                "\n, damageMinThreshold=" + damageMinThreshold +
                "\n, damageMaxThreshold=" + damageMaxThreshold +
                "\n, attackPoint=" + attackPoint +
                "\n, heroCharacteristics=" + categories + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return id.equals(hero.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
