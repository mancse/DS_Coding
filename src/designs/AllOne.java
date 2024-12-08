package designs;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class AllOne {
    Map<String, Integer> freqMap; // Key to frequency mapping
    Map<Integer, Set<String>> freqKeysMap; // Frequency to keys mapping
    int minFreq, maxFreq; // Track minimum and maximum frequencies

    public AllOne() {
        freqMap = new HashMap<>();
        freqKeysMap = new HashMap<>();
        minFreq = 0;
        maxFreq = 0;
    }

    public void inc(String key) {
        int oldFreq = freqMap.getOrDefault(key, 0);
        int newFreq = oldFreq + 1;

        freqMap.put(key, newFreq);

        // Remove key from old frequency bucket
        if (oldFreq > 0) {
            freqKeysMap.get(oldFreq).remove(key);
            if (freqKeysMap.get(oldFreq).isEmpty()) {
                freqKeysMap.remove(oldFreq);
                if (oldFreq == minFreq) {
                    minFreq++;
                }
            }
        } else {
            minFreq = 1; // New key, set minFreq to 1
        }

        // Add key to new frequency bucket
        freqKeysMap.computeIfAbsent(newFreq, k -> new LinkedHashSet<>()).add(key);
        maxFreq = Math.max(maxFreq, newFreq);
    }

    public void dec(String key) {
        if (!freqMap.containsKey(key)) return;

        int oldFreq = freqMap.get(key);
        int newFreq = oldFreq - 1;

        // Update frequency map
        if (newFreq == 0) {
            freqMap.remove(key);
        } else {
            freqMap.put(key, newFreq);
        }

        // Remove key from old frequency bucket
        freqKeysMap.get(oldFreq).remove(key);
        if (freqKeysMap.get(oldFreq).isEmpty()) {
            freqKeysMap.remove(oldFreq);

            // Update maxFreq if necessary
            if (oldFreq == maxFreq) {
                maxFreq--;
            }

            // Update minFreq if necessary
            if (oldFreq == minFreq) {
                minFreq = freqKeysMap.isEmpty() ? 0 : oldFreq - 1;
            }
        }

        // Add key to new frequency bucket (if frequency > 0)
        if (newFreq > 0) {
            freqKeysMap.computeIfAbsent(newFreq, k -> new LinkedHashSet<>()).add(key);

            // Update minFreq if necessary
            minFreq = Math.min(minFreq, newFreq);
        }
    }

    public String getMaxKey() {
        return maxFreq > 0 && freqKeysMap.containsKey(maxFreq) ?
                freqKeysMap.get(maxFreq).iterator().next() : "";
    }

    public String getMinKey() {
        return minFreq > 0 && freqKeysMap.containsKey(minFreq) ?
                freqKeysMap.get(minFreq).iterator().next() : "";
    }
}

