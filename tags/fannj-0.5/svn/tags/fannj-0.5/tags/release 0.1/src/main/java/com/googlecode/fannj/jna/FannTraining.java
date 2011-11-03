package com.googlecode.fannj.jna;

import com.sun.jna.Pointer;

interface FannTraining {

    /**
     * Train one iteration with a set of inputs, and a set of desired outputs.  
     * This training is always incremental training (see #fann_train_enum),
     *  since only one pattern is presented.
     * 
     * @param fann Ponter to the neural network structure
     * @param input an array of inputs.  This array must be exactly 
     *              #fann_get_num_input long.
     * @param desired_output an array of desired outputs.  This array must be 
     *                       exactly #fann_get_num_output long.
     */
    public void fann_train( Pointer ann, float[] input, float[] desired_output );
    
    public Pointer fann_test( Pointer ann, float[] input, float[] desired_output );
    
    public float fann_get_MSE( Pointer ann );
    
    public int fann_get_bit_fail( Pointer ann );
    
    public void fann_reset_MSE( Pointer ann );
    
    public void fann_train_on_data( 
            Pointer ann,
            Pointer data,
            int max_epochs,
            int epochs_between_reports,
            float desired_error );
    
    public void fann_train_on_file(
           Pointer ann,
           String filename,
           int max_epochs,
           int epochs_between_reports,
           float desired_error );
    
    public float fann_train_epoch( Pointer ann, Pointer data );
    
    public float fann_test_data( Pointer ann, Pointer data );
    
    public Pointer fann_read_train_from_file( String filename );
    
    public Pointer fann_create_train( 
            int num_data, int num_input, int num_output );
     
    public Pointer fann_create_train_from_callback( 
            int num_data, int num_input, int num_output, FannUserFunction user_function
            
        );
    
    public void fann_destroy_train( Pointer train_data );
        
    public void fann_shuffle_train_data( Pointer train_data );
    
    public void fann_scale_train( Pointer ann, Pointer data );
    
    public void fann_descale_train(Pointer ann, Pointer data );
    
    public int fann_set_input_scaling_params(
           Pointer ann, 
           Pointer data, 
           float new_input_min, 
           float new_input_max );
    
    public int fann_set_output_scaling_params(
           Pointer ann,
           Pointer data,
           float new_output_min,
           float new_output_max );
    
    public int fann_set_scaling_params(
           Pointer ann,
           Pointer data, 
           float new_input_min,
           float new_input_max,
           float new_output_min,
           float new_output_max );
    
    public int fann_clear_scaling_params( Pointer ann );
    
    public void fann_scale_input( Pointer ann, float[] input_vector );
    
    public void fann_scale_output( Pointer ann, float[] output_vector );
    
    public void fann_descale_input( Pointer ann, float[] input_vector );
    
    public void fann_descale_output( Pointer ann, float[] output_vector );
    
    public void fann_scale_input_train_data(
            Pointer train_data, float new_min, float new_max );
    
    public void fann_scale_output_train_data(
            Pointer train_data, float new_min, float new_max );
    
    public void fann_scale_train_data(
            Pointer train_data, float new_min, float new_max );
        
    public Pointer fann_merge_train_data( Pointer data1, Pointer data2 );
    
    public Pointer fann_duplicate_train_data( Pointer data );
    
    public Pointer fann_subset_train_data(
            Pointer data, int pos, int length );
    
    public int fann_length_train_data( Pointer data );
    
    public int fann_num_input_train_data( Pointer data );
    
    public int fann_num_output_train_data( Pointer data );
    
    public int fann_save_train( Pointer data, String filename );
    
    public int fann_save_train_to_fixed( 
            Pointer data, String filename, int decimal_point );
    
    public int fann_get_training_algorithm( Pointer ann );
    
    public void fann_set_training_algorithm( 
            Pointer ann, int training_algorithm );
    
    public float fann_get_learning_rate( Pointer ann );
    
    public void fann_set_learning_rate( Pointer ann, float learning_rate );
    
    public float fann_get_learning_momentum( Pointer ann );
    
    public void fann_set_learning_momentum( 
            Pointer ann, float learning_momentum );
    
    public int fann_get_activation_function( Pointer ann, int layer, int neuron );
    
    public void fann_set_activation_function(
           Pointer ann, int activation_function, int layer, int neuron );
    
    public void fann_set_activation_function_layer(
           Pointer ann, int activation_function, int layer );
    
    public void fann_set_activation_function_hidden(
           Pointer ann, int activation_function );
    
    public void fann_set_activation_function_output(
           Pointer ann, int activation_function );
    
    public float fann_get_activation_steepness(
           Pointer ann, int layer, int neuron );
    
    public void fann_set_activation_steepness( 
            Pointer ann, float steepness, int layer, int neuron );
    
    public void fann_set_activation_steepness_layer(
           Pointer ann, float steepness, int layer );
    
    public void fann_set_activation_steepness_hidden(
           Pointer ann, float steepness );
    
    public void fann_set_activation_steepness_output(
           Pointer ann, float steepness );
    
    public int fann_get_train_error_function( Pointer ann );
    
    public void fann_set_train_error_function(
           Pointer ann, int train_error_function );
    
    public int fann_get_train_stop_function( Pointer ann );
    
    public void fann_set_train_stop_function( 
            Pointer ann, int train_stop_function );
    
    public float fann_get_bit_fail_limit( Pointer ann );
    
    public void fann_set_bit_fail_limit( Pointer ann, float bit_fail_limit );
    
    public void fann_set_callback( Pointer ann, FannCallbackType callback );
    
    public float fann_get_quickprop_decay( Pointer ann );
    
    public void fann_set_quickprop_decay( Pointer ann, float quickprop_decay );
    
    public float fann_get_quickprop_mu( Pointer ann );
    
    public void fann_set_quickprop_mu( Pointer ann, float quickprop_mu );
    
    public float fann_get_rprop_increase_factor( Pointer ann );
    
    public void fann_set_rprop_increase_factor( 
           Pointer ann, float rprop_increase_factor );
            
    public float fann_get_rprop_decrease_factor( Pointer ann );
    
    public void fann_set_rprop_decrease_factor(
           Pointer ann, float rprop_decrease_factor );
    
    public float fann_get_rprop_delta_min( Pointer ann );
    
    public void fann_set_rprop_delta_min( Pointer ann, float rprop_delta_min );
    
    public float fann_get_rprop_delta_max( Pointer ann );
    
    public void fann_set_rprop_delta_max( Pointer ann, float rprop_delta_max );
    
    public float fann_get_rprop_delta_zero( Pointer ann );
    
    public void fann_set_rprop_delta_zero( 
            Pointer ann, float rprop_delta_max );
    
    public float fann_get_sarprop_weight_decay_shift( Pointer ann );
    
    public void fann_set_sarprop_weight_decay_shift(
           Pointer ann, float sarprop_weight_decay_shift );
    
    public float fann_get_sarprop_step_error_threshold_factor( Pointer ann );
    
    public void fann_set_sarprop_step_error_threshold_factor(
           Pointer ann, float sarprop_step_error_threshold_factor );
    
    public float fann_get_sarprop_step_error_shift( Pointer ann );
    
    public void fann_set_sarprop_step_error_shift(
           Pointer ann, float sarprop_step_error_shift );
    
    public float fann_get_sarprop_temperature( Pointer ann );
    
    public void fann_set_sarprop_temperature(
           Pointer ann, float sarprop_temperature );
    
}
