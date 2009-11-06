package com.googlecode.fannj;

import java.util.List;

import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;

/**
 * A Java binding to the Fast Artificial Neural Network (FANN) native library.
 * <p>
 * A standard fully connected backpropagation neural network.
 * </p> 
 * <p>Not thread safe.</p>
 * 
 * <p>This class invokes native code.  You must call close() to prevent
 * memory leakage.</p>
 * 
 * @author krenfro
 * @see <a href="http://leenissen.dk/fann">Fast Artificial Neural Network</a>
 * @see <a href="https://jna.dev.java.net/#direct">JNA Direct Maping</a>
 */
public class Fann {

    static{
        Native.register( Platform.isWindows() ? "fann" : "fann" );
    }
    
    protected Pointer ann;
    
    protected Fann(){
    }
    
    /**
     * Load a previously saved FANN neural network.
     * 
     * @param file The serialized FANN definition 
     * @see http://leenissen.dk/fann/html/files/fann_io-h.html#fann_save
     * @see http://leenissen.dk/fann/html/files/fann_io-h.html#fann_create_from_file
     */
    public Fann( String file ){
        ann = fann_create_from_file( file );
    }
        
    
    public Fann( List<Layer> layers ){
        if( layers == null )
            throw new IllegalArgumentException( "layers == null" );
        if( layers.size() == 0 )
            throw new IllegalArgumentException( "layers is empty" );
        
        int[] neurons = new int[ layers.size() ];
        for( int x = 0; x < neurons.length; x++ )
            neurons[x] = layers.get(x).size();
        
        ann = fann_create_standard_array( neurons.length, neurons );
        addLayers( layers );        
    }
    
    protected void addLayers( List<Layer> layers ){
        
        for( int x = 1; x < layers.size(); x++ ){
            Layer layer = layers.get( x );
            for( int n = 0; n < layer.size(); n++ ){
                fann_set_activation_function( 
                        ann, layer.get( n ).getActivationFunction().ordinal(), x, n );
                fann_set_activation_steepness( 
                        ann, layer.get( n ).getSteepness(), x, n );
            }
        }
    }
    
    public int getNumInputNeurons(){
        return fann_get_num_input( ann );        
    }
    
    public int getNumOutputNeurons(){
        return fann_get_num_output( ann );
    }
    
    public int getTotalNumNeurons(){
        return fann_get_total_neurons( ann );
    }
    
    /**
     * 
     * @param input length == numInputNeurons
     * @return the output of the ANN. (length = numOutputNeurons)
     * @throws IllegalArgumentException if input.length != numInputNeurons
     */
    public float[] run( float[] input ){
    
        if( input.length != getNumInputNeurons() )
            throw new IllegalArgumentException( 
                    "input.length != " + getNumInputNeurons() );
        
        Pointer result = fann_run( ann, input );
        float[] output = result.getFloatArray( 0, 1 );
        return output;
    }
    
    /**
     * <p>Frees allocated memory.</p>
     * You must call this method when you are finished to prevent
     * memory leaks.
     */
    public void close(){
        if( ann != null )
            fann_destroy( ann );
    }
    
    /* A JNA Direct Mapping implementation of the FANN library.  
     * This instance should be more performant than 
     * #com.googlecode.fannj.jna.FannLibrary
     */
    protected static native Pointer fann_create_from_file( String configuration_file );
    protected static native Pointer fann_create_standard_array( int numLayers, int[] layers );
    protected static native Pointer fann_create_sparse_array( float connection_rate, int numLayers, int[] layers );
    protected static native Pointer fann_create_shortcut_array( int numLayers, int[] layers );
    protected static native float fann_get_MSE( Pointer ann );
    protected static native Pointer fann_run( Pointer ann, float[] input );
    protected static native void fann_destroy( Pointer ann );
    protected static native int fann_get_num_input( Pointer ann );
    protected static native int fann_get_num_output( Pointer ann );
    protected static native int fann_get_total_neurons( Pointer ann );
    protected static native void fann_set_activation_function( 
            Pointer ann, int activation_function, int layer, int neuron );
    protected static native void fann_set_activation_steepness( 
            Pointer ann, float steepness, int layer, int neuron );
    protected static native Pointer fann_get_neuron( Pointer ann, int layer, int neuron);
}
