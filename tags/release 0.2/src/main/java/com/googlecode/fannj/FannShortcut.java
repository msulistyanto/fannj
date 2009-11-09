package com.googlecode.fannj;

import java.util.List;

/**
 * <p>
 * A standard backpropagation neural network, which is not fully connected and
 * which also has shortcut connections.
 * </p>
 * 
 * @author krenfro
 */
public class FannShortcut extends Fann {

    public FannShortcut(List<Layer> layers) {

	super();

	if (layers == null)
	    throw new IllegalArgumentException("layers == null");
	if (layers.size() == 0)
	    throw new IllegalArgumentException("layers is empty");

	int[] neurons = new int[layers.size()];
	for (int x = 0; x < neurons.length; x++)
	    neurons[x] = layers.get(x).size();

	ann = fann_create_shortcut_array(neurons.length, neurons);
	addLayers(layers);
    }

}
