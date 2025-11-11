/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagenericex1;

/**
 *
 * @author ziping
 */
public class Util {
    public static <T> boolean compare(GenericType<T> G1, GenericType<T> G2){
        return G1.get().equals(G2.get());
    }   
}
