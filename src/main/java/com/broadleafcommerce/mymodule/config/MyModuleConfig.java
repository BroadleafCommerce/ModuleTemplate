/*-
 * #%L
 * BroadleafCommerce My Module
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
package com.broadleafcommerce.mymodule.config;

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
@Configuration("blMyModuleModuleConfig")
public class MyModuleConfig {

    @Bean
    public static ModuleLifecycleLoggingBean blMyModuleLifecycleBean() {
        return new ModuleLifecycleLoggingBean(MyModuleModuleRegistration.MODULE_NAME, LifeCycleEvent.LOADING);
    }

    @Merge(targetRef = "blMergedPersistenceXmlLocations", early = true)
    public List<String> blMyModulePersistenceXmlLocations() {
        return Arrays.asList("classpath*:/META-INF/persistence-my-module.xml");
    }
    
    @Merge(targetRef = "blMergedEntityContexts", early = true)
    public List<String> blMyModuleEntityContexts() {
        return Arrays.asList("classpath:bl-my-module-applicationContext-entity.xml");
    }

    @Merge(targetRef = "blMergedCacheConfigLocations", early = true)
    public List<String> blMyModuleEhcache() {
        return Arrays.asList("classpath:bl-my-module-ehcache.xml");
    }
}
