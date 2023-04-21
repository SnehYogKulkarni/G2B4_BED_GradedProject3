package com.TTS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TTS.Entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	@Query(value = "select * from tickets t where t.short_description like %:keyword% or t.title like %:keyword%", nativeQuery = true)
	List<Ticket> findByKeyword(@Param("keyword") String keyword);

}
