package com.workouts.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * This is the annotation that you need to put on any class in order to make the class a 
 * Rest Controller, this is from spring mvc. What does a Rest Controller mean, it means that you 
 * can have methods in here in this class which map to URL request, you can have request mapped
 * to a particular request, so the method executes when the user makes a request to that URL. 
 * Since the class is annotated with Rest Controller, it means whatever the method returns, its
 * automatically going to converted it as a JSON and sent back a http response.
 *   
 */
@RestController
public class HelloController {
	/*
	 * Whenever there is a http request to this application at the url /hello, you want this method
	 * to be execute and this return value to be returned back, there is no http method over here,
	 * this way of mapping is only for a get, because thats the default method. If you want to map
	 * other methods, you have to explicitly mention it.
	 */
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
		/*
		 * The generated JSON has key names corresponding to property names of the Topic class. The
		 * JSON values are the values of those properties.
		 * 
		 */
	}
	
	/*
	 * Now that we have put this class in here, how do I plug this into the spring framework,
	 * well you don't have to do anything, because the very fact that you putting this class in the
	 * class path means that the spring framework scans it and knows this is what needs to happen,
	 * when the spring framework starts up, it basically does a class path scan, when the class path
	 * can happens, what its doing, it basically looking at all these classes and seeing if that
	 * there are annotations like these, and if it finds that annotation, it registers it. When the
	 * actual request comes in, say /hello, spring looks at its notes and says ok this is the method
	 * that I need to call, executes it and takes a return and returns it back.   
	 */
}