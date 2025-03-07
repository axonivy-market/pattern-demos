package com.axonivy.demo.patterndemos.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.axonivy.demo.patterndemos.placeholder.ReplacementService;

import ch.ivyteam.ivy.environment.IvyTest;

@IvyTest
public class ReplacementServiceTest {

	@Test
	public void test1() {
		var svc = ReplacementService.get();
		assertThat(svc.replacePlaceholders("This is a {{complexity}} test.", Map.of("complexity", "simple"))).isEqualTo("This is a simple test.");
	}
}
