package com.googlecode.fannj;

import java.util.ArrayList;

/**
 * A Layer of Neurons in an ANN.
 * 
 * @author krenfro
 */
public class Layer extends ArrayList<Neuron> {

    private static final long serialVersionUID = -6467294440860703773L;

    /**
     * Create a Layer with the specified number of neurons with the default
     * Activation Function: {@link Neuron.DEFAULT_ACTIVATION_FUNCTION} with
     * steepness: {@link Neuron.DEFAULT_ACTIVATION_STEEPNESS}
     * 
     * @param numNeurons
     * @return
     */
    public static Layer create(int numNeurons) {
	return create(numNeurons, Neuron.DEFAULT_ACTIVATION_FUNCTION,
	        Neuron.DEFAULT_ACTIVATION_STEEPNESS);
    }

    /**
     * Create a Layer with the specified number of neruons and a particular
     * ActivationFunction with the steepness:
     * {@link Neuron.DEFAULT_ACTIVATION_STEEPNESS}
     * 
     * @param numNeurons
     * @param activationFunction
     * @return
     */
    public static Layer create(int numNeurons, ActivationFunction activationFunction) {

	return create(numNeurons, activationFunction, Neuron.DEFAULT_ACTIVATION_STEEPNESS);
    }

    /**
     * Create a Layer with the specified number of neruons and a particular
     * ActivationFunction with specified steepness
     * 
     * @param numNeurons
     * @param activationFunction
     * @param steepness
     * @return
     */
    public static Layer create(int numNeurons, ActivationFunction activationFunction,
	    float steepness) {

	Layer layer = new Layer();
	for (int i = 0; i < numNeurons; i++)
	    layer.add(new Neuron(activationFunction, steepness));
	return layer;
    }
}
