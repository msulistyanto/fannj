package com.googlecode.fannj.jna;

import com.sun.jna.Callback;

public interface FannUserFunction extends Callback {
    
    public void invoke( 
            int num, 
            int num_input, 
            int num_output, 
            float[] input, 
            float[] output );
}
