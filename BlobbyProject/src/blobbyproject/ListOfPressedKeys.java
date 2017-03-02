/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blobbyproject;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author alex
 */
public class ListOfPressedKeys {

    private Set<Integer> keys = new HashSet<>();

    public void addKeyCode(int keyCode) {
        
        keys.add(keyCode);
    }

    public boolean containsKeyCode(int keyCode) {
        return keys.contains(keyCode);
    }

    public void removeKeyCode(int keyCode) {
        
        keys.remove(keyCode);
    }
    public Set<Integer> getKeys(){
        return keys;
    }

}
