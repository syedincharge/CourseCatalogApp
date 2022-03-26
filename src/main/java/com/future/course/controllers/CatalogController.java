package com.future.course.controllers;


import com.future.course.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;


@RestController
public class CatalogController {


    @Autowired
    private EurekaClient client;

    @RequestMapping("/")

    public String getCatalog(){

        String courses = "";

        //String courseAppURL = "http://localhost:8080/courses";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("fx-course-service", false);

        RestTemplate restTemplate = new RestTemplate();
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL+"/";
        courses = restTemplate.getForObject(courseAppURL, String.class);

        return ("Welcome to FutureX Course Catalog  " +courses);

    }




    @GetMapping("/coursecatalog")
    public String getAllCourses(){

        String courses = "";

        //String courseAppURL = "http://localhost:8080/courses";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("fx-course-service", false);

        RestTemplate restTemplate = new RestTemplate();
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL+"/courses";
        courses = restTemplate.getForObject(courseAppURL, String.class);

        return ("Our Courses  " +courses);
    }

    @RequestMapping("/coursename")
    public String getCourse() {

        Course course = new Course();

        //String courseAppURL = "http://localhost:8080/3";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("fx-course-service", false);

        RestTemplate restTemplate = new RestTemplate();
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL+"/1";
        course = restTemplate.getForObject(courseAppURL, Course.class);

        instanceInfo = client.getNextServerFromEureka("fx-user-service", false);
        String userAppURL = instanceInfo.getHomePageUrl();
        userAppURL = userAppURL+"/"+course.getCourseid();

        String usersList = restTemplate.getForObject(userAppURL, String.class);
        if (course != null) {
            return ("Welcome to FutureX Course Catalog   is    " + course.getCoursename()+
                    " *******  and Enrolled Users are ***** "+usersList);
        }
        return courseAppURL;
    }


}
