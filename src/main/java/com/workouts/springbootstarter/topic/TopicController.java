package com.workouts.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/*
 * When building any Rest API, one of the first few things that you need to think about is what
 * the resources of a Rest API are, Rest API usually deals with nouns as a Entities or Resources, 
 * you have to identify that first in order to contract for the Rest API, the Resources are the
 * things in your domain, so in the case of a Course API Topic is a resource, once you identify
 * the resources, you can then look at ways and which the consumers can access the resource with
 * different http methods, this is standard Rest. For the sake of our Course API, we are going to
 * be identifying three separate resources.
 * 
 *  Resources : Topic, Course and Lesson
 *  A topic can have multiple Courses and a Course can consist multiple Lessons.
 *  We are going to have a bunch of ways in which you access these resources either to get it or
 *  to update it, those ways are influenced by what the method you are using for accessing them,
 *  the http method influences what you do with these resources, but the resource itself are the 
 *  constants right, they are the entities or the nouns in your system.
 *  
 *  If you just focus on the topic, what are the URL's and what are the HTTP methods that you can
 *  perform on the Topic resource, these are the standard rest conventions, you can have other 
 *  possible ways of doing this, but this standard is usually recommended, so the standard is
 *  
 *   GET /topics Gets all topics - to get all the resources, a root URL
 *   GET /topics/id Gets the topic - you can have an individual element basically topics/ the id of
 *   the element and get that particular element alone
 *   POST /topics Create new topics - and the post body will contain the details about the new topic, 
 *   when you make a post request to /topics with that post body, the API should ideally create a
 *   new topic by looking at that post body.
 *   PUT /topics/id Updates the topic - again you going to do a Put request with put body containing
 *   the topic information and its going to update whatever is at that place.
 *   Delete /topic/id Deletes the topic - individual again, deletes that particular 
 *   topic looking at the delete body.
 */
@RestController
public class TopicController {
	
	/*
	 * When spring creates an instance of these classes, its also going to look at member variable
	 * and see if any of them has a dependency to topicservice and its going to inject that,
	 * We declare the dependency by @Autowired annotation.
	 * 
	 * When spring creates an instance of this class, its going to look at the @Autowired annotation
	 * to the topicService, it looks at its registry and sees if there is an instance of TopicService
	 * (instance created because of adding @Service in TopicService class) was already created, its going to
	 * take that instance and inject it to this.
	 */
	@Autowired
	private TopicService topicService;
	
	/* Map any request which is a GET on /topics */
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() { 
		return topicService.getAllTopics();
	}
	
	/*
	 * {tokenofanyname} is a variable part
	 */
	@RequestMapping("/topics/{tokenofanyname}")
	/* To tell {tokenofanyname} is the id, we have to use another annotation called @PathVariable.
	 * Whatever the variable is, we need to send that to the method argument when its called.
	 * 
	 * When the variable and argument name is same, we don't need to tell the method which is the 
	 * variable, but when variable(tokenofanyname) and argument(id) is different, we need to
	 * specify it in the @ParthVariable("tokenofanyname") and say pass this in the id argument.
	 */
	public Topic getTopic(@PathVariable("tokenofanyname") String id) {
		return topicService.getTopic(id);
	}
	
	/*
	 * Map this method to any request that supposed on /topics
	 * 
	 * Now I am going to have the POST request made to /topics and I said that the post body should contain 
	 * the object itself, the new topic thats being sent, just by adding the annotation @RequestBody this method is
	 * going to get called when its a POST request, now what I need in that method is to get that post body, convert it
	 * into a post instance and add that to the list in the topic service.
	 * 
	 * Hey spring mvc get the request body and pass it to me as a topic instance(Object). Hey pick this instance from
	 * the request body.
	 */
	 
	@RequestMapping(value = "/topics", method = RequestMethod.POST) // @RequestMapping(value="/topics", method=RequestMethod.POST)
	// @PostMapping - Short cut instead of method = RequestMethod.POST
	/*
	 * What @ReqestBody does is tell spring mvc that your request payload is going to contain the JSON representation
	 * of this Topic instance and you're asking it to take that request body and convert it into a topic instance
	 * and pass it to the addTopic when this url is mapped anyways.
	 */
	public void addTopic(@RequestBody List<Topic> topicList) {
		topicService.addTopic(topicList);
	}
	
	@RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
