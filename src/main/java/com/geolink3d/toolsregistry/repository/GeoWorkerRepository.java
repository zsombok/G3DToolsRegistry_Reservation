package com.geolink3d.toolsregistry.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.geolink3d.toolsregistry.model.GeoWorker;

public interface GeoWorkerRepository extends CrudRepository<GeoWorker, Long> {

	List<GeoWorker> findAll();
	Optional<GeoWorker> findById(Long id);
	GeoWorker findByUsername(String username);
	@Query(value = "select * from geoworkers where"
			+ " firstname like %:text%"
			+ " or "
			+ "lastname like %:text%" 
			+ " or "
			+ "user_name like %:text%"
			, nativeQuery = true)
	List<GeoWorker> findByText(@Param("text") String text);
	@Query(value = "select * from geoworkers where password like %:text%", nativeQuery = true)
	List<GeoWorker> findByPassword(@Param("text") String text);
	
}