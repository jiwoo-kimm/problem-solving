import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cache {

    public static void main(String[] args) {
//        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
//        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
//        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
//        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
//        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(solution(0, new String[]{"Seoul", "Seoul", "Seoul", "Seoul"}));
//        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    private static final int HIT = 1;
    private static final int MISS = 5;

    private static int cacheSize;
    private static Set<City> cache = new HashSet<>();
    private static int currentTime;

    private static int solution(int size, String[] cities) {
        cacheSize = size;
        processCities(cities);
        return currentTime;
    }

    private static void processCities(String[] cities) {
        for (String city : cities)
            currentTime += processCity(city.toUpperCase());
    }

    private static int processCity(String cityName) {
        if (cache.contains(new City(cityName)))
            return processHit(cityName);
        else
            return processMiss(cityName);
    }

    private static int processHit(String cityName) {
        cache.remove(new City(cityName));
        cache.add(new City(cityName, currentTime));
        return HIT;
    }

    private static int processMiss(String cityName) {
        if (cacheSize != 0) {
            if (cache.size() >= cacheSize) LRU();
            cache.add(new City(cityName, currentTime));
        }
        return MISS;
    }

    private static void LRU() {
        City leastRecentlyVisitedCity = cache.stream().min(Comparator.comparingInt(o -> o.lastVisitedTime)).orElse(null);
        cache.remove(leastRecentlyVisitedCity);
    }
}

class City {
    String cityName;
    int lastVisitedTime;

    public City(String cityName, int lastVisitedTime) {
        this.cityName = cityName;
        this.lastVisitedTime = lastVisitedTime;
    }

    public City(String cityName) {
        this(cityName, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName);
    }
}