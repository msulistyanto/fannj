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

import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;

/**
 * Trains an ANN. Currently only File based training is supported.
 * 
 * @author krenfro
 */
public class Trainer {

    static {
	Native.register(Platform.isWindows() ? "fann" : "fann");
    }

    Fann fann;

    public Trainer(Fann fann) {
	this.fann = fann;
    }

    public float train(String trainingFile, int maxEpochs, int epochsBetweenReports,
	    float desiredError) {

	fann_train_on_file(fann.ann, trainingFile, maxEpochs, epochsBetweenReports, desiredError);
	return fann_get_MSE(fann.ann);
    }

    /* A JNA Direct Mapping implementation of the FANN library. */
    protected static native void fann_train_on_file(Pointer ann, String filename, int max_epochs,
	    int epochs_between_reports, float desired_error);

    protected static native float fann_get_MSE(Pointer ann);

}
