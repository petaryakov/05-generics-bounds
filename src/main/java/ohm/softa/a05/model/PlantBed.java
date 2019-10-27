package ohm.softa.a05.model;

import ohm.softa.a05.collections.SimpleFilter;
import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.collections.SimpleListImpl;

public class PlantBed<T extends Plant> {
    private SimpleList<T> plants;
    private int size;

    public PlantBed(){
        plants = new SimpleListImpl<>();
    }
    public void add(T plant){
        plants.add(plant);
        size++;
    }

    public SimpleList<T> getPlantsByColor(PlantColor color) /*throws IllegalAccessException, InstantiationException */{
        //SimpleList<T> newList = new SimpleListImpl<>();                       // this also works
        //SimpleList<T> newList = (SimpleList<T>)getClass().newInstance();

        SimpleList<T> newList = plants.filter(p -> p.getColor() == color);

        return newList;
    }

    public int size(){
        return size;
    }

    public SimpleList<T> getPlants() {
        return plants;
    }
}
