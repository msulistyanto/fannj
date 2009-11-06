package com.googlecode.fannj;

/**
 * 
 * @author krenfro
 */
public class Neuron {

    public static final ActivationFunction DEFAULT_ACTIVATION_FUNCTION = 
        ActivationFunction.FANN_SIGMOID_STEPWISE;
    public static final float DEFAULT_ACTIVATION_STEEPNESS = .5f;
    
    ActivationFunction activationFunction;
    float steepness;
    
    /**
     * Create a neuron with default activation function: FANN_SIGMOID_STEPWISE
     * and activation steepness = .5
     */
    public Neuron(){
        this( DEFAULT_ACTIVATION_FUNCTION );
    }
    
    /**
     * Create a neuron with the specified activation function
     * and default activation steepness = .5
     * @param activationFunction
     */
    public Neuron( ActivationFunction activationFunction ){
        this( DEFAULT_ACTIVATION_FUNCTION, DEFAULT_ACTIVATION_STEEPNESS );
    }
    
    /**
     * Create a neuron with the specified activation function and steepness.
     * 
     * @param activationFunction
     * @param steepness
     */
    public Neuron( ActivationFunction activationFunction, float steepness ){
        if( activationFunction == null )
            throw new IllegalArgumentException( "activationFunction is null" );
        this.activationFunction = activationFunction;
        this.steepness = steepness;
    }
    
    public float getSteepness(){
        return steepness;
    }
    
    public ActivationFunction getActivationFunction(){
        return activationFunction;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
                * result
                + ((activationFunction == null) ? 0
                        : activationFunction.hashCode());
        result = prime * result + Float.floatToIntBits( steepness );
        return result;
    }

    @Override
    public boolean equals( Object obj ) {
        if( this == obj )
            return true;
        if( obj == null )
            return false;
        if( getClass() != obj.getClass() )
            return false;
        Neuron other = (Neuron) obj;
        if( activationFunction == null ) {
            if( other.activationFunction != null )
                return false;
        }
        else if( !activationFunction.equals( other.activationFunction ) )
            return false;
        if( Float.floatToIntBits( steepness ) != Float.floatToIntBits( other.steepness ) )
            return false;
        return true;
    }
    
}
