package com.classicModels.managers;

import com.classicModels.DTO.CustomersDTO;
import com.classicModels.DTO.EmployeesDTO;
import com.classicModels.DTO.LoginsDTO;
import com.classicModels.DTO.OfficesDTO;
import com.classicModels.DTO.OrderDetailsDTO;
import com.classicModels.DTO.OrdersDTO;
import com.classicModels.DTO.PaymentsDTO;
import com.classicModels.DTO.ProductLinesDTO;
import com.classicModels.DTO.ProductsDTO;
import com.classicModels.DTO.RegistrationDTO;

/**
 * Retourne un bean
 * 
 * 
 * <code>CustomersDTO dto = ManagerFactory.getCustomers();</code>
 * <code>ManagerFactory.update();</code>
 * 
 * @author Olivier
 *
 */
public class ManagerFactory {

	public static CustomersDTO getCustomers() {
		return new CustomersDTO();
	}

	public static LoginsDTO getlogins() {
		return new LoginsDTO();
	}

	public static EmployeesDTO GetEmployees() {

		return new EmployeesDTO();
	}

	public static OrdersDTO getOrders() {
		// TODO Auto-generated method stub
		return new OrdersDTO();
	}

	public static ProductLinesDTO getproductsline() {

		return new ProductLinesDTO();
	}

	public static ProductsDTO getProducts() {

		return new ProductsDTO();
	}

	public static OrderDetailsDTO getOrderDetails() {

		return new OrderDetailsDTO();
	}

	public static OfficesDTO getOffices() {

		return new OfficesDTO();
	}

	public static PaymentsDTO getPayments() {
		return new PaymentsDTO();
	}

	public static RegistrationDTO getRegistration() {
		return new RegistrationDTO();
	}
}