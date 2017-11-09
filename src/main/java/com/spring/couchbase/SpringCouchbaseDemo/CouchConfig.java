package com.spring.couchbase.SpringCouchbaseDemo;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.convert.CustomConversions;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;

@Configuration
@EnableCouchbaseRepositories(basePackages={"com.spring.couchbase.SpringCouchbaseDemo"})
public class CouchConfig extends AbstractCouchbaseConfiguration{

	
	@Value("${couchbase.host}")
	private String couchbaseHost;

	@Value("${couchbase.bucket.password}")
	private String bucketPassword;

	@Value("${couchbase.bucket.name}")
	private String bucketName;

	@Override
	protected List<String> getBootstrapHosts() {
		return Arrays.asList(couchbaseHost);
	}

	@Override
	protected String getBucketName() {
		return this.bucketName;
	}

	@Override
	protected String getBucketPassword() {
		return this.bucketPassword;
	}
	
	@Override
    protected CouchbaseEnvironment getEnvironment() {
        return DefaultCouchbaseEnvironment.builder()
                .connectTimeout(TimeUnit.SECONDS.toMillis(10000))
                .computationPoolSize(6)
                .build();
    }
    
    @Override
    @Bean(name = "org.springframework.data.couchbase.core.convert.customConversions")
    public CustomConversions customConversions() {
        return new CustomConversions(Collections.emptyList());
    }
	
}
