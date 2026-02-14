package com.example.listycity;

/**
 * Represents a city and its province/territory.
 * Two City objects are considered equal if they have the same name and province.
 */
public class City implements Comparable<City> {

    /** The city name. */
    private String name;

    /** The province/territory name. */
    private String province;

    /**
     * Creates a City with a name and province.
     *
     * @param name     city name
     * @param province province/territory
     */
    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }

    /**
     * Gets the city name.
     *
     * @return city name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the province/territory.
     *
     * @return province/territory
     */
    public String getProvince() {
        return province;
    }

    /**
     * Compares cities lexicographically by city name.
     *
     * @param other the other City to compare to
     * @return negative if this is smaller, 0 if equal by name, positive if larger
     */
    @Override
    public int compareTo(City other) {
        return this.name.compareTo(other.getName());
    }

    /**
     * Checks equality based on city name and province/territory.
     *
     * @param o object to compare
     * @return true if same name and province, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;

        City other = (City) o;
        return this.name.equals(other.name) && this.province.equals(other.province);
    }

    /**
     * Hash code consistent with equals (name + province).
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + province.hashCode();
        return result;
    }
}
