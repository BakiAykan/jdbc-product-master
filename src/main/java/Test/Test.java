package Test;

import Service.*;
import Servicee.Impl.*;
import com.proje.model.*;
import com0proje.connection.DBCon;
import com_proje.model.queries.CouponQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        BrandService brandService = new BrandServiceImpl();

        CategoryService categoryService = new CategoryServiceImpl();

        UserService userService = new UserServiceImpl();

        ProductService productService = new ProductServiceImpl();

        CouponService couponService = new CouponServiceImpl();


        /* List<Brand> brands = brandService.findBrands();

        for(Brand brand : brands){
            System.out.println("Brand Id :" + brand.getBrandId());
            System.out.println("Brand name :" + brand.getBrandName());
        } */

        /* Brand brand = brandService.findBrand(3);
        System.out.println(brand); */

        /* List<Category> categories = categoryService.findCategories();

        for(Category category : categories){

            System.out.println(category.getCategoryId() + " - " + category.getCategoryName());
        } */

        /* Category category = categoryService.findCategoryById(1);
        System.out.println(category.getCategoryName()); */

        /* List<Product> products = productService.findProducts();

        for(Product product : products){

            System.out.println(product.getProductId() + " - " + product.getAvaible() + " - " + product.getUnitPrice()
                    + " - " + product.getAddDate() + " - " + product.getUpdateDate() + " - " + product.getCategory().getCategoryName()
                    + " - " + product.getBrand().getBrandName());
        } */

        /* Product product = productService.findProductById(3);
        System.out.println(product); */

        /* List<User> users = userService.findUsers();
        for (User user: users) {
            System.out.println(user);
        } */

        /* User user = userService.findUserById(101);
        System.out.println(user); */

        /* User user = userService.findUserProductsById(100);
        System.out.println(user);
        List<Product> products = user.getProducts();
        System.out.println("Kullanıcının paylaştığı ürünler :");
        for (Product product : products){
            System.out.println("\t" + product);
        } */

        /* User user = new User(102,"Baki","Sen",new Date(new java.util.Date().getTime()),"canavar");
        userService.saveUser(user); */

        /* Product product = new Product(5,"Monster",5200,2,new Date(),null,null,null);
        Category category = categoryService.findCategoryById(2);
        product.setCategory(category);
        Brand brand = brandService.findBrand(5);
        product.setBrand(brand);

        productService.saveProduct(product); */

        /* userService.saveUserProduct(102,5); */

        /* Product product = productService.findProductById(5);
        product.setProductName("Monster Abra i7");

        productService.updateProduct(product); */

        /* Kupon kupon = new Kupon(4,"250TL");
        kuponService.saveKupon(kupon); */


        //kuponService.saveKuponUser(2,100);

        /* Kupon kupon = kuponService.findKuponById(2);
        System.out.println(kupon);
        kupon.setKuponName("180TL");
        kuponService.updateKupon(kupon); */

        //kuponService.removeKupon(4);

        /* List<Kupon> kupons = kuponService.findKupons();
        for (Kupon kupon : kupons){
            System.out.println(kupon);
        } */

        /* Kupon kupon = kuponService.findKuponUsersById(2);
        System.out.println(kupon);
        List<User> users = kupon.getUsers();
        System.out.println("Kuponu kullanan kişiler :");
        for (User user : users){
            System.out.println("\t" + user);
        } */


      /*  User user = userService.findUserProductsById(100);
        List<Product> products = user.getProducts();
        double toplamTutar = 0;
        for (Product product : products) {
            toplamTutar += product.getUnitPrice();
        }
        System.out.println(user.getUserId() + " id'li kullanıcının Toplam tutarı :" + toplamTutar);

        Coupon coupon = couponService.findCouponUsersById(1);
        System.out.println(coupon);
        List<User> users = coupon.getUsers();
        System.out.println("Kuponu kullanan kişiler :");
        for (User userler : users){
            System.out.println("\t" + userler);
            if (userler.getUserId() == user.getUserId()){

                int indirim = Integer.parseInt(coupon.getCouponName());
                toplamTutar -= indirim;
                System.out.println("İndirimli tutar :" + toplamTutar);
            }
        }
*/

        User user = userService.findUserProductsById(1);
        List<Coupon> coupons = couponService.findUser_Coupon(user);
        List<Product> products = user.getProducts();
        double totalAmount = 0;

        for (Product fProduct : products) {
            totalAmount +=fProduct.getUnitPrice();
        }
        System.out.println(user.getUserName() + " adlı kullanıcının toplam tutarı : " + totalAmount);
        for (Coupon coupon: coupons
        ) {
            System.out.println(user.getUserName() + " adlı kullanıcıya ait " + coupon.getCouponName() );
        }
        System.out.println("Uygulanılan kupon : " + GetRecommendCoupon(coupons , couponService,user));

            totalAmount -= GetRecommendCoupon(coupons , couponService,user);



        System.out.println(totalAmount);

    }
    public static double GetRecommendCoupon(List<Coupon> coupons, CouponService couponService, User user){
        coupons = couponService.findUser_Coupon(user);
            double maxCouponPrice = 0;
            for (int i = 1; i < couponService.findCouponLastId(); i++) {
                for (Coupon coupon: coupons
                ) {
                if (coupon.getUnitPrice()>maxCouponPrice){
                    maxCouponPrice = coupon.getUnitPrice();
                }
            }
        }
        return maxCouponPrice;
    }
}
