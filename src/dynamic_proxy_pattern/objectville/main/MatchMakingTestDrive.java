package dynamic_proxy_pattern.objectville.main;

import dynamic_proxy_pattern.objectville.person.PersonBean;
import dynamic_proxy_pattern.objectville.person.PersonBeanImpl;
import dynamic_proxy_pattern.objectville.proxy.ProxyCreator;

public class MatchMakingTestDrive {
    public static void main(String[] args) {
        PersonBean lam = new PersonBeanImpl("Lam", "M", 35);
        lam.setRating(8);


        System.out.println("**** Owner Proxy ****");
        PersonBean ownerProxy = ProxyCreator.getOwnerProxy(lam);
        System.out.println("Name is " + ownerProxy.getName());

        ownerProxy.setInterest("Board games");
        System.out.println("Interest is set by owner");

        try {
            ownerProxy.setRating(5);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }

        System.out.println("Rating is: " + ownerProxy.getRating());


        System.out.println("\n**** Non-Owner Proxy ****");
        PersonBean nonOwnerProxy = ProxyCreator.getNonOwnerProxy(lam);
        System.out.println("Name is " + ownerProxy.getName());

        try {
            nonOwnerProxy.setInterest("Board games");
        } catch (Exception e) {
            System.out.println("Can't set interest");
        }

        nonOwnerProxy.setRating(10);
        System.out.println("Rating set by Jackie");
        System.out.println("Rating is: " + ownerProxy.getRating());
    }
}
