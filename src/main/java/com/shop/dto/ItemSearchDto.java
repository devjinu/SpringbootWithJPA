package com.shop.dto;

import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSearchDto {

    private String searchDateType;

    private ItemSellStatus searchSellStatus;

    // itemNm : 상품명
    // createdBy : 상품등록자 아이디
    private String searchBy;
    
    private String searchQuery = "";
    
}
