package countries;

import java.util.List;

public class CountryMain {
	public static void main(String[] args) {

		CountryDAO c = new CountryDAO();
		List<Country> clist = c.getCountryList();

		for (Country con : clist) {
			System.out.println(con);
		}
		Country country = new Country();


	}
}