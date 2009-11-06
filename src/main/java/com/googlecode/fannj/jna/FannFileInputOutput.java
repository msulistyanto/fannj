package com.googlecode.fannj.jna;

import com.sun.jna.Pointer;

/**
 * The File Input/Output methods defined in the FANN Reference Manual
 * 
 * @author krenfro
 */
interface FannFileInputOutput {

    /**
     * Constructs a backpropagation neural network from a configuration file, 
     * which has been saved by {@link #fann_save}
     * 
     * @param configuration_file
     * @return Pointer to the struct fann (should not be modified)
     * @since FANN >= 1.0.0
     * @see #fann_save 
     * @see #fann_save_to_fixed
     */
    public Pointer fann_create_from_file( String configuration_file );
    
    /**
     * Save the entire network to a configuration file.
     * <p>
     * The configuration file contains all information about the neural network
     * and enables {@link #fann_create_from_file} to create an exact copy of the 
     * neural network and all of the parameters associated with the neural 
     * network.
     * </p>
     * <p>
     * These three parameters (fann_set_callback, fann_set_error_log, 
     * fann_set_user_data) are NOT saved to the file because they cannot 
     * safely be ported to a different location.  Also temporary parameters 
     * generated during training like fann_get_MSE is not saved.
     * </p>
     * 
     * @param fann Pointer to the struct fann (should not be modified)
     * @param configuration_file
     * @return 0 on success and -1 on failure.
     * @since FANN >= 1.0.0
     * @see #fann_create_from_file
     * @see #link fann_save_to_fixed
     */
    public int fann_save( Pointer ann, String configuration_file );
    
    
    /**
     * Saves the entire network to a configuration file.  But it is saved in 
     * fixed point format no matter which format it is currently in.
     * <p>
     * This is usefull for training a network in floating points, and then 
     * later executing it in fixed point.
     * </p>
     * <p>
     * The function returns the bit position of the fix point, which can be 
     * used to find out how accurate the fixed point network will be.  A high 
     * value indicates high precision, and a low value indicates low precision.
     * </p>
     * <p>
     * A negative value indicates very low precision, and a very strong 
     * possibility for overflow.  (the actual fix point will be set to 0, since 
     * a negative fix point does not make sence).
     * </p>
     * <p>
     * Generally, a fix point lower than 6 is bad, and should be avoided.  
     * The best way to avoid this, is to have less connections to each neuron, 
     * or just less neurons in each layer.
     * </p>
     * <p>
     * The fixed point use of this network is only intended for use on machines 
     * that have no floating point processor, like an iPAQ.  On normal 
     * computers the floating point version is actually faster.
     * </p>
     * 
     * @param fann Pointer to the struct fann (should not be modified)
     * @param configuration_file
     * @return (not documented)
     * @since FANN >= 1.0.0
     * @see #fann_create_from_file
     * @see #fann_save
     */
    public int fann_save_to_fixed( Pointer ann, String configuration_file );
    
    
}
