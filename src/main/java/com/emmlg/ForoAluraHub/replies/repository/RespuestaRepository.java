package com.emmlg.ForoAluraHub.replies.repository;

import com.emmlg.ForoAluraHub.replies.modelo.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepository extends JpaRepository<Reply, Long> {


}
