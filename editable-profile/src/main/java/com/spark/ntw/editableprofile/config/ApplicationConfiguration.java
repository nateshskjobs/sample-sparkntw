/**
 * 
 */
package com.spark.ntw.editableprofile.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author nkurup
 *
 * @created_Date Nov 22, 2018
 *
 */
@Configuration
@EnableJpaRepositories(basePackages= {"com.spark.ntw.editableprofile.repository"})
@EnableTransactionManagement
public class ApplicationConfiguration {

}
