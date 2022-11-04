package az.developia.springfiltering.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class VideoStreamingService {
	private static final String FORMAT = "file:C:/java4/%s";

	@Autowired
	ResourceLoader resourceLoader;

	public Mono<Resource> getVideo(String title) {
		return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(FORMAT, title)));
	}

}
