import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Date {
	static int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	int m;
	int d;
	int y;

	String currentpath = System.getProperty("user.dir");
	File tempFile0 = new File(currentpath + "\\data");
	File newFile = new File(tempFile0, "conf.dll");
	String conf[] = new String[10];

	Date(String date) {
		// Open Conf
		tempFile0.mkdir();
		BufferedReader dataOpened = null;
		String line = "";
		int z = 0;
		try {
			dataOpened = new BufferedReader(new FileReader(newFile));
			while ((line = dataOpened.readLine()) != null) {
				conf[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
		} 
	}

	Date(int d, int m, int y) {
		this.d = d;
		this.m = m;
		this.y = y;
	}

	int maxDays() {
		int md = daysInMonth[m - 1];
		// correction for Feb
		return md;
	}

	int index() {
		int index = 0;
		for (int i = 0; i < m - 1; i++) {
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
		Date date = new Date(d, m, y);
		int index = date.index();
		int returned[] = { 0, 0 };
		String appV;
		if (conf[0] == null || !conf[0].equals("3"))
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
		for (int i = index; i < index + date.maxDays(); i++) {
			if (First.isNumeric(value22[i])) {
				returned[0] += Integer.valueOf(value22[i]);
				if (Integer.valueOf(value22[i]) != 0)
					returned[1]++;
			}
		}
		return returned;
	}

	int[] totalOfMes() {
		Date date = new Date(d, m, y);
		int index = date.index();
		int returned[] = { 0, 0 };
		String value23[] = new String[366];
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
		for (int i = index; i < index + date.maxDays(); i++) {
			if (i < value23.length && First.isNumeric(value23[i])) {
				returned[0] += Integer.valueOf(value23[i]);
				if (Integer.valueOf(value23[i]) != 0)
					returned[1]++;
			}
		}
		return returned;
	}

}
