package com.googlecode.fannj.jna;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.googlecode.fannj.ActivationFunction;
import com.googlecode.fannj.jna.FannLibrary;
import com.sun.jna.Pointer;

/**
 * Tests using XOR training file
 * 
 * @author krenfro
 */
public class FannTrainingTest {

    static FannLibrary fann = FannLibrary.INSTANCE;
    static Pointer ann;
    
    /**
     * Create a basic ann with 3 layers:<br>
     * 2 input, 3 hidden, 1 output
     */
    @BeforeClass
    public static void create(){
     
        ann = fann.fann_create_standard( 3, 2, 3, 1 );
        fann.fann_set_activation_function_hidden( 
                ann, ActivationFunction.FANN_SIGMOID_SYMMETRIC.ordinal() );
        fann.fann_set_activation_function_output( 
                ann, ActivationFunction.FANN_SIGMOID_SYMMETRIC.ordinal() );
    }
    
    @AfterClass
    public static void destroy(){
        if( ann != null )
            fann.fann_destroy( ann );
    }

    @Test
    public void testGetNumInput(){
        assertEquals( 2, fann.fann_get_num_input( ann ));   
    }
    
    @Test
    public void testGetNumOutput(){
        assertEquals( 1, fann.fann_get_num_output( ann ));
    }
    
    /* requires 2.1.0
    @Test 
    public void testGetBiasArray(){
        int[] bias = new int[ 3 ];
        fann.fann_get_bias_array( ann, bias );
        for( int b : bias )
            System.out.println( "bias: " + b );
    }
    */
    
    @Test
    public void testGetTotalNeurons(){
        
        int bias = 2; //need FANN 2.1.0 to read this i think.
        int expected = 2 + 3 + 1 + bias;
        assertEquals( expected, fann.fann_get_total_neurons( ann ));
    }
    
    @Test
    public void testGetTotalConnections(){
        
        assertEquals( 13, fann.fann_get_total_connections( ann ));
    }
    
    
    @Test
    public void testTrainOnFile(){
        
        URL trainingFile = this.getClass().getResource( "xor.data" );
        fann.fann_train_on_file( 
                ann, trainingFile.getFile(), 500000, 1000, .001f );
                
        float[] input = new float[]{ -1, 1 };
        Pointer result = fann.fann_run( ann, input );
        float[] output = result.getFloatArray( 0, 1 );
        assertEquals( 1, output[0], .1f );                
    }
    

}
