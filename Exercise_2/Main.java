package com.company;

public class Main {
    public static void main(String[] args) {

        CarsRentalAgency kia = new CarsRentalAgency();
        String car;

        kia.cars.add("Picanto");
        kia.cars.add("Rio");
        kia.cars.add("Fortte");
        kia.cars.add("Sportage");
        kia.cars.add("Optima");

        kia.workers.add("Worker 1");
        kia.workers.add("Worker 2");
        kia.workers.add("Worker 3");
        kia.workers.add("Worker 4");
        kia.workers.add("Worker 5");

        kia.customers.add("Customer 1");
        kia.customers.add("Customer 2");
        kia.customers.add("Customer 3");
        kia.customers.add("Customer 4");
        kia.customers.add("Customer 5");

        kia.rentHourlyFee.put("Picanto", 15f);
        kia.rentHourlyFee.put("Rio", 20f);
        kia.rentHourlyFee.put("Fortte", 25f);
        kia.rentHourlyFee.put("Sportage", 30f);
        kia.rentHourlyFee.put("Optima", 35f);

        System.out.println(kia);

        car = kia.rentACar();
        System.out.println("===================");
        System.out.println(kia);

        System.out.println("===================");
        kia.returnACar("Customer", car);
        System.out.println(kia);

        car = kia.rentACar();
        System.out.println("===================");
        System.out.println(kia);

        System.out.println("===================");
        kia.returnACar("Customer", car);
        System.out.println(kia);
    }
}
