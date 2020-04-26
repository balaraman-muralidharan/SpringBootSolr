/**
 * 
 */
package com.javasampleapproach.solr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.solr.model.Customer;

/**
 * @author Dinesh.Rajput
 *
 */
@Repository 
public interface SolrOrderRepository extends SolrCrudRepository<Customer, Long> {
	
	Customer findByid(String id);
	
    //@Query("odesc:*?0*")
    //Page<Customer> findByOrderDescription(String searchTerm, Pageable pageable);
    
    //@Query("odesc:*?0* OR oname:*?0* OR pname:*?0*")
    //Page<Customer> findByCustomerQuery(String searchTerm, Pageable pageable);
 
   // @Query(name = "Order.findByNamedQuery")
   // Page<Customer> findByNamedQuery(String searchTerm, Pageable pageable);
}
