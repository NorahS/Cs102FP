package n.headsup;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Norah on 3/10/16 AD.
 */
public class HelperFunctions {

    static protected ArrayList<String> holder = new ArrayList<String>();
    static protected int[] usedInd;


    static protected void next() {

        int ranIndex;
        do {
            ranIndex = (int) (Math.random() * holder.size());
        } while (usedInd[ranIndex] == 1);
        usedInd[ranIndex] = 1;
        Setup.setText(holder.get(ranIndex));
    }

    protected static void play(Setup obj,String category, AssetManager mngr) {

        BufferedReader cat = null;

        if ((category.split("/")[1]).equals("Random")) {
            try {
                Random(obj,category,mngr);
            } catch (IOException e) {
            }

        } else {
            try {

                cat = new BufferedReader(
                        new InputStreamReader(mngr.open(category + ".txt")));
            } catch (IOException e) {
                System.out.println("Error 1:\nFile Not Found");
            }
            try {
                //catogry = cat.readLine();}
                while (cat.ready()) {
                    HelperFunctions.holder.add(cat.readLine());
                }
            } catch (IOException e) {
                System.out.println(e);
            }

        }

       usedInd = new int[holder.size()];
    }

    protected static void Random(Setup obj,String path , AssetManager mngr) throws IOException {

        //  String list[] = EnglishActivity.catogries;
        path= path.split("/")[0];
        String[] list = (String[])obj.langugae.get(path);
        //i till we add actit out for english
        String folder = path.split("/")[0];
        BufferedReader cat=null;
        for (int i = 0; i != list.length; i++) {



            try {

                cat = new BufferedReader(
                        new InputStreamReader(mngr.open(path+"/"+list[i] + ".txt")));
            } catch (IOException e) {
                System.out.println("Error 1:\nFile Not Found");
            }
            try {

                while (cat.ready()) {
                    HelperFunctions.holder.add(cat.readLine());
                }
            } catch (IOException e) {
                System.out.println("Error101");
            }
            cat.close();
        }

    }

    protected static void reset(){
        holder.clear();

    }

}
