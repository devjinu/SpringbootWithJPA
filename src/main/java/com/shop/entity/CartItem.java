package com.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

    // 하나의 장바구니에는 여러개의 상품을 담을 수 있으므로 @ManyToOne 이용하여 다대일 관계로 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;
    
    // 하나의 상품은 여러개의 장바구니에 담길 수 있으므로 @ManyToOne 이용하여 다대일 관계로 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    
    // 장바구니에 담기는 갯수
    private int count;

    public static CartItem createCartItem(Cart cart, Item item, int count) {
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setItem(item);
        cartItem.setCount(count);
        return cartItem;
    }

    // 기존 장바구니에 담겨있는 상품의 수량을 추가할 때 사용
    public void addCount(int count){
        this.count += count;
    }

    // 장바구니 수량 변경
    public void updateCount(int count){
        this.count = count;
    }


}
