package com.emmlg.ForoAluraHub.topics.repository;

import com.emmlg.ForoAluraHub.topics.modelo.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {

/* Al extender desde JpaRepository optenemos metodos como
   - findAll() → Obtiene todos los registros.
   - findById(Long id) → Busca un registro por su ID.
   - save(Topico topico) → Guarda o actualiza un registro.
   - deleteById(Long id) → Elimina un registro por ID.
*/
    //esto es para validar i existen titulo y 1 mensaje antes de publicar
    // boolean existsByTituloAndMensaje(String titulo, String mensaje);
    // Método derivado para verificar si el mensaje ya existe solo msg
    //  boolean existsByMensaje(String mensaje);
    // Método derivado para verificar si el título ya existe
    //  boolean existsByTitulo(String titulo);

    Topic findByTitle(String topicTitle);

    List<Topic> findByStatus(String status);

    List<Topic> findByCreationDate(LocalDate creationDate);

    List<Topic> findByCreationDateBetweenOrderByCreationDateAsc(LocalDate startDate, LocalDate endDate);

    List<Topic> findByCourse_CourseName(String courseName);

    List<Topic> findByCourseCategoryCategoryName(String categoryName);

    void deleteByTitle(String topicTitle);

    void deleteByStatus(String status);

    void deleteByCreationDate(LocalDate creationDate);

    void deleteByCreationDateBetween(LocalDate startDate, LocalDate endDate);

    void deleteByCourse_CourseName(String courseName);

    void deleteByCourse_Category_CategoryName(String categoryName);
}
