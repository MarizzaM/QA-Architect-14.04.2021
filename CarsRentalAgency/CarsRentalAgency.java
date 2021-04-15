package com.company;

import java.util.*;

public class CarsRentalAgency {

    Random random = new Random();

    protected ArrayList<String> cars = new ArrayList<>();
    protected Stack<String> workers = new Stack<>();
    protected Queue<String> customers = new LinkedList<>();;
    protected HashMap<String, Float> rentHourlyFee = new HashMap<>();
    protected float income;

    public CarsRentalAgency() {
    }

    public ArrayList<String> getCars() {
        return cars;
    }

    public Stack<String> getWorkers() {
        return workers;
    }

    public Queue<String> getCustomers() {
        return customers;
    }

    public HashMap<String, Float> getRentHourlyFee() {
        return rentHourlyFee;
    }

    public float getIncome() {
        return income;
    }

    public void setCars(ArrayList<String> cars) {
        this.cars = cars;
    }

    public void setWorkers(Stack<String> workers) {
        this.workers = workers;
    }

    public void setCustomers(Queue<String> customers) {
        this.customers = customers;
    }

    public void setRentHourlyFee(HashMap<String, Float> rentHourlyFee) {
        this.rentHourlyFee = rentHourlyFee;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public String rentACar(){

        if (customers.size() == 0){
            System.out.println("No customers waiting...");
            return null;
        }

        if (workers.empty()){
            System.out.println("Sorry, all our workers are busy right now");
            return null;
        }

        if (cars.size() == 0){
            System.out.println("Sorry, we are have no cars available right now");
            return null;
        }

        String worker = workers.pop();
        String customer = customers.peek();
        customers.remove(customer);

        int countOfCars = cars.size();
        String car = cars.get(random.nextInt(countOfCars));
        cars.remove(car);

        float rate = 0;
        if (rentHourlyFee.containsKey(car)){
            rate = rentHourlyFee.get(car);
        }

        int rentalHours = random.nextInt(12)+1;
        income += rentalHours*rate;

        System.out.println(String.format("The customer %s has rented the car %s for %d hours", customer, car, rentalHours));

        workers.push(worker);
        return car;
    }

    public void returnACar(String customer, String car){

        if (workers.empty()){
            System.out.println("Sorry, all our workers are busy right now");
            return;
        }
        String worker = workers.pop();
        cars.add(car);

        System.out.println(String.format("The customer %s has returned the car %s", customer, car));

        workers.push(worker);
    }

    @Override
    public String toString() {
        return "CarsRentalAgency{" +
                "\n cars=" + cars +
                "\n workers=" + workers +
                "\n customers=" + customers +
                "\n rentHourlyFee=" + rentHourlyFee +
                "\n income=" + income +
                '}';
    }
}
