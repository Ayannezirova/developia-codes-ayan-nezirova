package az.developia.springrestayaan.exporter;

public class Exporter {

	// dumpPath - mysql bazanı export eden, mysql qurulanda ustunde hazir gelen
	// proqramin linkidir
	// username - mysql username-dir
	// pass - mysql password-dur
	// dbName - export etmek istediyimiz bazanin adidir
	// sqlPath - hara export edeceyimizdir
	public void backUp(String dumpPath, String username, String pass, String dbName, String sqlPath) {
		Process p = null;

		try {
			Runtime runtime = Runtime.getRuntime();
			p = runtime.exec(
					dumpPath + " -u" + username + " -p" + pass + " --add-drop-database -B" + dbName + " -r" + sqlPath);
			int completed = p.waitFor();
			if (completed == 0) {
				System.out.println("success export --" + dbName);
			} else {
				System.out.println("failed --" + dbName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
