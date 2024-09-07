package capers;

import java.io.File;

public class tryFile {

    public static void main(String[] args){
        File CWD = new File(System.getProperty("user.dir"));
        File CAPERS_FOLDER = Utils.join(CWD,".capers");
        System.out.println(CAPERS_FOLDER);
        CAPERS_FOLDER.mkdir();
        File story = Utils.join(CAPERS_FOLDER, "story.txt");
        Utils.writeContents(story,"test files\n","test another line");
        //Utils.writeContents(story,"test a3 line");

    }


}
