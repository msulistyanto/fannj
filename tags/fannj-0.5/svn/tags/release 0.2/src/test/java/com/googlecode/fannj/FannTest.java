package com.googlecode.fannj;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.Test;

import com.googlecode.fannj.Fann;

public class FannTest {

    @Test
    public void testFromFile() {

	URL fannFile = this.getClass().getResource("xor_float.net");
	Fann fann = new Fann(fannFile.getFile());
	assertEquals(2, fann.getNumInputNeurons());
	assertEquals(1, fann.getNumOutputNeurons());
	assertEquals(-1f, fann.run(new float[] { -1, -1 })[0], .2f);
	assertEquals(1f, fann.run(new float[] { -1, 1 })[0], .2f);
	assertEquals(1f, fann.run(new float[] { 1, -1 })[0], .2f);
	assertEquals(-1f, fann.run(new float[] { 1, 1 })[0], .2f);
	fann.close();
    }

}
