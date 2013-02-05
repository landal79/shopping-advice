package org.shopping.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Preconditions;

public class RegexMatcher {
	
	public static String match(String regex, String text){
		Preconditions.checkArgument(StringUtils.isNotBlank(regex), "regex must be not empty!");
		Preconditions.checkNotNull(text, "text must be not empty!");
		
		Matcher matcher = Pattern.compile(regex, Pattern.MULTILINE).matcher(text);
		
		if (matcher.find()) {
			return matcher.group(1);
		}
		
		return null;
	}

}
