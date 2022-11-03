package az.developia.springrestayaan.scheduler;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import az.developia.springrestayaan.db.DBConfig;
import az.developia.springrestayaan.db.ReadDB;
import az.developia.springrestayaan.exporter.Exporter;

@Service
public class MyScheduler {

	@Autowired
	DBConfig dbConfig;

	String username = "root";
	String pass = "1234";
	String env = "ucuzluq";
	int sleepMillis = 172_800_000;

	Exporter exporter = new Exporter();
	ReadDB readDatabases = new ReadDB();

	int counter = 0;

	// @Scheduled(fixedDelay = 5000)
	public void backupDatabase() {

		List<String> dbNames = readDatabases.readDbNames("root", "1234");

		dbNames.remove("sys");
		dbNames.remove("mysql");
		dbNames.remove("information_schema");
		dbNames.remove("performance_schema");

		System.out.println(dbNames);
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();

		String dbfolderName = env + "_db_" + year + "_" + month + "_" + day + "_" + hour + "_" + minute + "_" + second;

		System.out.println(dbfolderName);

		String dumpPath = "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump.exe";

		File folder = new File("C:\\java4\\" + dbfolderName);
		folder.mkdir();

		for (String string : dbNames) {
			exporter.backUp(dumpPath, username, pass, string, "C:\\java4\\" + dbfolderName + "\\" + string + ".sql");
		}

		counter++;
		System.out.println("" + counter + "-sayli export bitdi");
	}

	@Scheduled(fixedDelay = 1000)
	void test() {
		dbConfig.connect();

	}

}
