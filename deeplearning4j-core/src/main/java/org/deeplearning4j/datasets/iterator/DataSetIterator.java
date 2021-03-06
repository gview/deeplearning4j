/*
 * Copyright 2015 Skymind,Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.deeplearning4j.datasets.iterator;

import org.nd4j.linalg.dataset.DataSet;

import java.io.Serializable;
import java.util.Iterator;



/**
 * A DataSetIterator handles
 * traversing through a dataset and preparing
 * 
 * data for a neural network.
 * 
 * Typical usage of an iterator is akin to:
 * 
 * DataSetIterator iter = ..;
 * 
 * while(iter.hasNext()) {
 *     DataSet d = iter.next();
 *     //iterate network...
 * }
 * 
 * 
 * For custom numbers of examples/batch sizes you can call:
 * 
 * iter.next(num)
 * 
 * where num is the number of examples to fetch
 * 
 * 
 * @author Adam Gibson
 *
 */
public interface DataSetIterator extends Iterator<DataSet>,org.nd4j.linalg.dataset.api.iterator.DataSetIterator,Serializable {
}
