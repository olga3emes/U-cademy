/* FileToStringConverter.java
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

import domain.File;

@Component
@Transactional
public class FileToStringConverter implements
		Converter<File, String> {

	@Override
	public String convert(File file) {
		String result;

		if (file == null)
			result = null;
		else
			result = String.valueOf(file.getId());

		return result;
	}

}
