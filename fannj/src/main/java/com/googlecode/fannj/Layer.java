package com.googlecode.fannj;

import java.util.ArrayList;

public class Layer extends ArrayList<Neuron> {

    private static final long serialVersionUID = -6467294440860703773L;
    
    public static Layer create( int numNeurons ){
        return create( 
                numNeurons, 
                Neuron.DEFAULT_ACTIVATION_FUNCTION, 
                Neuron.DEFAULT_ACTIVATION_STEEPNESS );
    }
    
    public static Layer create( 
            int numNeurons, 
            ActivationFunction activationFunction ){
        
        return create( 
                numNeurons, 
                activationFunction,
                Neuron.DEFAULT_ACTIVATION_STEEPNESS );
    }
    
    public static Layer create( 
            int numNeurons, 
            ActivationFunction activationFunction, 
            float steepness ){
        
        Layer layer = new Layer();
        for( int i = 0; i < numNeurons; i++ )
            layer.add( new Neuron( activationFunction, steepness ));        
        return layer;
    }
}
