package com.emmlg.ForoAluraHub.topics.repository;

import com.emmlg.ForoAluraHub.topics.modelo.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicosRepository extends JpaRepository<Topic, Long> {
/* Al extender desde JpaRepository optenemos metodos como
   - findAll() → Obtiene todos los registros.
   - findById(Long id) → Busca un registro por su ID.
   - save(Topico topico) → Guarda o actualiza un registro.
   - deleteById(Long id) → Elimina un registro por ID.
*/
    //esto es para validar i existen titulo y 1 mensaje antes de publicar
boolean existsByTituloAndMensaje(String titulo, String mensaje);
 // Método derivado para verificar si el mensaje ya existe solo msg
    boolean existsByMensaje(String mensaje);
        // Método derivado para verificar si el título ya existe
    boolean existsByTitulo(String titulo);
}
