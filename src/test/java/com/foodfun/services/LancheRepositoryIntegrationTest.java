
package com.foodfun.services;

import com.foodfun.domain.Lanche;
import com.foodfun.repositories.LancheRepository;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Geraldo Barros
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class LancheRepositoryIntegrationTest {
         @Autowired
    private TestEntityManager em;
 
    @Autowired
    private LancheRepository lr;
 
    
    
@Test
public void buscarNome_RetornarLanche() {
    // given
    Lanche l1 = new Lanche(null,"X-Bacon");
    em.persist(l1);
    em.flush();
 
    Optional<Lanche> encontrado = lr.findById(l1.getId());
    Lanche l2 = encontrado.get();
    
    // then
    assertThat(l2.getId())
      .isEqualTo(l1.getId());
}
    
}
