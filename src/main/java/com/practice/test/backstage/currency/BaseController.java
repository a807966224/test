package com.practice.test.backstage.currency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * 基础控制类
 * @author Scott
 *
 */
@Controller
public class BaseController {
	
    protected transient Logger logger = LoggerFactory.getLogger(getClass());
    
}
