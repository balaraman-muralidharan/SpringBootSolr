package com.javasampleapproach.solr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.solr.model.Customer;
import com.javasampleapproach.solr.repository.SolrOrderRepository;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
public class CustomerController {
	
	@Autowired
	SolrOrderRepository solrOrderRepository;
	
	@PostMapping("/customer")
	public String createOrder(@RequestBody Customer order){
		String description = "Customer Created";
		solrOrderRepository.save(order);
		return description;
	}
	
	@RequestMapping("/customer/{id}")
	public Customer readCustomer(@PathVariable String id){
		System.out.println("Inside Read Customer");
		return solrOrderRepository.findByid(id);
	}
	
	/*@PutMapping("/order")
	public String updateOrder(@RequestBody Customer customer){
		String description = "Customer Updated";
		solrOrderRepository.save(customer);
		return description;
	}*/
	
	/*@GetMapping("/customer/desc/{orderDesc}/{page}")
	public List<Customer> findOrder(@PathVariable String orderDesc, @PathVariable int page){
		return solrOrderRepository.findByOrderDescription(orderDesc, PageRequest.of(page, 2)).getContent();
	}
	
	@GetMapping("/customer/search/{searchTerm}/{page}")
	public List<Customer> findOrderBySearchTerm(@PathVariable String searchTerm, @PathVariable int page){
		return solrOrderRepository.findByCustomerQuery(searchTerm, PageRequest.of(page, 2)).getContent();
	}*/
}
