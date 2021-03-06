/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.ark.container.service;

import com.alipay.sofa.ark.container.BaseTest;
import com.alipay.sofa.ark.container.pipeline.StandardPipeline;
import com.alipay.sofa.ark.spi.pipeline.Pipeline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ruoshan
 * @since 0.1.0
 */
public class ArkServiceContainerTest extends BaseTest {

    private ArkServiceContainer arkServiceContainer;

    @Before
    public void before() {
        arkServiceContainer = new ArkServiceContainer();
    }

    @Test
    public void testStart() {
        arkServiceContainer.start();
        Assert.assertTrue(arkServiceContainer.isStarted());
        Assert.assertTrue(arkServiceContainer.isRunning());
    }

    @Test
    public void testStop() {
        arkServiceContainer.start();
        arkServiceContainer.stop();
        Assert.assertFalse(arkServiceContainer.isRunning());
    }

    @Test
    public void testGetService() {
        arkServiceContainer.start();
        Pipeline pipeline = arkServiceContainer.getService(Pipeline.class);
        Assert.assertNotNull(pipeline);
        Assert.assertTrue(pipeline instanceof StandardPipeline);
    }

}