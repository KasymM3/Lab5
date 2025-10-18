package kz.lab5.lab5.Repository;

import jakarta.transaction.Transactional;
import kz.lab5.lab5.Entity.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface AppRequestRepository extends JpaRepository<ApplicationRequest,Long> {
    List<ApplicationRequest> findByHandled(boolean handled);
}
