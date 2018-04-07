package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

//    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GirlService girlService;

    @Autowired
    private GirlRepository girlRepository;

    @GetMapping("/girls")
    public List<Girl> girlList() {
        logger.info("girlList");
        return girlRepository.findAll();
    }

    @PostMapping("/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        return ResultUtil.success(girlRepository.save(girl));
    }

    @GetMapping("/girls/age/{id}")
    public void getAge(@PathVariable("id") Integer id) {
        girlService.getAge(id);
    }

}
