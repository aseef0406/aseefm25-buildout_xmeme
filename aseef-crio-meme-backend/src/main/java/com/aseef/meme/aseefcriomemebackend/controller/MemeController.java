package com.aseef.meme.aseefcriomemebackend.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aseef.meme.aseefcriomemebackend.model.Meme;
import com.aseef.meme.aseefcriomemebackend.services.MemeServices;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping(value="/api")
public class MemeController {
	
	@Autowired
	MemeServices myservice ;
	//@CrossOrigin
	@GetMapping("/memes")
	@ApiOperation("Return Latest 100 Memes Data in JSON Format")
	public List<Meme> getMeme() {
		
		return myservice.findAllMemes();
	}
	//@CrossOrigin
	@GetMapping("/memes/{id}")
	@ApiOperation("Return Meme with given id in JSON Format")
	public Meme getMeme(@PathVariable long id) {
		Meme meme=myservice.getMeme(id);
		if(meme!=null)
			return myservice.getMeme(id);
		return null;
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/memes")
	@ResponseBody
	@ApiOperation("Adding a Meme in Database and Return respective id of Meme")
	public HashMap<String, String> addMeme(@RequestBody Meme data) {
		//Meme meme = new Meme(id,name,caption,url);
		long id=myservice.addMeme(data).id;
		HashMap<String, String> map = new HashMap<>();
		map.put("id", String.valueOf(id));
		return map;
	}
	//@CrossOrigin
	@RequestMapping(method=RequestMethod.PATCH, value="/memes/{id}")
	@ResponseBody
	@ApiOperation("Updating a Meme in Database and Return respective id of Meme")
	public long updateMeme(@PathVariable(value = "id") long id,@RequestBody Meme meme) {
		
		myservice.updateMeme(id,meme);
		return id;
		
	}
	//@CrossOrigin
	@GetMapping("/getlatestid")
	@ApiOperation("Returns the latest id of Meme")
	public long getLatestId() {
		return myservice.getLatestid();
	}
	
	
	@RequestMapping(
            value = "/**",
            method = RequestMethod.OPTIONS
    )
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
