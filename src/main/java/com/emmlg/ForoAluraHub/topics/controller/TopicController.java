package com.emmlg.ForoAluraHub.topics.controller;


import com.emmlg.ForoAluraHub.Exceptions.ForoAluraHubExceptions;
import com.emmlg.ForoAluraHub.topics.dto.TopicDto;
import com.emmlg.ForoAluraHub.topics.service.TopicService;
import com.emmlg.ForoAluraHub.util.GeneralResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "topicos", description = "Enpoint of topics CRUD operations")
@AllArgsConstructor
@RestController
@RequestMapping("${api.prefix}/topics")
public class TopicController {

    private final TopicService topicsService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new topic")
    public TopicDto addTopic(@RequestBody TopicDto topicoDto) throws ForoAluraHubExceptions {

        return topicsService.addTopic(topicoDto);
    }

    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a List of topic")
    public List<TopicDto> addTopicList(@RequestBody List<TopicDto> topicoDtoList) throws ForoAluraHubExceptions {

        return topicsService.addListTopic(topicoDtoList);
    }


    @GetMapping()
    @Operation(summary = "Get all topics")
    public List<TopicDto> getAllTopicos() throws ForoAluraHubExceptions {

        return topicsService.getAllTopics();
    }

    @GetMapping("/title")
    @Operation(summary = "Get topic by title")
    public TopicDto getTopicByTitle(@RequestParam String title) throws ForoAluraHubExceptions {
        return topicsService.getTopicByTitle(title);
    }

    @GetMapping("/status")
    @Operation(summary = "Get topic by status")
    public List<TopicDto> getTopicByStatus(@RequestParam String status) throws ForoAluraHubExceptions {
        return topicsService.getTopicByStatus(status);
    }

    @GetMapping("/creationDate")
    @Operation(summary = "Get topic by creation date")
    public List<TopicDto> getTopicByCreationDate(@RequestParam LocalDate creationDate) throws ForoAluraHubExceptions {
        return topicsService.getTopicByCreationDate(creationDate);
    }

    @GetMapping("/dateRange")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get topic by date range")
    public List<TopicDto> getTopicByDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) throws ForoAluraHubExceptions {
        return topicsService.getTopicByDateRange(startDate, endDate);
    }

    @GetMapping("/courseName")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get topic by course name")
    public List<TopicDto> getTopicByCourseName(@RequestParam String courseName) throws ForoAluraHubExceptions {
        return topicsService.getTopicByCourseName(courseName);
    }

    @GetMapping("/courseCategory")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get topic by course category")
    public List<TopicDto> getTopicByCourseCategory(@RequestParam String courseCategory) throws ForoAluraHubExceptions {
        return topicsService.getTopicByCourseCategory(courseCategory);
    }


    @PutMapping("/updateByTitle")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update topic by title")
    public TopicDto updateTopic(@RequestBody TopicDto topicoDto, @RequestParam String topicTitle) throws ForoAluraHubExceptions {

        return topicsService.updateTopic(topicoDto, topicTitle);
    }

    @PutMapping("/{topicId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update topic by ID")
    public TopicDto updateTopic(@RequestBody TopicDto topicoDto, @PathVariable Integer topicId) throws ForoAluraHubExceptions {

        return topicsService.updateTopic(topicoDto, topicId);
    }

    @DeleteMapping("/{topicId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete topic by ID")
    public GeneralResponse deleteTopicById(@PathVariable Integer topicId) throws ForoAluraHubExceptions {

        return topicsService.deleteTopic(topicId);
    }

    @DeleteMapping("/deleteByTitle")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete topic by title")
    public GeneralResponse deleteTopicByTitle(@RequestParam String title) throws ForoAluraHubExceptions {

        return topicsService.deleteTopicByTitle(title);
    }

    @DeleteMapping("/deleteByStatus")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete topic by status")
    public GeneralResponse deleteTopicByStatus(@RequestParam String status) throws ForoAluraHubExceptions {

        return topicsService.deleteTopicByStatus(status);
    }

    @DeleteMapping("/deleteByCreationDate")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete topic by creation date")
    public GeneralResponse deleteTopicByCreationDate(@RequestParam LocalDate creationDate) throws ForoAluraHubExceptions {

        return topicsService.deleteTopicByCreationDate(creationDate);
    }

    @DeleteMapping("/deleteByDateRange")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete topic by date range")
    public GeneralResponse deleteTopicByDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) throws ForoAluraHubExceptions {

        return topicsService.deleteTopicByRangeOfTime(startDate, endDate);
    }

    @DeleteMapping("/deleteByCourseName")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete topic by course name")
    public GeneralResponse deleteTopicByCourseName(@RequestParam String courseName) throws ForoAluraHubExceptions {

        return topicsService.deleteTopicByCourseName(courseName);
    }

    @DeleteMapping("/deleteByCourseCategory")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete topic by course category")
    public GeneralResponse deleteTopicByCourseCategory(@RequestParam String courseCategory) throws ForoAluraHubExceptions {

        return topicsService.deleteTopicByCourseCategory(courseCategory);
    }

}
