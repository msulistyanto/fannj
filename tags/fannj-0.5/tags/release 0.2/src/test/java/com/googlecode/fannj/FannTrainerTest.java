package com.googlecode.fannj;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FannTrainerTest {

    @Test
    public void testTraining() {

	URL trainingFile = this.getClass().getResource("xor.data");

	List<Layer> layers = new ArrayList<Layer>();
	layers.add(Layer.create(2));
	layers.add(Layer.create(3, ActivationFunction.FANN_SIGMOID_SYMMETRIC));
	layers.add(Layer.create(1, ActivationFunction.FANN_SIGMOID_SYMMETRIC));

	Fann fann = new Fann(layers);
	Trainer trainer = new Trainer(fann);

	float desiredError = .001f;
	float mse = trainer.train(trainingFile.getFile(), 500000, 1000, desiredError);
	assertTrue("" + mse, mse <= desiredError);
    }

}
