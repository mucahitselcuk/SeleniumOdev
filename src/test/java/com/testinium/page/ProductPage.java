package com.testinium.page;

import com.testinium.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ProductPage {
    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage() {
        methods = new Methods();
    }

    public void selectProduct() {
        methods.sendKeys(By.id("search-input"), "Oyuncak");
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(2);
//        methods.scrollWithActions(By.id("product-572810"));
//        methods.waitBySeconds(2);
//        methods.click(By.xpath("//*[@id=\"product-577328\"]/div[2]/div[3]/a[4]/i"));
//        methods.click(By.xpath("//*[@id=\"product-561234\"]/div[2]/div[3]/a[4]/i"));
//        methods.click(By.xpath("//*[@id=\"product-565088\"]/div[2]/div[3]/a[4]/i"));
//        methods.click(By.xpath("//*[@id=\"product-572810\"]/div[2]/div[3]/a[5]/i"));
//        methods.waitBySeconds(5);
    }

    public void getFavorites() {
        methods.scrollWithActions(By.cssSelector("div[class='menu top my-list']>ul>li>a[class='common-sprite']"));
        methods.click(By.cssSelector("div[class='menu top my-list']>ul>li>div>ul>li>a[href='https://www.kitapyurdu.com/index.php?route=account/favorite&selected_tags=0']"));
        methods.waitBySeconds(2);
        methods.scrollWithActions(methods.listUnit(4));
        //methods.scrollWithActions(By.xpath("//*[@id=\"product-561234\"]/div[2]/div[3]/a[3]/i"));
        methods.waitBySeconds(2);
        methods.scrollWithActions(By.xpath("//*[@id=\"tag-0\"]"));
        methods.click(By.cssSelector("a[href='https://www.kitapyurdu.com/']"));
        methods.waitBySeconds(1);
    }

    public void puanCatalog() {
        methods.click(By.cssSelector("a[href='puan-katalogu']"));
        methods.scrollWithActions(By.cssSelector("img[title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.click(By.cssSelector("img[title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.selectByText(By.cssSelector("div[class='sort']>select[onchange='location = this.value;']"), "Yüksek Oylama");
        methods.waitBySeconds(2);
    }

    public void booksHobi() {
        methods.click(By.xpath("//*[@id=\"mainNav\"]/div[1]/ul/li[1]/div[2]/ul/li[3]/span"));
        methods.waitBySeconds(2);

        methods.click(By.xpath("//*[@id=\"mainNav\"]/div[1]/ul/li[1]/div[2]/ul/li[3]/div/div[1]/div/ul[2]/li[14]/a"));
        methods.waitBySeconds(2);
    }

    public void shoppingList() {
        methods.click(By.xpath("//*[@id=\"product-584966\"]/div[4]/a/span"));
        methods.scrollWithActions(By.cssSelector("p[class='info-text']"));
        methods.click(By.xpath("//*[@id=\"button-cart\"]/span"));
        methods.scrollWithActions(By.cssSelector("div[class='menu top my-list']>ul>li>a[class='common-sprite']"));

        methods.click(By.cssSelector("div[class='menu top my-list']>ul>li>div>ul>li>a[href='https://www.kitapyurdu.com/index.php?route=account/favorite&selected_tags=0']"));
        methods.scrollWithActions(By.xpath("//*[@id=\"content\"]/div[2]/div/ul/li[14]/a"));
        methods.waitBySeconds(1);




       methods.click(By.xpath("//*[@id=\"product-577328\"]/div[2]/div[3]/a[3]/i"));
       methods.waitBySeconds(1);

        methods.scrollWithActions(By.xpath("//*[@id=\"cart\"]/div[1]/div[2]/h4"));
        methods.waitBySeconds(1);

        methods.click(By.xpath("//*[@id=\"cart\"]/div[1]/div[2]/h4"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//*[@id=\"js-cart\"]"));
        methods.waitBySeconds(2);
    }
    public void addProdouct() {
        methods.getClearAndWrite(By.cssSelector("input[style='width:22px']"), "5");
        methods.click(By.cssSelector("i[onclick='cartProductUpdate($(this).parent())']"));
        methods.waitBySeconds(5);

        methods.click(By.cssSelector("div[class='right']"));
        methods.waitBySeconds(5);
    }
    public void addHomeAddress() {
        methods.click(By.cssSelector("a[onclick=\"setShippigAddressType('new')\"]"));
        methods.sendKeys(By.cssSelector("input[id='address-firstname-companyname']"), "Mücahit");
        methods.sendKeys(By.cssSelector("input[id='address-lastname-title']"), "Selçuk");
        methods.selectByText(By.cssSelector("[id=\"address-country-id\"]"), "Türkiye");
        methods.click(By.id("address-zone-id"));
        methods.click(By.cssSelector("#address-zone-id>option[value='3345']"));
        methods.click(By.id("address-zone-id"));
        methods.click(By.cssSelector("#address-county-id>option[value='349']"));
        methods.sendKeys(By.id("district"), "Sancaktepe");
        methods.sendKeys(By.id("address-address-text"), "İnönü Mah. Demokrasi Caddesi");
        methods.sendKeys(By.id("address-telephone"), "2167677777");
        methods.sendKeys(By.id("address-mobile-telephone"), "5342343434");
        methods.click(By.cssSelector("button[type='button']"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("button[id='button-checkout-continue']"));
        methods.waitBySeconds(2);
        methods.click(By.id("button[id=\"button-checkout-continue\"]"));
        methods.waitBySeconds(5);
    }
    public void loguot() {
        methods.click(By.cssSelector("img[title='kitapyurdu.com']"));
    }
public void randomFavorites(){
    methods.click(By.cssSelector(".common-sprite.button-search"));
    methods.scrollWithActions(methods.listUnit(7));
    methods.addFavoritesRandom(4);
    methods.addFavoritesRandom(5);
    methods.addFavoritesRandom(6);
    methods.addFavoritesRandom(7);
    methods.waitBySeconds(2);

}

//    }
//    public void attributeTest() {
//        String attribute = methods.getAttribute(By.cssSelector(".logo-text>a>img"), "title");
//        System.out.println("Alınan Text " + attribute);
//        logger.info("Alınan text " + attribute);
//        methods.waitBySeconds(2);
//    }
//    public void testControl(){
//        String text=methods.getText(By.cssSelector(".common-sprite"));
//        System.out.println("Alınan text "+text);
//    }
//    public void valueControlTest(){
//        methods.sendKeys(By.id("search-input"),"testinium");
//        String value = methods.getValue(By.id("search-input"));
//        System.out.println("Alınan text "+value);
//        logger.info("Alınan text: "+value);
//        Assert.assertEquals("testinium",value);
//        methods.waitBySeconds(5);
//    }


}

