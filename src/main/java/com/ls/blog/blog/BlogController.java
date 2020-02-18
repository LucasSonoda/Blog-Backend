package com.ls.blog.blog;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("blogs")
public class BlogController {
	
	private final IBlogService blogService;
	private Blog blog;
	private HashMap<Object,String> response;
	
	@Autowired
	public BlogController(IBlogService blogService) {
		this.blogService = blogService;
		response = new HashMap<>();
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Blog>> getAll(){
		return ResponseEntity.ok(blogService.findAll());
	}
	
	@GetMapping(value="/{blogid}")
	public ResponseEntity<Blog> getById(@PathVariable String blogid){
		try {
			return ResponseEntity.ok(blogService.findOne(blogid));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<Blog> save(@RequestBody Blog blog){
		return ResponseEntity.ok(blogService.save(blog));
	}
	
	@DeleteMapping("/{blogid}")
	public ResponseEntity<HashMap<Object,String>> delete(@PathVariable String blogid){
		try {
			blogService.delete(blogid);
			response.put("mensaje", "Post eliminado correctamente.");
			return new ResponseEntity<HashMap<Object, String>>(response, HttpStatus.OK);
		}catch(Exception e) {
			response.put("mensaje", "Error al intentar eliminar el post. "+e.getMessage());
			return new ResponseEntity<HashMap<Object, String>>(response, HttpStatus.NOT_MODIFIED);
		}
		//return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/update")
	public ResponseEntity<HashMap<Object,String>> update(@RequestBody Blog blog){
		
		try {
			blogService.update(blog);
			response.put("Mensaje", "Actualizado correctamente!.");
			return new ResponseEntity<HashMap<Object, String>>(response, HttpStatus.OK);
		}catch(Exception e){
			response.put("Mensaje", "Error al intentar actualizar" + e.getMessage());
			return new ResponseEntity<HashMap<Object, String>>(response, HttpStatus.NOT_MODIFIED);
		}
	}
	
}
