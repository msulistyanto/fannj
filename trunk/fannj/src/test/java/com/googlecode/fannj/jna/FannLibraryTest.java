package com.googlecode.fannj.jna;

import org.junit.Test;

import com.googlecode.fannj.jna.FannLibrary;
import com.sun.jna.Pointer;


public class FannLibraryTest {

    
    @Test
    public void testCreateStandard(){
   
        Pointer fann = 
            FannLibrary.INSTANCE.fann_create_standard( 4, 2, 8, 9, 1 );
        
        FannLibrary.INSTANCE.fann_destroy( fann );
    }
    
    @Test
    public void testCreateStandardArray(){
        
        int[] layers = new int[]{ 2, 8, 9, 1 };
        Pointer fann = 
            FannLibrary.INSTANCE.fann_create_standard_array( 
                    layers.length, layers );
    
        FannLibrary.INSTANCE.fann_destroy( fann );
    }
    
    @Test
    public void testCreateSparse(){
        
        Pointer fann = 
            FannLibrary.INSTANCE.fann_create_sparse( .5f, 4, 2, 8, 9, 1 );
        
        FannLibrary.INSTANCE.fann_destroy( fann );
    }
    
    @Test
    public void testCreateSparseArray(){
        
        int[] layers = new int[]{ 2, 8, 9, 1 };
        Pointer fann = 
            FannLibrary.INSTANCE.fann_create_sparse_array(  
                    .5f, layers.length, layers );
        
        FannLibrary.INSTANCE.fann_destroy( fann );
    }
    
    
    @Test
    public void testCreateShortcut(){
        
        Pointer fann = 
            FannLibrary.INSTANCE.fann_create_shortcut( 4, 2, 8, 9, 1 );
        
        FannLibrary.INSTANCE.fann_destroy( fann );
    }
    
    @Test
    public void testCreateShortcutArray(){
        
        int[] layers = new int[]{ 2, 8, 9, 1 };
        Pointer fann = 
            FannLibrary.INSTANCE.fann_create_shortcut_array( 
                    layers.length, layers );
        
        FannLibrary.INSTANCE.fann_destroy( fann );
    }
    
    /* not available until FANN 2.2.0
    @Test
    public void testCopy(){
        
        Pointer fann = 
            FannLibrary.INSTANCE.fann_create_standard( 4, 2, 8, 9, 1 );
        
        Pointer copy = FannLibrary.INSTANCE.fann_copy( fann );
        assertFalse( copy.equals( fann ));
        
        FannLibrary.INSTANCE.fann_destroy( fann );
        FannLibrary.INSTANCE.fann_destroy( copy );
    }
    */
 
}
