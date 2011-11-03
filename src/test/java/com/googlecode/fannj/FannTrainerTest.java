/* FannJ
 * Copyright (C) 2009 Kyle Renfro
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 */
package com.googlecode.fannj;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FannTrainerTest {

    @Test
    public void testTrainingDefault() {

        URL trainingFile = this.getClass().getResource("xor.data");

        List<Layer> layers = new ArrayList<Layer>();
        layers.add(Layer.create(2));
        layers.add(Layer.create(3, ActivationFunction.FANN_SIGMOID_SYMMETRIC));
        layers.add(Layer.create(1, ActivationFunction.FANN_SIGMOID_SYMMETRIC));

        Fann fann = new Fann(layers);
        Trainer trainer = new Trainer(fann);

        float desiredError = .001f;
        float mse = trainer.train(trainingFile.getFile(), 500000, 1000,
                desiredError);
        assertTrue("" + mse, mse <= desiredError);
    }

    @Test
    public void testTrainingQuickprop() {

        URL trainingFile = this.getClass().getResource("xor.data");

        List<Layer> layers = new ArrayList<Layer>();
        layers.add(Layer.create(2));
        layers.add(Layer.create(3, ActivationFunction.FANN_SIGMOID_SYMMETRIC));
        layers.add(Layer.create(1, ActivationFunction.FANN_SIGMOID_SYMMETRIC));

        Fann fann = new Fann(layers);
        Trainer trainer = new Trainer(fann);

        trainer.setTrainingAlgorithm(TrainingAlgorithm.FANN_TRAIN_QUICKPROP);

        float desiredError = .001f;
        float mse = trainer.train(trainingFile.getFile(), 500000, 1000,
                desiredError);
        assertTrue("" + mse, mse <= desiredError);
    }

    @Test
    public void testTrainingBackprop() {

        URL trainingFile = this.getClass().getResource("xor.data");

        List<Layer> layers = new ArrayList<Layer>();
        layers.add(Layer.create(2));
        layers.add(Layer.create(3, ActivationFunction.FANN_SIGMOID_SYMMETRIC));
        layers.add(Layer.create(2, ActivationFunction.FANN_SIGMOID_SYMMETRIC));
        layers.add(Layer.create(1, ActivationFunction.FANN_SIGMOID_SYMMETRIC));

        Fann fann = new Fann(layers);
        Trainer trainer = new Trainer(fann);

        trainer.setTrainingAlgorithm(TrainingAlgorithm.FANN_TRAIN_INCREMENTAL);

        float desiredError = .001f;
        float mse = trainer.train(trainingFile.getFile(), 500000, 1000,
                desiredError);
        assertTrue("" + mse, mse <= desiredError);
    }

    @Test
    public void testCascadeTraining() {
        URL trainingFile = this.getClass().getResource("parity8.train");
        Fann fann = new FannShortcut(8, 1);
        Trainer trainer = new Trainer(fann);

        float desiredError = .00f;
        float mse = trainer.cascadeTrain(trainingFile.getFile(), 30, 1,
                desiredError);

        assertTrue("" + mse, mse <= desiredError);
    }

}
