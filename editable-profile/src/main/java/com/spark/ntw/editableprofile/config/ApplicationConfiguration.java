/**
 * 
 */

package com.spark.ntw.editableprofile.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration class of the Application.
 * <p/>
 * Also used for providing instances of Spring beans.
 * 
 * @author nkurup
 *
 * @created_Date Nov 22, 2018
 *
 */
@Configuration
@EnableTransactionManagement
public class ApplicationConfiguration {

}
