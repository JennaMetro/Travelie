/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author phan thanh cuong
 */
public class City {
    private final String name;
    private int count;
    
    public City(String name) {
        this.name = name;
        count = 1;
    }
    
    public City(String name, int count) {
        this.name = name;
        this.count = count;
    }
    
    public void countIncrement() {
        count++;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCount() {
        return count;
    }
}
