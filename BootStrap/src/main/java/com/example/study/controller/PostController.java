package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {
	@PostMapping("/postMethod")
	public SearchParam PostController(@RequestBody SearchParam searchParam){

		return searchParam;
	}

	@PutMapping
	public void put(){

	}

	@PatchMapping
	public void patch(){
		
	}
}