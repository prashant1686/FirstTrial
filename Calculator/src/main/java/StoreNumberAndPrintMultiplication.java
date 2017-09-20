import java.io.File;
import java.util.Optional;
import java.util.Scanner;

import static java.util.Optional.ofNullable;

/**
 * Created by pku141 on 8/18/2017.
 */
 class StoreNumberAndPrintMultiplication {
   public static void main(String... args) throws Exception {
//
       POJO a = new POJO(10,20);
       POJO b= null;

       Optional <POJO> a1 =Optional.of(a);
       Optional<POJO> a2 = Optional.ofNullable(b);
       add(a1);


   }


   static POJO add(Optional<POJO> pojoOptional){


       System.out.println(pojoOptional.get());

       return null;

   }

    }
