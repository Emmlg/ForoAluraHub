package com.emmlg.ForoAluraHub.topics.service;

import com.emmlg.ForoAluraHub.topics.dto.TopicDto;
import com.emmlg.ForoAluraHub.util.GeneralResponse;

import java.time.LocalDate;
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

    GeneralResponse deleteTopic(Integer topicId);

    GeneralResponse deleteTopicByTitle(String topicTitle);

    GeneralResponse deleteTopicByStatus(String status);

    GeneralResponse deleteTopicByCreationDate(LocalDate creationDate);

    GeneralResponse deleteTopicByRangeOfTime(LocalDate startDate, LocalDate endDate);

    GeneralResponse deleteTopicByCourseName(String courseName);

    GeneralResponse deleteTopicByCourseCategory(String courseCategory);


}
