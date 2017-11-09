
package com.spring.couchbase.SpringCouchbaseDemo.repository;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import com.spring.couchbase.SpringCouchbaseDemo.document.User;


public interface UserRepository extends CouchbaseRepository<User, String> {

}
