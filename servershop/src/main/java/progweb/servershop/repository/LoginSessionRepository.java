package progweb.servershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import progweb.servershop.model.LoginSession;

public interface LoginSessionRepository extends JpaRepository<LoginSession, Long> {
    
}
