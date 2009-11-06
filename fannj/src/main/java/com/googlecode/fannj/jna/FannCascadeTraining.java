package com.googlecode.fannj.jna;

import com.sun.jna.Pointer;

interface FannCascadeTraining {

    public void fann_cascadetrain_on_data(
            Pointer ann,  
            Pointer data,
            int max_neurons,
            int neurons_between_reports,
            float desired_error );
    
    public void fann_cascadetrain_on_file(
            Pointer ann,  
            String filename,
            int max_neurons,
            int neurons_between_reports,
            float desired_error );
    
    public float fann_get_cascade_output_change_fraction( Pointer ann );
    
    public void fann_set_cascade_output_change_fraction(
            Pointer ann, float cascade_output_change_fraction );
    
    public int fann_get_cascade_output_stagnation_epochs( Pointer ann );
    
    public void fann_set_cascade_output_stagnation_epochs(
            Pointer ann,  int cascade_output_stagnation_epochs );
    
    public float fann_get_cascade_candidate_change_fraction( Pointer ann );
    
    public void fann_set_cascade_candidate_change_fraction(
            Pointer ann, float cascade_candidate_change_fraction  );
    
    public int fann_get_cascade_candidate_stagnation_epochs( Pointer ann );
    
    public void fann_set_cascade_candidate_stagnation_epochs(
            Pointer ann,  int cascade_candidate_stagnation_epochs );
    
    public float fann_get_cascade_weight_multiplier( Pointer ann );
    
    public void fann_set_cascade_weight_multiplier(
            Pointer ann, float cascade_weight_multiplier );
    
    public float fann_get_cascade_candidate_limit( Pointer ann );
    
    public void fann_set_cascade_candidate_limit(
            Pointer ann, float cascade_candidate_limit );
    
    public int fann_get_cascade_max_out_epochs( Pointer ann );
    
    public void fann_set_cascade_max_out_epochs(
            Pointer ann,  int cascade_max_out_epochs );
    
    public int fann_get_cascade_min_out_epochs( Pointer ann );
    
    public void fann_set_cascade_min_out_epochs(
            Pointer ann,  int cascade_min_out_epochs );
    
    public int fann_get_cascade_max_cand_epochs( Pointer ann );
    
    public void fann_set_cascade_max_cand_epochs( 
            Pointer ann,  int cascade_max_cand_epochs );
    
    public int fann_get_cascade_min_cand_epochs( Pointer ann );
    
    public void fann_set_cascade_min_cand_epochs( 
            Pointer ann,  int cascade_min_cand_epochs );
    
    public int fann_get_cascade_num_candidates( Pointer ann );
    
    public int fann_get_cascade_activation_functions_count( Pointer ann );
   
    /**
     * @param fann
     * @return Pointer to int[]
     */
    public Pointer fann_get_cascade_activation_functions( Pointer ann );
    
    public void fann_set_cascade_activation_functions(
            Pointer ann,  
            int[] cascade_activation_functions,
            int cascade_activation_functions_count );
    
    public int fann_get_cascade_activation_steepnesses_count( Pointer ann );
    
    /**
     * @param fann
     * @return Pointer to float[]
     */
    Pointer fann_get_cascade_activation_steepnesses( Pointer ann );
    
    public void fann_set_cascade_activation_steepnesses(
            Pointer ann, 
            float[] cascade_activation_steepnesses,
            int cascade_activation_steepnesses_count );
    
    public int fann_get_cascade_num_candidate_groups( Pointer ann );
    
    public void fann_set_cascade_num_candidate_groups(
            Pointer ann,  int cascade_num_candidate_groups );
    
}
