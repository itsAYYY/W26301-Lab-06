package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages a list of City objects.
 */
public class CityList {

    /** Internal list storing City objects. */
    private final ArrayList<City> cities = new ArrayList<>();

    /** Creates an empty CityList. */
    public CityList() { }

    /**
     * Adds a city to the list if it is not already present.
     *
     * @param city City to add
     * @throws IllegalArgumentException if the city already exists
     */
    public void add(City city) {
        if (hasCity(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
        sortCities();
    }

    /**
     * Checks whether the list contains a city with the same name and province.
     *
     * @param city City to check
     * @return true if present, false otherwise
     */
    public boolean hasCity(City city) {
        for (City c : cities) {
            if (c.getName().equalsIgnoreCase(city.getName())
                    && c.getProvince().equalsIgnoreCase(city.getProvince())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes a city from the list.
     *
     * @param city City to delete
     * @throws IllegalArgumentException if the city is not found
     */
    public void delete(City city) {
        for (int i = 0; i < cities.size(); i++) {
            City c = cities.get(i);
            if (c.getName().equalsIgnoreCase(city.getName())
                    && c.getProvince().equalsIgnoreCase(city.getProvince())) {
                cities.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * Gets the number of cities in the list.
     *
     * @return count of cities
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * Returns an unmodifiable view of the cities list.
     *
     * @return list of cities
     */
    public List<City> getCities() {
        return Collections.unmodifiableList(cities);
    }

    /** Sorts cities by name, then province (case-insensitive). */
    private void sortCities() {
        cities.sort((a, b) -> {
            int nameCmp = a.getName().compareToIgnoreCase(b.getName());
            if (nameCmp != 0) return nameCmp;
            return a.getProvince().compareToIgnoreCase(b.getProvince());
        });
    }
}
