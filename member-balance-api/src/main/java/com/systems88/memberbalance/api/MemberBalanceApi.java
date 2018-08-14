package com.systems88.memberbalance.api;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

/**
 * 
 * @author Jeriel Kenneth L. Gallofin
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.systems88.memberbalance.api", "com.systems88.memberbalance.core" })
@EntityScan(basePackages = { "com.systems88.memberbalance.core.persistence.entities" })
public class MemberBalanceApi extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(MemberBalanceApi.class);

	public static void main(String[] args) {
		SpringApplication.run(MemberBalanceApi.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MemberBalanceApi.class);
	}

	//Solution to “Tomcat can’t stop [Abandoned connection cleanup thread]” during tomcat shutdown
	@Bean
	protected ServletContextListener listener() {

		return new ServletContextListener() {

			@Override
			public void contextInitialized(ServletContextEvent sce) {
				log.info("Initialising Context...");
			}

			@Override
			public final void contextDestroyed(ServletContextEvent sce) {
				log.info("Destroying Context...");
				try {
					log.info("Calling MySQL AbandonedConnectionCleanupThread shutdown");
					AbandonedConnectionCleanupThread.shutdown();
				} catch (InterruptedException e) {
					log.error("Error calling MySQL AbandonedConnectionCleanupThread shutdown {}", e);
					Thread.currentThread().interrupt();
				}

				ClassLoader cl = Thread.currentThread().getContextClassLoader();
				Enumeration<Driver> drivers = DriverManager.getDrivers();
				while (drivers.hasMoreElements()) {
					Driver driver = drivers.nextElement();
					log.info("Driver found : " + driver.getClass().getName());
					if (driver.getClass().getClassLoader() == cl) {
						try {
							log.info("Deregistering JDBC driver {}", driver);
							DriverManager.deregisterDriver(driver);
						} catch (SQLException ex) {
							log.error("Error deregistering JDBC driver {}", driver, ex);
						}
					} else {
						log.trace("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader",
								driver);
					}
				}
			}
		};
	}

}
