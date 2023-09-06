package org.example.concurence;

public class RaceConditionTest {
    private long count=0;
    public synchronized long get() {
        return count;
    }

    public synchronized void set(long val){
        count=val;
    }

    public void add10k() {
        long idx = 0;
        while (idx < 1000) {
            set(get() + 1);
            idx++;
        }
    }
}
