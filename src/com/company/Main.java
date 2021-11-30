package com.company;

import java.util.Scanner;
import java.util.Random;

abstract class Bicycle{
    abstract void BicycleRepair();

    abstract void BicycleUsing();

    abstract void BicycleAssembly();

    void BicycleBuying(){
        System.out.println("Bicycle was bought");
    }

}

//Unicycle - одноколесный велосипед
class Unicycle extends Bicycle{

    @Override
    void BicycleRepair() {
        System.out.println("Unicycle repair");
    }

    @Override
    void BicycleUsing() {
        System.out.println("Rules for using unicycle");
    }

    @Override
    void BicycleAssembly() {
        System.out.println("Unicycle assembly");
    }
}

//TwoWheeledBicycle - двухколесный велосипед
class TwoWheeledBicycle extends Bicycle{

    @Override
    void BicycleRepair() {
        System.out.println("Two-wheeled bicycle repair");
    }

    @Override
    void BicycleUsing() {
        System.out.println("Rules for using two-wheeled bicycle");
    }

    @Override
    void BicycleAssembly() {
        System.out.println("Two-wheeled bicycle assembly");
    }
}

//Tricycle - трехколесный велосипед
class Tricycle extends Bicycle{

    @Override
    void BicycleRepair() {
        System.out.println("Tricycle repair");
    }

    @Override
    void BicycleUsing() {
        System.out.println("Rules for using tricycle");
    }

    @Override
    void BicycleAssembly() {
        System.out.println("Tricycle assembly");
    }
}

// класс "Мастерская"
class Workshop{
    void BicycleWorkshop(Bicycle bicycle){
        bicycle.BicycleRepair();
    }
}



public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        final Random random = new Random();

        Bicycle[] array = new Bicycle[N];

        // заполнение массива
        for (int i = 0; i < N; i++) {
            switch (random.nextInt(3)){
                case 0:
                    array[i] = new Unicycle();
                    break;
                case 1:
                    array[i] = new TwoWheeledBicycle();
                    break;
                case 2:
                    array[i] = new Tricycle();
                    break;
            }
        }
        //ремонт одноколесных
        for (int i = 0; i < N; i++) {
            if (array[i] instanceof Unicycle) array[i].BicycleRepair();//можно внутри сортировки
        }

        System.out.println("Sort start");
        //сортировка
        int counter = 0;
        for (int i = 0; i < N; i++) {
            if (array[i] instanceof Unicycle){
                Bicycle replace = array[counter];
                array[counter] = array[i];
                array[i] = replace;
                counter++;
            }
        }
        for (int i = counter; i < N; i++) {
            if (array[i] instanceof TwoWheeledBicycle){
                Bicycle replace = array[counter];
                array[counter] = array[i];
                array[i] = replace;
                counter++;
            }
        }
        System.out.println("Sort end");
    }
}
