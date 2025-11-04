/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahashmapschainex;

import java.util.Objects;

/**
 *
 * @author ziping
 */
public class Player {
    private String name, team, position;
    private int height, weight;
    private float age;
    
    public Player(String name, String team, String position, int height, int weight, float age) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }
    
    public void set(String name, String team, String position, int height, int weight, float age) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public String getTeam() {
        return team;
    }
    
    public String getPosition() {
        return position;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public float getAge() {
        return age;
    }
    
    @Override
    public Object clone()throws CloneNotSupportedException{
        return (Player)super.clone();
    }
    
        @Override
    public String toString(){
        return name + ", " + team + ", " + position + ", " 
                + height + ", " + weight + ", " + age; 
    }   
    
    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Player)) {
            return false;
        }   
        
        Player p = (Player)o;
        return (name.equals(p.name) && team.equals(p.team) && position.equals(p.position)
                && height == p.height && weight == p.weight && age == p.age);
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(name, team, position, height, weight, age);
    }
}
