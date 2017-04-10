/*-
 * #%L
 * BroadleafCommerce MYMODULE
 * %%
 * Copyright (C) 2009 - 2017 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt).
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of Broadleaf Commerce, LLC
 * The intellectual and technical concepts contained
 * herein are proprietary to Broadleaf Commerce, LLC
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Broadleaf Commerce, LLC.
 * #L%
 */
package com.broadleafcommerce.MYMODULE.config;

import org.broadleafcommerce.common.extensibility.context.merge.Merge;
import org.broadleafcommerce.common.logging.LifeCycleEvent;
import org.broadleafcommerce.common.logging.ModuleLifecycleLoggingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author
 */
@Configuration("blMYMODULEModuleConfig")
public class MYMODULEConfig {

    @Bean
    public static ModuleLifecycleLoggingBean blMYMODULELifecycleBean() {
        return new ModuleLifecycleLoggingBean(MYMODULEModuleRegistration.MODULE_NAME, LifeCycleEvent.LOADING);
    }

    @Merge(targetRef = "blMergedPersistenceXmlLocations", early = true)
    public List<String> blMYMODULEPersistenceXmlLocations() {
        return Arrays.asList("classpath*:/META-INF/persistence-MYMODULE.xml");
    }
    
    @Merge(targetRef = "blMergedEntityContexts", early = true)
    public List<String> blMYMODULEEntityContexts() {
        return Arrays.asList("classpath:bl-MYMODULE-applicationContext-entity.xml");
    }

    @Merge(targetRef = "blMergedCacheConfigLocations", early = true)
    public List<String> blMYMODULEEhcache() {
        return Arrays.asList("classpath:bl-MYMODULE-ehcache.xml");
    }
}
