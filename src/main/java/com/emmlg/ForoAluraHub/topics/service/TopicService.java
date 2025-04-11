package com.emmlg.ForoAluraHub.topics.service;

import com.emmlg.ForoAluraHub.Exceptions.ForoAluraHubExceptions;
import com.emmlg.ForoAluraHub.curso.repository.CourseRepository;
import com.emmlg.ForoAluraHub.topics.dto.TopicDto;
import com.emmlg.ForoAluraHub.topics.modelo.Topic;
import com.emmlg.ForoAluraHub.topics.repository.TopicRepository;
import com.emmlg.ForoAluraHub.util.GeneralResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.emmlg.ForoAluraHub.common.constants.Messages.*;
import static com.emmlg.ForoAluraHub.util.ConvertDtoToEntity.convertDtoToEntity;
import static com.emmlg.ForoAluraHub.util.ConvertEntityToDto.*;

@Service
@AllArgsConstructor
public class TopicService implements ITopicService {

    private final TopicRepository topicRepository;
    private final CourseRepository courseRepository;


    @Override
    @Transactional
    public TopicDto addTopic(TopicDto topicDto) throws ForoAluraHubExceptions {

        // 1. traer datos de usuario
        //2. validar noduplicados
        var existSameTopic = topicRepository.findByTitle(topicDto.getTitle());
        if (existSameTopic != null)
            throw new ForoAluraHubExceptions(
                    HttpStatus.CONFLICT,
                    List.of("topic already exist"),
                    TOPIC_ALREADY_EXISTS, TOPIC_SEARCH);

        //3. traer datos de curso
        var course = courseRepository.findByCourseName(topicDto.getCursoName());
        if (course == null)
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("course not found"),
                    COURSE_NOT_FOUND,
                    COURSE_SEARCH);

        Topic topicnew = convertDtoToEntity(topicDto);
        topicnew.setCourse(course);

