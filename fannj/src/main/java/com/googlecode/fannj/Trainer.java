package com.googlecode.fannj;

import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;

/**
 * Trains an ANN.
 * 
 * @author krenfro
 */
public class Trainer {

    static{
        Native.register( Platform.isWindows() ? "fann" : "fann" );
    }
    
    Fann fann;
    
    public Trainer( Fann fann ){
        this.fann = fann;
    }
    
    public float train( 
            String trainingFile, 
            int maxEpochs, 
            int epochsBetweenReports, 
            float desiredError ){
        
        fann_train_on_file( 
                fann.ann, trainingFile, maxEpochs, epochsBetweenReports, desiredError );
        return fann_get_MSE( fann.ann );
    }
    
    /* A JNA Direct Mapping implementation of the FANN library.  */
    protected static native void fann_train_on_file( 
            Pointer ann, String filename, int max_epochs, int epochs_between_reports, float desired_error );
    protected static native float fann_get_MSE( Pointer ann );

}
