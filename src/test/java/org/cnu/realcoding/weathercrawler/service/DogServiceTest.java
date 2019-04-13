package org.cnu.realcoding.weathercrawler.service;

import org.cnu.realcoding.weathercrawler.domain.Dog;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class DogServiceTest {

    private DogService dogService = new DogService();

    @Test
    public void testInsertDog(){
        Dog dog = new Dog();
        dog.setName("허숙히");
        dog.setKind("시베리안 허스키");

        dogService.insertDog(dog);

        List<Dog> dogs = dogService.getAllDogs();
        System.out.println(dogs);
        assertTrue(dogs.size() == 1);
        assertFalse(dogs.size() == 0);
    }

    @Test
    public void testCountDogs(){
        Dog dog = new Dog();
        dog.setName("멍뭉이");
        dog.setKind("포메리안");
        dogService.insertDog(dog);

        dog.setName("맥");
        dog.setKind("말티즈");
        dogService.insertDog(dog);

        List<Dog> dogs = dogService.getAllDogs();
        System.out.println("result :: " + dogs);

        assertTrue(dogs.size() == 2);
    }

    @Test
    public void testGetDogsByName(){
        Dog dog = new Dog();
        dog.setName("멍뭉이");
        dog.setKind("포메리안");
        dogService.insertDog(dog);
        List<Dog> dogs = dogService.getAllDogs();
        System.out.println("result :: " + dogs);

        Dog dog2 = new Dog();
        dog2.setName("웰시 코르키");
        dog2.setKind("웰시코기");
        dogService.insertDog(dog2);

        dogs = dogService.getAllDogs();
        System.out.println("result :: " + dogs);

        Dog foundDog = dogService.getDogsByName(dog2.getName());

        assertTrue(foundDog.getName() == dog2.getName());
        assertEquals(true, foundDog.getName().equals(dog2.getName()));
    }


    @Test
    public void testUpdateDogs() {
        Dog dog = new Dog();
        dog.setName("누렁이");
        dog.setKind("진돗개");
        dogService.insertDog(dog);

        Dog foundDog = dogService.getDogsByName(dog.getName());
        assertTrue(foundDog.getKind().equals("진돗개"));

        Dog updateDog = new Dog();
        updateDog.setName("누렁이");
        updateDog.setKind("믹스견");
        dogService.updateDog(updateDog);

        Dog updatedDog = dogService.getDogsByName("누렁이");
        assertTrue(updatedDog.getKind().equals("믹스견"));
    }

}