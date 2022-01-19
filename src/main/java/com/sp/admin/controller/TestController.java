package com.sp.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/test/v1")
public class TestController {

	@GetMapping(value = "/list")
	public void showTestList(@RequestParam("list") List<String> list) {
		System.out.println(list);
	}
	
	@PostMapping(value = "/map")
	public void showTestMap(@RequestBody() Map<String,Object> map) {
		System.out.println(map);
	}
	
}
