package com.demo.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.TvDto;
import com.demo.dto.WatchesDto;
import com.demo.entity.TvEntity;
import com.demo.entity.WatchEntity;
import com.demo.repository.TvRepository;
import com.demo.repository.WatchRepository;
import com.demo.service.ProductService;
@RestController
@RequestMapping("/ecom")
public class ProductJsonController {
	@Autowired
	private WatchRepository watchRepo;
	
	@Autowired
	private TvRepository tvRepo;
	@Autowired
	private ProductService productsService;
	@GetMapping(value="/getAllWatches")
	public List<WatchEntity> getAllWatches()
	{
	List<WatchEntity> watch = watchRepo.findAll();
	return watch;
	}
	@PostMapping(value="/saveWatches")
	public JSONObject saveWatches(@RequestBody WatchEntity watch) {
	WatchEntity save = watchRepo.save(watch);
	if(save!=null)
	{
	JSONObject response = productsService.productsResponse("ok","Watches Details are Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	else
	{
	JSONObject response = productsService.productsResponse("Not ok","Watches Details are NOT Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}


	}
	@PutMapping(value="/updateWatches/{productId}")
	public JSONObject updateWatch(@RequestBody WatchesDto watchDto,@PathVariable int productId)
	{
	WatchEntity watch=new WatchEntity();
	
	String Model = watchDto.getModel();
	String Brand = watchDto.getBrand();
	String colour = watchDto.getColour();
	String price = watchDto.getPrice();
	watch.setModel(Model);
	watch.setBrand(Brand);
	watch.setColour(colour);
	
	watch.setPrice(productId);
	WatchEntity save = watchRepo.save(watch);
	if(save!=null)
	{
	JSONObject response = productsService.productsResponse("ok","Watch Details are Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	else
	{
	JSONObject response = productsService.productsResponse("Not ok","Watch Details are NOT Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}

	}
	@DeleteMapping(value="/deleteWatches/{id}")
	public void delateWatch(@PathVariable int id)
	{
	watchRepo.deleteById(id);
	}
	@GetMapping(value="/getTvs")
	public List<TvEntity> getAllTvs()
	{
	List<TvEntity> tvs = tvRepo.findAll();
	return tvs;
	}
	@PostMapping(value="/saveTvs")
	public JSONObject saveTvs(@RequestBody TvEntity tv) {
	TvEntity save = tvRepo.save(tv);
	if(save!=null)
	{
	JSONObject response = productsService.productsResponse("ok","Tv Details are Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	else
	{
	JSONObject response = productsService.productsResponse("Not ok","Tv Details are NOT Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}

	}
	@PutMapping(value="/updateTvs/{productId}")
	public JSONObject updateTvs(@RequestBody TvDto tvDto,@PathVariable int productId)
	{
	TvEntity tv=new TvEntity();
	String Model = tvDto.getModel();
	String brand = tvDto.getBrand();
	String colour = tvDto.getColour();
	int price = tvDto.getPrice();
	tv.getModel();
	tv.getBrand();
	tv.getColour();
	tv.getPrice();
	TvEntity save = tvRepo.save(tv);
	if(save!=null)
	{
	JSONObject response = productsService.productsResponse("ok","Tv Details are Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	else
	{
	JSONObject response = productsService.productsResponse("Not ok","Tv Details are NOT Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}

	}
	

	@DeleteMapping(value="/deleteTvs/{id}")
	public JSONObject delateTvs(@PathVariable int id)
	{
	tvRepo.deleteById(id);
	JSONObject response = productsService.productsResponse("ok","Tv recdord getting deleted" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}

}


