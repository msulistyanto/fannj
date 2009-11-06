package com.googlecode.fannj.jna;

import com.sun.jna.Pointer;

/**
 * The Creation/Execution methods defined in the FANN Reference Manual
 *
 * @author krenfro
 */
interface FannCreationExecution {

    /* the varargs methods require non-primitives to work. 
     * (i.e., Integer, Float)*/
    
    
    /**
     * <p>
     * Creates a standard fully connected backpropagation neural network.
     * </p>
     * <p>
     * There will be a bias neuron in each layer (except the output layer), 
     * and this bias neuron will be connected to all neurons in the next layer.  
     * When running the network, the bias nodes always emits 1.
     * </p>
     * <p>
     * To destroy a struct fann use the {@link #fann_destory} function.
     * </p>
     * 
     * <h3>example:</h3>
     * Creating an ANN with 2 input neurons, 1 output neuron,
     * and two hidden neurons with 8 and 9 neurons:<br> 
     * <code>
     * Pointer ann = FannLibrary.INSTANCE.fann_create_standard(4, 2, 8, 9, 1);
     * </code>
     * 
     * @param num_layers The total number of layers including the input and the 
     *                   output layer.
     * @param layers Integer values determining the number of neurons in each 
     *               layer starting with the input layer and ending with the 
     *               output layer.
     * @return A Pointer to the newly created struct fann.
     * @since FANN >= 2.0.0
     * @see {@link fann_create_standard_array} 
     *      {@link fann_create_sparse} 
     *      {@link fann_create_shortcut}
     */
    public Pointer fann_create_standard( int num_layers, Integer... layers );
    
    
    /**
     * Just like fann_create_standard, but with an array of layer sizes instead 
     * of individual parameters.
     * 
     * <h3>Example:</h3>
     * Creating an ANN with 2 input neurons, 1 output neuron,
     * and two hidden neurons with 8 and 9 neurons:<br>
     * <code>
     * int layers[] = new int[]{2, 8, 9, 1};
     * Pointer ann = FannLibrary.INSTANCE.fann_create_standard_array(4, layers);
     * </code>
     * 
     * @param num_layers The total number of layers including the input and the 
     *                   output layer.
     * @param layers int array determining the number of neurons in each 
     *               layer starting with the input layer and ending with the 
     *               output layer.
     * @return A Pointer to the newly created struct fann.
     * @see #fann_create_standard
     * @see #fann_create_sparse
     * @see #fann_create_shortcut
     * @since FANN >= 2.0.0
     */
    public Pointer fann_create_standard_array( int num_layers, int[] layers );
    
 
    /**
     * Creates a standard backpropagation neural network, which is not fully 
     * connected.
     * 
     * @param connection_rate The connection rate controls how many connections 
     *                        there will be in the network.  If the connection 
     *                        rate is set to 1, the network will be fully 
     *                        connected, but if it is set to 0.5 only half of 
     *                        the connections will be set.  A connection rate 
     *                        of 1 will yield the same result as 
     *                        {@link #fann_create_standard}
     *                        
     * @param num_layers The total number of layers including the input and the 
     *                   output layer.
     * @param layers Integer values determining the number of neurons in each 
     *               layer starting with the input layer and ending with the 
     *               output layer.
     * @return A Pointer to the newly created struct fann.
     * @see #fann_create_sparse_array
     * @see #fann_create_standard
     * @see #fann_create_shortcut
     * @since FANN >= 2.0.0
     */
    public Pointer fann_create_sparse( 
            float connection_rate, int num_layers, Integer... layers );
    
