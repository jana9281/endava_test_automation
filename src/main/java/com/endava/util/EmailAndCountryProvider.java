
package com.endava.util;

import org.testng.annotations.DataProvider;

/**
 * @author Aleksandar.Zizovic
 *
 */
public class EmailAndCountryProvider {
	@DataProvider(name = "EmailAndCountryProvider")
	public String[][] getData() {
		return new String[][] { { "Aleksandar.Zizovic@endava.com", "Serbia" },
				{ "Vlatko.Stefanovski@endava.com", "Macedonia" }, { "Adrian.Mutu@endava.com", "Romania" } };
	}
}
