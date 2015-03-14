/* GroupToStringConverter.java
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

import domain.Group;

@Component
@Transactional
public class GroupToStringConverter implements
		Converter<Group, String> {

	@Override
	public String convert(Group group) {
		String result;

		if (group == null)
			result = null;
		else
			result = String.valueOf(group.getId());

		return result;
	}

}
