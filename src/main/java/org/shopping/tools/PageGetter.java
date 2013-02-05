package org.shopping.tools;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.base.Preconditions;

public class PageGetter {
	
	private static final String ISO_8859_1 = "iso-8859-1";

	public static String getWebPage(String pageUrl) throws MalformedURLException, IOException {
		Preconditions.checkArgument(StringUtils.isNotBlank(pageUrl), "page url must be not empty!");		
		return IOUtils.toString(new URL(pageUrl),ISO_8859_1);
	}

}
