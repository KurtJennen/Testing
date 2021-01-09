package chapter5.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SpringService {
	private Set<String> names = new HashSet<String>();
	
	@RequestMapping(value="/{name}", method=RequestMethod.GET)
	public String displayMsg(@PathVariable String name) {
		String result = "Welcome " + name;
		names.add(name);
		return result;
	}
	
	@RequestMapping(value="/all/", method=RequestMethod.GET)
	public String anotherMsg() {
		StringBuilder result = new StringBuilder("We greeted so far ");
		for(String name : names) {
			result.append(name).append(", ");
		}
		return result.toString();
	}
}