    /**
     * Just like {@link #fann_create_sparse}, but with an array of layer sizes 
     * instead of individual parameters.
     * 
     * <h3>Example:</h3>
     * Creating an ANN with 2 input neurons, 1 output neuron,
     * and two hidden neurons with 8 and 9 neurons:<br>
     * <code>
     * int layers[] = new int[]{2, 8, 9, 1};
     * Pointer ann = FannLibrary.INSTANCE.fann_create_sparse_array(4, layers);
     * </code> 
     * 
     * @param connection_rate The connection rate controls how many connections 
     *                        there will be in the network.  If the connection 
     *                        rate is set to 1, the network will be fully 
     *                        connected, but if it is set to 0.5 only half of 
     *                        the connections will be set.  A connection rate 
     *                        of 1 will yield the same result as 
     *                        {@link #fann_create_standard}
     * @param num_layers The total number of layers including the input and the 
     *                   output layer.
     * @param layers int array determining the number of neurons in each 
     *               layer starting with the input layer and ending with the 
     *               output layer.
     * @return A Pointer to the newly created struct fann.
     * @since FANN >= 2.0.0
     * @see #fann_create_sparse
     * @see #fann_create_standard
     * @see #fann_create_shortcut
     */
    public Pointer fann_create_sparse_array(
            float connection_rate, int num_layers, int[] layers );
 
    
    /**
     * <p>
     * Creates a standard backpropagation neural network, which is not fully 
     * connected and which also has shortcut connections.
     * </p>
     * <p>
     * Shortcut connections are connections that skip layers.  A fully 
     * connected network with shortcut connections, is a network where all 
     * neurons are connected to all neurons in later layers.  Including direct 
     * connections from the input layer to the output layer.
     * </p> 
     * 
     * @param num_layers The total number of layers including the input and the 
     *                   output layer.
     * @param layers Integer values determining the number of neurons in each 
     *               layer starting with the input layer and ending with the 
     *               output layer.
     * @return A Pointer to the newly created struct fann.
     * @since FANN >= 2.0.0
     * @see {@link fann_create_shortcut_array} 
     *      {@link fann_create_standard} 
     *      {@link fann_create_sparse}
     */
    public Pointer fann_create_shortcut( int num_layers, Integer... layers );
            
    
    /**
     * Just like {@link #fann_create_shortcut}, but with an array of layer sizes 
     * instead of individual parameters.
     * 
     * <h3>Example:</h3>
     * Creating an ANN with 2 input neurons, 1 output neuron,
     * and two hidden neurons with 8 and 9 neurons:<br>
     * <code>
     * int layers[] = new int[]{2, 8, 9, 1};
     * Pointer ann = FannLibrary.INSTANCE.fann_create_shortcut_array(4, layers);
     * </code> 
     * 
     * @param num_layers The total number of layers including the input and the 
     *                   output layer.
     * @param layers int array determining the number of neurons in each 
     *               layer starting with the input layer and ending with the 
     *               output layer.
     * @return A Pointer to the newly created struct fann.
     * @since FANN >= 2.0.0
     * @see #fann_create_sparse
     * @see #fann_create_standard
     * @see #fann_create_shortcut
     */
    public Pointer fann_create_shortcut_array( int num_layers, int[] layers );

    
    /**
     * Destroys the entire network and properly freeing all the associated 
     * memory.
     * 
     * @param fann
     * @since FANN >= 1.0.0
     */
    public void fann_destroy( Pointer ann );
    
    /**
     * Creates a copy of a fann structure.
     *
     * Data in the user data fann_set_user_data is not copied, but the user 
     * data pointer is copied.
     * 
     * @param fann struct fann to be copied
     * @return the copy of the struct fann
     * @since FANN >= 2.2.0
     */
    public Pointer fann_copy( Pointer ann );
    
    
    /**
     * Will run input through the neural network, returning an array of 
     * outputs, the number of which being equal to the number of neurons in 
     * the output layer.
     * 
     * @param fann Pointer to the struct fann
     * @param input
     * @return Pointer to the float[] output, length == number of neurons in the 
     * output layer
     * @since FANN >= 1.0.0
     * @see #fann_test
     */
    public Pointer fann_run( Pointer ann, float[] input );
    
