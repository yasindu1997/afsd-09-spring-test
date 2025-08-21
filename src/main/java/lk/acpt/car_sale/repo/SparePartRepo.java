package lk.acpt.car_sale.repo;

import lk.acpt.car_sale.entity.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SparePartRepo extends JpaRepository<SparePart,Integer> {
}
