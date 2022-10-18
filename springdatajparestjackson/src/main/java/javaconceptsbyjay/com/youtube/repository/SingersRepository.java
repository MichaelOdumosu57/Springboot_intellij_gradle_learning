package javaconceptsbyjay.com.youtube.repository;

import javaconceptsbyjay.com.youtube.entity.Singers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingersRepository extends JpaRepository<Singers, Integer> {
}
