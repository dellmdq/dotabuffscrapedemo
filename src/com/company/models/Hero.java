package com.company.models;

public abstract class Hero {

    private String name;
    private Double strength;
    private Double agility;
    private Double intelligence;
    private Double movement_speed;
    private Integer day_sight_range;
    private Integer night_sight_range;
    private Double armor;
    private Double base_attack_time;
    private Integer damage_min_threshold;
    private Integer damage_max_threshold;
    private Double attack_point;


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

    public Double getMovement_speed() {
        return movement_speed;
    }

    public void setMovement_speed(Double movement_speed) {
        this.movement_speed = movement_speed;
    }

    public Integer getDay_sight_range() {
        return day_sight_range;
    }

    public void setDay_sight_range(Integer day_sight_range) {
        this.day_sight_range = day_sight_range;
    }

    public Integer getNight_sight_range() {
        return night_sight_range;
    }

    public void setNight_sight_range(Integer night_sight_range) {
        this.night_sight_range = night_sight_range;
    }

    public Double getArmor() {
        return armor;
    }

    public void setArmor(Double armor) {
        this.armor = armor;
    }

    public Double getBase_attack_time() {
        return base_attack_time;
    }

    public void setBase_attack_time(Double base_attack_time) {
        this.base_attack_time = base_attack_time;
    }

    public Integer getMin_damage_threshold() {
        return damage_min_threshold;
    }

    public void setMin_damage_threshold(Integer min_damage_threshold) {
        this.damage_min_threshold = min_damage_threshold;
    }

    public Integer getMax_damage_threshold() {
        return damage_max_threshold;
    }

    public void setMax_damage_threshold(Integer max_damage_threshold) {
        this.damage_max_threshold = max_damage_threshold;
    }

    public Double getAttack_point() {
        return attack_point;
    }

    public void setAttack_point(Double attack_point) {
        this.attack_point = attack_point;
    }

    public Double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Double intelligence) {
        this.intelligence = intelligence;
    }

    //todo toString

    @Override
    public String toString() {
        return "Hero{\n" +
                "strenght=" + strength +
                ", \nagility=" + agility +
                ", \nintelligence=" + intelligence +
                ", \nmovement_speed=" + movement_speed +
                ", \nday_sight_range=" + day_sight_range +
                ", \nnight_sight_range=" + night_sight_range +
                ", \narmor=" + armor +
                ", \nbase_attack_time=" + base_attack_time +
                ", \ndamage_min_threshold=" + damage_min_threshold +
                ", \ndamage_max_threshold=" + damage_max_threshold +
                ", \nattack_point=" + attack_point +
                '}';
    }


    //todo Equals
}
