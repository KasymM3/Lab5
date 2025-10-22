package kz.lab5.lab5.Repository;


import kz.lab5.lab5.Entity.Operators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorsRepository extends JpaRepository<Operators,Long> {
}
