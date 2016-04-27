/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contactbook;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author ws374078
 */
public class CustomMultimap <Key extends Comparable, Value extends Comparable> {
    
    public Map<Key, Set<Value>> map;
    
    public boolean isEmpty() {
        return map.isEmpty();
    }
    
    public int count(Key key) {
        return map.get(key).size(); 
    }
    
    public Set<Value> getAll(Key key) {
        return map.get(key);
    }
    
    public Set<Key> keySet() {
        return map.keySet();
    }
      
    public void put(Key key, Value value) {
        Set<Value> set = map.get(key);
        if (set != null)
            set.add(value);
        else {
            set = new TreeSet<Value>();
            set.add(value);
            map.put(key, set);
        }
    }
    
    public void removeAll(Key key) {
        map.remove(key);
    }
    
    public void remove(Key key, Value value) {
        Set<Value> set = map.get(key);
        if (set != null) {    
            set.remove(value);
            if (set.isEmpty())
                map.remove(key);
        }
    }
    
}
