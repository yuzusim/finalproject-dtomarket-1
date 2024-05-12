package com.example.finalprojectdtomarket.order;

import com.example.finalprojectdtomarket.cart.CartRequest;
import com.example.finalprojectdtomarket.cart.CartResponse;
import com.example.finalprojectdtomarket.cart.CartService;
import com.example.finalprojectdtomarket.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrderController {
    private final OrderService orderService;
    private final CartService cartService;
    private final HttpSession session;

    // 주문 목록
    @GetMapping({"/order-list"})
    public String list() {
        return "";
    }

//    @GetMapping("/order/save-form")
//    public String orderSaveForm(HttpServletRequest request) {
//        User sessionUser = (User) session.getAttribute("sessionUser");
//
//        // 필요한 추가 파라미터 값을 설정
//        boolean newStatus = true; // 새로운 상태 값
//        boolean oldStatus = false; // 이전 상태 값
//        boolean isChecked = true; // 체크 상태
//        Integer id = 1; // 장바구니 항목 ID
//
//        // 수정된 메서드 호출
//        List<CartResponse.ListDTO> orderList = orderService.updateCartStatusAndReturn(sessionUser.getId(), newStatus, oldStatus, isChecked, id);
//        System.out.println("주문서확인: " + orderList);
//        request.setAttribute("orderList", orderList);
//        session.setAttribute("user", sessionUser);
//
//        return "order/save-form";
//    }





    @GetMapping("/order/save-form")
    public String orderSaveForm(HttpServletRequest request) {
        User sessionUser = (User) session.getAttribute("sessionUser");

        // 장바구니 업데이트를 위한 DTO 리스트 생성
//        List<CartRequest.UpdateDTO> updateDTOs = new ArrayList<>();

        // 장바구니 리스트 가져오기
        List<CartResponse.ListDTO> orderList = cartService.findById(sessionUser.getId());
        request.setAttribute("orderList", orderList);

//        // 장바구니 업데이트를 위한 DTO 생성
//        for (CartResponse.ListDTO cartDTO : orderList) {
//            CartRequest.UpdateDTO updateDTO = new CartRequest.UpdateDTO();
//            updateDTO.setCartId(cartDTO.getId());
//            updateDTO.setOrderQty(cartDTO.getOrderQty());
//            updateDTO.setIsChecked(cartDTO.getIsChecked());
//            updateDTOs.add(updateDTO);
//        }
//
//        // 장바구니 업데이트 서비스 호출
//        cartService.updateCart(updateDTOs);

        return "order/save-form";
    }

    // 주문하기
    @PostMapping("/order/save")
    public String orderSave() {
        return "redirect:/order-list";
    }

    // 삭제하기
    @PostMapping("/order/{id}/delete")
    public String delete() {
        return "";
    }
}
