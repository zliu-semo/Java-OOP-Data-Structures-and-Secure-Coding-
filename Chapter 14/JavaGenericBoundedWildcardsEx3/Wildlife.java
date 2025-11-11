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
public class Wildlife extends Animal{
    private String m_habitat;
    private int m_id;
    private static int m_num = 0;
    
    public Wildlife(){
        super();
        m_habitat = "nature";
        m_num++;
        m_id = m_num;
    }
    
    public Wildlife(String name, double weight, double height, double maxSpeed, String habitat){
        super(name, weight, height, maxSpeed);
        m_habitat = habitat;
        m_num++;
        m_id = m_num;        
    }
    
    String getHabitat(){
        return m_habitat;
    }
    
    @Override
    public void eat(){
        System.out.printf("%s%.2f%s\n", "I am eating ", m_weight / (m_height * m_height) *0.06, "kg food");
       
    }
    
    int getID(){
        return m_id;
    }
    
    public static int getNum(){
        return m_num;
    }
   
    void setHabitat(String habitat){
        m_habitat = habitat;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s: %d\n", "Wildlife ID", m_id) + 
                super.toString() + String.format("%s: %s\n", "habitat", m_habitat);
    }   

    @Override
    public boolean equals(Object o){
        return super.equals((Animal)o) && 
                this.m_habitat.equals(((Wildlife)o).m_habitat); 
    }     
}
