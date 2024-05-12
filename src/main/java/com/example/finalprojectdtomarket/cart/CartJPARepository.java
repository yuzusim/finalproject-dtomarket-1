package com.example.finalprojectdtomarket.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CartJPARepository extends JpaRepository<Cart, Integer> {

    //롤백
//    @Modifying
//    @Query("update Cart c set c.isChecked = :newStatus where c.isChecked = :oldStatus")
//    int updateIsChecked(boolean newStatus, boolean oldStatus);
//
//    //장바구니 체크박스 업데이트
//    @Modifying
//    @Query("update Cart c set c.isChecked = :isChecked where c.id = :id")
//    void updateIsCheckedById(boolean isChecked, Integer id);

//    // 메소드 이름으로 쿼리 생성
//    List<Cart> findByUserIdAndIsChecked(int userId, boolean isChecked);






//    // 주문서 확인 폼
//    @Query("select c from Cart c JOIN FETCH c.product p JOIN FETCH c.user u WHERE u.id =:userId and c.isChecked =:isChecked")
//    List<CartResponse.ListDTO> findByUserIdAndChecked(@Param("userId") int userId, @Param("isChecked") boolean isChecked);
//
//    @Modifying
//    @Query("update Cart c set c.isChecked = :isChecked where c.id = :id")
//    int updateCheckedById();

//    @Query("SELECT c FROM Cart c JOIN FETCH c.product p JOIN FETCH c.user u WHERE u.id = :userId AND c.isChecked = :isChecked")
//    List<Cart> findByUserIdAndIsCheckedWithJoinFetch(int userId, Boolean isChecked);

    //cart-save 용
    //재고 수량 조회
    @Query("select c from Cart c join fetch c.product p where c.id = :cartId")
    Cart findByQtyWithId(@Param("cartId") Integer cartId);

    //cart-list 용
    @Query("select c from Cart c join fetch c.product p where c.user.id = :userId order by c.id desc")
    List<Cart> findByCartUserId(@PathVariable("userId") Integer userId);


    @Modifying
    @Query("delete from Cart c where c.product.id = :productId")
    void deleteByProductId(@PathVariable("productId") Integer productId);

}
