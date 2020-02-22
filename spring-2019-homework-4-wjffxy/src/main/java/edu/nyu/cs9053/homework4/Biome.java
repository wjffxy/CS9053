package edu.nyu.cs9053.homework4;

public enum Biome {

    Equatorial("always moist, little temperature seasonality"),
    Tropical("summer rainy season and cooler \"winter\" dry season"),
    Subtropical("highly seasonal, arid climate"),
    Mediterranean("winter rainy season and summer drought"),
    WarmTemperate("occasional frost, often with summer rainfall maximum"),
    Nemoral("moderate climate with winter freezing"),
    Continental("arid, with warm or hot summers and cold winters"),
    Boreal("cold temperate with cool summers and long winters"),
    Polar("short, cool summers and long, cold winters");

    private final String description;

    private Biome(String description) {
    	this.description = description;
    }

    public String getDescription() {
    	return description;
    }

    public static void print(Biome ... biomes) {
    	for (Biome biome : biomes) {
    		System.out.printf("%s%n",biome.getDescription());
    	}
    }
}