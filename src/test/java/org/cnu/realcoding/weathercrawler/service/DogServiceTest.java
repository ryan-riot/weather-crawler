package org.cnu.realcoding.weathercrawler.service;

import org.cnu.realcoding.weathercrawler.domain.Dog;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class DogServiceTest {

    private DogService dogService;

    @Before
    public void setUp(){
        dogService = new DogService();

        Dog dog = new Dog();
        dog.setName("허숙히");
        dog.setKind("시베리안 허스키");
        dogService.insertDog(dog);

        Dog dog2 = new Dog();
        dog2.setName("멍뭉이");
        dog2.setKind("포메리안");
        dogService.insertDog(dog2);

        Dog dog3 = new Dog();
        dog3.setName("알콩이");
        dog3.setKind("말티즈");
        dogService.insertDog(dog3);

        Dog dog4 = new Dog();
        dog4.setName("누렁이");
        dog4.setKind("진돗개");
        dogService.insertDog(dog4);

        Dog dog5 = new Dog();
        dog5.setName("웰시 코르키");
        dog5.setKind("웰시코기");
        dogService.insertDog(dog5);

        System.out.println(dogService.getAllDogs());
    }

    @Test
    public void testCountDogs(){
        List<Dog> dogs = dogService.getAllDogs();
        System.out.println("CountDogs - all dogs :: " + dogs);

        assertTrue(dogs.size() == 5);
        assertFalse(dogs.size() == 0);
    }

    @Test
    public void testGetDogsByName(){
        String findDogName = "웰시 코르키";

        Dog foundDog = dogService.getDogsByName(findDogName);

        assertTrue(foundDog.getName() == findDogName);
        assertEquals(true, foundDog.getName().equals(findDogName));
        assertThat(true, is(foundDog.getName().equals(findDogName)));
    }

    @Test
    public void testUpdateDogs() {
        String findDogName = "누렁이";
        Dog foundDog = dogService.getDogsByName(findDogName);
        assertTrue(foundDog.getKind().equals("진돗개"));

        Dog updateDog = new Dog();
        //updateDog.setName("누렁이");
        updateDog.setKind("믹스견");
        dogService.updateDog(updateDog);

        Dog updatedDog = dogService.getDogsByName("누렁이");
        assertTrue(updatedDog.getKind().equals("믹스견"));
    }

}