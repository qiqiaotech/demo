package com.example.demo.sr.core;

import com.example.demo.sr.core.proxy.TestObj;
import com.example.demo.sr.core.proxy.TestObjImpl;
import com.example.demo.sr.core.proxy.TestOtherObj;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class SpringDynamicService extends ProxyFactory {

    //    @Autowired
//    private SpringDynamicAdvice springDynamicAdvice;

    @Autowired
    private ApplicationContext ctx;

    private TestObjImpl testObj;

    public SpringDynamicService() {

    }

    public void testSpringProxy() {
        this.setInterfaces(TestOtherObj.class.getInterfaces());
        //SpringDynamicAdvice advice = (SpringDynamicAdvice)ctx.getBean("springDynamicAdvice");
        this.setProxyTargetClass(true);
        this.addAdvice((SpringDynamicAdvice)ctx.getBean("springDynamicAdvice"));
        testObj = new TestObjImpl();
        this.setTarget(testObj);
        testObj.showMessage();

        TestObj proxyObject = (TestObj)this.getProxy();
        proxyObject.showMessage();
        TestOtherObj proxyOtherObject = (TestOtherObj) proxyObject;
        proxyOtherObject.showOtherMessage();

    }
}
