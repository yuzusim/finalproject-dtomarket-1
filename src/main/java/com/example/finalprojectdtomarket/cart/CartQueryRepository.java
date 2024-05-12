package com.example.finalprojectdtomarket.cart;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CartQueryRepository {
    private final EntityManager em;

    //장바구니 체크박스 업데이트
    public void updateIsChecked(CartRequest.UpdateDTO reqDTO) {
//        for (CartRequest.UpdateDTO dto : reqDTOs) {}

        String q = """
                  update Cart c set  c.isChecked = :isChecked where c.id = :id
                """;
        Query query = em.createQuery(q);
        //query.setParameter("orderQty", 1000); // 새로운 수량 값 설정
        //query.setParameter("orderQty", reqDTO.getOrderQty()); c.orderQty = :orderQty,
        query.setParameter("isChecked", true); // 새로운 상태 값 설정
        query.setParameter("id", reqDTO.getCartId());
        query.executeUpdate();
    }

    //롤백
    public void updateStatus() {
        String q = "update Cart c set c.isChecked = :newisChecked where c.isChecked = :oldisChecked";
        Query query = em.createQuery(q);
        query.setParameter("newisChecked", false);
        query.setParameter("oldisChecked", true);
        query.executeUpdate();
    }

}
