package hello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.spring.guides.gs_producing_web_service.Customer;

@Component
public class CustomerRepository {
	private static final List<Customer> customers = new ArrayList<>();

	@PostConstruct
	public void initData() throws ParseException, DatatypeConfigurationException {
		GregorianCalendar cal = new GregorianCalendar();
		Date dob1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/07/1950");
		Date dob2 = new SimpleDateFormat("dd/MM/yyyy").parse("15/10/1948");
		Date dob3 = new SimpleDateFormat("dd/MM/yyyy").parse("20/01/1952");
		DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();

		Customer cust1 = new Customer();
		cust1.setNino("AA111111A");
		cust1.setFirstName("Samba");
		cust1.setLastName("Mitra");
		cal.setTime(dob1);
		cust1.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));

		Customer cust2 = new Customer();
		cust1.setNino("AB123456B");
		cust1.setFirstName("Faran");
		cust1.setLastName("Kardame");
		cal.setTime(dob2);
		cust1.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));

		Customer cust3 = new Customer();
		cust1.setNino("BB223344C");
		cust1.setFirstName("Meera");
		cust1.setLastName("Varma");
		cal.setTime(dob3);
		cust1.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));

		this.customers.add(cust1);
		this.customers.add(cust2);
		this.customers.add(cust3);
	}

	public Customer findCustomer(String nino) {
		Assert.notNull(nino);

		for (Customer customer : this.customers) {
			if (customer.getNino().equalsIgnoreCase(nino)) {
				return customer;
			}
		}

		return null;

	}
}
