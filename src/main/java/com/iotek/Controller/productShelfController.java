package com.iotek.Controller;

import com.iotek.po.ProductShelf;
import com.iotek.service.ProductShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * com.iotek.Controller
 *
 * @author <Author Administrator>
 * @date 2018/3/9 22:57
 */
@Controller
@RequestMapping(value = "productShelf")
public class productShelfController {
    @Autowired
    private ProductShelfService productShelfService;
    @RequestMapping(value = "allProduct.do")
    public @ResponseBody List<ProductShelf> showAllProduct(){
        return  productShelfService.queryAllProduct();
    }

}