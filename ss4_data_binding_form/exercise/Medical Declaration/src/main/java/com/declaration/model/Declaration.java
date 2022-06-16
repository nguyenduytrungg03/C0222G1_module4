package com.declaration.model;

public class Declaration {
    private String name;
    private String dayOfBirth;
    private String nationality;
    private String gender;
    private String idCard;
    private String vehicle;
    private String idVehicle;
    private String chair;
    private String dayComeBack;
    private String dayComeOut;
    private String reason;

    public Declaration() {
    }

    public Declaration(String name, String dayOfBirth,
                       String gender, String idCard,
                       String vehicle, String idVehicle,
                       String chair, String dayComeBack,
                       String dayComeOut, String reason) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.idVehicle = idVehicle;
        this.chair = chair;
        this.dayComeBack = dayComeBack;
        this.dayComeOut = dayComeOut;
        this.reason = reason;
    }

    public Declaration(String name, String dayOfBirth, String nationality, String gender, String idCard, String vehicle, String idVehicle, String chair, String dayComeBack, String dayComeOut, String reason) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.nationality = nationality;
        this.gender = gender;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.idVehicle = idVehicle;
        this.chair = chair;
        this.dayComeBack = dayComeBack;
        this.dayComeOut = dayComeOut;
        this.reason = reason;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getChair() {
        return chair;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    public String getDayComeBack() {
        return dayComeBack;
    }

    public void setDayComeBack(String dayComeBack) {
        this.dayComeBack = dayComeBack;
    }

    public String getDayComeOut() {
        return dayComeOut;
    }

    public void setDayComeOut(String dayComeOut) {
        this.dayComeOut = dayComeOut;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
