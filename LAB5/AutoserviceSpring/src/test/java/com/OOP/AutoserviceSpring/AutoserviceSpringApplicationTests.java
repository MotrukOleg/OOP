package com.OOP.AutoserviceSpring;

import com.OOP.AutoserviceSpring.model.Customer;
import com.OOP.AutoserviceSpring.repository.CustomerRepository;
import com.OOP.AutoserviceSpring.service.CustomerService;
import com.OOP.AutoserviceSpring.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertNull;


@SpringBootTest
class CustomerServiceApplicationTests {

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerServiceImpl customerService;
	private static Customer testcustomer;

	@BeforeEach
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		testcustomer.setFirstname("John");
		testcustomer.setLastname("Doe");
		testcustomer.setPhone("1234567890");
		testcustomer.setEmail("olegmotruk");
		testcustomer.setTimeofapplication("2021-10-10");
	}

	@Test
	void saveCustomerSuccessfultest(){

		//arrange
		when(customerService.saveCustomer(testcustomer)).thenReturn(testcustomer);

		//act
		customerService.saveCustomer(testcustomer);

		//assert
		assertEquals(testcustomer, customerService.saveCustomer(testcustomer));
	}

	@Test
	void saveCustomerFailTest(){

		//arrange
		when(customerService.saveCustomer(testcustomer)).thenReturn(null);

		//act
		customerService.saveCustomer(testcustomer);

		//assert
		assertNull(null, customerService.saveCustomer(testcustomer));
	}


	@Test
	void findByNameSuccessTest() {

		//arrange
		when(customerService.findByName("John")).thenReturn(testcustomer);

		//act
		Customer foundCustomer = customerService.findByName("John");

		//assert
		assertEquals("John" , foundCustomer.getFirstname());
	}

	@Test
	void findByNameFailTest(){

		//arrange
		when(customerService.findByName("John")).thenReturn(null);

		//act
		Customer foundCustomer = customerService.findByName("John");

		//assert
		assertNull(null, foundCustomer);
	}

	@Test
	void updateCustomerSuccessTest(){

		//arrange
		when(customerService.updateCustomer(testcustomer)).thenReturn(testcustomer);

		//act
		Customer UpdatedCustomer = customerService.updateCustomer(testcustomer);

		//assert
		assertEquals(testcustomer , UpdatedCustomer);
	}

	@Test
	void updateCustomerFailTest(){

		//arrange
		when(customerService.updateCustomer(testcustomer)).thenReturn(null);

		//act
		Customer UpdatedCustomer = customerService.updateCustomer(testcustomer);

		//assert
		assertNull(null , UpdatedCustomer);
	}

	@Test
	void deleteCustomerSuccessfulTest(){

		//arrange
		String CustomerName = "John";
		CustomerService customerService = Mockito.mock(CustomerService.class);
		doNothing().when(customerService).deleteCustomerApplication(CustomerName);

		//act
		customerService.deleteCustomerApplication(CustomerName);

		//assert
		verify(customerService, times(1)).deleteCustomerApplication(CustomerName);
	}

	@Test
	void deleteCustomerFailTest() {

		//arrange
		String CustomerName = testcustomer.getFirstname();
		CustomerService customerService = Mockito.mock(CustomerService.class);
		when(customerService.findByName(CustomerName)).thenReturn(null);


		//act
		customerService.deleteCustomerApplication(CustomerName);

		//assert
		verify(customerService, times(1)).deleteCustomerApplication(CustomerName);
	}
}