    /**
     * Give each connection a random weight between min_weight and max_weight
     * <br>
     * From the beginning the weights are random between -0.1 and 0.1.
     * 
     * @param fann Pointer to the struct fann
     * @param min_weight
     * @param max_weight
     * @since FANN >= 1.0.0
     * @see #fann_init_weights
     */
    public void fann_randomize_weights( 
            Pointer ann, float min_weight, float max_weight );
    
    
    /**
     * Initialize the weights using Widrow + Nguyen's algorithm.
     * 
     * <p>
     * This function behaves similarly to fann_randomize_weights.  It will use 
     * the algorithm developed by Derrick Nguyen and Bernard Widrow to set the 
     * weights in such a way as to speed up training.  This technique is not 
     * always successful, and in some cases can be less efficient than a 
     * purely random initialization.
     * </p>
     * 
     * <p>
     * The algorithm requires access to the range of the input data (ie, 
     * largest and smallest input), and therefore accepts a second argument, 
     * data, which is the training data that will be used to train the network.
     * </p>

     * @param fann Pointer to the struct fann
     * @param train_data Pointer to the struct train_data
     * @since FANN >= 1.1.0
     */
    public void fann_init_weights( Pointer ann, Pointer train_data );
    
    
    /**
     * Will print the connections of the ann in a compact matrix, for easy 
     * viewing of the internals of the ann.
     * 
     * <p>
     * The output from fann_print_connections on a small (2 2 1) network 
     * trained on the xor problem.
     * </p>
     * <pre>
     * Layer / Neuron 012345
     * L   1 / N    3 BBa...
     * L   1 / N    4 BBA...
     * L   1 / N    5 ......
     * L   2 / N    6 ...BBA
     * L   2 / N    7 ......
     * </pre>
     * <p> 
     * This network have five real neurons and two bias neurons.  This gives a 
     * total of seven neurons named from 0 to 6.  The connections between these 
     * neurons can be seen in the matrix.  "." is a place where there is no 
     * connection, while a character tells how strong the connection is on a 
     * scale from a-z.  The two real neurons in the hidden layer 
     * (neuron 3 and 4 in layer 1) has connection from the three neurons in 
     * the previous layer as is visible in the first two lines.  The output 
     * neuron (6) has connections form the three neurons in the hidden 
     * layer 3 - 5 as is visible in the fourth line.
     * </p>
     * <p>
     * To simplify the matrix output neurons is not visible as neurons that 
     * connections can come from, and input and bias neurons are not visible 
     * as neurons that connections can go to.
     * </p>
     * @param fann 
     * @since FANN >= 1.2.0
     */
    public void fann_print_connections( Pointer ann );
    
    
    /**
     * Prints all of the parameters and options of the ANN 
     * @param fann
     * @since FANN >= 1.2.0
     */
    public void fann_print_parameters( Pointer ann );

    
    /**
     * Get the number of input neurons.
     * @param fann
     * @return the number of input neurons
     * @since FANN >= 1.0.0
     */
    public int fann_get_num_input( Pointer ann );

    /**
     * Get the number of output neurons. 
     * @param fann
     * @return the number of output neurons
     * @since FANN >= 1.0.0
     */
    public int fann_get_num_output( Pointer ann );

    /**
     * Get the total number of neurons in the entire network.  
     * This number does also include the bias neurons, so a 2-4-2 network 
     * has 2+4+2 +2(bias) = 10 neurons.
     * 
     * @param fann
     * @return      
     * @since FANN >= 1.0.0
     */
    public int fann_get_total_neurons( Pointer ann );
    
    /**
     * Get the total number of connections in the entire network. 
     * @param fann
     * @return
     * @since FANN >= 1.0.0
     */
    public int fann_get_total_connections( Pointer ann );


//TODO: enums
    //public int fann_nettype_enum FANN_API fann_get_network_type(
    
    /**
     * Get the type of neural network it was created as.
     * 
     * @param fann
     * @return The neural network type from enum fann_network_type_enum
     * @since FANN >= 2.1.0
     */
    public int fann_get_network_type( Pointer ann );

    /**
     * Get the connection rate used when the network was created 
     * @param fann
     * @return The connection rate
     * @since FANN >= 2.1.0
     */
    public float fann_get_connection_rate( Pointer ann );

    /**
     * Get the number of layers in the network
     * 
     * @param fann
     * @return
     * @since FANN >= 2.1.0
     */
    public int fann_get_num_layers( Pointer ann );


