import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DateModified {
	static int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	int m;
	int d;
	int y;

	String currentpath = System.getProperty("user.dir");
	File tempFile0 = new File(currentpath + "\\data");
	File temp23 = new File(tempFile0 + "\\extra");
	File file23 = new File(temp23, "2023.dll");
	String conf[] = new String[10];

	DateModified(int d, int m, int y) {
		this.d = d;
		this.m = m;
		this.y = y;
	}

	int dayFromIndex(int index) {
		int indexMonths[] = new int[12];
		indexMonths[0] = daysInMonth[0];
		for (int i = 1; i < 12; i++)
			indexMonths[i] = daysInMonth[i] + indexMonths[i - 1];

		int indexTrue = 0;
		while (indexTrue < 12) {
			if (index < indexMonths[indexTrue])
				break;
			indexTrue++;
		}
		int day;
		if (indexTrue == 0)
			day = 0;
		else
			day = index - indexMonths[indexTrue - 1] + 1;

		return day;
	}

	int maxDays() {
		int md = daysInMonth[m - 1];

		return md;
	}

	int index() {
		int index = 0;
		for (int i = 0; i < m - 1; i++)
			index += daysInMonth[i];
		return index;
	}

	DateModified addDays(int n) {
		int d = this.d += n;
		int m = this.m;
		int y = this.y;
		while (d > maxDays()) {
			d = d - maxDays();
			m++;
			if (m > 12) {
				y++;
				m = 1;
			}
		}
		return new DateModified(d, m, y);
	}

	int whatMonthsToAdd() {// return number of months to be added -1
		int k = 0;
		DateModified date = new DateModified(1, 1, y);
		int index = this.index();
		while (date.index() < index) {
			k++;
			date = new DateModified(1, k + 1, y);
		}
		return k;
	}

	String getMonthForInt(int num, int language) {
		String months[][] = {
				{ "enero", "febrero", "marzo", "Abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre",
						"noviembre", "diciembre" },
				{ "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro",
						"Novembro", "Dezembro" },
				{ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
						"November", "December" },
				{ "janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre",
						"novembre", "décembre" } };
		return months[language][num].toUpperCase();
	}

	// Save the new total to 2023
	void saveTotal23(int total) {
		// save what will rest for tmrw
		BufferedReader data23 = null;
		String l23 = "";
		tempFile0.mkdir();
		File temp23 = new File(tempFile0 + "\\extra");
		temp23.mkdir();
		File file23 = new File(temp23, y + ".dll");
		ArrayList<String> con23 = new ArrayList<>();
		try {// open the data for 2023
			data23 = new BufferedReader(new FileReader(file23));
			while ((l23 = data23.readLine()) != null) {
				con23.add(l23.toString());
			}
			data23.close();
		} catch (Exception e) {
		}
		try {// save the data
			FileWriter save23 = new FileWriter(file23);
			int count = con23.size();
			for (String element : con23)
				save23.write(element + System.lineSeparator());
			count = con23.size();
			while (count++ < (this.index() + Integer.valueOf(d) - 1))// write the days off
				save23.write(0 + System.lineSeparator());
			if (count == (index() + Integer.valueOf(d)))
				save23.write(total + System.lineSeparator());// write the current day
			save23.close();
		} catch (Exception e2) {
		}
	}
}
