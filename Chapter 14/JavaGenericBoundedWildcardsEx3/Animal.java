/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

/**
 *
 * @author ziping
 */
public class Animal {
    String m_name;
    double m_weight, m_height;
    double m_maxSpeed;
    private static int m_count = 0;
    
    public Animal(){
        m_name = "default animal";
        m_weight = 1.0;
        m_height = 1.0;
        m_maxSpeed = 0.0;
        m_count++;
    }
    
    public Animal(String name, double weight, double height, double maxSpeed){
        m_name = name;
        m_weight = weight;
        m_height = height;
        m_maxSpeed = maxSpeed;
        m_count++;
    } 
    
    public String getName(){
        return m_name;
    }
    
    public double getWeight(){
        return m_weight;
    }
    
    public double getHeight(){
        return m_height;
    } 
    
    public double getMaxSpeed(){
        return m_maxSpeed;
    }
    
    public static int getCount(){
        return m_count;
    }
    
    public void setName(String name){
        m_name = name;
    }
    
    public void setWeight(double weight){
        m_weight = weight;
    }
    
    public void setHeight(double height){
        m_height = height;
    } 
    
    public void setMaxSpeed(double maxSpeed){
        m_maxSpeed = maxSpeed;
    } 
    
    public void eat() //kg/(m*m)
    {
        System.out.println("I am eating " + m_weight / (m_height * m_height) + " kg food");
    }
    
    public Animal getClone(){
        Animal temp = new Animal(this.m_name, this.m_weight, this.m_height, this.m_maxSpeed);
        return temp;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s: %s\n%s: %.2f\n%s: %.2f\n%s: %.2f\n", 
                "animal name", m_name,
                "weight", m_weight,
                "height", m_height,
                "max running speed", m_maxSpeed);
    } 
    
    @Override
    public boolean equals(Object o){
        return this.m_name.equals(((Animal)o).m_name) &&
                this.m_weight == ((Animal)o).m_weight &&
                this.m_height == ((Animal)o).m_height &&
                this.m_maxSpeed == ((Animal)o).m_maxSpeed; 
    }
}
