/* InscriptionToStringConverter.java
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

import domain.Inscription;

@Component
@Transactional
public class InscriptionToStringConverter implements
		Converter<Inscription, String> {

	@Override
	public String convert(Inscription inscription) {
		String result;

		if (inscription == null)
			result = null;
		else
			result = String.valueOf(inscription.getId());

		return result;
	}

}
