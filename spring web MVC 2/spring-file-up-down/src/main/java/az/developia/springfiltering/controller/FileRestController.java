package az.developia.springfiltering.controller;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import az.developia.springfiltering.service.VideoStreamingService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/files")
@CrossOrigin(origins = "*")
public class FileRestController {

	// upload
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, path = "/upload")
	public void upload(@RequestParam(name = "fayl") MultipartFile fayl) throws Exception {

		String filename = fayl.getOriginalFilename();

		InputStream i = fayl.getInputStream();

		UUID uuid = UUID.randomUUID();
		String s = uuid.toString(); // milyon defe kodu tekrar tekrar cagirsaq hec vaxt eyni deyerleri vermir,
		// ferqli unicode-lar cagirir.

		int i1 = filename.lastIndexOf(".");
		String fileNameWithoutExt = filename.substring(0, i1);
		filename = filename.replaceAll(fileNameWithoutExt, s);

		// 1-ci parametr neyi kopyalayacagini
		// 2-ci parametr hara kopyalayacagini
		// 3-cu parametr eger kopyaladigi yerde teze fayl movcuddursa ona verdiyimiz
		// emri edir
		Files.copy(i, Paths.get("C:/java4/" + filename), StandardCopyOption.REPLACE_EXISTING);

	}

	@GetMapping("/download/{filename:.+}")
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws Exception {

		Resource file = loadAsResource(filename);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {

			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	final Path rootLocation = Paths.get("C:/java4");

	@Autowired
	VideoStreamingService videoStreamingService;

	@GetMapping(path = "/video/{title}", produces = "video/mp4")
	public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader String range) {
		System.out.println("range :" + range);

		File f = new File("C:/java4/" + title);
		if (f.exists() && !f.isDirectory()) {

		} else {
			throw new RuntimeException("Video tapilmadi!");
		}

		return videoStreamingService.getVideo(title);
	}
}