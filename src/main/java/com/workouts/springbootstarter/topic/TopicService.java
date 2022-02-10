package com.workouts.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * In Spring, business services are typically Singletons, when the application starts up spring
 * creates an instance of this service and then it keeps that in its memory, right it registers 
 * that instance. Other classes and other services and other controllers which depend on this, right
 * it declares a dependency, hey spring I need that service, spring knows that this is an instance
 * and created going to inject it to those different classes.
 * 
 * @Service is what called as a Stereotype annotation, this is something that marks this class as
 * a spring business service. When the application starts up, its going to detect in the class path.
 * All the services which have that @Service annotation is going to <code>create an instance</code> of all those
 * classes, its going to register it. 
 */
@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	
	
	/*
	 * private List<Topic> topicsList = new ArrayList<>(Arrays.asList( new
	 * Topic("spring", "Spring Framework", "Spring Framework Description"), new
	 * Topic("java", "Core Java", "Java Description"), new Topic("javascript",
	 * "Java Script", "Java script Description")));
	 */
	 
	 
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		// We have only one copy of the topic list, it won't create instances 
		// every time, because of this business service class is a singleton.
		//return topicsList; 
		topicRepository.findAll().forEach(topics::add); 
		return topics;
	}
	
	public Topic getTopic(String id) {
		//return topicsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Optional<Topic> optionalTopic = topicRepository.findById(id);
		return optionalTopic.orElseThrow(() -> new IllegalArgumentException());
	}

	public void addTopic(List<Topic> topicList) {
		//return topicsList.add(topic);
		for(Topic topic : topicList) {
			topicRepository.save(topic);
		}
	}

	public void updateTopic(Topic updatedTopic, String id) {
		
		/*
		 * for (int i = 0; i < topicsList.size(); i++) { Topic topic =
		 * topicsList.get(i); if (topic.getId().equals(id)) { topicsList.set(i,
		 * updatedTopic); return; } }
		 */
		Topic top = topicRepository.save(updatedTopic);
		System.out.println("Topic Deleted : " + top.getId());
	}

	public void deleteTopic(String id) {
		//topicsList.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}
	
}
