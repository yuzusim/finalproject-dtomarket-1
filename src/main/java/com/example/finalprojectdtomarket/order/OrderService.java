package com.example.finalprojectdtomarket.order;

import com.example.finalprojectdtomarket.cart.Cart;
import com.example.finalprojectdtomarket.cart.CartJPARepository;
import com.example.finalprojectdtomarket.cart.CartQueryRepository;
import com.example.finalprojectdtomarket.cart.CartResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderJPARepository orderJPARepository;
    private final CartJPARepository cartJPARepository;
    private final CartQueryRepository cartQueryRepository;

    private final HttpSession session;


//    @Transactional
//    public List<CartResponse.ListDTO> findByUserIdAndIsChecked(Integer userId) {
//        // 장바구니 리스트 조회
////        List<Cart> cartList =
////                cartJPARepository.findByUserIdAndIsCheckedWithJoinFetch(userId);
//
//        // 장바구니 상태 업데이트
//        //cartQueryRepository.updateIsChecked();
//
//        //롤백
//        cartQueryRepository.updateStatus();
//
//        //return cartList;
//        return cartList.stream().map(CartResponse.ListDTO::new).toList();
//    }




//    @Transactional
//    public List<CartResponse.ListDTO> findByCartIdAndUserIdAndStatusAndUpdateCartStatus(Integer userId, boolean newStatus, boolean oldStatus, boolean isChecked, Integer id) {
//        List<CartResponse.ListDTO> cartList =
//                cartJPARepository.findByUserIdAndStatusWithJoinFetch(userId, isChecked);
//
//
//        // 장바구니 상태 업데이트
//        cartJPARepository.updateIsChecke(newStatus, oldStatus);
//
//        // 장바구니 체크박스 업데이트
//        cartJPARepository.updateIsCheckedById(isChecked, id);
//
//        return cartList;
//    }



//    //주문서 (카트에 있는거 들고 와서 뿌림 .. 카트를 DI)
//    @Transactional
//    public List<CartResponse.ListDTO> findByCartIdAndUserIdAndStatus(Integer userId) {
//        // 저장된 리스트를 사용자 ID와 카트 ID를 기준으로 조회
//        List<CartResponse.ListDTO> cartList = cartJPARepository.findByUserIdAndStatusWithJoinFetch(userId);
//
//        return cartList;
//    }
//
//    @Transactional
//    public void updateCartStatus(boolean newStatus, boolean oldStatus) {
//        // 장바구니 상태 업데이트 메서드 호출
//        cartJPARepository.updateStatus(newStatus, oldStatus);
//    }



//    @Transactional
//    public List<CartResponse.ListDTO> findByUserIdAndChecked(Integer userId, Boolean isChecked) {
//        // 저장된 리스트를 사용자 ID와 상태를 기준으로 조회
//        List<CartResponse.ListDTO> cartList = cartJPARepository.findByUserIdAndChecked(userId, isChecked);
//        cartJPARepository.updateCheckedById();
//        // 모든 조회된 항목의 isChecked 상태를 true로 업데이트
////        for (CartResponse.ListDTO cart : cartList) {
////            cartJPARepository.updateCheckedById(true, cart.getId());
////        }
//
//
////        // 조회된 카트 목록을 CartResponse.ListDTO로 변환
////        List<CartResponse.ListDTO> cartList = cartList.stream()
////                .map(this::convertToDto)
////                .collect(Collectors.toList());
//
//        return cartList;
//    }
}
