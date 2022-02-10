package com.workouts.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* 
 * Tells spring boot, this is the starting point for this application 
 */
@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {
		/*
		 * Static method run
		 * Setup default configuration - Spring boot favors convention versus configuration, the
		 * default configuration addresses that 80% use case, For the most part default 
		 * configuration is fine.
		 * 
		 * Starts spring application context - Is a container for all URL, the code that runs on your
		 * Application Server, creates the application context. Lets see we have Business services, 
		 * controller, data services. Spring access a container for all those different services and 
		 * this container is what called as Application Context. Every spring application has this 
		 * application context which runs when the spring application runs. So this spring boot 
		 * starter creates the application context.
		 * 
		 * Performs class path scan - The way to plugin code into spring boot is by creating your own
		 * custom classes and annotating them with the intent,lets say you want to create a business
		 * services, you create a class and annotate with @Service annotation, well create a controller,
		 * create a class and annotate it with @Controller annotation, you basically marking your 
		 * classes, this is a service, this is a controller so on. So each class contains a marker. Now
		 * spring has to look at all classes and say depending on the marker treat it differently, if its
		 * a service annotation, treat it as a service, if its a controller annotation, treat it as a
		 * controller, In order to know what the files are you are marked, it has to actually scan the
		 * class path to identify all those different classes thats what class path scan does, spring
		 * on starting up can potentially look at your class path, which is looking at all your code and
		 * see it the class has any annotations, if it does it considers them and treats it as such,
		 * service is treated as a service, controller is treated as a controller and these classes
		 * typically have other meta data which also tells spring, how the controller needs to behave, how
		 * the service needs to behave, so spring infers all that from the annotations and does the right 
		 * thing, the point here is to do that, it needs to scan the class path.  
		 * 
		 * Starts Tomcat server - It actually starts the tomcat server, which is what we access, we access
		 * the url, it was actually a tomcat server which got started, did you download tomcat and install
		 * it, well no you did not, this came with spring boot and this is why the output of spring boot is
		 * a stand-alone application. Stand alone means, you have to create a servlet container, spring
		 * boot is all you need to start the application and start the servlet container.
		 * 
		 * The advantages of Spring chooses Embedded Tomcat Server for Convenience, the other
		 * advantage is Servlet container config is now application config, in the source code you
		 * also have tomcat related configuration, stand alone application easy to deploy, devlop
		 * and run, this was spring boot's one of the goal. The final advantage here is Useful for
		 * micro service architecture, When you have a bunch of micro services, you don't want to
		 * have additional steps in order to deploy each micro service, if we have one big
		 * monolithic code base, well its ok to take the pain, ok these are the steps to deploy
		 * to tomcat but we have like 10 different micro services, you don't want to deploy it 10 
		 * different times, it going to be a pain, but with an application being stand alone, you 
		 * just have to run a command have the micro service start up which is much more
		 * Convenient and thats where the embedded tomcat server really helps. Tomcat is the
		 * default chose you get, you can choose other servlet container, just you need to specify
		 * the dependency in your pom.xml and configure it.
		 * 
		 */
		SpringApplication.run(CourseApiApp.class, args);
	}

}
