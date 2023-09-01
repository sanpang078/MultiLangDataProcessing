package org.example.concurence;

import static java.lang.System.out;

public class Hb {
    int x = 0;
    boolean v = false;

    public void writer(){
        x = 42;
        v = true;
    }

    public void read(){
        if (v){
            out.println(x);
        }
    }
}
