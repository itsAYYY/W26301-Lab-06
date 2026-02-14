package com.example.listycity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    private CityList mockCityList() {
        CityList list = new CityList();
        list.add(mockCity());
        return list;
    }

    @Test
    void testAddCityIncreasesCount() {
        CityList list = new CityList();
        City c = new City("Edmonton", "AB");

        list.add(c);

        assertEquals(1, list.countCities());
        assertTrue(list.hasCity(c));
    }

    @Test
    void testAddDuplicateCityThrows() {
        CityList list = new CityList();
        City c1 = new City("Edmonton", "AB");
        City c2 = new City("Edmonton", "AB");

        list.add(c1);

        assertThrows(IllegalArgumentException.class, () -> list.add(c2));
        assertEquals(1, list.countCities());
    }

    @Test
    void testHasCityTrue() {
        CityList list = mockCityList();
        assertTrue(list.hasCity(mockCity()));
    }

    @Test
    void testHasCityFalse() {
        CityList list = mockCityList();
        assertFalse(list.hasCity(new City("Calgary", "AB")));
    }

    @Test
    void testCountCities() {
        CityList list = mockCityList();
        assertEquals(1, list.countCities());

        list.add(new City("Regina", "SK"));
        assertEquals(2, list.countCities());
    }

    @Test
    void testDeleteCityRemovesIt() {
        CityList list = mockCityList();

        assertEquals(1, list.countCities());

        list.delete(mockCity());

        assertEquals(0, list.countCities());
        assertFalse(list.hasCity(mockCity()));
    }

    @Test
    void testDeleteNonExistentCityThrows() {
        CityList list = mockCityList();
        City missing = new City("Nowhere", "ZZ");

        assertThrows(IllegalArgumentException.class, () -> list.delete(missing));
        assertEquals(1, list.countCities()); // original city still there
    }
}
