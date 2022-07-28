package com.Luka;

import java.util.Objects;

public class Plane extends Vehicle{
    int wings;

    public Plane(){
        super.setvehicleType("Plane");
        super.setproductionYear(2012);
        super.setSpeed(1000);
        wings=2;
    }

    public Plane(int ProductionYear,int speed,int wings){
        super.setSpeed(speed);
        super.setvehicleType("Car");
        super.setproductionYear(ProductionYear);
        this.wings=wings;
    }

    @Override
    public void showFullInfo(){
        System.out.println("Vehicle type: "+super.getvehicleType());
        System.out.println("Vehicle max speed: "+super.getSpeed());
        System.out.println("Vehicle production year: "+super.getproductionYear());
        System.out.println("Vehicle wing count: "+this.wings);
    }

    public int getWings() {
        return wings;
    }

    public void setWings(int wings) {
        this.wings = wings;
    }

    @Override
    void startEngine(){
        System.out.println("Plane engine has started.");
    }
    @Override
    public void transportPeople(Station stationA,Station stationB){
        People[] people=stationA.getAllPeopleOnStation();
        if(people.length>40){
            System.out.println("A plane can not transport more than 40 people.");
            return;
        }
        for(int i=0;i<people.length;i++){
            stationB.setPeopleOnStation(people[i],i);
        }
        stationA.makeStationEmpty();
        System.out.println(people.length+" people transported with a plane from "+stationA.getStationName()+ " to "+stationB.getStationName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return wings == plane.wings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wings);
    }

    @Override
    public String toString() {
        return super.getproductionYear() + " " + super.getSpeed() +" "+ wings;
    }
}