        return convertEntityToDto(topicRepository.save(topicnew));
    }

    @Override
    public List<TopicDto> addListTopic(List<TopicDto> topicDto) throws ForoAluraHubExceptions {

        return topicDto.stream()
                .map(this::addTopic)
                .toList();
    }

    @Override
    public TopicDto getTopicByTitle(String topicTitle) {
        Topic topic = topicRepository.findByTitle(topicTitle);
        if (topic == null) {
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("topic not found"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH);
        }
        return convertEntityToDto(topic);
    }

    @Override
    public List<TopicDto> getAllTopics() {
        List<Topic> topics = topicRepository.findAll();
        if (topics.isEmpty()) {
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("topics not found"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH);
        }
        return convertTopicListToDto(topics);
    }

    @Override
    public List<TopicDto> getTopicByStatus(String status) {
        List<Topic> topics = topicRepository.findByStatus(status);
        if (topics.isEmpty()) {
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("topic not found"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH);
        }
        return convertTopicListToDto(topics);
    }

    @Override
    public List<TopicDto> getTopicByCreationDate(LocalDate creationDate) {
        List<Topic> topics = topicRepository.findByCreationDate(creationDate);
        if (topics.isEmpty())
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("topics not found", "topics maybe not exist"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH);

        return convertTopicListToDto(topics);

    }

    @Override
    public List<TopicDto> getTopicByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Topic> topics = topicRepository.findByCreationDateBetweenOrderByCreationDateAsc(startDate, endDate);
        if (topics.isEmpty())
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("topics not found from " + startDate + " to" + endDate, "topics maybe not exist"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH);

        return convertTopicListToDto(topics);
    }

    @Override
    public List<TopicDto> getTopicByCourseName(String courseName) {
        List<Topic> topics = topicRepository.findByCourse_CourseName(courseName);
        if (topics.isEmpty())
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("topics not found with the name : " + courseName, "topics maybe not exist"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH);
        return convertTopicListToDto(topics);
    }

    @Override
    public List<TopicDto> getTopicByCourseCategory(String courseCategory) {
        List<Topic> topics = topicRepository.findByCourseCategoryCategoryName(courseCategory);
        if (topics.isEmpty())
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("topics not found with the category : " + courseCategory, "topics maybe not exist"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH);
        return convertTopicListToDto(topics);
    }

    @Override
    public TopicDto updateTopic(TopicDto topicDto, String topicTitle) {
        // 1. traer datos de usuario
        //2. validar noduplicados
        var existingTopic = topicRepository.findByTitle(topicTitle);
        if (existingTopic == null)
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("topic not exist"),
                    TOPIC_NOT_FOUND, TOPIC_SEARCH);

        //3. traer datos de curso
        var course = courseRepository.findByCourseName(topicDto.getCursoName());
        if (course == null)
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("course not found"),
                    COURSE_NOT_FOUND,
                    COURSE_SEARCH);

        existingTopic.setTitle(topicDto.getTitle());
        existingTopic.setMessage(topicDto.getMessage());
        existingTopic.setStatus(topicDto.getStatus());
        existingTopic.setCreationDate(topicDto.getCreationDate());
        existingTopic.setUpdateDate(topicDto.getUpdateDate());
        existingTopic.setCourse(course);

        return convertEntityToDto(topicRepository.save(existingTopic));

    }

    @Override
    public TopicDto updateTopic(TopicDto topicDto, Integer topicId) {
        // 1. traer datos de usuario
        //2. validar noduplicados
        var existingTopic = topicRepository.findById(Long.valueOf(topicId));
        if (!existingTopic.isPresent())
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("topic not exist"),
                    TOPIC_NOT_FOUND, TOPIC_SEARCH);

        //3. traer datos de curso
        var course = courseRepository.findByCourseName(topicDto.getCursoName());
        if (course == null)
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("course not found"),
                    COURSE_NOT_FOUND,
                    COURSE_SEARCH);

        existingTopic.get().setTitle(topicDto.getTitle());
        existingTopic.get().setMessage(topicDto.getMessage());
        existingTopic.get().setStatus(topicDto.getStatus());
        existingTopic.get().setCreationDate(topicDto.getCreationDate());
        existingTopic.get().setUpdateDate(topicDto.getUpdateDate());
        existingTopic.get().setCourse(course);

        return convertEntityToDto(topicRepository.save(existingTopic.get()));
    }

    @Override
    @Transactional
    public GeneralResponse deleteTopic(Integer topicId) {
        boolean topicExists = topicRepository.existsById(Long.valueOf(topicId));
        if (!topicExists)
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("El tópico con el id " + topicId + " no existe"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH);
        topicRepository.deleteById(Long.valueOf(topicId));
        return new GeneralResponse(TOPIC_DELETED + "Id = " + topicId, HttpStatus.OK);
    }

    @Override
    @Transactional
    public GeneralResponse deleteTopicByTitle(String topicTitle) {
        var topicExists = topicRepository.findByTitle(topicTitle);
        if (topicExists == null)
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("El tópico con el título " + topicTitle + " no existe"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH);
        topicRepository.deleteByTitle(topicTitle);
        return new GeneralResponse(TOPIC_DELETED + "With Title = " + topicTitle, HttpStatus.OK);

    }

    @Override
    @Transactional
    public GeneralResponse deleteTopicByStatus(String status) {
        var topicExists = topicRepository.findByStatus(status);
        if (topicExists.isEmpty())
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("El tópico con el status " + status + " no existe"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH);
        topicRepository.deleteByStatus(status);
        return new GeneralResponse(TOPIC_DELETED + "With Status = " + status, HttpStatus.OK);
    }

    @Override
    @Transactional
    public GeneralResponse deleteTopicByCreationDate(LocalDate creationDate) {
        var topicExists = topicRepository.findByCreationDate(creationDate);
        if (topicExists.isEmpty())
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("El tópico con la fecha " + creationDate + " no existe"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH);
        topicRepository.deleteByCreationDate(creationDate);
        return new GeneralResponse(TOPIC_DELETED + "With Creation Date = " + creationDate, HttpStatus.OK);
    }

    @Override
    @Transactional
    public GeneralResponse deleteTopicByRangeOfTime(LocalDate startDate, LocalDate endDate) {
        var topicExists = topicRepository.findByCreationDateBetweenOrderByCreationDateAsc(startDate, endDate);
        if (topicExists.isEmpty())
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("El tópico con la fecha " + startDate + " no existe"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH);
        topicRepository.deleteByCreationDateBetween(startDate, endDate);
        return new GeneralResponse(TOPIC_DELETED + "With Creation Date Between = " + startDate + " and " + endDate, HttpStatus.OK);
    }

    @Override
    @Transactional
    public GeneralResponse deleteTopicByCourseName(String courseName) {
        var topicExists = topicRepository.findByCourse_CourseName(courseName);
        if (topicExists.isEmpty())
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("El tópico con el curso " + courseName + " no existe"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH);
        topicRepository.deleteByCourse_CourseName(courseName);
        return new GeneralResponse(TOPIC_DELETED + "with Course Name = " + courseName, HttpStatus.OK);
    }

    @Override
    @Transactional
    public GeneralResponse deleteTopicByCourseCategory(String courseCategory) {

        var topicExists = topicRepository.findByCourseCategoryCategoryName(courseCategory);
        if (topicExists.isEmpty())
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("El tópico con la categoria " + courseCategory + " no existe"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH);
        topicRepository.deleteByCourse_Category_CategoryName(courseCategory);
        return new GeneralResponse(TOPIC_DELETED + "With Course Category = " + courseCategory, HttpStatus.OK);
    }
}
