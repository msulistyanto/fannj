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
        assertEquals(-1f, fann.run(new float[]{-1, -1})[0], .2f);
        assertEquals(1f, fann.run(new float[]{-1, 1})[0], .2f);
        assertEquals(1f, fann.run(new float[]{1, -1})[0], .2f);
        assertEquals(-1f, fann.run(new float[]{1, 1})[0], .2f);
        fann.close();
    }
}
