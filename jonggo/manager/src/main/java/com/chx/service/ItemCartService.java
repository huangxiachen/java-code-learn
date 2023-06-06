package com.chx.service;

import com.chx.pojo.ItemCat;
import com.chx.vo.EasyUITree;

import java.util.List;

public interface ItemCartService {
    ItemCat findById(Long itemCartId);

    List<EasyUITree> findEasyUiTree(Long parentId);
}
