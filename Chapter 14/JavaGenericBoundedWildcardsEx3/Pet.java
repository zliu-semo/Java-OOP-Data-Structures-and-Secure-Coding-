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
public class Pet extends Animal{
    private String m_owner;
    private int m_id;
    private static int m_num = 0;
    
    public Pet(){
        super();
        m_owner = "pet shop";
        m_num++;
        m_id = m_num;
    }
    
    public Pet(String name, double weight, double height, double maxSpeed, String owner){
        super(name, weight, height, maxSpeed);
        m_owner = owner;
        m_num++;
        m_id = m_num;        
    }
    
    String getOwner(){
        return m_owner;
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
   
    void setOwner(String owner){
        m_owner = owner;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s: %d\n", "Pet ID", m_id) + 
                super.toString() + String.format("%s: %s\n", "owner", m_owner);
    }   

    @Override
    public boolean equals(Object o){
        return super.equals((Animal)o) && 
                this.m_owner.equals(((Pet)o).m_owner); 
    }        
}
