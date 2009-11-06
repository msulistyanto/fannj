package com.googlecode.fannj;

import java.util.List;

public class FannSparse extends Fann{

    public static final float DEFAULT_CONNECTION_RATE = 1f;
    
    float connectionRate = 1f;
    
    public FannSparse( List<Layer> layers ) {
        this( DEFAULT_CONNECTION_RATE, layers );
    }
    
    public FannSparse( float connectionRate, List<Layer> layers ){
        
        super();
        
        if( layers == null )
            throw new IllegalArgumentException( "layers == null" );
        if( layers.size() == 0 )
            throw new IllegalArgumentException( "layers is empty" );
        
        this.connectionRate = connectionRate;
        int[] neurons = new int[ layers.size() ];
        for( int x = 0; x < neurons.length; x++ )
            neurons[x] = layers.get(x).size();

        ann = fann_create_sparse_array( connectionRate, neurons.length, neurons );
        addLayers( layers );
    }
        
}
