package com.hostmdy.cinema.utility;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClassPathFileLoader {
	
	private final ResourceLoader resourceLoader;
	
	public String getClassPathFileRelativePath(String path) throws IOException {
		Resource resource = resourceLoader.getResource(ResourceUtils.CLASSPATH_URL_PREFIX+path);
		return resource.getFile().getAbsolutePath();
	}

}
