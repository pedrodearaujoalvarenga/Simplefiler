import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Simplefiler {

    FileOutputStream fos;
    public Simplefiler(String filename, String format){
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), filename +"."+ format);
        int fileAmount = 1;
        String filenameHolder = filename;
        while(file.exists()){
            filename = filenameHolder + " (" + fileAmount + ")";
            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), filename + "." + format);
            fileAmount++;
        }

        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    void writeString(String string_to_Write){
        try {
            fos.write(string_to_Write.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeInt(int integer_to_Write){
        try {
            fos.write(integer_to_Write);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void end(){
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
