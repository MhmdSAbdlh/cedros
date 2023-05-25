import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JOptionPane;

public class Date {
	static int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	int m;
	int d;
	int y;

	String currentpath = System.getProperty("user.dir");
	File tempFile0 = new File(currentpath + "\\data");
	File temp23 = new File(tempFile0 + "\\extra");
	File file23 = new File(temp23, "2023.dll");
	String conf[] = new String[10];

	Date(String date) {
	}

	Date(int d, int m, int y) {
		this.d = d;
		this.m = m;
		this.y = y;
	}

	private String dayName(Date d, int lang) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, d.d);
		calendar.set(Calendar.MONTH, d.m);
		calendar.set(Calendar.YEAR, d.y);

		return lang == 0 ? new SimpleDateFormat("EEEEE", new Locale("es")).format(calendar.getTime()).toUpperCase()
				: lang == 1 ? new SimpleDateFormat("EEEE", new Locale("pt")).format(calendar.getTime()).toUpperCase()
						: new SimpleDateFormat("EEEEE", new Locale("en")).format(calendar.getTime()).toUpperCase();
	}

	int dayFromIndex(int index, int lang) {
		int indexMonths[] = new int[12];
		indexMonths[0] = daysInMonth[0];
		for (int i = 1; i < 12; i++) {
			if (i == 1)
				if ((y % 4 == 0) && !(y % 100 == 0) || (y % 400 == 0))
					indexMonths[i] = 29 + indexMonths[i - 1];
				else
					indexMonths[i] = daysInMonth[i] + indexMonths[i - 1];
			else
				indexMonths[i] = daysInMonth[i] + indexMonths[i - 1];
		}

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

	int monthFromIndex(int index) {
		int indexMonths[] = new int[12];
		indexMonths[0] = daysInMonth[0];
		for (int i = 1; i < 12; i++) {
			if (i == 1)
				if ((y % 4 == 0) && !(y % 100 == 0) || (y % 400 == 0))
					indexMonths[i] = 29 + indexMonths[i - 1];
				else
					indexMonths[i] = daysInMonth[i] + indexMonths[i - 1];
			else
				indexMonths[i] = daysInMonth[i] + indexMonths[i - 1];
		}
		int indexTrue = 0;
		while (indexTrue < 12) {
			if (index < indexMonths[indexTrue])
				break;
			indexTrue++;
		}

		return indexTrue + 1;
	}

	int maxDays() {
		int md = daysInMonth[m - 1];
		// correction for Feb
		if (m == 2)
			if ((y % 4 == 0) && !(y % 100 == 0) || (y % 400 == 0))
				md = 29;
			else
				md = 28;

		return md;
	}

	int index() {
		int index = 0;
		for (int i = 0; i < m - 1; i++) {
			if (i == 1)
				if ((y % 4 == 0) && !(y % 100 == 0) || (y % 400 == 0))
					index += 29;
				else
					index += 28;
			else
				index += daysInMonth[i];
		}
		return index;
	}

	Date addDays(int n) {
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
		return new Date(d, m, y);
	}

	int[] totalOfMes22() {
		int index = this.index();
		int returned[] = { 0, 0 };
		String appV;
		if (First.conf[0] == null || !First.conf[0].equals("3"))
			appV = "2022C.dll";
		else
			appV = "2022N.dll";
		String value22[] = new String[366];
		try {
			BufferedReader dataOpened = new BufferedReader(
					new InputStreamReader(this.getClass().getResourceAsStream("/extra/" + appV)));
			String line = "";
			int z = 0;
			while ((line = dataOpened.readLine()) != null) {
				value22[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
		}
		for (int i = index; i < index + this.maxDays(); i++) {
			if (First.isNumeric(value22[i])) {
				returned[0] += Integer.valueOf(value22[i]);
				if (Integer.valueOf(value22[i]) != 0)
					returned[1]++;
			}
		}
		return returned;
	}

	int[] totalOfMes() {// return the total for this month, and the quantity of days
		int index = this.index();
		int returned[] = { 0, 0 };
		ArrayList<String> con23 = new ArrayList<String>();
		try {// open the data for 2023
			File extraFolder = new File(tempFile0 + "\\extra");
			File extraFile = new File(extraFolder, "2023.dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			String line = "";
			while ((line = dataOpened.readLine()) != null) {
				con23.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane("ERROR!", JOptionPane.ERROR_MESSAGE);
			opt.show();
		}

		for (int i = index; i < index + this.maxDays(); i++) {
			if (i < con23.size() && First.isNumeric(con23.get(i))) {
				returned[0] += Integer.valueOf(con23.get(i));
				if (Integer.valueOf(con23.get(i)) != 0)
					returned[1]++;
			}
		}
		return returned;
	}

	int[] maxMinMes() {// return the max and the min of the month
		int index = this.index();
		int returned[] = { 0, 0, 0, 0 };
		ArrayList<String> con23 = new ArrayList<String>();
		try {// open the data for 2023
			File extraFolder = new File(tempFile0 + "\\extra");
			File extraFile = new File(extraFolder, "2023.dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			String line = "";
			while ((line = dataOpened.readLine()) != null) {
				con23.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane("ERROR!", JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
		int[] valuesMes = new int[this.maxDays()];
		int count = 0;
		for (int i = index; i < index + this.maxDays(); i++) {
			if (i < con23.size())
				if (First.isNumeric(con23.get(i)) && Integer.valueOf(con23.get(i)) != 0)
					valuesMes[count] = Integer.valueOf(con23.get(i));
				else
					valuesMes[count] = avgSellOfDay()[2];
			else
				valuesMes[count] = avgSellOfDay()[2];
			count++;
		}
		returned[0] = getMaxValue(valuesMes)[0];
		returned[1] = getMinValue(valuesMes)[0];
		returned[2] = getMaxValue(valuesMes)[1] + index;
		returned[3] = getMinValue(valuesMes)[1] + index;
		return returned;
	}

	int[] yearMaxMin() {// return the max and the min of the year
		int[] returned = { 0, 0, 0, 0 };
		ArrayList<String> con23 = new ArrayList<String>();
		try {// open the data for 2023
			File extraFolder = new File(tempFile0 + "\\extra");
			File extraFile = new File(extraFolder, "2023.dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			String line = "";
			while ((line = dataOpened.readLine()) != null) {
				con23.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane("ERROR!", JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
		int maxYear[] = new int[whatMonthsToAdd() + 1];
		int minYear[] = new int[whatMonthsToAdd() + 1];
		int maxIndex[] = new int[whatMonthsToAdd() + 1];
		int minIndex[] = new int[whatMonthsToAdd() + 1];
		int maxTotal[] = new int[2];
		int minTotal[] = new int[2];
		int monthIndex = 1;
		Date monthS = new Date(d, monthIndex, y);
		int optOfMonth[] = new int[4];
		for (int i = 0; i < whatMonthsToAdd() + 1; i++) {
			optOfMonth = monthS.maxMinMes();
			maxYear[i] = optOfMonth[0];
			minYear[i] = optOfMonth[1];
			maxIndex[i] = optOfMonth[2];
			minIndex[i] = optOfMonth[3];
			monthIndex++;
			monthS = new Date(d, monthIndex, y);
		}
		maxTotal = getMaxValue(maxYear);
		minTotal = getMinValue(minYear);

		returned[0] = maxTotal[0];
		returned[1] = minTotal[0];
		returned[2] = maxIndex[maxTotal[1]];
		returned[3] = minIndex[minTotal[1]];
		return returned;
	}

	int[][] totalOfMeses() {// return the total for this month, and the quantity of days
		int howMonths = this.whatMonthsToAdd();
		int returned[][] = new int[howMonths][2];
		String value23[] = new String[this.index() + 1];
		try {
			File extraFolder = new File(tempFile0 + "\\extra");
			File extraFile = new File(extraFolder, "2023.dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			String line = "";
			int z = 0;
			while ((line = dataOpened.readLine()) != null) {
				value23[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
		}
		Date date = new Date(1, 1, y);
		if (howMonths == 0)
			return null;
		for (int i = 0; i < howMonths; i++) {
			returned[i][0] = 0;
			returned[i][1] = 0;
			for (int j = 0; j < date.maxDays(); j++) {
				if (First.isNumeric(value23[j + date.index()])) {
					returned[i][0] += Integer.valueOf(value23[j + date.index()]);
					if (Integer.valueOf(value23[j + date.index()]) != 0)
						returned[i][1]++;
				}
			}
			date = new Date(1, i + 2, y);
		}

		return returned;
	}

	int whatMonthsToAdd() {// return number of months to be added -1
		int k = 0;
		Date date = new Date(1, 1, y);
		int index = this.index();
		while (date.index() < index) {
			k++;
			date = new Date(1, k + 1, y);
		}
		return k;
	}

	int[] avgSellOfDay() {
		Date date2 = new Date(1, 1, 2023);
		BufferedReader data23 = null;
		String l23 = "";
		ArrayList<String> con23 = new ArrayList<String>();
		int[] result = { 0, 0, 0 };
		try {// open the data for 2023
			data23 = new BufferedReader(new FileReader(file23));
			while ((l23 = data23.readLine()) != null) {
				con23.add(l23.toString());
			}
			data23.close();
		} catch (Exception e) {
			JOptionPane opt = new JOptionPane("ERROR!", JOptionPane.ERROR_MESSAGE);
			opt.show();
		}
		int i = 0, counter = 0, nbOfDays = 0;
		while (i < con23.size()) {// average of the same days
			if (dayName(this, 0).equals(dayName(date2, 0)))
				if (First.isNumeric(con23.get(i))) {
					counter += Integer.valueOf(con23.get(i));
					nbOfDays++;
				}
			i++;
			date2.addDays(1);
		}
		result[0] = counter / nbOfDays;
		nbOfDays = 0;
		// daily average
		i = 0;
		counter = 0;
		while (i < con23.size()) {
			if (First.isNumeric(con23.get(i))) {
				counter += Integer.valueOf(con23.get(i));
				nbOfDays++;
			}
			i++;
		}
		result[1] = counter / nbOfDays;
		// monthly average
		i = this.index();
		counter = 0;
		nbOfDays = 0;
		while (i < con23.size()) {
			if (First.isNumeric(con23.get(i))) {
				counter += First.isNumeric(con23.get(i)) ? Integer.valueOf(con23.get(i)) : 0;
				nbOfDays++;
			}
			i++;
		}
		result[2] = counter / nbOfDays;

		return result;
	}

	int dailyAverage(int year) {
		int i = 0, nbOfDays = 0;
		int counter = 0;
		String appV;
		ArrayList<String> con23 = new ArrayList<String>();
		if (year == 2022) {
			if (First.conf[0] == null || !First.conf[0].equals("3"))
				appV = "2022C.dll";
			else
				appV = "2022N.dll";
			try {
				BufferedReader dataOpened = new BufferedReader(
						new InputStreamReader(this.getClass().getResourceAsStream("/extra/" + appV)));
				String line = "";
				while ((line = dataOpened.readLine()) != null) {
					con23.add(line.toString());
				}
				dataOpened.close();
			} catch (Exception e) {
			}
		} else {
			// open the data for 2023
			File extraFolder = new File(tempFile0 + "\\extra");
			File extraFile = new File(extraFolder, "2023.dll");
			try {
				BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
				String line = "";
				while ((line = dataOpened.readLine()) != null) {
					con23.add(line.toString());
				}
				dataOpened.close();
			} catch (Exception e) {
			}
		}
		while (i < con23.size()) {
			if (First.isNumeric(con23.get(i))) {
				counter += Integer.valueOf(con23.get(i));
				nbOfDays++;
			}
			i++;
		}
		return (counter / nbOfDays);
	}

	String vend2022(int d) {
		Date date = new Date(1, 1, 2022);
		String date22[] = new String[366];
		String appV;
		if (First.conf[0] == null || !First.conf[0].equals("3"))
			appV = "2022C.dll";
		else
			appV = "2022N.dll";
		for (int i = 0; i < 366; i++) {
			date22[i] = date.d + "" + date.m;
			date = date.addDays(1);
		}
		String value22[] = new String[366];
		try {
			BufferedReader dataOpened = new BufferedReader(
					new InputStreamReader(this.getClass().getResourceAsStream("/extra/" + appV)));
			String line = "";
			int z = 0;
			while ((line = dataOpened.readLine()) != null) {
				value22[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
		}
		int numero = 0;
		for (int i = 0; i < 366; i++) {
			if (Integer.valueOf(date22[i]) == d) {
				numero = i;
				break;
			}
		}
		return value22[numero];
	}

	String getMonthForInt(int num, int language) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, num);
		return language == 0 ? new SimpleDateFormat("MMMM", new Locale("es")).format(calendar.getTime()).toUpperCase()
				: language == 1
						? new SimpleDateFormat("MMMM", new Locale("pt")).format(calendar.getTime()).toUpperCase()
						: new SimpleDateFormat("MMMM", new Locale("en")).format(calendar.getTime()).toUpperCase();

	}

	// getting the maximum value
	private int[] getMaxValue(int[] array) {
		int index[] = { 0, 0 };
		index[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > index[0]) {
				index[0] = array[i];
				index[1] = i;
			}
		}
		return index;
	}

	// getting the miniumum value
	private int[] getMinValue(int[] array) {
		int index[] = { 0, 0 };
		index[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < index[0]) {
				index[0] = array[i];
				index[1] = i;
			}
		}
		return index;
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
		ArrayList<String> con23 = new ArrayList<String>();
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
			for (int i = 0; i < con23.size(); i++)
				save23.write(con23.get(i) + System.lineSeparator());
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