    /**
     * Get the number of neurons in each layer in the network.
     * 
     * <p>
     * Bias is not included so the layers match the fann_create functions.
     * </p>
     * 
     * <p>
     * The layers array must be preallocated to at least 
     * sizeof(unsigned int) * fann_num_layers() long.
     * </p>
     * 
     * @param fann
     * @param layers
     * @since FANN >= 2.1.0
     */
    public void fann_get_layer_array( Pointer ann, int[] layers );
    
    /**
     * Get the number of bias in each layer in the network.
     * <p>
     * The bias array must be preallocated to at least 
     * sizeof(unsigned int) * fann_num_layers() long.
     * </p>
     * @param fann
     * @param bias
     * @since FANN >= 2.1.0
     */
    public void fann_get_bias_array( Pointer ann, int[] bias );


    /**
     * Get the connections in the network.
     * <p>
     * The connections array must be preallocated to at least 
     * sizeof(struct fann_connection) * fann_get_total_connections() long.
     * </p> 
     * @param fann
     * @param connections
     * @since FANN >= 2.1.0
     */
    public void fann_get_connection_array( Pointer ann, Pointer connections );
    
    /**
     * Set connections in the network.
     * <p>
     * Only the weights can be changed, connections and weights are ignored if 
     * they do not already exist in the network.
     * </p> 
     * <p>
     * The array must have sizeof(struct fann_connection) * num_connections size.
     * </p>
     * @param fann
     * @param connections
     * @param num_connections
     * @since FANN >= 2.1.0
     */
    public void fann_set_weight_array( 
            Pointer ann, Pointer connections, int num_connections );

    /**
     * Set a connection in the network.
     * <p>
     * Only the weights can be changed.  The connection/weight is ignored if 
     * it does not already exist in the network.
     * </p> 
     * @param fann
     * @param from_neuron
     * @param to_neuron
     * @param weight
     * @since FANN >= 2.1.0
     */
    public void fann_set_weight( 
            Pointer ann, int from_neuron, int to_neuron, float weight );
    

    /**
     * Store a pointer to user defined data.  The pointer can be retrieved 
     * with #fann_get_user_data for example in a callback.  It is the user's 
     * responsibility to allocate and deallocate any data that the pointer 
     * might point to. 
     * @param fann
     * @param user_data A void pointer to user defined data.
     * @since FANN >= 2.1.0
     */
    public void fann_set_user_data( Pointer ann, Pointer user_data );

    /**
     * Get a pointer to user defined data that was previously set with 
     * #fann_set_user_data.  It is the user's responsibility to allocate and 
     * deallocate any data that the pointer might point to.
     * 
     * @param fann
     * @return A void pointer to user defined data.
     * @since FANN >= 2.1.0
     */
    public Pointer fann_get_user_data( Pointer ann );

    /**
     * Returns the position of the decimal point in the ann.
     * <b>
     * This function is only available when the ANN is in fixed point mode.
     * </b>
     * The decimal point is described in greater detail in the tutorial Fixed Point Usage. 
     * @param fann
     * @return
     * @since FANN >= 1.0.0
     * @see #fann_get_multiplier
     * @see #fann_save_to_fixed
     * @see #fann_save_train_to_fixed
     */
    public int fann_get_decimal_point( Pointer ann );


    /**
     * returns the multiplier that fix point data is multiplied with.
     * <p>
     * This function is only available when the ANN is in fixed point mode.
     * </p>
     * <p>
     * The multiplier is the used to convert between floating point and fixed 
     * point notation.  A floating point number is multiplied with the 
     * multiplier in order to get the fixed point number and visa versa.
     * </p>
     * <p>
     * The multiplier is described in greater detail in the tutorial 
     * Fixed Point Usage.</p>
     *
     * @param fann
     * @return
     * @see #fann_get_multiplier
     * @see #fann_save_to_fixed
     * @see #fann_save_train_to_fixed
     * @since FANN >= 1.0.0
     */
    public int fann_get_multiplier( Pointer ann );
    
}