package com.grachro.util;

import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.grachro.util.ClassUtils;

public class ClassUtilsTest extends ClassUtils {

	@Test
	public void testLoadClasses() throws IOException {
		List<Class<?>> classList = ClassUtils.loadClasses("sample.script");
		assertFalse(classList.isEmpty());
	}

}
