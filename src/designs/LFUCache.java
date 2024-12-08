package designs;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache {
    int capacity;
    Map<Integer, Integer> keyValMap; 
    Map<Integer,Integer> keyFreqMap; 
    Map<Integer, LinkedHashSet<Integer>> freqBuckKeysMap; 
    int minFreq;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyFreqMap = new HashMap<>();
        keyValMap = new HashMap<>();
        freqBuckKeysMap = new HashMap<>();
        minFreq = 0;
    }
    
    public int get(int key) {
        int ret;
        if (!keyValMap.containsKey(key)){
           return -1;
        }   
        changeFrequency(key);   
        return keyValMap.get(key);
    }
    
    public void put(int key, int value) {
        if (keyValMap.containsKey(key)){
            keyValMap.put(key,value);
            changeFrequency(key);
            return;
        }
        if (keyValMap.size() >= capacity){
           //Evict minimum frequency key from map. 
           LinkedHashSet<Integer> keys = freqBuckKeysMap.get(minFreq);
           int keyToRemove = keys.iterator().next();
           keys.remove(keyToRemove);
           keyValMap.remove(keyToRemove);
           keyFreqMap.remove(keyToRemove);
        }
        keyValMap.put(key,value);
        minFreq = 1;
        keyFreqMap.put(key,1);
        LinkedHashSet<Integer> keys = freqBuckKeysMap.getOrDefault(1, new LinkedHashSet<>());
        keys.add(key);
        freqBuckKeysMap.put(1, keys);
    }

    private void changeFrequency(int key){
        int oldFreq = keyFreqMap.get(key);
        int newFreq = oldFreq + 1; 
        keyFreqMap.put(key,newFreq);
        if (freqBuckKeysMap.containsKey(oldFreq)){
            freqBuckKeysMap.get(oldFreq).remove(key);
            if (freqBuckKeysMap.get(oldFreq).isEmpty()){
                if(minFreq == oldFreq){
                   minFreq++;
                }
            }
            if (freqBuckKeysMap.containsKey(newFreq)){
                freqBuckKeysMap.get(newFreq).add(key);
            }
            else{
                LinkedHashSet<Integer> keys = new LinkedHashSet<>();
                keys.add(key);
                freqBuckKeysMap.put(newFreq,keys);
            }
        }
        else{
            LinkedHashSet<Integer> keys = new LinkedHashSet<>();
            keys.add(key);
            freqBuckKeysMap.put(newFreq,keys);
        }
    }
}
