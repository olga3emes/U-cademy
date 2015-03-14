/* InvoiceToStringConverter.java
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Invoice;

@Component
@Transactional
public class InvoiceToStringConverter implements
		Converter<Invoice, String> {

	@Override
	public String convert(Invoice invoice) {
		String result;

		if (invoice == null)
			result = null;
		else
			result = String.valueOf(invoice.getId());

		return result;
	}

}
