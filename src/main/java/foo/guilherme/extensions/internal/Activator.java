/*
 *  Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package foo.guilherme.extensions.internal;

import foo.guilherme.extensions.handler.LoginReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.wso2.carbon.identity.event.handler.AbstractEventHandler;

/**
 * This is a sample bundle activator class.
 *
 * @since 1.0-SNAPSHOT
 */
public class Activator implements BundleActivator {
    private static final Logger log = LogManager.getLogger(LoginReporter.class.getName());

    /**
     * This is called when the bundle is started.
     *
     * @param bundleContext BundleContext of this bundle
     * @throws Exception Could be thrown while bundle starting
     */
    public void start(BundleContext bundleContext) throws Exception {
        log.info("Starting self registration");
        try {
            bundleContext.registerService(AbstractEventHandler.class.getName(), new LoginReporter(), null);
            log.info("Successfully registered the service");
        } catch (Exception e) {
            log.error("Error during self registration", e);
        }

    }

    /**
     * This is called when the bundle is stopped.
     *
     * @param bundleContext BundleContext of this bundle
     * @throws Exception Could be thrown while bundle stopping
     */
    public void stop(BundleContext bundleContext) throws Exception {
    }
}
