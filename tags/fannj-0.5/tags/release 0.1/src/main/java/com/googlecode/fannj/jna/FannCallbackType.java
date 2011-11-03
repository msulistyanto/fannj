package com.googlecode.fannj.jna;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

public interface FannCallbackType extends Callback {

    public int invoke ( 
            PointerByReference net, 
            PointerByReference train,
            int max_epochs, 
            int epochs_between_reports,
            float desired_error, 
            int epochs, 
            Pointer user_data );
}
