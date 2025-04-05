package com.emmlg.ForoAluraHub.topics.service;

import com.emmlg.ForoAluraHub.topics.dto.TopicDto;
import com.emmlg.ForoAluraHub.util.GeneralRespose;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ITopicService {

    TopicDto addTopic(TopicDto topicDto);

    List<TopicDto> addListTopic(List<TopicDto> topicDtoList);

    List<TopicDto> getAllTopics();

    TopicDto getTopicByTitle(String topicTitle);

    List<TopicDto> getTopicByStatus(String status);

    List<TopicDto> getTopicByCreationDate(LocalDate creationDate);

    List<TopicDto> getTopicByDateRange(LocalDate startDate, LocalDate endDate);

    List<TopicDto> getTopicByCourseName(String courseName);

    List<TopicDto> getTopicByCourseCategory(String courseCategory);

    TopicDto updateTopic(TopicDto topicoDto, String topicTitle);

    TopicDto updateTopic(TopicDto topicoDto, Integer topicId);

    GeneralRespose deleteTopic(Integer topicId);

    GeneralRespose deleteTopicByTitle(String topicTitle);

    GeneralRespose deleteTopicByStatus(String status);

    GeneralRespose deleteTopicByCreationDate(LocalDate creationDate);

    GeneralRespose deleteTopicByRangeOfTime(LocalDate startDate, LocalDate endDate);

    GeneralRespose deleteTopicByCourseName(String courseName);

    GeneralRespose deleteTopicByCourseCategory(String courseCategory);


}
