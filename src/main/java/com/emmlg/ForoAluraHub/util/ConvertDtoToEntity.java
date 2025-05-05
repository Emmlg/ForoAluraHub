package com.emmlg.ForoAluraHub.util;

import com.emmlg.ForoAluraHub.curso.dto.CourseCategoryDto;
import com.emmlg.ForoAluraHub.curso.dto.CourseDto;
import com.emmlg.ForoAluraHub.curso.modelo.Course;
import com.emmlg.ForoAluraHub.curso.modelo.CourseCategory;
import com.emmlg.ForoAluraHub.replies.dto.ReplyDto;
import com.emmlg.ForoAluraHub.replies.modelo.Reply;
import com.emmlg.ForoAluraHub.topics.dto.TopicDto;
import com.emmlg.ForoAluraHub.topics.modelo.Topic;
import com.emmlg.ForoAluraHub.user.dto.UserDto;
import com.emmlg.ForoAluraHub.user.modelo.User;

import java.util.List;

public class ConvertDtoToEntity {

    public static CourseCategory convertDtoToEntity(CourseCategoryDto courseCategoryDto) {

        if (courseCategoryDto == null) {
            return null;
        }
        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setCategoryId(courseCategoryDto.getCategoryId());
        courseCategory.setCategoryName(courseCategoryDto.getCategoryName());
        return courseCategory;
    }

    public static Course convertDtoToEntity(CourseDto courseDto) {
        if (courseDto == null) {
            return null;
        }
        Course course = new Course();
        course.setCourseId(courseDto.getCourseId());
        course.setCourseName(courseDto.getCourseName());
        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setCategoryName(courseDto.getCategory());
        course.setCategory(courseCategory);
        return course;
    }

    public static Topic convertDtoToEntity(TopicDto topicDto) throws RuntimeException {
        if (topicDto == null) {
            return null;
        }
        Topic newTopic = new Topic();
        newTopic.setTopicId(topicDto.getTopicoId());
        newTopic.setTitle(topicDto.getTitle());
        newTopic.setMessage(topicDto.getMessage());
        newTopic.setCreationDate(topicDto.getCreationDate());
        newTopic.setUpdateDate(topicDto.getUpdateDate());
        newTopic.setStatus(topicDto.getStatus());
        Course course = new Course();
        course.setCourseName(topicDto.getCursoName());
        newTopic.setCourse(course);
        return newTopic;
    }

    public static Reply convertDtoToEntity(ReplyDto replyDto) {
        if (replyDto == null) {
            return null;
        }
        Reply reply = new Reply();
        reply.setReplyId(replyDto.getReplyId());
        reply.setMessage(replyDto.getReplyMessage());
        reply.setCreationDate(replyDto.getCreationDate());
        reply.setUpdateDate(replyDto.getUpdateDate());
        return reply;
    }

    public static User convertDtoToEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserPassword(userDto.getUserPassword());
        user.setUserRole(userDto.getUserRole());
        user.setTopics(userDto.getTopicOrReplyList() == null ? null :
                userDto.getTopicOrReplyList().stream()
                        .filter(item -> item instanceof Topic)
                        .map(item -> (Topic) item)
                        .toList());
        return user;
    }
}
