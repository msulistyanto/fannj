/* FannJ
 * Copyright (C) 2009 Kyle Renfro, 2011 Daniel Thomas
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

import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;

/**
 * Trains an ANN. Currently only File based training is supported.
 * 
 * @author krenfro, drt24
 */
public class Trainer {

    static {
        Native.register(Platform.isWindows() ? "fann" : "fann");
    }
    Fann fann;

    public Trainer(Fann fann) {
        this.fann = fann;
    }

    /**
     * @param trainingFile 
     * @param maxEpochs 
     * @param epochsBetweenReports 
     * @param desiredError 
     * @return MSE for the ann once trained
     */
    public float train(String trainingFile, int maxEpochs, int epochsBetweenReports,
                       float desiredError) {

        fann_train_on_file(fann.ann, trainingFile, maxEpochs, epochsBetweenReports, desiredError);
        return fann_get_MSE(fann.ann);
    }

    /**
     *
     * @param testingFile
     * @return MSE for the Fann which has been tested
     */
    public float test(String testingFile) {
        fann_reset_MSE(fann.ann);// so that only influence on the MSE is from
        // testing data
        Pointer testingData = fann_read_train_from_file(testingFile);

        fann_test_data(fann.ann, testingData);

        fann_destroy_train(testingData);// deallocate it.
        return fann_get_MSE(fann.ann);
    }

    /* A JNA Direct Mapping implementation of the FANN library. */
    protected static native void fann_train_on_file(Pointer ann, String filename, int max_epochs,
                                                    int epochs_between_reports, float desired_error);

    /**
     * Resets the mean square error from the network.
     *
     * @param ann
     */
    protected static native void fann_reset_MSE(Pointer ann);

    /**
     * Reads the mean square error from the network.
     *
     * @param ann
     * @return the mean square error of the network
     */
    protected static native float fann_get_MSE(Pointer ann);

    /**
     * Test the network using data and return the MSE of the network.
     *
     * You might need to run {@link #fann_reset_MSE(Pointer)} first
     *
     * @param ann
     * @param data
     *          the data to test with
     * @return the mean square error of the network
     */
    protected static native float fann_test_data(Pointer ann, Pointer data);

    /**
     * Read the training or testing data from a file
     *
     * You must call {@link #fann_destroy_train(Pointer)} on the {@link Pointer}
     * you get from this after you have finished with it
     *
     * @param filename
     *          the file name of the file to read the data from
     * @return pointer to the data which has been read for use with
     *         {@link #fann_test_data(Pointer,Pointer)}
     */
    protected static native Pointer fann_read_train_from_file(String filename);

    /**
     * Deallocate the data
     *
     * @param data
     *          the training/testing data to deallocate
     */
    protected static native void fann_destroy_train(Pointer data);
}
