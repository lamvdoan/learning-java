package dynamic_proxy_pattern.objectville.proxy;

import dynamic_proxy_pattern.objectville.invocation_handler.NonOwnerInvocationHandler;
import dynamic_proxy_pattern.objectville.invocation_handler.OwnerInvocationHandler;
import dynamic_proxy_pattern.objectville.person.PersonBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyCreator {
    public static PersonBean getOwnerProxy(PersonBean personBean) {
        return createProxyInstance(true, personBean);
    }

    public static PersonBean getNonOwnerProxy(PersonBean personBean) {
        return createProxyInstance(false, personBean);
    }

    private static PersonBean createProxyInstance(boolean isOwnerInvocationHandler, PersonBean personBean) {
        InvocationHandler newInvocationHandlerObject = null;

        if (isOwnerInvocationHandler) {
            newInvocationHandlerObject =  new OwnerInvocationHandler(personBean);
        } else {
            newInvocationHandlerObject =  new NonOwnerInvocationHandler(personBean);
        }

        return (PersonBean) Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                newInvocationHandlerObject);
    }
}
