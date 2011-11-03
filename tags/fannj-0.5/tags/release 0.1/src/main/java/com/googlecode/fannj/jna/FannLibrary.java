package com.googlecode.fannj.jna;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

/**
 * The JNA interface to FANN.
 * 
 * <p>
 * All the methods in the FANN Reference Manual should be available.
 * All the documentation provided here is copied from the FANN Reference 
 * Manual as a convenience and slightly modified for Java.  
 * <b>The FANN Reference Manual should be the definitive source for 
 * documentation.</b>
 * </p>
 * 
 * <p>
 * The method names do not conform to typical Java coding conventions to avoid 
 * confusion about which methods in the FANN C Library are being called.
 * </p>
 * 
 * @since FANN 2.1.0 beta
 * @author krenfro
 * @see <a href="http://leenissen.dk/fann">Fast Artificial Neural Network Library (FANN)</a>
 */
public interface FannLibrary extends 
        Library, FannFileInputOutput, FannCreationExecution, 
        FannTraining, FannCascadeTraining {

    /* Note: The method names could be changed to match typical Java 
     * coding conventions with the com.sun.jna.FunctionMapper interface. 
     */
     
    public FannLibrary INSTANCE = 
        (FannLibrary) Native.loadLibrary(
                (Platform.isWindows() ? "fann" : "fann"),
                FannLibrary.class);         
}
