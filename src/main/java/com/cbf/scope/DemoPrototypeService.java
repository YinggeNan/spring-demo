package com.cbf.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Author yingge
 * @Date 2022/9/7 7:52
 */
@Scope("prototype")
@Service
public class DemoPrototypeService {
}
