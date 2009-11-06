package com.googlecode.fannj.jna;

import com.sun.jna.Pointer;

public interface FannErrorHandling {

    public void fann_set_error_log( Pointer errdat, Pointer log_file );
    
    public int fann_get_errno( Pointer errdat );
    
    public void fann_reset_errno( Pointer errdat );
    
    public void fann_reset_errstr( Pointer errdat );
    
    public String fann_get_errstr( Pointer errdat );
    
    public void fann_print_error( Pointer errdat );    
}
