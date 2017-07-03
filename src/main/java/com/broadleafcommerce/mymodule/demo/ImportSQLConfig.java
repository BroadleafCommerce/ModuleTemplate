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
package com.broadleafcommerce.mymodule.demo;

import org.broadleafcommerce.common.demo.AutoImportPersistenceUnit;
import org.broadleafcommerce.common.demo.AutoImportSql;
import org.broadleafcommerce.common.demo.AutoImportStage;
import org.broadleafcommerce.common.demo.DemoCondition;
import org.broadleafcommerce.common.demo.ImportCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 */
@Configuration("blMyModuleData")
@Conditional(ImportCondition.class)
public class ImportSQLConfig {

    @Bean
    public AutoImportSql blMyModuleSecurity() {
        return new AutoImportSql(AutoImportPersistenceUnit.BL_PU, "config/bc/sql/load_my_module_admin_security.sql", AutoImportStage.PRIMARY_MODULE_SECURITY);
    }

    @Bean
    @Conditional(DemoCondition.class)
    public AutoImportSql blMyModuleDemoData() {
        return new AutoImportSql(AutoImportPersistenceUnit.BL_PU,"config/bc/sql/samples/load_my_module_demo_data.sql", AutoImportStage.PRIMARY_BASIC_DATA);
    }
}
