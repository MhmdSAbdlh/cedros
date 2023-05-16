public class Date {
	static int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	int m;
	int d;
	int y;

	Date(String date) {
		// parse and get int fields
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
}
