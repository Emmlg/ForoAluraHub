package com.emmlg.ForoAluraHub.util;

import com.emmlg.ForoAluraHub.curso.dto.CourseCategoryDto;
import com.emmlg.ForoAluraHub.curso.dto.CourseDto;
import com.emmlg.ForoAluraHub.curso.modelo.Course;
import com.emmlg.ForoAluraHub.curso.modelo.CourseCategory;
import com.emmlg.ForoAluraHub.replies.dto.ReplyDto;
import com.emmlg.ForoAluraHub.replies.modelo.Reply;
import com.emmlg.ForoAluraHub.topics.dto.TopicDto;
import com.emmlg.ForoAluraHub.topics.modelo.Topic;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertEntityToDto {

    public static CourseCategoryDto convertEntityToDto(CourseCategory courseCategory) {
        if (courseCategory == null) {
            return null;
        }
        return CourseCategoryDto
                .builder()
                .CategoryName(courseCategory.getCategoryName())
                .categoryId(courseCategory.getCategoryId())
                .build();
    }

    public static List<CourseCategoryDto> convertEntityToDto(List<CourseCategory> courseCategories) {
        if (courseCategories == null || courseCategories.isEmpty()) {
            return List.of();
        }

        return courseCategories.stream()
                .map(courseCategory ->
                        CourseCategoryDto.builder()
                                .CategoryName(courseCategory.getCategoryName())
                                .categoryId(courseCategory.getCategoryId())
                                .build())
                .collect(Collectors.toList());
    }

    public static CourseDto convertEntityToDto(Course course) {
        if (course == null) {
            return null;
        }

        return CourseDto
                .builder()
                .courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .category(course.getCategory().getCategoryName())
                .build();
    }

    public static List<CourseDto> convertCourseToDto(List<Course> courses) {
        if (courses == null || courses.isEmpty()) {
            return List.of();
        }

        return courses.stream()
                .map(course ->
                        CourseDto.builder()
                                .courseId(course.getCourseId())
                                .courseName(course.getCourseName())
                                .category(course.getCategory().getCategoryName())
                                .build())
                .collect(Collectors.toList());
    }

    public static TopicDto convertEntityToDto(Topic topic) {
        if (topic == null) {
            return null;
        }
        return TopicDto.builder()
                .topicoId(topic.getTopicId())
                .title(topic.getTitle())
                .message(topic.getMessage())
                .status(topic.getStatus())
                .creationDate(topic.getCreationDate())
                .updateDate(topic.getUpdateDate())
                .CursoName(topic.getCourse().getCourseName())
                .CursoCategory(topic.getCourse().getCategory().getCategoryName())
                .replies(topic.getReplies()).build();
    }

    public static List<TopicDto> convertTopicListToDto(List<Topic> topics) {
        if (topics == null || topics.isEmpty()) {
            return List.of();
        }

        return topics.stream()
                .map(topic ->
                        TopicDto.builder()
                                .topicoId(topic.getTopicId())
                                .title(topic.getTitle())
                                .message(topic.getMessage())
                                .status(topic.getStatus())
                                .creationDate(topic.getCreationDate())
                                .updateDate(topic.getUpdateDate())
                                .CursoName(topic.getCourse().getCourseName())
                                .CursoCategory(topic.getCourse().getCategory().getCategoryName())
                                .replies(topic.getReplies()).build())
                .collect(Collectors.toList());
    }

    public static ReplyDto convertEntityToDto(Reply reply) {
        if (reply == null)
            return null;
        return ReplyDto.builder()
                .replyId(reply.getReplyId())
                .replyMessage(reply.getMessage())
                .creationDate(reply.getCreationDate())
                .updateDate(reply.getUpdateDate())
                .build();

    }
}
