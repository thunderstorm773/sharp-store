package sharpStore.staticData;

import sharpStore.models.bindingModels.AddKnife;
import java.math.BigDecimal;

public class KnivesSampleData {

    public static AddKnife knife1;

    public static AddKnife knife2;

    public static AddKnife knife3;

    static {
        knife1 = new AddKnife("Sharp 3000", BigDecimal.valueOf(140.00),
                "http://assets.reviews.com/uploads/2017/04/19165159/Product-Card-Shun.jpg");
        knife2 = new AddKnife("Sharp 4", BigDecimal.valueOf(99.00),
                "http://www.ikea.com/PIAimages/0217043_PE373188_S5.JPG");
        knife3 = new AddKnife("Sharp Ultimate", BigDecimal.valueOf(450.00),
                "http://www.hartsofstur.com/acatalog/IS07N-Sabatier-Stellar-18cm-Santoku-Knife.jpg");
    }

}
